import { useState } from "react";

const Form = ({ boxes, setBoxes }) => {
  const [color, setColor] = useState("");
  const [size, setSize] = useState("");

  const submitHandler = (e) => {
    e.preventDefault();

    if (color.trim() === "") return;

    const newBox = {
      color: color,
      size: size === "" ? 100 : Number(size),
    };

    setBoxes([...boxes, newBox]);

    setColor("");
    setSize("");
  };

  return (
    <form onSubmit={submitHandler}>
      <div>
        <label>Color</label>

        <input
          type="text"
          value={color}
          onChange={(e) => setColor(e.target.value)}
        />
      </div>

      <div>
        <label>Size</label>

        <input
          type="number"
          value={size}
          onChange={(e) => setSize(e.target.value)}
        />
      </div>

      <button>Add</button>
    </form>
  );
};

export default Form;
