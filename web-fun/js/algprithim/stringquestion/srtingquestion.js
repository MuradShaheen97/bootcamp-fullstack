// 1
function reverseString(str) {
  let result = "";

  for (let i = str.length - 1; i >= 0; i--) {
    result += str[i];
  }

  return result;
}
// 2
function countVowels(str) {
  let count = 0;

  for (let i = 0; i < str.length; i++) {
    let ch = str[i];

    if (ch === "a" || ch === "e" || ch === "i" || ch === "o" || ch === "u") {
      count++;
    }
  }

  return count;
}

// 3
function isPalindrome(str) {
  for (let i = 0; i < str.length / 2; i++) {
    if (str[i] !== str[str.length - 1 - i]) {
      return false;
    }
  }

  return true;
}

// 4

function longestWord(sentence) {
  let longest = "";
  let current = "";

  for (let i = 0; i < sentence.length; i++) {
    if (sentence[i] !== " ") {
      current += sentence[i];
    } else {
      if (current.length > longest.length) {
        longest = current;
      }
      current = "";
    }
  }
  if (current.length > longest.length) {
    longest = current;
  }

  return longest;
}

////////////////////////

// 1
function gradeFeedback(grade) {
  switch (grade) {
    case "A":
      return "Excellent";

    case "B":
      return "Good job";

    case "C":
      return "You passed";

    case "D":
      return "Need improvement";

    case "F":
      return "Failed";

    default:
      return "Invalid grade";
  }
}

// 2

function countTypes(str) {
  let vowels = 0;
  let digits = 0;
  let spaces = 0;
  let others = 0;

  for (let i = 0; i < str.length; i++) {
    let ch = str[i];

    switch (ch) {
      // vowels
      case "a":
      case "e":
      case "i":
      case "o":
      case "u":
      case "A":
      case "E":
      case "I":
      case "O":
      case "U":
        vowels++;
        break;

      // space
      case " ":
        spaces++;
        break;

      default:
        // digits check
        if (ch >= "0" && ch <= "9") {
          digits++;
        } else {
          others++;
        }
    }
  }

  return {
    vowels: vowels,
    digits: digits,
    spaces: spaces,
    others: others,
  };
}
