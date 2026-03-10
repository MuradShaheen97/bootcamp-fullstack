//sec1
function welcome() {
  console.log("welcome to coding");
}
welcome();

//sec2
function square(x) {
  x = x * x;
  console.log("its square " + x);
}
var x = 7;
square(x);
//sec3
function converttocelesius() {
  degree = ((degree - 32) * 5) / 9;
  return degree;
}
var degree = 55;
var c = converttocelesius(degree);
console.log(c);
//sec4

function itseven(A) {
  if (A % 2 == 0) {
    console.log("is even");
    return true;
  } else if (A % 2 == 1) {
    console.log("is odd");
    return false;
  }
}

var A = 51;
console.log(A);
console.log(itseven(A));