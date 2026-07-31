import { useState } from "react";
import { useNavigate } from "react-router-dom";

const SearchForm = () => {
  const [resource, setResource] = useState("people");
  const [id, setId] = useState("");
  const navigate = useNavigate();

  const submitHandler = (e) => {
    e.preventDefault();

    if (id.trim() === "") {
      return;
    }

    navigate(`/${resource}/${id}`);
  };

  return (
    <form
      onSubmit={submitHandler}
      style={{
        display: "flex",
        alignItems: "center",
        gap: "10px",
        marginBottom: "30px",
      }}
    >
      <label htmlFor="resource">Search for:</label>

      <select
        id="resource"
        value={resource}
        onChange={(e) => setResource(e.target.value)}
      >
        <option value="people">People</option>
        <option value="planets">Planets</option>
      </select>

      <label htmlFor="id">ID:</label>

      <input
        type="number"
        id="id"
        min="1"
        value={id}
        onChange={(e) => setId(e.target.value)}
      />

      <button type="submit">Search</button>
    </form>
  );
};

export default SearchForm;
