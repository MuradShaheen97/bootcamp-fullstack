const express = require("express");
const app = express();
const PORT = 8000;
const { faker } = require("@faker-js/faker");

const createuser = () => {
  const user = {
    _id: faker.string.uuid(),
    firstName: faker.person.firstName(),
    lastName: faker.person.lastName(),
    email: faker.internet.email(),
    password: faker.internet.password(),
    phone: faker.phone.number(),
  };
  return user 
};

const createcompany = () => {
  const company = {
    _id: faker.string.uuid(),
    name: faker.company.name(),
    address: {
      street: faker.location.street(),
      City: faker.location.city(),
      state: faker.location.state(),
      zipCode: faker.location.zipCode(),
      country: faker.location.country(),
    },
  };
  return company
};

app.get("/api/GET/users/new" , (req,res)=>{
  const newuser = createuser()
  res.status(200).json({user: newuser})
})


app.get("/api/GET/companys/new" , (req,res)=>{
  const newcompany = createcompany()
  res.status(200).json({company: newcompany})
})



app.get("/api/GET/users/companys" , (req,res)=>{
  const newcompany = createcompany()
  const newuser = createuser()
  res.status(200).json({company: newcompany, 
    user: newuser
  })
})
app.listen(PORT,()=>{console.log("server is runing")})
