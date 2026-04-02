const changeBgBtn = document.getElementById("changeBgBtn");
const mainImage = document.getElementById("mainImage");
const addServiceBtn = document.getElementById("addServiceBtn");
const servicesContainer = document.getElementById("servicesContainer");
const scrollTopBtn = document.getElementById("scrollTopBtn");
const zoomInBtn = document.getElementById("zoomIn");

const originalImage =
  "https://images.unsplash.com/photo-1516321318423-f06f85e504b3?q=80&w=1200&auto=format&fit=crop";

const secondImage =
  "https://images.unsplash.com/photo-1552664730-d307ca884978?q=80&w=1200&auto=format&fit=crop";

let changed = false;
let zoomLevel = 1;

changeBgBtn.addEventListener("click", function () {
  if (!changed) {
    mainImage.src = secondImage;
    changed = true;
  } else {
    mainImage.src = originalImage;
    changed = false;
  }
});

addServiceBtn.addEventListener("click", function () {
  const newCard = document.createElement("div");
  newCard.classList.add("service-card");

  newCard.innerHTML = `
    <img src="https://images.unsplash.com/photo-1522202176988-66273c2fd55f?q=80&w=800&auto=format&fit=crop" alt="new service">
    <p>
      Lorem ipsum dolor sit amet consectetur adipisicing elit.
      Nihil cum repellendus vitae expedita tempore necessitatibus
      quae cumque placeat at quibusdam, nulla qui dolorum.
    </p>
  `;

  servicesContainer.appendChild(newCard);
});

scrollTopBtn.addEventListener("click", function () {
  window.scrollTo({
    top: 0,
    behavior: "smooth",
  });
});

zoomInBtn.addEventListener("click", function () {
  zoomLevel += 0.1;
  document.body.style.transform = `scale(${zoomLevel})`;
});
