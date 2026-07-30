import { useState } from "react";
import axios from "axios";

const Pokemon = () => {
  const [pokemon, setPokemon] = useState([]);

  const fetchPokemon = async () => {
    try {
      const response = await axios.get(
        "https://pokeapi.co/api/v2/pokemon?limit=807",
      );

      setPokemon(response.data.results);
    } catch (error) {
      console.log("Error fetching Pokemon:", error);
    }
  };

  return (
    <div>
      <button onClick={fetchPokemon}>Fetch or find Pokemon</button>

      <ul>
        {pokemon.map((item) => (
          <li key={item.name}>{item.name}</li>
        ))}
      </ul>
    </div>
  );
};

export default Pokemon;
