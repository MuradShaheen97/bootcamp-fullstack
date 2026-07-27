// Parent class for all cards
class Card {
  constructor(name, cost) {
    this.name = name;
    this.cost = cost;
  }
}

// Unit cards can attack other Unit cards
class Unit extends Card {
  constructor(name, cost, power, resilience) {
    super(name, cost);
    this.power = power;
    this.resilience = resilience;
  }

  attack(target) {
    if (!(target instanceof Unit)) {
      throw new Error("Attack target must be a Unit!");
    }

    target.resilience -= this.power;

    console.log(
      `${this.name} attacks ${target.name} for ${this.power} damage.`,
    );
    console.log(`${target.name} now has ${target.resilience} resilience.`);

    return this;
  }
}

// Effect cards modify a Unit's power or resilience
class Effect extends Card {
  constructor(name, cost, text, stat, magnitude) {
    super(name, cost);

    if (stat !== "power" && stat !== "resilience") {
      throw new Error("Effect stat must be power or resilience!");
    }

    this.text = text;
    this.stat = stat;
    this.magnitude = magnitude;
  }

  play(target) {
    if (!(target instanceof Unit)) {
      throw new Error("Effect target must be a Unit!");
    }

    target[this.stat] += this.magnitude;

    console.log(`${this.name} was played on ${target.name}.`);
    console.log(this.text);
    console.log(`${target.name}'s ${this.stat} is now ${target[this.stat]}.`);

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

// Play the required scenario
hardAlgorithm.play(redBeltNinja);
unhandledPromiseRejection.play(redBeltNinja);
pairProgramming.play(redBeltNinja);
redBeltNinja.attack(blackBeltNinja);

// Display final card information
console.log(redBeltNinja);
console.log(blackBeltNinja);

//Final values

// Red Belt Ninja:
// power = 5
// resilience = 5

// Black Belt Ninja:
// power = 5
// resilience = -1
