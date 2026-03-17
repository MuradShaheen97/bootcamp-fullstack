function changeLogin(element) {
  if (element.innerText === "Login") {
    element.innerText = "Logout";
  } else {
    element.innerText = "Login";
  }
}

let button = document.querySelector(".login-btn");

button.addEventListener("click", function () {
  button.style.backgroundColor = "red";
});

function removeButton(element) {
  element.remove();
}

function likeAlert() {
  alert("Ninja was liked");
}
