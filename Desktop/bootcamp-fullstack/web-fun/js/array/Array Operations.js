//1//

let colors = ["red", "blue", "green", "yello", "purple"];

console.log(colors[0] + " " + colors[colors.length - 1]);
console.log(colors[colors.length - 4]);
colors[2] = "orange";
console.log(colors);

//2//
//a//
let numbers = [10, 20, 30, 40, 50];
for (var i = 0; i < numbers.length - 1; i++) {
  console.log(numbers[i]);
}
//b//
let numbers = [10, 20, 30, 40, 50];
for (var i = 4; i >= 0; i--) {
  console.log(numbers[i]);
}

//3//
let numbers = [5, 10, 15, 20, 25];
let found = false;
for (let i = 0; i < numbers.length; i++) {
  if (numbers[i] === 25) {
    console.log("found it position " + i);
    found = true;
    break;
  }
}
if (!found) {
  console.log("not found");
}
//4//
//a//
let scores = [50, 20, 70, 10, 40];
scores.sort(function (a, b) {
  return a - b;
});
console.log(scores);

let scores = [50, 20, 70, 10, 40];
scores.sort(function (a, b) {
  return b - a;
});
console.log(scores);

//b//
let names = ["shatha", "sara", "lina", "sami", "dalia"];
names.sort();
console.log(names);

//5//
let animals = ["dog", "cat", "rabbit"];
animals.push("elephant");
animals.unshift("lion");
animals.splice(2, 0, "tiger");
console.log(animals);

//6//
let fruits = ["apple", "banana", "cherry", "date"];
fruits.shift();
fruits.pop();
let index = fruits.indexOf("banana");
if (index !== -1) {
  fruits.splice(index, 1);
}
console.log(fruits);

//7//
let array1 = [1, 2, 3];
let array2 = [4, 5, 6];
let combined = array1.concat(array2);
console.log(combined);

//8//
let items = ["a", "b", "c", "d", "e"];
let firstPart = items.slice(0, 3);
let secondPart = items.slice(3);
console.log(firstPart);
console.log(secondPart);

//9//
let numbers = [1, 5, 10, 15, 20, 25, 30];
let filtered = [];
for (let i = 0; i < numbers.length; i++) {
  if (numbers[i] > 15) {
    filtered.push(numbers[i]);
  }
}
console.log(filtered);

//10//
//a//
function removeDuplicates(arr) {
  var result = [];

  for (var i = 0; i < arr.length; i++) {
    var isDuplicate = false;

    for (var j = 0; j < result.length; j++) {
      if (arr[i] === result[j]) {
        isDuplicate = true;
        break;
      }
    }

    if (!isDuplicate) {
      result.push(arr[i]);
    }
  }

  return result;
}

var arr1 = [1, 2, 2, 3, 4, 4, 5];
console.log(removeDuplicates(arr1));

//b//

function rotateRight(arr, n) {
  var length = arr.length;
  var result = [];

  // Adjust n if it's larger than array length
  n = n % length;

  for (var i = 0; i < length; i++) {
    result[(i + n) % length] = arr[i];
  }

  return result;
}

// Example
var arr2 = [1, 2, 3, 4, 5];
console.log(rotateRight(arr2, 2));
