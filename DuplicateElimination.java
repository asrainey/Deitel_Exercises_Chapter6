// Exercise 6.12 DuplicateElimination
// Write an application that inputs five numbers,
// each between 10 and 100 inclusive.
// As each number is read, display it only if it is not a duplicate of a
// number already read. Provide for the worst case of five unique numbers
// Use the smallest possible array. Display the complete set of unique values
// input after the user enters a new value
import java.util.Scanner;

public class DuplicateElimination
{
  public static void main(String[] args)
  {

    int[] numbers = new int[5];

    numbers[0] = readNumber();
    displayUniqueNumbers(numbers[0]);

    numbers[1] = readNumber();
    if(numbers[1] != numbers[0]) // if - 1
    {
      displayUniqueNumbers(numbers[0], numbers[1]);
      numbers[2] = readNumber();

      if(numbers[2] != numbers[1] && numbers[2] != numbers[0]) // if - 2
      {
        displayUniqueNumbers(numbers[0], numbers[1], numbers[2]);
        numbers[3] = readNumber();

        if(numbers[3] != numbers[2] && numbers[3] != numbers[1] &&
          numbers[2] != numbers[0]) // if - 3
        {
          displayUniqueNumbers(numbers[0], numbers[1], numbers[2],
            numbers[3]);
            numbers[4] = readNumber();

            if(numbers[4] != numbers[3] && numbers[4] != numbers[2] &&
              numbers[4] != numbers[1] && numbers[4] != numbers[0]) // if - 4
            {
              displayUniqueNumbers(numbers[0], numbers[1], numbers[2],
                numbers[3], numbers[4]);
            }
            else // else - 4
            {
              displayUniqueNumbers(numbers[0], numbers[1], numbers[2],
                numbers[3]);
            }
        }
        else // else - 3
        {
          displayUniqueNumbers(numbers[0], numbers[1], numbers[2]);
            numbers[4] = readNumber();
            if (numbers[4] != numbers[3] && numbers[4] != numbers[2] &&
              numbers[4] != numbers[1] && numbers[4] != numbers[0]) // if - 5
            {
              displayUniqueNumbers(numbers[0], numbers[1], numbers[2],
                numbers[4]);
            }
            else  // else - 5
            {
              displayUniqueNumbers(numbers[0], numbers[1], numbers[2]);
            }
        }
      }
      else // - 2
      {
        displayUniqueNumbers(numbers[0], numbers[1]);
        numbers[3] = readNumber();

        if(numbers[3] != numbers[2] && numbers[3] != numbers[1] &&
          numbers[3] != numbers[0]) // if - 6
        {
          displayUniqueNumbers(numbers[0], numbers[1], numbers[3]);
          numbers[4] = readNumber();

          if(numbers[4] != numbers[3] && numbers[4] != numbers[2] &&
            numbers[4] != numbers[1] && numbers[4] != numbers[0]) // if - 7
          {
          displayUniqueNumbers(numbers[0], numbers[1], numbers[3],
            numbers[4]);
          }
          else // else - 7
          {
            displayUniqueNumbers(numbers[0], numbers[1], numbers[3]);
          }
        }
        else // else - 6
        {
          displayUniqueNumbers(numbers[0], numbers[1]);
          numbers[4] = readNumber();

          if(numbers[4] != numbers[3] && numbers[4] != numbers[2] &&
            numbers[4] != numbers[1] && numbers[4] != numbers[0]) // if - 8
          {
          displayUniqueNumbers(numbers[0], numbers[1], numbers[4]);
          }
          else // else - 8
          {
            displayUniqueNumbers(numbers[0], numbers[1]);
          }
        }
      }
    }
    else // else - 1
    {
      displayUniqueNumbers(numbers[0]);
      numbers[2] = readNumber();
      if (numbers[2] != numbers[1] && numbers[2] != numbers[0]) // if - 9
      {
        displayUniqueNumbers(numbers[0], numbers[2]);
        numbers[3] = readNumber();

        if(numbers[3] != numbers[2] && numbers[3] != numbers[1] &&
          numbers[3] != numbers[0]) // if - 10
        {
          displayUniqueNumbers(numbers[0], numbers[2], numbers[3]);
          numbers[4] = readNumber();

          if(numbers[4] != numbers[3] && numbers[4] != numbers[2] &&
            numbers[4] != numbers[1] && numbers[4] != numbers[0])  // if - 11
          {
            displayUniqueNumbers(numbers[0], numbers[2], numbers[3],
              numbers[4]);
          }
          else  // else - 11
          {
            displayUniqueNumbers(numbers[0], numbers[2], numbers[3]);
          }
        }
        else // else - 10
        {
          displayUniqueNumbers(numbers[0], numbers[2]);
          numbers[4] = readNumber();

          if(numbers[4] != numbers[3] && numbers[4] != numbers[2] &&
            numbers[4] != numbers[1] && numbers[4] != numbers[0])  // if - 12
          {
            displayUniqueNumbers(numbers[0], numbers[2], numbers[4]);
          }
          else  // else - 12
          {
            displayUniqueNumbers(numbers[0], numbers[2]);
          }
        }
      }
      else // else - 9
      {
        displayUniqueNumbers(numbers[0]);
        numbers[3] = readNumber();

        if(numbers[3] != numbers[2] && numbers[3] != numbers[1] &&
          numbers[3] != numbers[0]) // if - 13
        {
          displayUniqueNumbers(numbers[0], numbers[3]);
          numbers[4] = readNumber();

          if(numbers[4] != numbers[3] && numbers[4] != numbers[2] &&
            numbers[4] != numbers[1] && numbers[4] != numbers[0])  // if - 14
          {
            displayUniqueNumbers(numbers[0], numbers[3], numbers[4]);
          }
          else  // else - 14
          {
            displayUniqueNumbers(numbers[0], numbers[3]);
          }
        }
        else // else - 13
        {
          displayUniqueNumbers(numbers[0]);
          numbers[4] = readNumber();

          if(numbers[4] != numbers[3] && numbers[4] != numbers[2] &&
            numbers[4] != numbers[1] && numbers[4] != numbers[0])  // if - 15
          {
            displayUniqueNumbers(numbers[0], numbers[4]);
          }
          else  // else - 15
          {
            displayUniqueNumbers(numbers[0]);
          }
        }
      }
    }

  }

  public static int readNumber()
  {
    Scanner input = new Scanner(System.in);

    System.out.println("Please enter a number between 10 and 100");
    int num = input.nextInt();

    return num;
  }

  public static void displayUniqueNumbers(int number)
  {
    System.out.printf("Unique values are [%d]\n", number);
  }

  public static void displayUniqueNumbers(int number, int number2)
  {
    System.out.printf("Unique values are [%d, %d]\n", number, number2);
  }

  public static void displayUniqueNumbers(int number, int number2,
    int number3)
  {
    System.out.printf("Unique values are [%d, %d, %d]\n", number,
      number2, number3);
  }

  public static void displayUniqueNumbers(int number, int number2,
    int number3, int number4)
  {
    System.out.printf("Unique values are [%d, %d, %d, %d]\n", number,
      number2, number3, number4);
  }

  public static void displayUniqueNumbers(int number, int number2,
    int number3, int number4, int number5)
  {
    System.out.printf("Unique values are [%d, %d, %d, %d, %d]\n", number,
      number2, number3, number4, number5);
  }

}
