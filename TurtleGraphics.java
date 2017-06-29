// Exercise 6.21 TurtleGraphics.java
// This application will create a computerized sketchpad by simulating
// the movements of a turtle. The turtle holds a pen in one of two positions
// up or down. When the pen is down, the turtle traces shapes as it moves
// Use a 20x20 array initialized to zeros. Turtle always starts at 0,0 (pen up)
// Keep track of turtle position and whether pen is up or down
// Commands : 1 = Pen up, 2 = Pen down, 3 = Turn right, 4 = Turn left
//            5, 10 = move forward 10 spaces (can change this number)
//            6 = display the 20x20 array, 9 = End of data (sentinel)
import java.util.Scanner;

public class TurtleGraphics
{
	public static void main(String[] args)
	{
		TurtleGraphics player = new TurtleGraphics();

		int[][] floor = new int[20][20];
		int[] turtle = {0, 0, 3, 1};
		// row, column, orientation, drawStatus
	 // Orientation 1 = up, 2 = down, 3 = right, 4 = left
	 // drawStatus 1 = up, 2 = down
	 	player.welcomeToGame();
		System.out.printf("\nOriginal Turtle array is : %d, %d, %d, %d\n",
			turtle[0], turtle[1], turtle[2], turtle[3]);  // for testing
		int[] commands = player.enterCommands();
		System.out.println("Your program has been entered.");  // for testing
		System.out.println();
		player.processCommand(floor, turtle, commands);
		System.out.printf("\nTurtle array is : %d, %d, %d, %d\n",
			turtle[0], turtle[1], turtle[2], turtle[3]); // for testing

	}

	// IN PROGRESS
	public int[] processCommand(int[][] floor, int[] location, int[] command)
	{
		// location array - row, column, orientation, drawStatus
		for(int k : command)
		{
			if(command[k] == 1 || command[k] == 2)  // this is going to return a new drawStatus
			{
				location[3] = command[k];
			}
			else if(command[k] == 3 || command[k] == 4)  // this is going to return orientation
			{
				location[2] = turnTurtle(location[2], command[k]);
			}
			else if(command[k] == 5)
			{
				location = moveTurtle(location, command[k + 1]);
				k++;
			}
			else if(command[k] == 6)  // display array
			{
				for(int row[] : floor)
				{
					for(int column : row)
					System.out.printf("%d  ", column);

				System.out.println();
				}
			}
		}
		return location;
	}



	// IN PROGRESS
	// if floor array is [row][column] then left and right add or subtract row #
	// and up/down add or subtract column#
	// details array - row, column, orientation, drawStatus
	public static int[] moveTurtle(int[] details, int units)
	{
		for(int k = 0; k < units; k++)
		{
			if(details[2] == 1)
			{
				details[0] += 1;
			}
			else if(details[2] == 2)
			{
				details[0] -= 1;
			}
			else if(details[2] == 3)
			{
				details[1] += 1;
			}
			else
			{
				details[1] -= 1;
			}
		}
		return details;
	}


	// IN PROGRESS
	public static int turnTurtle(int orientation, int command)
	{
		// Orientation: 1 = up, 2 = down, 3 = right, 4 = left

		if (command	== 3)   // turn right
		{
			if(orientation == 1)
			{
				orientation = 3;
			}
			else if(orientation == 2)
			{
				orientation = 4;
			}
			else if(orientation == 3)
			{
				orientation = 2;
			}
			else
			{
				orientation = 1;
			}
		}

		else // command == 4 turn left
		{
			if(command == 4)
			{
				if(orientation == 1)
				{
					orientation = 4;
				}
				else if(orientation == 2)
				{
					orientation = 3;
				}
				else if(orientation == 3)
				{
					orientation = 1;
				}
				else
				{
					orientation = 2;
				}
			}
		}

		return orientation;
	}

	// IN PROGRESS
	public static int[][] updateLocation(int[][] array, int turtle[])
	{
		if(turtle[3] == 2)
		{
			array[turtle[0]][turtle[1]] = 1;
		}
		return array;
	}


	// COMPLETE
	public void welcomeToGame()
	{
		System.out.println("Welcome to Turtle Graphics.");
		System.out.println("Your turtle works on a 20x20 grid.");
		System.out.println("It starts in the top left corner[0, 0] with pen up.");
	}

	// COMPLETE
	public void displayCommands()
	{
		System.out.printf("The turtle graphics commands are as follows:\n");
		System.out.printf("1 = Pen up\n2 = Pen down\n3 = Turn right\n 4 = Turn left");
		System.out.printf("5 = move forward\n");
		System.out.printf("6 = display the 20x20 array\n9 = Exit");
	}

	// COMPLETE
	public int[] enterCommands()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("If you need to see a list of commands, enter 0");
		System.out.println("Please enter your command program ");
		System.out.println("with a return after each number.");
		System.out.println("For 5 (forward command), put the number of steps to"
			+ " move on the subsequent line. Enter 9 to end your program.\n");

		int[] commands = new int[50];

		int k = 0;

		while (k < commands.length)
		{
			commands[k] = input.nextInt();

			if (commands[k] == 9)
			{
				break;
			}
			else
			{
				k++;
			}
		}
		return commands;
	}


// COMPLETE
	public void drawLine(int[] details)
	{
		int value = details[3];
		if(value == 1)
		{
			System.out.print("-");
		}
		else
		{
			System.out.print(" ");
		}
	}
}
