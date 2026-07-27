// import { useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from './assets/vite.svg'
// import heroImg from './assets/hero.png'
import PersonCard from './components/PersonCard'
// import './App.css'
import './components/personCrad.css' // Import CSS here instead
function App() {
return (
  <div>
    <PersonCard firstName="Jane" lastName="Doe" age={45} hairColor="Black" />
    <PersonCard firstName="john" lastName="smith" age={88} hairColor="brown" />
    <PersonCard firstName="millard" lastName="fillmore" age={50} hairColor="brown" />
    <PersonCard firstName="maria" lastName="smith" age={62} hairColor="brown" />
  </div>
)
}

export default App
