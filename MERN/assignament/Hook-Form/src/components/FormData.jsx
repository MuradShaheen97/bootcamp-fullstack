const FormData = ({
  firstName,
  lastName,
  email,
  password,
  confirmPassword,
}) => {
  return (
    <div>
      <hr />

      <h2>Your Form Data</h2>

      <p>First Name: {firstName}</p>
      <p>Last Name: {lastName}</p>
      <p>Email: {email}</p>
      <p>Password: {password}</p>
      <p>Confirm Password: {confirmPassword}</p>
    </div>
  );
};

export default FormData;
