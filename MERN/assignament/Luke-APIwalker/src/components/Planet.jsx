import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const Planet = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  const [planet, setPlanet] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    setLoading(true);
    setPlanet(null);

    axios
      .get(`https://swapi.py4e.com/api/planets/${id}/`)
      .then((response) => {
        setPlanet(response.data);
      })
      .catch((error) => {
        console.error(error);
        navigate("/error");
      })
      .finally(() => {
        setLoading(false);
      });
  }, [id, navigate]);

  if (loading) {
    return <p>Loading planet...</p>;
  }

  if (!planet) {
    return null;
  }

  return (
    <section>
      <h2>{planet.name}</h2>

      <p>
        <strong>Climate:</strong> {planet.climate}
      </p>

      <p>
        <strong>Terrain:</strong> {planet.terrain}
      </p>

      <p>
        <strong>Surface Water:</strong> {planet.surface_water}
      </p>

      <p>
        <strong>Population:</strong> {planet.population}
      </p>
    </section>
  );
};

export default Planet;
