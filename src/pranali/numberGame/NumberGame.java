package pranali.numberGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
	private int tries;
	private int rounds;
	private int roundsWon;
	private int roundsLost;
	private int totalAttempts;
	
	public NumberGame(int tries, int rounds) {
		this.tries = tries;
		this.rounds = rounds;
	}

	private static void displayStats(NumberGame numGame) {
		System.out.println("-------------- Your Score --------------");
		System.out.println("Number of attempts taken: " + numGame.totalAttempts + " out of " + 7*numGame.rounds);
		System.out.println("Total rounds played: " + numGame.rounds);
		System.out.println("Rounds won: " + numGame.roundsWon);
		System.out.println("Rounds lost: " + numGame.roundsLost);
	}

	private static void playGame(NumberGame numGame, Scanner sc) {
		numGame.rounds++;
		numGame.tries = 7;
		Random rand = new Random();
		int num = rand.nextInt(100) + 1;
		System.out.println("You have 7 tries to guess the exact number(1 - 100)");
		System.out.println("Your guess? ");
		int userGuess;
		
		while((userGuess = sc.nextInt()) != num && (--numGame.tries) != 0) {
			numGame.totalAttempts++;
			if(!(userGuess > 0 && userGuess <= 100)) {
				System.out.println("Guess should be between 1 to 100");
			}
			else if(userGuess > num+5) {
				System.out.println("Too high!");
			}
			else if(userGuess < num-5) {
				System.out.println("Too low!");
			}
			else if(Math.abs(userGuess - num) <=5) {
				if(userGuess < num)
					System.out.println("You are close!, but it's higher");
				else
					System.out.println("You are close!, but it's lower");
			}
			System.out.println("Tries left - "+ numGame.tries);
			System.out.print("Guess again - ");
			
		}
		if(userGuess == num) {
			numGame.roundsWon++;
			System.out.println("You won! Congratulations <3");
			
		}
		else if(numGame.tries == 0) {
			System.out.println("You lost!");
			numGame.roundsLost++;
			System.out.println("The number was "+num);
		}
	}

	public static void main(String[] args) {
		NumberGame numberGame = new NumberGame(7, 0);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Welcome! Let's play guessing game");
		playGame(numberGame, sc);
		String input = "yes";
		while(input.equals("yes")) {
			System.out.println("Wanna try again??(yes/no)");
			input = sc.next();
			if(input.equals("yes"))
				playGame(numberGame, sc);	
		}
		displayStats(numberGame);
	}

}
