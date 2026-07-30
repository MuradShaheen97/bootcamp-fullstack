import { useState } from "react";
import Result from "./Result";

function tossCoin() {
  return Math.random() > 0.5 ? "heads" : "tails";
}

const CoinFlip = () => {
  const [message, setMessage] = useState("");

  const fiveHeads = () => {
    return new Promise((resolve) => {
      let headsCount = 0;
      let attempts = 0;

      while (headsCount < 5) {
        attempts++;

        const result = tossCoin();
        console.log(`${result} was flipped`);

        if (result === "heads") {
          headsCount++;
        } else {
          headsCount = 0;
        }
      }

      resolve(`It took ${attempts} tries to flip five heads in a row.`);
    });
  };

  const startGame = () => {
    fiveHeads().then((res) => {
      setMessage(res);
    });

    console.log("When does this run now?");
  };

  return (
    <div>
      <button onClick={startGame}>Flip Coin</button>

      <Result message={message} />
    </div>
  );
};

export default CoinFlip;