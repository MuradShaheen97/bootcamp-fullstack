import { Link } from "react-router-dom";

const Error = () => {
  return (
    <section>
      <h2>These aren't the droids you're looking for.</h2>

      <img
        src="/obi-wan.jpg"
        alt="Obi-Wan Kenobi"
        style={{
          width: "350px",
          maxWidth: "100%",
          display: "block",
          marginTop: "20px",
        }}
      />

      <Link
        to="/"
        style={{
          display: "inline-block",
          marginTop: "20px",
        }}
      >
        Return to search
      </Link>
    </section>
  );
};

export default Error;
