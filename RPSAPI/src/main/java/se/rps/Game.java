package se.rps;

import java.io.IOException;

public class Game {
	
	public static String playerVsComputer(String player) throws IOException {
		
		// Changed logic from conditional operations(ternary) to if/else for String return instead of int.
		// as part of the documentation assignment.
		
		String playerOne = player.toLowerCase().strip();
		String computer = Computer.computer();
		String result = "";
		
		if (playerOne.equals(computer)) {
			ScoreBean.ties++;
			result = "It's a tie";
		} else if (playerOne.equals("rock") && computer.equals("scissor")) {
			ScoreBean.wins++;
			result = "Player wins";
		} else if (playerOne.equals("paper") && computer.equals("rock")) {
			ScoreBean.wins++;
			result = "Player wins";
		} else if (playerOne.equals("scissor") && computer.equals("paper")) {
			ScoreBean.wins++;
			result = "Player wins";
		} else {
			ScoreBean.loss++;
			result = "Player lost";
		} return result;
		
		}
	
	public static String playerVsPlayer(String pOne, String pTwo) throws IOException {
		
		// Changed logic from conditional operations(ternary) to if/else for String return instead of int.
		// as part of the documentation assignment.
		
		String playerTwo = pTwo.toLowerCase().strip();
		String playerOne = pOne.toLowerCase().strip();
		String result = "";
		
		if (playerOne.equals(playerTwo)) {
			ScoreBean.ties++;
			result = "It's a tie";
		} else if (playerOne.equals("rock") && playerTwo.equals("scissor")) {
			ScoreBean.wins++;
			result = "Player One wins";
		} else if (playerOne.equals("paper") && playerTwo.equals("rock")) {
			ScoreBean.wins++;
			result = "Player One wins";
		} else if (playerOne.equals("scissor") && playerTwo.equals("paper")) {
			ScoreBean.wins++;
			result = "Player One wins";
		} else {
			ScoreBean.loss++;
			result = "Player Two wins";
		} return result;

			
	}

}
