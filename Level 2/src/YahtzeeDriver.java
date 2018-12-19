import java.sql.SQLOutput;
import java.util.Scanner;

public class YahtzeeDriver
{
	/*
	1. Creates a new instance of the YahtzeeGame class
	2. Calls the playGame method on the Yahtzee object
	3. Asks user if they would like to play again
	4. When the user is done playing, prints the number of games played, min, max, and average score
	*/
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		String play = new String();
		int minScore = 1000;
		int maxScore = 0;
		double aveScore = 0;
		double allScores = 0;
		double gamesPlayed = 0;
		do {
			int score;
			YahtzeeGame myGame = new YahtzeeGame();
			System.out.println("Welcome to Jim's APCSA Yahtzee Game!");
			score = myGame.playGame();
			System.out.print("Do you want to play again?");
			play = s.nextLine();
			gamesPlayed++;
			allScores += score;
			if(score > maxScore){
				maxScore = score;
			}
			if(score < minScore){
				minScore = score;
			}
		}while(play.equals("Y"));
		aveScore = allScores/gamesPlayed;
		System.out.println("Your lowest score was " + minScore);
		System.out.println("Your highest score was " + maxScore);
		System.out.println("Your average score was " + aveScore);
	}
}
