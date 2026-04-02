// button hover color
var startBtn = document.getElementById("startBtn");

startBtn.addEventListener("mouseover", function () {
  startBtn.style.backgroundColor = "#3b4598";
});

startBtn.addEventListener("mouseout", function () {
  startBtn.style.backgroundColor = "";
});

// change about section
var changeBtn = document.getElementById("changeBtn");
var aboutTitle = document.getElementById("aboutTitle");
var aboutParagraph = document.getElementById("aboutParagraph");
var aboutImg = document.getElementById("aboutImg");

var changed = false;

changeBtn.addEventListener("click", function () {
  if (changed === false) {
    aboutTitle.innerText = "What we do";
    aboutParagraph.innerText =
      "At our company, innovation drives everything we do. We specialize in leveraging cutting-edge technologies and strategic expertise to empower businesses to grow smarter and faster. From enhancing digital experiences and optimizing internal workflows to unlocking new revenue opportunities.";
    aboutImg.src = "./imgweb/alt-features.png";
    changeBtn.innerText = "Change Back";
    changed = true;
  } else {
    aboutTitle.innerText = "Who we are";
    aboutParagraph.innerText =
      "We are a forward-thinking company dedicated to providing innovative solutions that fuel business growth.";
    aboutImg.src = "./imgweb/about.jpg";
    changeBtn.innerText = "Make A Change";
    changed = false;
  }
});

// add service card
var addServiceBtn = document.getElementById("addServiceBtn");
var servicesContainer = document.getElementById("servicesContainer");

addServiceBtn.addEventListener("click", function () {
  var newCard = document.createElement("div");
  newCard.classList.add("card");

  newCard.innerHTML = `
    <img src="./imgweb/features.png">
    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nihil cum repellendus vitae expedita tempore necessitatibus quasi cumque placeat ad quibusdam, nulla qui dolorum, perferendis</p>
  `;

  servicesContainer.appendChild(newCard);
});
