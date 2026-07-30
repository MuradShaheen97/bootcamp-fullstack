import { useState } from "react";

const Pokemon = () => {
  const [pokemon, setPokemon] = useState([]);

  const fetchPokemon = async () => {
    try {
      const response = await fetch(
        "https://pokeapi.co/api/v2/pokemon?limit=807",
      );

      const data = await response.json();

      setPokemon(data.results);
    } catch (error) {
      console.log("Error fetching Pokemon:", error);
    }
  };

  return (
    <div>
      <button onClick={fetchPokemon}>(Fetch (find) Pokemon)</button>

      <ul>
        {pokemon.map((item) => (
          <li key={item.name}>{item.name}</li>
        ))}
      </ul>
    </div>
  );
};

export default Pokemon;
