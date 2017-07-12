// Exercise 6.17: DiceRoll.java
// Write an application to simulate the rolling of two dice
// Use an object of the class Random once to roll the first die and again
// to roll the second. The sum of the two values should be calculated
// Application should roll the dice 36,000,000 times
// Use a one-dimensional array to tally the number of times each possible
// sum appears. Display the results in tabular format

import java.util.Random;

public class DiceRoll
{
  public static void main(String[] args)
  {
    int[] sums = new int[36000000];

    for (int counter = 0; counter < 36000000; counter++)
    {
      sums[counter] = rollDice();
    }

    int[] frequency = calculateFrequency(sums);
    displayResults(frequency);

  }
  public static int rollDice()
  {
    Random randomNumbers = new Random();

    int die1 = 1 + randomNumbers.nextInt(6); // first die roll
    int die2 = 1 + randomNumbers.nextInt(6); // second die roll

    int sum = die1 + die2;
    System.out.printf("%d + %d = %d\n", die1, die2, sum);
    return sum;
  }

  public static int[] calculateFrequency(int[] array)
  {
    int frequency[] = new int[11];

    for(int n : array)
    {
      ++frequency[(array[n]) - 2];
    }

    return frequency;
  }

  public static void displayResults(int[] array)
  {
    for(int counter = 0; counter < array.length; counter++)
    {
      System.out.printf("%2d: ", counter + 2);
      System.out.printf("%d\n", array[counter]);
    }
  }

}
