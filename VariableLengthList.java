// Exercise 6.14: VariableLengthList.java
// Write an application that calculates the product of a series of
// integers that are passed to method product using a variable-length
// argument list.

public class VariableLengthList
{
  public static int product(int... numbers)
  {
    int total = 1;

    for(int n : numbers)
      total *= n;

    return total;
  }

  public static void main(String[] args)
  {
    int n1 = 5;
    int n2 = 10;
    int n3 = 2;
    int n4 = 4;
    int n5 = 8;
    int n6 = 3;

    System.out.printf("n1 = %d\nn2 = %d\nn3 = %d\nn4 = %d\nn5 = %d\nn6 = %d\n",
      n1, n2, n3, n4, n5, n6);
    System.out.println();

    System.out.printf("The product of n1 and n2 is %d\n", product(n1, n2));
    System.out.printf("The product of n1, n2 and n3 is %d\n",
      product(n1, n2, n3));
    System.out.printf("The product of n1, n2, n3 and n4 is %d\n",
      product(n1, n2, n3, n4));
    System.out.printf("The product of n1, n2, n3, n4 and n5 is %d\n",
      product(n1, n2, n3, n4, n5));
    System.out.printf("The product of n1, n2, n3, n4, n5 and n6 is %d\n",
        product(n1, n2, n3, n4, n5, n6));
  }
}
