function playSong(src, name) {
  var audio = document.getElementById("audio");
  var title = document.getElementById("title");

  audio.src = src;
  title.innerText = name;

  audio.play();
}
