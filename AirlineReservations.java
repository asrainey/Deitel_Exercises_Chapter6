// Exercise 6.19: AirlineReservations.java
// Write an application to assign seats on a 10 seat airplane
// Seats 1-5 are first class, seats 6-10 are economy
// Ask the individual if they want First Class (1) or Economy(2)
// Assign a seat in the correct section and display a boarding pass (seat no.)
// If section is full, app should ask if individual would like to sit in
// the other section. If yes, assign a seat, if no display the message
// "The next flight leaves in three hours"

import java.util.Scanner;

public class AirlineReservations
{
  static boolean[] seats = new boolean[10];

  public static void main(String[] args)
  {
    AirlineReservations a1 = new AirlineReservations();
    Scanner input = new Scanner(System.in);

    String answer = "Y";

    while(answer.equalsIgnoreCase("Y"))
    {
    int section = a1.requestClass();
    a1.assignSeat(seats, section);

    System.out.print("Would you like to buy another seat? Y or N: ");
    answer = input.nextLine();
    }
  }

  public int requestClass()
  {
    AirlineReservations a2 = new AirlineReservations();
    Scanner input = new Scanner(System.in);

    System.out.println("Please type 1 for First Class or 2 for Economy");
    int section = input.nextInt();

    if(section != 1 && section != 2)
    {
      System.out.println("That is not a valid response.");
      a2.requestClass();
    }

    return section;
  }

  public boolean[] assignSeat(boolean[] array, int section)
  {
    AirlineReservations a3 = new AirlineReservations();

    if(section == 1)
    {
      for(int counter = 0; counter <= 5; counter++)
      {
        if(counter == 5)
        {
          a3.switchSection(1);
        }

        if(array[counter] == false)
        {
          System.out.printf("You have been assigned seat %d in first class.\n",
          counter + 1);
          array[counter] = true;
          break;
        }
      }
    }
    else
    {
      for(int counter = 5; counter <= 10; counter++)
      {
        if(counter == 10)
        {
          a3.switchSection(0);
        }

        if(array[counter] == false)
        {
          System.out.printf("You have been assigned seat %d in economy.\n",
          counter + 1);
          array[counter] = true;
          break;
        }
      }
    }
    return array;
  }

  public void switchSection(int section)
  {
    AirlineReservations a4 = new AirlineReservations();
    Scanner input = new Scanner(System.in);

    if(section == 1)
    {
      System.out.println("There are no more seats in first class.");
      System.out.println("Would you like an economy seat");
      System.out.print("Please enter Y or N : ");
      String response = input.nextLine();

      if(response.equalsIgnoreCase("Y"))
      {
        a4.assignSeat(seats, 2);
      }
      else
      {
        System.out.println("Next flight leaves in 3 hours");
        System.exit(0);
      }
    }
    else
    {
      System.out.println("There are no more seats in economy.");
      System.out.println("Would you like a first class seat");
      System.out.print("Please enter Y or N : ");
      String response = input.nextLine();

      if(response.equalsIgnoreCase("Y"))
      {
        a4.assignSeat(seats, 1);
      }
      else
      {
        System.out.println("Next flight leaves in 3 hours");
        System.exit(0);
      }
    }
  }
}
