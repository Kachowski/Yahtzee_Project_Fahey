public class YahtzeeSortDice
{
	int first;
	int second;
	int third;
	int fourth;
	int fifth;
	int change1;
	int change2;

	/* constructor: initializes the private data by sorting the order of the dice */
	public YahtzeeSortDice(int a, int b, int c, int d, int e)
	{
		first = a;
		second = b;
		third = c;
		fourth = d;
		fifth = e;
		change1 = 0;
		change2 = 0;
	}

	/* returns the minimum of the five numbers */
	public int getFirst()
	{
		return first;
	}

	/* returns the second smallest of the five number */
	public int getSecond()
	{
		//your code here
		return -999;
	}

	/* returns the middle of the five numbers */
	public int getThird()
	{
		//your code here
		return -999;
	}

	/* returns the second largest of the five numbers */
	public int getFourth()
	{
		//your code here
		return -999;
	}

	/* returns the biggest of the five numbers */
	public int getFifth()
	{
		//your code here
		return -999;
	}
}