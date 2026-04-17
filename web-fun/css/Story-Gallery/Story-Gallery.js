const filterButtons = document.querySelectorAll(".filter-btn");
const cards = document.querySelectorAll(".card");
const searchInput = document.getElementById("searchInput");
const searchBtn = document.getElementById("searchBtn");

let currentCategory = "all";

filterButtons.forEach((button) => {
  button.addEventListener("click", function () {
    filterButtons.forEach((btn) => btn.classList.remove("active"));
    this.classList.add("active");

    currentCategory = this.dataset.category;
    filterCards();
  });
});

searchBtn.addEventListener("click", filterCards);
searchInput.addEventListener("keyup", filterCards);

function filterCards() {
  const searchValue = searchInput.value.toLowerCase().trim();

  cards.forEach((card) => {
    const title = card.dataset.title.toLowerCase();
    const category = card.dataset.category.toLowerCase();

    const matchesCategory =
      currentCategory === "all" || category === currentCategory;

    const matchesSearch = title.includes(searchValue);

    if (matchesCategory && matchesSearch) {
      card.classList.remove("hidden");
    } else {
      card.classList.add("hidden");
    }
  });
}
