import { useState } from "react";

const Form = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  return (
    <form>
      <div>
        <label htmlFor="firstName">First Name</label>

        <input
          type="text"
          id="firstName"
          name="firstName"
          value={firstName}
          onChange={(e) => setFirstName(e.target.value)}
        />

        {firstName.length > 0 && firstName.length < 2 && (
          <p>First Name must be at least 2 characters.</p>
        )}
      </div>

      <div>
        <label htmlFor="lastName">Last Name</label>

        <input
          type="text"
          id="lastName"
          name="lastName"
          value={lastName}
          onChange={(e) => setLastName(e.target.value)}
        />

        {lastName.length > 0 && lastName.length < 2 && (
          <p>Last Name must be at least 2 characters.</p>
        )}
      </div>

      <div>
        <label htmlFor="email">Email</label>

        <input
          type="email"
          id="email"
          name="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />

        {email.length > 0 && email.length < 5 && (
          <p>Email must be at least 5 characters.</p>
        )}
      </div>

      <div>
        <label htmlFor="password">Password</label>

        <input
          type="password"
          id="password"
          name="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        {password.length > 0 && password.length < 8 && (
          <p>Password must be at least 8 characters.</p>
        )}
      </div>

      <div>
        <label htmlFor="confirmPassword">Confirm Password</label>

        <input
          type="password"
          id="confirmPassword"
          name="confirmPassword"
          value={confirmPassword}
          onChange={(e) => setConfirmPassword(e.target.value)}
        />

        {confirmPassword.length > 0 && confirmPassword !== password && (
          <p>Passwords must match.</p>
        )}
      </div>
    </form>
  );
};

export default Form;
