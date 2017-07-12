// Exercise 6.10: SalesCommission.java
// Write an application that determines how many salespeople
// Earned salaries in a set of ranges
// Summarize the results in a tabular format

public class SalesCommission
{
  public static void main(String[] args)
  {
  int[] sales = {1000, 5000, 800, 500, 2000, 10000,
                    1000, 750, 3000, 5000};

  int[] salary = calculateSalary(sales);

  chartSalary(salary);
  }

  public static int[] calculateSalary(int[] array)
  {
    for(int counter = 0; counter < array.length; counter++)
    {
      array[counter] = 200 + ((array[counter] * 9) / 100);
    }

    return array;
  }

  public static void chartSalary(int[] array)
  {
    int[] frequency = new int[9];

    for(int k = 0; k < array.length; k++)
    {
    try
    {
      ++frequency[(((array[k]) / 100) - 2)];
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
      ++frequency[8];
    }
    }
    System.out.printf("%s%10s%n", "Salary", "Frequency");

    for(int counter = 0; counter < frequency.length; counter++)
    {
      if(counter == 8)
      {
        System.out.printf("$1000 and over: ");
      }
      else
      {
        System.out.printf("%d - %d: ", (counter + 2) * 100,
          (counter + 2) * 100 + 99);
      }
      System.out.printf("%d\n", frequency[counter]);
    }
  }

}
