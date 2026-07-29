import { useState } from "react";

const Form = () => {
  const [firstName, setfirstName] = useState("");
  const [lastName, setlastName] = useState("");
  const [Email, setEmail] = useState("");
  const [Password, setPassword] = useState("");
  const [confirmPassword, setconfirmPassword] = useState("");

  return (
    <form>
      <div>
        <label htmlFor="firstName">firstName</label>
        <input
          type="text"
          name="firstName"
          id="firstName"
          value={firstName}
          onChange={(e) => setfirstName(e.target.value)}
        />
      </div>
      <div>
        <label htmlFor="lastName">lastName</label>
        <input
          type="text"
          name="lastName"
          id="lastName"
          value={lastName}
          onChange={(e) => setlastName(e.target.value)}
        />
      </div>
      <div>
        <label htmlFor="Email">Email</label>
        <input
          type="email"
          name="Email"
          id="Email"
          value={Email}
          onChange={(e) => setEmail(e.target.value)}
        />
      </div>
      <div>
        <label htmlFor="Password">Password</label>
        <input
          type="password"
          name="Password"
          id="Password"
          value={Password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>
      <div>
        <label htmlFor="confirmPassword">confirmPassword</label>
        <input
          type="password"
          name="confirmPassword"
          id="confirmPassword"
          value={confirmPassword}
          onChange={(e) => setconfirmPassword(e.target.value)}
        />
      </div>

      <hr />

      <h2>Your Form Data</h2>

      <p>First Name: {firstName}</p>
      <p>Last Name: {lastName}</p>
      <p>Email: {Email}</p>
      <p>Password: {Password}</p>
      <p>Confirm Password: {confirmPassword}</p>
    </form>
  );
};

export default Form;
