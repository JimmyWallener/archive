
import java.util.Scanner;
import java.util.Random;


/*******************************
 * Hangman Game by Jimmy Wallener
 * Java development class.
 *
 * Project involves:
 * 1. Create a game menu.
 * 2. Let user guess letter or whole word.
 * 3. Display _ _ _ _ depending on word, then fill in right letter on its place.
 * 4. Display number of guesses and how many remaining before Game Over.
 * 5. Display graphically the different stages of hanging man.
 * 6. Display congratulations if player manages to guess the word.
 *
 * Player will have 10 guesses before Game Over.
 * Guesses are counted for both wrong & right because of high amount of guesses
 * Word will be taken from random array.
 * User can restart game
 *
 * ******************************/

public class Hangman {

    public static void main(String[] args) {

        // First assign the variables needed
        int numberOfGuesses = 10; // User gets 10 guesses
        int wrongGuesses = 0; // variable to keep track of guesses made
        Scanner reader = new Scanner(System.in);
        String[] words = {"programming", "java", "winter", "snowman", "christmas", "homework", "boolean", "integer", "double",
                "joyful", "blitzen", "holiday", "hangman", "mistletoe" };
        String guessedWord;
        boolean gameIsOn = true;
        Random random = new Random();
            // Game while loop, active as long as true
        while (gameIsOn) {
            System.out.println("**********************************************\n" +
                    "* Welcome to a game of Hangman\n" +
                    "* You have " + numberOfGuesses + " guesses before game over\n" +
                    "* All guesses count - both right and wrong\n" +
                    "* There is the option to guess whole word or a single letter\n" +
                    "* Good Luck!\n" +
                    "***********************************************************\n");
            // Randomises a word from the array based on the length of the array.
            String wordToGuess = words[random.nextInt(words.length)];
            char[] letter = wordToGuess.toCharArray(); // Create array for single letter guesses, by deconstructing it with toCharArray
            char[] lettersToGuess = wordToGuess.toCharArray(); // Creating a second char array to use in loop below.
            // loop pushing out _ based on length of char array.
            for (int i = 0; i < lettersToGuess.length; i++) {
                lettersToGuess[i] = '_';
            }


            boolean isWordGuessed = false;
            // While loop for the guessing of word and letters
            while (!isWordGuessed && numberOfGuesses != wrongGuesses) {
                if (wrongGuesses == 0) {
                    System.out.println(emptyCharacter());
                } else {
                    System.out.println(switchMethod(wrongGuesses));
                }
                blankSpaces(lettersToGuess);
                System.out.println("\nYou have " + (numberOfGuesses - wrongGuesses) + " guesses left");
                System.out.println("Guess the word | Guess a letter: ");
                guessedWord = reader.nextLine().toLowerCase().trim();
                char singleLetter = guessedWord.charAt(0);


                // Checking if user types whole word or just a letter
                if (guessedWord.equals(wordToGuess)) {
                    System.out.println("Congratulations! You entered the correct word " + wordToGuess);
                    System.out.println("Wanna try again?: Y/N");
                    String answer = reader.nextLine().toLowerCase();
                    if (answer.equals("y")) {
                        gameIsOn = true;
                        isWordGuessed = true;
                        wrongGuesses = 0;
                    } else {
                        gameIsOn = false;
                    }

                } else {
                    fillInLetters(letter, lettersToGuess, singleLetter);
                    wrongGuesses++;
                }
                if (isWordEqual(lettersToGuess)) {
                    System.out.println("You won!");
                    System.out.println("The correct word was: " + wordToGuess);
                    System.out.println("Wanna try again?: Y/N");
                    String answer = reader.nextLine().toLowerCase();
                    if (answer.equals("y")) {
                        gameIsOn = true;
                        isWordGuessed = true;
                        wrongGuesses = 0;
                    } else {
                        gameIsOn = false;
                    }
                } else if (!isWordEqual(lettersToGuess) && (wrongGuesses >= numberOfGuesses)) {
                    System.out.println("Game Over!");
                    System.out.println("The correct word was: " + wordToGuess);
                    System.out.println("Wanna try again?: Y/N");
                    String answer = reader.nextLine().toLowerCase();
                    if (answer.equals("y")) {
                        gameIsOn = true;
                        isWordGuessed = true;
                        wrongGuesses = 0;
                    } else {
                        gameIsOn = false;
                    }
                }

            }
        }
    }
    // Method for checking if letter is in word, then replace letter in _ array at right index [i]
    private static void fillInLetters(char[] letter, char[] lettersToGuess, char singleLetter) {
        for (int i = 0; i < letter.length; i++) {
            if (letter[i] == singleLetter) {
                lettersToGuess[i] = singleLetter;
            }
        }
    }
    // prints out the _ with blank spaces in between
    private static void blankSpaces(char[] letters) {
        for (char letter : letters) {
            System.out.print(letter + " ");
        }
    }

    // checks if there is anymore _ in the word, else return true and stop game
    private static boolean isWordEqual(char[] letters) {
        for (char letter : letters) {
            if (letter == '_') return false;
        } return true;
    }
    private static String switchMethod(int number) {
        switch (number) {
            case 1:
                return drawPoleFirstLine();
            case 2:
                return drawPoleSecondLine();
            case 3:
                return drawPoleThirdLine();
            case 4:
                return drawRope();
            case 5:
                return drawHead();
            case 6:
                return drawFirstArm();
            case 7:
                return drawBody();
            case 8:
                return drawSecondArm();
            case 9:
                return drawFirstLeg();
            case 10:
                return drawWholeBody();
            default:
                return "Hmm, something is broken";

        }

    }



    // creating private classes that returns a string containing the hangman in different stages
    private static String emptyCharacter() {
        return "  \n" +
                " |         \n" +
                " |        \n" +
                " |      \n" +
                " |      \n" +
                " | \n" +
                " | ";
    }
    private static String drawPoleFirstLine() {
        return "  ___\n" +
                " |         \n" +
                " |        \n" +
                " |      \n" +
                " |      \n" +
                " | \n" +
                " | ";
    }
    private static String drawPoleSecondLine() {
        return "  _____\n" +
                " |         \n" +
                " |        \n" +
                " |      \n" +
                " |      \n" +
                " | \n" +
                " | ";
    }
    private static String drawPoleThirdLine() {
        return "  _______\n" +
                " |         \n" +
                " |        \n" +
                " |      \n" +
                " |      \n" +
                " | \n" +
                " | ";
    }
    private static String drawRope() {
        return "  _______ \n" +
                " |       |  \n" +
                " |        \n" +
                " |      \n" +
                " |      \n" +
                " | \n" +
                " | ";
    }
    private static String drawHead() {
        return "  _______ \n" +
                " |       |  \n" +
                " |       O \n" +
                " |      \n" +
                " |      \n" +
                " | \n" +
                " | ";
    }
    private static String drawFirstArm() {
        return "  _______ \n" +
                " |       |  \n" +
                " |       O \n" +
                " |      /\n" +
                " |      \n" +
                " | \n" +
                " | ";
    }
    private static String drawBody() {
        return "  _______ \n" +
                " |       |  \n" +
                " |       O \n" +
                " |      /|\n" +
                " |      \n" +
                " | \n" +
                " | ";
    }
    private static String drawSecondArm() {
        return "  _______ \n" +
                " |       |  \n" +
                " |       O \n" +
                " |      /|\\ \n" +
                " |       \n" +
                " | \n" +
                " | ";
    }

    private static String drawFirstLeg() {
        return "  _______ \n" +
                " |       |  \n" +
                " |       O \n" +
                " |      /|\\ \n" +
                " |      / \n" +
                " | \n" +
                " | ";
    }
    private static String drawWholeBody() {
        return "  _______ \n" +
                " |       |  \n" +
                " |       O \n" +
                " |      /|\\ \n" +
                " |      / \\ \n" +
                " | \n" +
                " | ";
    }
}


