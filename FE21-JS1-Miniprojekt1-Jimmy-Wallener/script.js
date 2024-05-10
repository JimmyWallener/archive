const body = document.querySelector("body");
const arrayOfNumbers = [
  "ett",
  "två",
  "tre",
  "fyra",
  "fem",
  "sex",
  "sju",
  "åtta",
  "nio",
  "tio",
];

// Creating a wrapper and populating it with colored <div> using foreach. Also capsulate text in <p> for better encapsulation.

const div = document.createElement("div");
body.appendChild(div);

div.setAttribute("class", "wrapper");
div.style.width = "90vw";

for (let i = 1; i < 6; i++) {
  const wrapper = document.querySelector(".wrapper");
  const colorDivs = document.createElement("div");
  const p = document.createElement("p");

  colorDivs.setAttribute("class", "color");
  wrapper.appendChild(colorDivs);

  let height = i * 20;
  let colorCode = 130 + i * 10;

  colorDivs.style.cssText = `
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    margin-bottom: ${1 + i}vh;
    background-color: hsl(${colorCode}, 100%, 80%);
    height: ${height}px;
    text-align: center;
    `;

  const div = wrapper.querySelectorAll(".color");

  div.forEach((div) => {
    div.appendChild(p);

    p.innerHTML = `Rad ${i}`;
    p.style.cssText = `
      color: hsl(322, 100%, 31%);
      font-size: ${i * 15}px;
      font-weight: bold;
      padding: 5px;
    `;
  });
}

// Second <div> that will contain three centered <ul> boxes.

const div2 = document.createElement("div");
div.appendChild(div2);

div2.setAttribute("class", "list-container");
div2.style.cssText = `
  display: flex;
  align-items: center;
  justify-content: space-evenly;
  width: 90vw;
  height: 45vh;
  border: 1px solid black;
`;

const container = document.querySelector(".list-container");

/* 
  creating <ul> with nested for-loops for populating <ul> with <li>.
  first nested for-loop is reversed for the backwards countdown.
  adding <li> elements for each <ul> with corresponding data and styles.
  will use className for isolating element instead of [i] for readability.
*/

for (let i = 0; i < 3; i++) {
  const ul = document.createElement("ul");
  container.appendChild(ul);
  ul.setAttribute("class", `list${i + 1}`);

  const borderColor = "hsla(254, 40%, 70%, 1)";
  ul.style.cssText = `
  border: 1.5em solid ${borderColor};
  color: white;
  padding: 0;
  background: black;
  width: 4em;
  height: 21vh;
  list-style: none;
  `;
  const list = document.querySelectorAll("ul");

  if (list[i].className == "list2") {
    for (let k = 9; k >= 0; k--) {
      const li = document.createElement("li");
      const liStyle = `
            display: flex;
            background: white;
            color: black;
            align-items: center;
            height: 2.1vh;
            `;
      list[i].appendChild(li);
      li.innerText = k;
      li.style.cssText = liStyle;
      li.style.justifyContent = "center";

      if (k === 8) {
        li.style.backgroundColor = "hsla(254, 40%, 70%, 1)";
      } else if (k === 0 || k % 2 === 0) {
        li.style.backgroundColor = "black";
        li.style.color = "white";
      }
    }
  }

  for (let j = 0; j < 10; j++) {
    const li = document.createElement("li");
    const liStyle = `
        display: flex;
        align-items: center;
        height: 2.1vh;
        `;
    if (list[i].className == "list1") {
      list[i].appendChild(li);
      li.innerText = j;
      li.style.cssText = liStyle;
      if (j === 4) {
        li.style.backgroundColor = "hsla(254, 40%, 70%, 1)";
      } else if (j % 2 != 0) {
        li.style.backgroundColor = "white";
        li.style.color = "black";
      }
    } else if (list[i].className == "list3") {
      list[i].appendChild(li);
      li.innerText = arrayOfNumbers[j];
      li.style.cssText = liStyle;
      li.style.justifyContent = "right";

      if (j === 6 - 1) {
        li.style.backgroundColor = "hsla(254, 40%, 70%, 1)";
      } else if (j % 2 != 0) {
        li.style.backgroundColor = "white";
        li.style.color = "black";
      }
    }
  }
}
