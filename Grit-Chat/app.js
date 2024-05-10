/*
Prompt for users preferenced handle.
Get current url.
If no handle is given, sets handle to Anonymous with an adjacent random number
*/
// Self invoked anonymous function (function () {})();
(function () {
  let peer = null;
  let conn = null;
  const inputField = document.querySelector(".new-message");
  const url = window.location.href;
  let mediaConn = null;

  let clientId = prompt("Enter your name:");
  if (clientId == null || clientId == "") {
    const max = 1;
    const min = 10000;
    clientId = "Anonymous" + Math.floor(Math.random() * (max - min) + min);
  }

  /*  Updates URL with prompted name
        If refreshing webpage for new username input, #clientId stacks in url.
        Removes #clientId from url, leaving just https://url/path/
        But still holds value for peer communication
    */
  let changeUrl = (url, id) => {
    id = location.hash.slice(1);
    let new_url = url + id;
    window.history.pushState("data", new_url);
  };

  changeUrl(url, clientId);

  const connectToPeerClick = (e) => {
    const peerId = e.target.textContent;
    conn && conn.close();
    conn = peer.connect(peerId);
    conn.on("open", () => {
      console.log("connection open");
      const event = new CustomEvent("peer-changed", {
        detail: { peerId: peerId },
      });
      document.dispatchEvent(event);
      conn.on("data", (data) => {
        printMessage(data, "them");
      });
    });
  };
  const peerOnConnection = (dataConnection) => {
    conn && conn.close();
    conn = dataConnection;

    const event = new CustomEvent("peer-changed", {
      detail: { peerId: conn.peer },
    });
    document.dispatchEvent(event);

    conn.on("data", (data) => {
      printMessage(data, "them");
    });
  };
  const peerOnCall = (ic) => {
    mediaConn && mediaConn.close();

    navigator.mediaDevices
      .getUserMedia({ audio: true, video: true })
      .then((stream) => {
        mediaConn = ic;
        ic.answer(stream);
        mediaConn.on("stream", mediaConnectionOnStream);
      });
  };

  // Set up peer connection using ID
  peer = new Peer(clientId, {
    host: "glajan.com",
    port: 8443,
    path: "/myapp",
    secure: true,
    //config: {
    //  iceServers: [
    //   {
    //     url: ["stun:eu-turn7.xirsys.com"],
    //    },
    //    {
    //      username:
    //        "1FOoA8xKVaXLjpEXov-qcWt37kFZol89r0FA_7Uu_bX89psvi8IjK3tmEPAHf8EeAAAAAF9NXWZnbGFqYW4=",
    //      credential: "83d7389e-ebc8-11ea-a8ee-0242ac140004",
    //      url: "turn:eu-turn7.xirsys.com:80?transport=udp",
    //    },
    //  ],
    //},
  });

  peer.on(
    "open",
    (connnectionSuccess = (id) => {
      document.querySelector(".my-peer-id").innerHTML = id;
    })
  );
  peer.on(
    "error",
    (errorMsg = (error) => {
      console.log(error);
    })
  );
  peer.on("call", peerOnCall);
  peer.on("connection", peerOnConnection);

  // Refresh connected userlist every minute
  setInterval(() => {
    refreshUserList(clientId);
  }, 30000 * 5);

  // Manually refresh userlist
  document
    .querySelector(".list-all-peers-button")
    .addEventListener("click", () => {
      refreshUserList(clientId);
    });
  // register enter key press in inputfield
  inputField.addEventListener("keyup", (e) => {
    if (e.keyCode === 13) {
      e.preventDefault();
      sendMessage();
    }
  });
  // register send-button click
  document
    .querySelector(".send-new-message-button")
    .addEventListener("click", () => {
      sendMessage();
    });

  /*
    Functions here
    
    */
  // Sending text message between peers
  function sendMessage() {
    const msg = document.querySelector(".new-message").value;
    conn.send(msg);

    printMessage(msg, "me");
  }
  // Getting current local time
  function getTime() {
    let date = new Date();
    let localTime = date.toLocaleTimeString();
    return localTime;
  }
  // Creates the chatlog
  function printMessage(message, writer) {
    const msgDiv = document.querySelector(".messages");
    const wrapperDiv = document.createElement("div");
    const newMsgDiv = document.createElement("div");
    newMsgDiv.innerText = `${getTime()}: ${message}`;
    wrapperDiv.classList.add("message");
    wrapperDiv.classList.add(writer);
    wrapperDiv.appendChild(newMsgDiv);
    msgDiv.appendChild(wrapperDiv);
    msgDiv.scrollTo(0, msgDiv.scrollHeight);
  }

  function refreshUserList(id) {
    peer.listAllPeers((peers) => {
      const connectedUsers = document.querySelector(".peers");
      const ul = document.createElement("ul");
      connectedUsers.firstChild && connectedUsers.firstChild.remove();
      //removing existing elements, needed for not stacking queries.
      /* while (connectedUsers.lastChild) {
                connectedUsers.removeChild(connectedUsers.lastChild);
            } */

      peers
        .filter((users) => users !== id)
        .map((user) => {
          const li = document.createElement("li");
          const button = document.createElement("button");
          button.innerText = user;
          button.classList.add("connect-button");
          button.classList.add(`ID-${user}`);
          button.addEventListener("click", connectToPeerClick);
          li.appendChild(button);
          ul.appendChild(li);
        });
      connectedUsers.appendChild(ul);
    });
  }
  document.addEventListener("peer-changed", (e) => {
    const peerId = e.detail.peerId;
    document.querySelector(".name").innerHTML = peerId;
    document.querySelectorAll("connect-button.connected").forEach((e) => {
      e.classList.remove(".connected");
    });
    const btnConnected = document.querySelector(`.connect-button.ID-${peerId}`);
    btnConnected && btnConnected.classList.add("connected");

    const video = document.querySelector(".video-container.them");
    video.classList.add("connected");
    video.querySelector(".stop").classList.remove("active");
    video.querySelector(".start").classList.add("active");
  });

  navigator.mediaDevices
    .getUserMedia({ audio: true, video: true })
    .then((stream) => {
      const video = document.querySelector(".video-container.me video");

      video.srcObject = stream;
    });
  // display videofeed in container
  const mediaConnectionOnStream = (stream) => {
    const video = document.querySelector(".video-container.them video");

    video.srcObject = stream;
  };
  // Start video call
  const startVideoCall = () => {
    const video = document.querySelector(".video-container.them");
    const startButton = video.querySelector(".start");
    const stopButton = video.querySelector(".stop");
    startButton.classList.remove("active");
    stopButton.classList.add("active");

    navigator.mediaDevices
      .getUserMedia({ audio: true, video: true })
      .then((stream) => {
        mediaConn = peer.call(conn.peer, stream);
        mediaConn.on("stream", mediaConnectionOnStream);
      });
  };
  // Stop video call
  const stopVideoCall = () => {
    mediaConn && mediaConn.close();
    const video = document.querySelector(".video-container.them");
    const startButton = video.querySelector(".start");
    const stopButton = video.querySelector(".stop");
    stopButton.classList.remove("active");
    startButton.classList.add("active");
  };
  //eventlistener for starting the call
  document
    .querySelector(".video-container.them .start")
    .addEventListener("click", startVideoCall);
  // eventlistener for stopping the call
  document
    .querySelector(".video-container.them .stop")
    .addEventListener("click", stopVideoCall);
})();
