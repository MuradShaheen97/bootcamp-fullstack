// 1

var hello;

console.log(hello); // undefined

hello = "world";

// 2

var needle;

function test() {
  var needle;

  needle = "magnet";

  console.log(needle); // magnet
}

needle = "hystack";

test();

// 3

var brendan;

function print() {
  brendan = "only okay";

  console.log(brendan);
}

brendan = "super cool";

console.log(brendan); // super cool

// 4

var food;

function eat() {
  var food;

  food = "half-chicken";

  console.log(food); // half-chicken

  food = "gone";
}

food = "chicken";

console.log(food); // chicken

eat();

// 5

var mean;

mean(); // error: mean() is not a function it is a variable.

console.log(food);

mean = function () {
  var food;

  food = "chicken";

  console.log(food);

  food = "fish";

  console.log(food);
};

console.log(food);

// 6

var genre;

function rewind() {
  var genre;

  genre = "rock";

  console.log(genre); // rock

  genre = "r&b";

  console.log(genre); // r&b
}

console.log(genre); // undefined

genre = "disco";

rewind();

console.log(genre); // disco

// 7

function learn() {
  var dojo;

  dojo = "seattle";

  console.log(dojo); // seattle

  dojo = "burbank";

  console.log(dojo); // burbank
}

dojo = "san jose";

console.log(dojo); // san jose

learn();

console.log(dojo); // san jose

// 8

function makeDojo(name, students) {
  const dojo = {};

  dojo.name = name;

  dojo.students = students;

  if (dojo.students > 50) {
    dojo.hiring = true;
  } else if (dojo.students <= 0) {
    dojo.status = "closed for now";
  }

  return dojo;
}

console.log(makeDojo("Chicago", 65));
// { name: "Chicago", students: 65, hiring: true }

console.log(makeDojo("Berkeley", 0));
// { name: "Berkeley", students: 0, status: "closed for now" }
