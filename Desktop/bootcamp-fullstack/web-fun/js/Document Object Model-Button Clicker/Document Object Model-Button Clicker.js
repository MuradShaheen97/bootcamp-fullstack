function changeLogin(element) {
  if (element.innerText === "Login") {
    element.innerText = "Logout";
  } else {
    element.innerText = "Login";
  }
}

function removeButton(element) {
  element.remove();
}

function likeAlert() {
  alert("Ninja was liked");
}
