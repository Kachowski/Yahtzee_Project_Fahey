import java.util.Scanner;

public class YahtzeeGame
{
	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */
	public YahtzeeDie die1;
	public YahtzeeDie die2;
	public YahtzeeDie die3;
	public YahtzeeDie die4;
	public YahtzeeDie die5;
	public YahtzeeScorecard card;
	public Scanner s;

	/* initializes the dice and scoreboard */
	public YahtzeeGame()
	{
		die1 = new YahtzeeDie(6);
		die2 = new YahtzeeDie(6);
		die3 = new YahtzeeDie(6);
		die4 = new YahtzeeDie(6);
		die5 = new YahtzeeDie(6);
		card = new YahtzeeScorecard();
		s = new Scanner(System.in);
	}

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		for(int i = 1; i < 13; i++){
			takeTurn();
		}
		System.out.println(card);
		return card.getGrandTotal();
	}

	/* 	1. call rollDice()
		2. call printDice()
		3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		4. call chooseFrozen()
		5. call rollDice()
		6. call printDice()
		7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		8. call chooseFrozen()
		9. call rollDice()
		10. call printDice()
		11. call markScore()
	*/
	private void takeTurn()
	{
		int j = 0;
		String roll;
		String roll2;
		rollDice();
		printDice();
		System.out.println("Are you satisfied with your roll, or would you like to roll again(s/r):");
		roll = s.nextLine();
		while(roll.equals("r") && j < 2){
			chooseFrozen();
			rollDice();
			printDice();
			System.out.println("Are you satisfied with your roll, or would you like to roll again(s/r):");
			roll = s.nextLine();
			j += 1;
		}
		markScore();
	}

	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		if(!die1.isFrozen()){ die1.rollDie(); }
		if(!die2.isFrozen()){ die2.rollDie(); }
		if(!die3.isFrozen()){ die3.rollDie(); }
		if(!die4.isFrozen()){ die4.rollDie(); }
		if(!die5.isFrozen()){ die5.rollDie(); }
		die1.unfreezeDie();
		die2.unfreezeDie();
		die3.unfreezeDie();
		die4.unfreezeDie();
		die5.unfreezeDie();
	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
		System.out.println("Which die should be frozen 1-5:");
		String frozenDie = s.nextLine();
		if(frozenDie.indexOf('1') > -1){ die1.freezeDie(); }
		if(frozenDie.indexOf('2') > -1){ die1.freezeDie(); }
		if(frozenDie.indexOf('3') > -1){ die1.freezeDie(); }
		if(frozenDie.indexOf('4') > -1){ die1.freezeDie(); }
		if(frozenDie.indexOf('5') > -1){ die1.freezeDie(); }
	}

	/* Should print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
		System.out.print(die1.getValue() + "\t" + die2.getValue() + "\t" + die3.getValue() + "\t" + die4.getValue() + "\t" + die5.getValue() + "\t");
	}

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{
		card.printScoreCard();
		System.out.println("Where do you want to mark your score?");
		int marking = s.nextInt();
		s.nextLine();
		boolean marked = false;
		while(!marked){
			switch (marking){
				case 1: card.markOnes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); marked = true; break;
				case 2: card.markTwos(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); marked = true; break;
				case 3: card.markThrees(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); marked = true; break;
				case 4: card.markFours(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); marked = true; break;
				case 5: card.markFives(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); marked = true; break;
				case 6: card.markSixes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); marked = true; break;
				case 7: card.markThreeOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); marked = true; break;
				case 8: card.markFourOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); marked = true; break;
				case 9: card.markFullHouse(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); marked = true; break;
				case 10: card.markSmallStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); marked = true; break;
				case 11: card.markLargeStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); marked = true; break;
				case 12: card.markYahtzee(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); marked = true; break;
				case 13: card.markChance(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); marked = true; break;
				default: break;

			}
		}
	}
}