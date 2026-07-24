// Parent class for all cards.

// Both Unit cards and Effect cards share a name and cost.

class Card {
  constructor(name, cost) {
    this.name = name;

    this.cost = cost;
  }
}

// Unit inherits the name and cost properties from Card.

class Unit extends Card {
  constructor(name, cost, power, resilience) {
    // Calls the Card constructor.

    super(name, cost);

    // The amount of damage this Unit can deal.

    this.power = power;

    // The amount of damage this Unit can receive.

    this.resilience = resilience;
  }

  // Allows this Unit to attack another Unit.

  attack(target) {
    // Check that the target is an instance of Unit.

    if (target instanceof Unit) {
      // Reduce the target's resilience by this Unit's power.

      target.resilience -= this.power;

      console.log(
        `${this.name} attacks ${target.name} for ${this.power} damage.`,
      );

      console.log(`${target.name} now has ${target.resilience} resilience.`);

      // Returning this allows method chaining if needed.

      return this;
    }

    // Throw an error if the target is not a Unit.

    throw new Error("Attack target must be a Unit!");
  }
}

// Effect also inherits the name and cost properties from Card.

class Effect extends Card {
  constructor(name, cost, text, stat, magnitude) {
    // Calls the Card constructor.

    super(name, cost);

    // A description of what the Effect card does.

    this.text = text;

    // The Unit property that will change:

    // either "power" or "resilience".

    this.stat = stat;

    // The amount added to or removed from the property.

    // Positive numbers increase the stat.

    // Negative numbers decrease the stat.

    this.magnitude = magnitude;
  }

  // Applies the Effect card to a Unit.

  play(target) {
    // Check that the target is an instance of Unit.

    if (target instanceof Unit) {
      // Change the selected stat using bracket notation.

      // Example:

      // target["resilience"] += 3;

      target[this.stat] += this.magnitude;

      console.log(`${this.name} was played on ${target.name}.`);

      console.log(this.text);

      console.log(`${target.name}'s ${this.stat} is now ${target[this.stat]}.`);

      return this;
    }

    // Throw an error if the target is not a Unit.

    throw new Error("Effect target must be a Unit!");
  }
}

// Create the Unit cards

const redBeltNinja = new Unit(
  "Red Belt Ninja",

  3,

  3,

  4,
);

const blackBeltNinja = new Unit(
  "Black Belt Ninja",

  4,

  5,

  4,
);

// Create the Effect cards

const hardAlgorithm = new Effect(
  "Hard Algorithm",

  2,

  "Increase target's resilience by 3.",

  "resilience",

  3,
);

const unhandledPromiseRejection = new Effect(
  "Unhandled Promise Rejection",

  1,

  "Reduce target's resilience by 2.",

  "resilience",

  -2,
);

const pairProgramming = new Effect(
  "Pair Programming",

  3,

  "Increase target's power by 2.",

  "power",

  2,
);

// Play the required scenario

// Turn 1:

// Red Belt Ninja starts with 4 resilience.

// Hard Algorithm adds 3 resilience.

// New resilience: 7

hardAlgorithm.play(redBeltNinja);

// Turn 2:

// Unhandled Promise Rejection removes 2 resilience.

// New resilience: 5

unhandledPromiseRejection.play(redBeltNinja);

// Turn 3:

// Pair Programming adds 2 power.

// Red Belt Ninja's power changes from 3 to 5.

pairProgramming.play(redBeltNinja);

// Red Belt Ninja attacks Black Belt Ninja.

// Black Belt Ninja starts with 4 resilience.

// It receives 5 damage.

// New resilience: -1

redBeltNinja.attack(blackBeltNinja);

// Display the final card information.

console.log(redBeltNinja);

console.log(blackBeltNinja);
