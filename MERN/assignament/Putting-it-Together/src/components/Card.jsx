import { useState } from "react"

const Card = (props) => {
const [age, setAge] = useState(props.age);
const increaseAge = () =>
    {setAge(age+1)};
return( 
<div>
<h2>
    {props.firstname}{props.lastname} {""}
    </h2>
<p>Age is : {age}</p>
<p>hair color is {props.hair}</p>
<button onClick={increaseAge}> 
    birthday button for {props.firstname} {props.lastname}
    </button>
</div>


);

};
export default Card;