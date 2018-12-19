public class YahtzeeScorecard
{
	/* instance data given */
	private int ones;
	private int twos;
	private int threes;
	private int fours;
	private int fives;
	private int sixes;
	private int threeKind;
	private int fourKind;
	private int fiveKind;
	private int chance;
	private int fullHouse;
	private int smStraight;
	private int lgStraight;
	private boolean bonus;

	/* Sets up a new game.  Sets all instance data to incomplete (-1). Sets bonus to false */
	public YahtzeeScorecard()
	{
		ones = -1;
		twos = -1;
		threes = -1;
		fours = -1;
		fives = -1;
		sixes = -1;
		threeKind = -1;
		fourKind = -1;
		fiveKind = -1;
		chance = -1;
		fullHouse = -1;
		smStraight = -1;
		lgStraight = -1;
		bonus = false;

	}

	/* 1. If the field is already full, return false
	   2. Set data value ones equal to number of ones rolled multiplied by one.
	   3. Update the bonus (call updateBonus())
	   4. Return true   */
	public boolean markOnes(int die1, int die2, int die3, int die4, int die5) {
		YahtzeeSortDice sd = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if (this.ones == -1) {
			if(die1 == 1){ones++;}
			if(die2 == 1){ones++;}
			if(die3 == 1){ones++;}
			if(die4 == 1){ones++;}
			if(die5 == 1){ones++;}
			updateBonus();
			return true;
		} else {
			return false;
		}
	}

	/* 1. If the field is already full, return false
	   2. Set data value twos equal to number of twos rolled multiplied by two.
	   3. Update the bonus (call updateBonus())
	   4. Return true   */
	public boolean markTwos(int die1, int die2, int die3, int die4, int die5)
	{
		if (this.twos == -1) {
			if(die1 == 2){twos++;}
			if(die2 == 2){twos++;}
			if(die3 == 2){twos++;}
			if(die4 == 2){twos++;}
			if(die5 == 2){twos++;}
			updateBonus();
			return true;
		} else {
			return false;
		}
	}

	/* 1. If the field is already full, return false
	   2. Set data value threes equal to number of threes rolled multiplied by three.
	   3. Update the bonus (call updateBonus())
	   4. Return true  */
	public boolean markThrees(int die1, int die2, int die3, int die4, int die5)
	{
		if (this.threes == -1) {
			if(die1 == 3){threes++;}
			if(die2 == 3){threes++;}
			if(die3 == 3){threes++;}
			if(die4 == 3){threes++;}
			if(die5 == 3){threes++;}
			updateBonus();
			return true;
		} else {
			return false;
		}
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value fours equal to number of fours rolled multiplied by four.
	   3. Update the bonus (call updateBonus())
	   4. Returns true   */
	public boolean markFours(int die1, int die2, int die3, int die4, int die5)
	{
		if (this.fours == -1) {
			if(die1 == 4){fours++;}
			if(die2 == 4){fours++;}
			if(die3 == 4){fours++;}
			if(die4 == 4){fours++;}
			if(die5 == 4){fours++;}
			updateBonus();
			return true;
		} else {
			return false;
		}
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value fives equal to number of fives rolled multiplied by five.
	   3. Update the bonus (call updateBonus())
	   4. Returns true   */
	public boolean markFives(int die1, int die2, int die3, int die4, int die5)
	{
		if (this.fives == -1) {
			if(die1 == 5){fives++;}
			if(die2 == 5){fives++;}
			if(die3 == 5){fives++;}
			if(die4 == 5){fives++;}
			if(die5 == 5){fives++;}
			updateBonus();
			return true;
		} else {
			return false;
		}
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value sixes equal to number of sixes rolled multiplied by six.
	   3. Update the bonus (call updateBonus())
	   4. Returns true */
	public boolean markSixes(int die1, int die2, int die3, int die4, int die5)
	{
		if (this.sixes == -1) {
			if(die1 == 6){sixes++;}
			if(die2 == 6){sixes++;}
			if(die3 == 6){sixes++;}
			if(die4 == 6){fours++;}
			if(die5 == 6){fours++;}
			updateBonus();
			return true;
		} else {
			return false;
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually three of the same value.
		   If there are, set the data value threeKind to the value of all five dice.
		   If there aren’t set the value to 0.
	   	   (Hint: use YahtzeeSortDice class!)
	   	4. Return true   */
	public boolean markThreeOfAKind(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice sd = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if (sd.getFirst() == sd.getThird() || sd.getSecond() == sd.getFourth() || sd.getThird() == sd.getFifth()) {
			if(threeKind == -1) {
				threeKind = die1 + die2 + die3 + die4 + die5;

				return true;
			}
			else{
				return false;
			}
		} else {
			if(threeKind != -1){
				return false;
			}
			else{
				threeKind = 0;
				return true;
			}
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four of the same value.
		   If there are, set the data value fourKind to the value of all five dice.
		   If there aren’t set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		4. Return true  */
	public boolean markFourOfAKind(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice sd = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if (sd.getFirst() == sd.getFourth() ||  sd.getSecond() == sd.getFifth()) {
			if(fourKind == -1) {
				fourKind = die1 + die2 + die3 + die4 + die5;

				return true;
			}
			else{
				return false;
			}
		} else {
			if(fourKind != -1){
				return false;
			}
			else{
				fourKind = 0;
				return true;
			}
		}
	}

	/* 1. If the field is already full, return false
	   2. Check to see if there are actually three die with the same value, and two with another value.
	      If there are, set the data value fullHouse to 25.
	      If there aren’t set the value to 0.
	      (Hint: Use YahtzeeSortedDice class!)
       3. Return true   */
	public boolean markFullHouse(int die1, int die2, int die3, int die4, int die5) {
		YahtzeeSortDice sd = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if (sd.getFirst() == sd.getThird() && sd.getFourth() == sd.getFifth() || sd.getFirst() == sd.getSecond() && sd.getThird() == sd.getFifth()) {
			if (fullHouse == -1) {
				fullHouse = 25;

				return true;
			} else {
				return false;
			}
		} else {
			if (fullHouse != -1) {
				return false;
			} else {
				fullHouse = 0;
				return true;
			}
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four consecutive dice numbers.
		   If there are, set the data value smStraight to 30.
		   If there aren’t set the value to 0.
		   (Hint: Use YahtzeeSortedDice class)
		4. Return true  */
	public boolean markSmallStraight(int die1, int die2, int die3, int die4, int die5) {
		YahtzeeSortDice sd = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if (sd.getFirst() != sd.getSecond() && sd.getSecond() != sd.getThird() && sd.getThird() != sd.getFourth()
				|| sd.getSecond() != sd.getThird() && sd.getThird() != sd.getFourth() && sd.getFourth() != sd.getFifth()) {
			if (smStraight == -1) {
				smStraight = 30;

				return true;
			} else {
				return false;
			}
		} else {
			if (smStraight != -1) {
				return false;
			} else {
				smStraight = 0;
				return true;
			}
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually five consecutive dice numbers.
		   If there are, set the data value lgStraight to 40.
		   If there aren’t set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		3. Return true  */
	public boolean markLargeStraight(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice sd = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if (sd.getFirst() != sd.getSecond() && sd.getSecond() != sd.getThird() && sd.getThird() != sd.getFourth() && sd.getFourth() != sd.getFifth()) {
			if (lgStraight == -1) {
				lgStraight = 40;

				return true;
			} else {
				return false;
			}
		} else {
			if (lgStraight != -1) {
				return false;
			} else {
				lgStraight = 0;
				return true;
			}
		}
	}

	/* 1. If the field is already full, return false
	   2. Checks to see if there are actually five of the same value.  If there are, set the data value fiveKind to 50.  If there aren’t set the value to 0;
       3. Return true   */
	public boolean markYahtzee(int die1, int die2, int die3, int die4, int die5)
	{
		YahtzeeSortDice sd = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if (sd.getFirst() == sd.getFifth()) {
			if (fiveKind == -1) {
				fiveKind = 50;

				return true;
			} else {
				return false;
			}
		} else {
			if (fiveKind != -1) {
				return false;
			} else {
				fiveKind = 0;
				return true;
			}
		}
	}

	/* 1. If the field is already full, return false
	   2. Set the data value chance to the value of all five dice.
	   3. Return true  */
	public boolean markChance(int die1, int die2, int die3, int die4, int die5)
	{
		if(chance != -1 && chance != 0){
			chance = die1 + die2 + die3 + die4 + die5;
			return true;
		}
		else{
			return false;
		}
	}

	/* 	1. If the bonus has already been assigned, do nothing
		2. If the upper section’s total is 63 or greater, set the data value bonus to true */
	private void updateBonus()
	{
		if(!bonus && getUpperTotal() >= 63){ bonus = true;}
	}

	/* 	returns the upper total, remember incompletes (-1s) should not be factored in! */
	public int getUpperTotal()
	{
		int upTot = 0;
		if(ones != -1){ upTot += ones; }
		if(twos != -1){ upTot += twos; }
		if(threes != -1){ upTot += threes; }
		if(fours != -1){ upTot += fours; }
		if(fives != -1){ upTot += fives; }
		if(sixes != -1){ upTot += sixes; }
		return upTot;
	}

	/* 	returns the lower total, remember incompletes (-1s) should not be factored in! */
	public int getLowerTotal()
	{
		int botTot = 0;
		if(threeKind != -1){ botTot += threeKind; }
		if(fourKind != -1){ botTot += fourKind; }
		if(fiveKind != -1){ botTot += fiveKind; }
		if(fullHouse != -1){ botTot += fullHouse; }
		if(smStraight != -1){ botTot += smStraight; }
		if(lgStraight != -1){ botTot += lgStraight; }
		if(chance != -1){ botTot += chance; }
		return botTot;
	}

	/* 	returns the grand total, remember incompletes (-1s) should not be factored in! */
	public int getGrandTotal()
	{
		int grandTot = getLowerTotal() + getUpperTotal();
		return grandTot;
	}

	/*	Prints a scorecard with the current total, using "__" to mark uncompleted fields and a number to mark filled fields
		Sample:
		**********************************
		*  	    Yahtzee Score Card		 *
		*  					`		  	 *
		* 	Ones:				__		 *
		* 	Twos:				__		 *
		* 	Threes:				__		 *
		* 	Fours:				__		 *
		* 	Fives:				25		 *
		* 	Sixes:				__		 *
		*								 *
		*	Upper Bonus:		 0		 *
		* 	Upper Total:   		25		 *
		*								 *
		*	3 of Kind:			__		 *
		* 	4 of Kind:			__		 *
		* 	Full House:			25		 *
		* 	Sm Straight:		__		 *
		* 	Lg  Straight:		__		 *
		* 	Yahtzee:	  		 0		 *
		* 	Chance:				__		 *
		*								 *
		* 	Lower Total:		25		 *
		*								 *
		* 	Grand Total:		50		 *
		**********************************
		already implemented
	*/
	public void printScoreCard()
	{
		System.out.println();
		System.out.println("*********************************");
		System.out.println("*      Yahtzee Score Card       *");
		System.out.println("*                               *");
		System.out.print("*  Ones:\t\t");
		if(ones==-1)System.out.print("__");
		else System.out.print(ones);
		System.out.println("\t*");
		System.out.print("*  Twos:\t\t");
		if(twos==-1)System.out.print("__");
		else System.out.print(twos);
		System.out.println("\t*");
		System.out.print("*  Threes:\t\t");
		if(threes==-1)System.out.print("__");
		else System.out.print(threes);
		System.out.println("\t*");
		System.out.print("*  Fours:\t\t");
		if(fours==-1)System.out.print("__");
		else System.out.print(fours);
		System.out.println("\t*");
		System.out.print("*  Fives:\t\t");
		if(fives==-1)System.out.print("__");
		else System.out.print(fives);
		System.out.println("\t*");
		System.out.print("*  Sixes:\t\t");
		if(sixes==-1)System.out.print("__");
		else System.out.print(sixes);
		System.out.println("\t*");
		System.out.println("*\t\t\t\t*");
		System.out.print("*  Upper Bonus:\t\t");
		if(bonus)System.out.print("35");
		else System.out.print("0");
		System.out.println("\t*");
		System.out.print("*  Upper Total:\t\t");
		System.out.print(this.getUpperTotal());
		System.out.println("\t*");
		System.out.println("*                               *");
		System.out.print("*  3 of Kind:\t\t");
		if(threeKind==-1)System.out.print("__");
		else System.out.print(threeKind);
		System.out.println("\t*");
		System.out.print("*  4 of Kind:\t\t");
		if(fourKind==-1)System.out.print("__");
		else System.out.print(fourKind);
		System.out.println("\t*");
		System.out.print("*  Full House:\t\t");
		if(fullHouse==-1)System.out.print("__");
		else System.out.print(fullHouse);
		System.out.println("\t*");
		System.out.print("*  Sm Straight:\t\t");
		if(smStraight==-1)System.out.print("__");
		else System.out.print(smStraight);
		System.out.println("\t*");
		System.out.print("*  Lg Straight:\t\t");
		if(lgStraight==-1)System.out.print("__");
		else System.out.print(lgStraight);
		System.out.println("\t*");
		System.out.print("*  Yahtzee:\t\t");
		if(fiveKind==-1)System.out.print("__");
		else System.out.print(fiveKind);
		System.out.println("\t*");
		System.out.print("*  Chance:\t\t");
		if(chance==-1)System.out.print("__");
		else System.out.print(chance);
		System.out.println("\t*");
		System.out.println("*                               *");
		System.out.print("*  Lower Total:\t\t");
		System.out.print(this.getLowerTotal());
		System.out.println("\t*");
		System.out.println("*                               *");
		System.out.print("*  Grand Total:\t\t");
		System.out.print(this.getGrandTotal());
		System.out.println("\t*");
		System.out.println("**********************************");
		System.out.println();
	}


}