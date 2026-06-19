package src;

import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

    private Random random = new Random();

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> rolls = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            rolls.add(random.nextInt(20) + 1);
        }

        return rolls;
    }

    public char getRandomLetter() {
        char[] letters = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'
        };

        int randomIndex = random.nextInt(26);
        return letters[randomIndex];
    }

    public String generatePassword() {
        String password = "";

        for (int i = 0; i < 8; i++) {
            password += getRandomLetter();
        }

        return password;
    }

    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> passwords = new ArrayList<String>();

        for (int i = 0; i < length; i++) {
            passwords.add(generatePassword());
        }

        return passwords;
    }

    public void shuffleArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int randomIndex = random.nextInt(numbers.length);

            int temp = numbers[i];
            numbers[i] = numbers[randomIndex];
            numbers[randomIndex] = temp;
        }
    }
}