import { Route, Routes } from "react-router-dom";
import SearchForm from "./components/SearchForm";
import Person from "./components/Person";
import Planet from "./components/Planet";
import Error from "./components/Error";
import Home from "./pages/Home";

function App() {
  return (
    <main
      style={{
        width: "700px",
        maxWidth: "90%",
        margin: "40px auto",
        fontFamily: "Arial, sans-serif",
      }}
    >
      <h1>Luke APIwalker</h1>

      <SearchForm />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/people/:id" element={<Person />} />
        <Route path="/planets/:id" element={<Planet />} />
        <Route path="/error" element={<Error />} />
        <Route path="*" element={<Error />} />
      </Routes>
    </main>
  );
}

export default App;
