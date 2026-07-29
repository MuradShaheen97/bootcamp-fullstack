import { useState } from "react";
import "./App.css";
import Form from "./Components/Form";
import BoxDisplay from "./Components/BoxDisplay";

function App() {
  const [boxes, setBoxes] = useState([]);

  return (
    <>
      <Form boxes={boxes} setBoxes={setBoxes} />
      <BoxDisplay boxes={boxes} />
    </>
  );
}

export default App;