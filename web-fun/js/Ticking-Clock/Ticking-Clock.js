function updateClock() {
  const now = new Date();

  const seconds = now.getSeconds();
  const minutes = now.getMinutes();
  const hours = now.getHours();

  const secondsDeg = seconds * 6;
  const minutesDeg = minutes * 6;
  const hoursDeg = (hours % 12) * 30 + minutes * 0.5;

  document.getElementById("seconds").style.transform =
    `translate(-50%, 0) rotate(${secondsDeg}deg)`;

  document.getElementById("minutes").style.transform =
    `translate(-50%, 0) rotate(${minutesDeg}deg)`;

  document.getElementById("hour").style.transform =
    `translate(-50%, 0) rotate(${hoursDeg}deg)`;
}

updateClock();
setInterval(updateClock, 1000);
