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

public class TurtleGraphicsTest
{
	private static int[][] floor = new int[20][20];
	private static int[] turtle = {0, 0, 3, 1};
	// row, column, orientation, drawStatus
 // Orientation 1 = up, 2 = down, 3 = right, 4 = left
 // drawStatus 1 = up, 2 = down

	public static void main(String[] args)
	{
		TurtleGraphicsTest player = new TurtleGraphicsTest();

	 	player.welcomeToGame();
		int[] commands = player.enterCommands();
		player.processCommand(commands);

	}

	// IN PROGRESS
	public void processCommand(int[] command)
	{
		// location array - row, column, orientation, drawStatus
		for(int k = 0; k < command.length; k++)
		{
			if(command[k] == 1 || command[k] == 2)  // this is going to return a new drawStatus
			{
				turtle[3] = command[k];
			}
			else if(command[k] == 3 || command[k] == 4)  // this is going to return orientation
			{
				turnTurtle(command[k]);
			}
			else if(command[k] == 5)
			{
				updateFloor(command[k+1]);
				k = k + 1;
			}
			else if(command[k] == 6)  // display array
			{
				for(int row[] : floor)
				{
					for(int column : row)
					{
						if(column == 1)
						{
							System.out.printf("-");
						}
						else
						{
							System.out.print(" ");
						}
					}
				System.out.println();
				}
			}
		}
	}


	public static void updateFloor(int command)
	{
		if(turtle[3] == 2)
		{
			for(int k = 0; k < command; k++)
			{
				if(turtle[2] == 1)
				{
					turtle[0] -= 1;
					floor[turtle[0]][turtle[1]] = 1;
				}
				else if(turtle[2] == 2)
				{
					turtle[0] += 1;
					floor[turtle[0]][turtle[1]] = 1;
				}
				else if(turtle[2] == 3)
				{
					turtle[1] += 1;
					floor[turtle[0]][turtle[1]] = 1;
				}
				else
				{
					turtle[1] -= 1;
					floor[turtle[0]][turtle[1]] = 1;
				}
			}
		}
	}


	// IN PROGRESS
	public static void turnTurtle(int command)
	{
		// Orientation: 1 = up, 2 = down, 3 = right, 4 = left

		if (command	== 3)   // turn right
		{
			if(turtle[2] == 1)
			{
				turtle[2] = 3;
			}
			else if(turtle[2] == 2)
			{
				turtle[2] = 4;
			}
			else if(turtle[2] == 3)
			{
				turtle[2] = 2;
			}
			else
			{
				turtle[2] = 1;
			}
		}
		else // command == 4 turn left
		{
			if(command == 4)
			{
				if(turtle[2] == 1)
				{
					turtle[2] = 4;
				}
				else if(turtle[2] == 2)
				{
					turtle[2] = 3;
				}
				else if(turtle[2] == 3)
				{
					turtle[2] = 1;
				}
				else
				{
					turtle[2] = 2;
				}
			}
		}
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

			if(commands[k] == 0)
			{
				displayCommands();
			}

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
}
