// import { useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from './assets/vite.svg'
// import heroImg from './assets/hero.png'
import './App.css'
import Card from './components/card'

function App() {
return(
<div>
  <Card
    firstname="jane "
    lastname="doe" 
    age={45} 
    hair="black"
    />

  <Card
    firstname="john" 
    lastname="smith" 
    age={88} 
    hair="brown"
    />
  </div>
)


}

export default App
