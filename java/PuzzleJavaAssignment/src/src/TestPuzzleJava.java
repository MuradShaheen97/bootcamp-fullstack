package src;

import java.util.ArrayList;
import java.util.Arrays;

public class TestPuzzleJava {

    public static void main(String[] args) {

        PuzzleJava generator = new PuzzleJava();

        ArrayList<Integer> rolls = generator.getTenRolls();
        System.out.println("Ten Random Rolls:");
        System.out.println(rolls);

        System.out.println();

        System.out.println("Random Letter:");
        System.out.println(generator.getRandomLetter());

        System.out.println();

        System.out.println("Random Password:");
        System.out.println(generator.generatePassword());

        System.out.println();

        System.out.println("Password Set:");
        ArrayList<String> passwords = generator.getNewPasswordSet(5);
        System.out.println(passwords);

        System.out.println();

        int[] numbers = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("Before Shuffle:");
        System.out.println(Arrays.toString(numbers));

        generator.shuffleArray(numbers);

        System.out.println("After Shuffle:");
        System.out.println(Arrays.toString(numbers));
    }
}
