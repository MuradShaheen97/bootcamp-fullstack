// Parent class for all cards
class Card {
  constructor(name, cost) {
    this.name = name;
    this.cost = cost;
  }
}

// Unit card with power and resilience
class Unit extends Card {
  constructor(name, cost, power, resilience) {
    super(name, cost);
    this.power = power;
    this.resilience = resilience;
  }

  // Attack another Unit
  attack(target) {
    if (!(target instanceof Unit)) {
      throw new Error("Attack target must be a Unit!");
    }

    target.resilience -= this.power;

    console.log(
      `${this.name} attacks ${target.name} for ${this.power} damage.`,
    );

    return this;
  }
}

// Effect card changes a Unit's stats
class Effect extends Card {
  constructor(name, cost, text, stat, magnitude) {
    super(name, cost);

    // Only power or resilience can be changed
    if (stat !== "power" && stat !== "resilience") {
      throw new Error("Effect stat must be power or resilience!");
    }

    this.text = text;
    this.stat = stat;
    this.magnitude = magnitude;
  }

  // Play the Effect on a Unit
  play(target) {
    // Make sure the target is a Unit
    if (!(target instanceof Unit)) {
      throw new Error("Effect target must be a Unit!");
    }

    // Update the correct stat
    if (this.stat === "power") {
      target.power += this.magnitude;
    } else if (this.stat === "resilience") {
      target.resilience += this.magnitude;
    }

    console.log(`${this.name} was played on ${target.name}.`);
    console.log(this.text);

    return this;
  }
}

// Create Unit cards
const redBeltNinja = new Unit("Red Belt Ninja", 3, 3, 4);
const blackBeltNinja = new Unit("Black Belt Ninja", 4, 5, 4);

// Create Effect cards
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

// Required game scenario
hardAlgorithm.play(redBeltNinja);
unhandledPromiseRejection.play(redBeltNinja);
pairProgramming.play(redBeltNinja);
redBeltNinja.attack(blackBeltNinja);

// Display final card information
console.log(redBeltNinja);
console.log(blackBeltNinja);

// Final values:
//
// Red Belt Ninja:
// power = 5
// resilience = 5
//
// Black Belt Ninja:
// power = 5
// resilience = -1
