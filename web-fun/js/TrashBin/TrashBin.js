const items = document.querySelectorAll(".item");
const trashBin = document.getElementById("trashBin");

let draggedItem = null;

items.forEach((item) => {
  item.addEventListener("dragstart", function () {
    draggedItem = this;
    this.classList.add("dragging");
  });

  item.addEventListener("dragend", function () {
    this.classList.remove("dragging");
  });
});

trashBin.addEventListener("dragover", function (e) {
  e.preventDefault();
  trashBin.classList.add("hovered");
});

trashBin.addEventListener("dragleave", function () {
  trashBin.classList.remove("hovered");
});

trashBin.addEventListener("drop", function (e) {
  e.preventDefault();

  if (draggedItem) {
    draggedItem.remove();
    draggedItem = null;
  }

  trashBin.classList.remove("hovered");
  trashBin.classList.add("shake");

  setTimeout(() => {
    trashBin.classList.remove("shake");
  }, 300);
});
