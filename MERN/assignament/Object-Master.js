const pokemon = Object.freeze([
  { id: 1, name: "Bulbasaur", types: ["poison", "grass"] },
  { id: 5, name: "Charmeleon", types: ["fire"] },
  { id: 9, name: "Blastoise", types: ["water"] },
  { id: 12, name: "Butterfree", types: ["bug", "flying"] },
  { id: 16, name: "Pidgey", types: ["normal", "flying"] },
  { id: 23, name: "Ekans", types: ["poison"] },
  { id: 24, name: "Arbok", types: ["poison"] },
  { id: 25, name: "Pikachu", types: ["electric"] },
  { id: 37, name: "Vulpix", types: ["fire"] },
  { id: 52, name: "Meowth", types: ["normal"] },
  { id: 63, name: "Abra", types: ["psychic"] },
  { id: 67, name: "Machamp", types: ["fighting"] },
  { id: 72, name: "Tentacool", types: ["water", "poison"] },
  { id: 74, name: "Geodude", types: ["rock", "ground"] },
  { id: 87, name: "Dewgong", types: ["water", "ice"] },
  { id: 98, name: "Krabby", types: ["water"] },
  { id: 115, name: "Kangaskhan", types: ["normal"] },
  { id: 122, name: "Mr. Mime", types: ["psychic"] },
  { id: 133, name: "Eevee", types: ["normal"] },
  { id: 144, name: "Articuno", types: ["ice", "flying"] },
  { id: 145, name: "Zapdos", types: ["electric", "flying"] },
  { id: 146, name: "Moltres", types: ["fire", "flying"] },
  { id: 148, name: "Dragonair", types: ["dragon"] },
]);

// 1. Get all Pokémon whose id is divisible by 3

const divisibleBy3 = pokemon.filter((p) => p.id % 3 === 0);

console.log(divisibleBy3);

// 2. Get all Pokémon that have the "fire" type

const firePokemon = pokemon.filter((p) => p.types.includes("fire"));

console.log(firePokemon);

// 3. Get all Pokémon that have more than one type

const multipleTypes = pokemon.filter((p) => p.types.length > 1);

console.log(multipleTypes);

// 4. Create an array containing only the Pokémon names

const names = pokemon.map((p) => p.name);

console.log(names);

// 5. Create an array with the names of Pokémon
//    whose id is greater than 99

const namesOver99 = pokemon.filter((p) => p.id > 99).map((p) => p.name);

console.log(namesOver99);

// 6. Create an array with the names of Pokémon
//    whose ONLY type is poison

const poisonOnly = pokemon
  .filter((p) => p.types.length === 1 && p.types[0] === "poison")
  .map((p) => p.name);

console.log(poisonOnly);

// 7. Create an array containing only the FIRST type
//    of Pokémon whose SECOND type is flying

const firstFlyingTypes = pokemon
  .filter((p) => p.types[1] === "flying")
  .map((p) => p.types[0]);

console.log(firstFlyingTypes);

// 8. Count how many Pokémon have the "normal" type

const normalCount = pokemon.filter((p) => p.types.includes("normal")).length;

console.log(normalCount);
