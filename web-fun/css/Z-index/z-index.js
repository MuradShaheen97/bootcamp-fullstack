let modal = document.querySelector(".modal");
let overlay = document.querySelector(".overlay");
let button = document.querySelector("button");

button.onclick = function () {
  modal.style.display = "none";
  overlay.style.display = "none";
};
