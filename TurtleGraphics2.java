// Exercise 6.21 TurtleGraphics2.java
// This application will create a computerized sketchpad by simulating
// the movements of a turtle. The turtle holds a pen in one of two positions
// up or down. When the pen is down, the turtle traces shapes as it moves
// Use a 20x20 array initialized to zeros. Turtle always starts at 0,0 (pen up)
// Keep track of turtle position and whether pen is up or down
// Commands : 1 = Pen up, 2 = Pen down, 3 = Turn right, 4 = Turn left
//            5, 10 = move forward 10 spaces (can change this number)
//            6 = display the 20x20 array, 9 = End of data (sentinel)
import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;

public class TurtleGraphics2
{
	private static int[][] floor = new int[20][20];
	private static int[] turtle = {0, 0, 3, 1};

	public static void main(String[] args)
	{
		TurtleGraphics2 player = new TurtleGraphics2();
		player.welcomeToGame();
		player.enterCommands();


	}


	// COMPLETE
	public void welcomeToGame()
	{
		System.out.println("Welcome to Turtle Graphics.");
		System.out.println("Your turtle works on a 20x20 grid.");
		System.out.println("It starts in the top left corner[0, 0] with pen up.");
	}

	// COMPLETE
	public static void displayCommands()
	{
		System.out.printf("The turtle graphics commands are as follows:\n");
		System.out.printf("1 = Pen up\n2 = Pen down\n3 = Turn right\n 4 = Turn left");
		System.out.printf("5, n = move forward, number of spaces\n");
		System.out.printf("6 = display the 20x20 array\n9 = Exit");
	}

	public void enterCommands()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("If you need to see a list of commands, enter 0");
		System.out.println("Please enter your command program ");
		System.out.println("with a return after each number.");
		System.out.println("Enter 9 to end your program.");

		String command = input.nextLine();

		while (!command.equalsIgnoreCase("9"))
		{
			if(command.equalsIgnoreCase("0"))
			{
				displayCommands();
			}
			else if(command.equalsIgnoreCase("1") || command.equalsIgnoreCase("2"))
			// this is going to return a new drawStatus
			{
				int commandValue = Integer.parseInt(command);
				turtle[3] = commandValue;
			}
			else if(command.equalsIgnoreCase("3") || command.equalsIgnoreCase("4"))
			// this is going to return orientation
			{
				int commandValue = Integer.parseInt(command);
				turnTurtle(commandValue);
			}
			else if(command.contains("5"))
			{
				String[] moveCommands = command.split(",");
				int distance = Integer.parseInt(moveCommands[1]);
				updateFloor(distance);
			}
			else if(command.equalsIgnoreCase("6"))  // display array
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
			command = input.nextLine();
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
			else if(turtle[2] == 4)
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

}
