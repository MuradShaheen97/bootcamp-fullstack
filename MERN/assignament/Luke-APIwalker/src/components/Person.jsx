import axios from "axios";
import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

const Person = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  const [person, setPerson] = useState(null);
  const [homeworld, setHomeworld] = useState(null);
  const [homeworldId, setHomeworldId] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    setLoading(true);
    setPerson(null);
    setHomeworld(null);
    setHomeworldId(null);

    axios
      .get(`https://swapi.py4e.com/api/people/${id}/`)
      .then((response) => {
        const personData = response.data;

        setPerson(personData);

        const planetId = personData.homeworld.split("/").filter(Boolean).pop();

        setHomeworldId(planetId);

        return axios.get(personData.homeworld);
      })
      .then((response) => {
        setHomeworld(response.data);
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
    return <p>Loading person...</p>;
  }

  if (!person) {
    return null;
  }

  return (
    <section>
      <h2>{person.name}</h2>

      <p>
        <strong>Height:</strong> {person.height} cm
      </p>

      <p>
        <strong>Mass:</strong> {person.mass} kg
      </p>

      <p>
        <strong>Hair Color:</strong> {person.hair_color}
      </p>

      <p>
        <strong>Skin Color:</strong> {person.skin_color}
      </p>

      <p>
        <strong>Homeworld:</strong>{" "}
        {homeworld && homeworldId ? (
          <Link to={`/planets/${homeworldId}`}>{homeworld.name}</Link>
        ) : (
          "Loading homeworld..."
        )}
      </p>
    </section>
  );
};

export default Person;
