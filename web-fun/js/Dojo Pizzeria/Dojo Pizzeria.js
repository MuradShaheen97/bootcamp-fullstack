function pizzaOven(crustType, sauceType, cheeses, toppings) {
  var pizza = {};
  pizza.crustType = crustType;
  pizza.sauceType = sauceType;
  pizza.cheeses = cheeses;
  pizza.toppings = toppings;
  return pizza;
}

// 1
var pizza1 = pizzaOven(
  "deep dish",
  "traditional",
  ["mozzarella"],
  ["pepperoni", "sausage"],
);
console.log(pizza1);

// 2
var pizza2 = pizzaOven(
  "hand tossed",
  "marinara",
  ["mozzarella", "feta"],
  ["mushrooms", "olives", "onions"],
);
console.log(pizza2);

// 3
var pizza3 = pizzaOven(
  "thin crust",
  "alfredo",
  ["parmesan", "mozzarella"],
  ["chicken", "spinach"],
);
console.log(pizza3);

// 4
var pizza4 = pizzaOven(
  "stuffed crust",
  "bbq",
  ["cheddar"],
  ["beef", "corn", "jalapeno"],
);
console.log(pizza4);

// Bonus
function randomPizza() {
  var crustTypes = ["deep dish", "hand tossed", "thin crust", "stuffed crust"];
  var sauceTypes = ["traditional", "marinara", "alfredo", "bbq"];
  var cheeseOptions = ["mozzarella", "feta", "parmesan", "cheddar"];
  var toppingOptions = [
    "pepperoni",
    "sausage",
    "mushrooms",
    "olives",
    "onions",
    "chicken",
    "spinach",
    "corn",
    "jalapeno",
  ];

  var randomCrust = crustTypes[Math.floor(Math.random() * crustTypes.length)];
  var randomSauce = sauceTypes[Math.floor(Math.random() * sauceTypes.length)];

  var randomCheese1 =
    cheeseOptions[Math.floor(Math.random() * cheeseOptions.length)];

  var randomCheese2 =
    cheeseOptions[Math.floor(Math.random() * cheeseOptions.length)];

  var randomTopping1 =
    toppingOptions[Math.floor(Math.random() * toppingOptions.length)];
  var randomTopping2 =
    toppingOptions[Math.floor(Math.random() * toppingOptions.length)];
  var randomTopping3 =
    toppingOptions[Math.floor(Math.random() * toppingOptions.length)];

  return pizzaOven(
    randomCrust,
    randomSauce,
    [randomCheese1, randomCheese2],
    [randomTopping1, randomTopping2, randomTopping3],
  );
}

console.log(randomPizza());
