// CHANGE NAME
var editBtn = document.querySelector(".edit");
var userName = document.querySelector(".card-body h1");

editBtn.addEventListener("click", function (e) {
  e.preventDefault();
  userName.innerText = "Any Other Name";
});

// SELECT BADGES
var requestNumber = document.querySelector(".rr .badge");
var connectionNumber = document.querySelectorAll(".badge")[1];

// SELECT ALL REQUESTS
var requests = document.querySelectorAll(".rr .list-item");

requests.forEach(function (request) {
  var buttons = request.querySelectorAll(".icon-btn");

  var acceptBtn = buttons[0];
  var declineBtn = buttons[1];

  // ACCEPT
  acceptBtn.addEventListener("click", function () {
    request.remove();

    var currentRequests = parseInt(requestNumber.innerText);
    requestNumber.innerText = currentRequests - 1;

    var currentConnections = parseInt(connectionNumber.innerText);
    connectionNumber.innerText = currentConnections + 1;
  });

  // DECLINE
  declineBtn.addEventListener("click", function () {
    request.remove();

    var currentRequests = parseInt(requestNumber.innerText);
    requestNumber.innerText = currentRequests - 1;
  });
});
