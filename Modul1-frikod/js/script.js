/*
Yrkeshögskola Grit Academy 2020 - Javautvecklare
Kod skriven av Jimmy Wallener för kursen Avancerad Javascript.

Övningsuppgift vecka 1

Syftet är att öva på användning:
#addEventListener
#window.location
#E6 arrow functions
#Regular Functions
#.map,.filter,.reduce
#appendChild etc

*/
(function () {
  window.addEventListener("load", () => {
    loadContent();
  });

  setInterval(() => {
    changeColor();
  }, 30000 * 1);

  /*
  FUNCTIONS HERE
  */

  // Lame function which changes background color on the divs. Just to use querySelectorAll
  function changeColor() {
    const div = document.querySelectorAll("div");

    console.log(typeof div);
    console.log(div.length);

    const index = "0123456789ABCDEF";
    let color = "#";
    for (let i = 0; i < 6; i++) {
      color += index[Math.floor(Math.random() * 16)];
    }
    div.forEach((e) => {
      e.style.backgroundColor = color;
    });
  }

  // Create buttons with urls
  function populateLinks(json) {
    const linkList = document.querySelector(".links_list");
    const ul = document.createElement("ul");

    json.map((links) => {
      const li = document.createElement("li");
      const button = document.createElement("button");

      button.innerText = links.link;
      button.classList.add("link_button");
      button.classList.add(`${links.id}`);
      li.appendChild(button);
      ul.appendChild(li);
    });
    linkList.appendChild(ul);

    const click = document.querySelectorAll(".link_button");

    click.forEach((e) => {
      json.map((links) => {
        let link = links.link;
        let id = links.id;
        e.addEventListener("click", () => {
          if (e.classList.item(1) == id) {
            location.assign("http://" + link);
          }
        });
      });
    });
  }
  // Getting urls from external json file
  async function loadContent() {
    const data = fetch("./json/links.json")
      .then((response) => response.json())
      .then((json) => populateLinks(json))
      .catch((err) => console.warn(err));
  }
})();