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
	static int[][] floor = new int[20][20];
 	static int nextCommand = 0;

	static int[] turtle = {0, 0, 3, 1};  // row, column, orientation, drawStatus
	// Orientation 1 = up, 2 = down, 3 = right, 4 = left
	// drawStatus 1 = up, 2 = down

	public static void main(String[] args)
	{
		TurtleGraphics player = new TurtleGraphics();

		while (true)
		{
			int[] commands = player.enterCommands();
			player.processCommand(turtle, commands);
		}

	}

	// IN PROGRESS
	public void processCommand(int[] location, int[] command)
	{
		// location array - row, column, orientation, drawStatus
		for(int k = 0; k < command.length; k++)
		{
			if(command[k] == 1 || command[k] == 2)  // this is going to return a new drawStatus
			{
				location[3] = command[k];
			}
			else if(command[k] == 3 || command[k] == 4)  // this is going to return orientation
			{
				turnTurtle(location, command[k]);
			}
			else if(command[k] == 5)
			{
				moveTurtle(location, command[k+ 1]);
			}
			else if(command[k] == 6)  // display array
			{

			}
			else if(command[k] == 9)  // end game
			{
			System.out.println("Thank you for playing.");
			System.exit(0);
			}
			else  // to skip lines that are forward steps
			{
			k++;
			}
		}
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

	// IN PROGRESS
	// if floor array is [row][column] then left and right add or subtract row #
	// and up/down add or subtract column#
	// details array - row, column, orientation, drawStatus
	public void moveTurtle(int[] details, int units)
	{
		for(int k = 0; k < units; k++)
			{
				drawLine(details);
				switch(details[2])
				{
					case 1:
					details[0] += 1;
					break;

					case 2:
					details[0] -= 1;
					break;

					case 3:
					details[1] += 1;
					break;

					case 4:
					details[1] -= 1;
					break;
				}
				if(details[3] == 2)
				{
					floor[details[0]][details[1]] = 1;
				}
		}
	}

	// COMPLETE
	public static int[] turnTurtle(int [] location, int command)
	{
		// Orientation: 1 = up, 2 = down, 3 = right, 4 = left

		if (command	== 3)   // turn right
		{
			switch(location[2])
			{
				case 1: location[2] = 3;
						break;

				case 2: location[2] = 4;
						break;

				case 3: location[2] = 2;
						break;

				case 4: location[2] = 1;
						break;
			}
		}
		else // command == 4 turn left
		{
			switch(location[2])
			{
				case 1: location[2] = 4;
						break;

				case 2: location[2] = 3;
						break;

				case 3: location[2] = 1;
						break;

				case 4: location[2] = 2;
						break;
			}
		}

		return location;
	}

	// IN PROGRESS
	public void displayArray()
	{

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
		System.out.print("Please enter your command program with a return after" +
			" each number. For 5(forward), put the number of steps on the subsequent "
			+ "line. Enter 9 to end your program.");

		int k = 0;
		int[] commands = new int[50];

		do {
			commands[k] = input.nextInt();
			k++;
		} while (commands[k] != 9);

		return commands;
	}
}
