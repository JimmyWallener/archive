package rockscissorpaper;
import java.util.Scanner;


public class Main {

	
	public static void main(String[] args) {
		
		
		/* First lets create the variables we need
		* 1. A Scanner for input
		* 2. String variables for storing player name and choice
		* a while loop boolean for error handling
		* Three integer for storing round and scores.
		*/
		
		Scanner reader = new Scanner(System.in);
		String nameOfPlayerOne = "";
		String nameOfPlayerTwo = "";
		String playerOne = "";
		String playerTwo = "";
		boolean isGameOn = true;
		int numberOfRounds = 0;
		int scorePlayerOne = 0;
		int scorePlayerTwo = 0;
		int playerChoice = 0;
		
		
		
		// Welcome screen to the game. Asks for players name to use in the game.
		
		System.out.println("Welcome to a game of Rock vs Scissor vs Paper\n\nMay the best player win! Good Luck\n");
		System.out.println("Player One, enter your name: ");
		nameOfPlayerOne = reader.nextLine();
		System.out.println("Player Two, enter your name: ");
		nameOfPlayerTwo = reader.nextLine();
		System.out.println("How many rounds do you want to run?");
		playerChoice = reader.nextInt();
		
		// Will place all code inside a while loop, where variable numberOfRounds remains true as long as its value is'nt equal to 5
		
		while(numberOfRounds != playerChoice) {
			
			// Had to create a nested while loop checking if user input is valid, if not, return to beginning and get new input.
			// While loop is set to true (which means it will loop) unless user input is correct, then it moves on.
			// Since user input is treated as String, no try & catch needed, since it will not throw an exception error.
			// Using an if-statement to set allowed values for user input. All else is rejected.
			// Challenge said numbers & words, which this does. Challenge did not stipulate if number had to converted and treated as int.
			
			while (isGameOn) {
			System.out.println("Enter corresponding number or write:\n(" + numberOfRounds + " Round of " + playerChoice + ")\n\n1. Rock\n2. Scissor\n3. Paper\n\n");
			System.out.println("It's your turn, " + nameOfPlayerOne + ". Your current score: " + scorePlayerOne + ". " + nameOfPlayerTwo +"s score is: " + scorePlayerTwo);
			playerOne = reader.nextLine().toLowerCase();
			
			if (playerOne.equals("1") || playerOne.equals("2") || playerOne.equals("3") || playerOne.equals("rock") || playerOne.equals("scissor") || playerOne.equals("paper")) {
				isGameOn = false;
			} else {
				System.out.print("Wrong choice. Try again\n");
			}
			}isGameOn = true;
		
			// Second while loop for player two with same conditionals.
			while (isGameOn) {
			
				System.out.println("Enter corresponding number or write:\n(" + numberOfRounds + " Round of " + playerChoice + "\n\n1. Rock\n2. Scissor\n3. Paper\n\n");
				System.out.println("It's your turn, " + nameOfPlayerTwo + ". Your current score: " + scorePlayerTwo + ". " + nameOfPlayerOne + "s score is: " + scorePlayerOne);
			playerTwo = reader.nextLine().toLowerCase();
			
			if (playerTwo.equals("1") || playerTwo.equals("2") || playerTwo.equals("3") || playerTwo.equals("rock") || playerTwo.equals("scissor") || playerTwo.equals("paper")) {
				isGameOn = false;
			} else {
				System.out.print("Wrong choice. Try again\n");
			}
			}
			isGameOn = true; 
	
			
			 // Creating logic for the game. Will not convert numbers to Integers due to the fact that no Math is involved.
			// Using AND/OR statements for comparing different input and against players.
			// Since input is set to String, I use equals to check if variable holds string value.
			// Was thinking of placing this in own Method and call it, but did it this way.
			
			
			if ((playerOne.equals("1") || playerOne.equals("rock")) && (playerTwo.equals("1") || playerTwo.equals("rock"))){
				System.out.print("It's a draw, both selected Rock. No Points\n");
				numberOfRounds++;
			} else if ((playerOne.equals("2") || playerOne.equals("scissor")) && (playerTwo.equals("2") || playerTwo.equals("scissor"))) {
				System.out.print("It's a draw, both selected Scissor. No Points\n");
				numberOfRounds++;
			} else if ((playerOne.equals("3") || playerOne.equals("paper")) && (playerTwo.equals("3") || playerTwo.equals("paper"))) {
				System.out.print("It's a draw, both selected Paper. No Points\n");
				numberOfRounds++;
			} else if ((playerOne.equals("1") || playerOne.equals("rock")) && (playerTwo.equals("2") || playerTwo.equals("scissor"))) {
				System.out.print("Point to " + nameOfPlayerOne + ".\n");
				numberOfRounds++;
				scorePlayerOne++;
			} else if ((playerOne.equals("2") || playerOne.equals("scissor")) && (playerTwo.equals("3") || playerTwo.equals("paper"))) {
				System.out.print("Point to " + nameOfPlayerOne + ".\n");
				numberOfRounds++;
				scorePlayerOne++;
			} else if ((playerOne.equals("3") || playerOne.equals("paper")) && (playerTwo.equals("1") || playerTwo.equals("rock"))) {
				System.out.print("Point to " + nameOfPlayerOne + ".\n");
				numberOfRounds++;
				scorePlayerOne++;
			} else if ((playerOne.equals("1") || playerOne.equals("rock")) && (playerTwo.equals("3") || playerTwo.equals("paper"))) {
				System.out.print("Point to " + nameOfPlayerTwo + ".\n");
				numberOfRounds++;
				scorePlayerTwo++;
			} else if ((playerOne.equals("2") || playerOne.equals("scissor")) && (playerTwo.equals("1") || playerTwo.equals("rock"))) {
				System.out.print("Point to " + nameOfPlayerTwo + ".\n");
				numberOfRounds++;
				scorePlayerTwo++;
			} else if ((playerOne.equals("3") || playerOne.equals("paper")) && (playerTwo.equals("2") || playerTwo.equals("scissor"))) {
				System.out.print("Point to " + nameOfPlayerTwo + ".\n");
				numberOfRounds++;
				scorePlayerTwo++;
			}
			// Outputs score, added tie since a draw equals no point, but counts as a turn since its best of 5 turns.
		} if (scorePlayerOne > scorePlayerTwo) {
			System.out.println("\nCongratulations " + nameOfPlayerOne + ". You won with " + scorePlayerOne + " against " + nameOfPlayerTwo + "s " + scorePlayerTwo);
		} else if (scorePlayerOne < scorePlayerTwo) {
			System.out.println("\nCongratulations " + nameOfPlayerTwo + ". You won with " + scorePlayerTwo + " against " + nameOfPlayerOne + "s " + scorePlayerOne);
		} else {
			System.out.println("\nYou both scored " + scorePlayerOne + " & " + scorePlayerTwo + ". It's a tie!");
		}
	} 
	} 
	







	
	
		
	
		
	
	
