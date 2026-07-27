// import './personCrad.css' // Import CSS here instead

const PersonCard = (props) => {

    return (
        <>

        <h2 class ="name">{props.firstName} {props.lastName}</h2>

        <p class="name">{props.age}</p>
        <p class="name">{props.hairColor}</p>
        </>
    )
}

export default PersonCard;