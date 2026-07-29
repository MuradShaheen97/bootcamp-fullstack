const BoxDisplay = ({ boxes }) => {
  return (
    <div className="boxes">
      {boxes.map((box, index) => (
        <div
          key={index}
          className="box"
          style={{
            backgroundColor: box.color,
            width: `${box.size}px`,
            height: `${box.size}px`,
          }}
        ></div>
      ))}
    </div>
  );
};

export default BoxDisplay;
