//1//
for (let i = 1; i <= 10; i++) {
  console.log(i);
}
//2//

for (let i = 10; i >= 1; i--) {
  console.log(i);
}

//3//

for (let i = 1; i <= 20; i++) {
  if (i % 2 === 0) {
    console.log(i);
  }
}

//4///
for (let i = 1; i <= 20; i += 2) {
  console.log(i);
}

//5//

let sum = 0;
for (var i = 1; i <= 10; i++) {
  sum += i;
}
console.log(sum);

//6//
for (let i = 1; i <= 30; i++) {
  if (i % 3 === 0 && i % 5 === 0) {
    console.log("FizzBuzz");
  } else if (i % 3 === 0) {
    console.log("Fizz");
  } else if (i % 5 === 0) {
    console.log("Buzz");
  } else {
    console.log(i);
  }
}
