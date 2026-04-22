const b = document.getElementById("b");
const container = document.getElementById("container");
const result = document.getElementById("result");

function clearHighlight() {
  document.querySelectorAll(".box").forEach((el) => {
    el.classList.remove("highlight");
  });
}

function showParent() {
  clearHighlight();

  const parent = b.parentElement;
  parent.classList.add("highlight");

  result.innerText = "Parent of B is: " + parent.tagName;
}

function showChildren() {
  clearHighlight();

  const children = container.children;
  let names = [];

  for (let child of children) {
    child.classList.add("highlight");
    names.push(child.innerText.toLowerCase());
  }

  result.innerText =
    "Container has " + children.length + " children: " + names.join(", ");
}

function showSiblings() {
  clearHighlight();

  const siblings = b.parentElement.children;
  let names = [];

  for (let el of siblings) {
    if (el !== b) {
      el.classList.add("highlight");
      names.push(el.innerText.toLowerCase());
    }
  }

  result.innerText = "Siblings of B: " + names.join(", ");
}
