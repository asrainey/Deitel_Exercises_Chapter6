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

	 // Need to set commands to change 0s in array to 1s
	 // Turning right or left determines which way you are going next
	 // Up or down if previously going L or R, and vice versa
	 // When pen is down need to record - on the terminal for each slot in
  	// array that is crossed

	public void playGame()
	{
		TurtleGraphics player = new TurtleGraphics();

		while (true)
		{
			int[] commands = player.enterCommands();
			processCommand(turtle, nextCommand);
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

	// IN PROGRESS
	public int[] enterCommands()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("If you need to see a list of commands, enter 0");
		System.out.print("Please enter your command program with a return after" +
			" each number. For 5(forward), put the number of steps on the subsequent "
			+ "line. Enter 9 to end your program.");

		int k = 0;
		int[] commands = new int[50];

		do
		{
			commands[k] = input.nextInt();
			k++;
		} while (commands[k] != 9);

		return commands;
	}

	// IN PROGRESS
	public int[] processCommand(int[] location, int[] command)
	{
		// location array - row, column, orientation, drawStatus
		for(int item : command)
		{
			if(command == 1 || command == 2)  // this is going to return a new drawStatus
			{
				location[3] = command;
				return location;
			}
			else if(command == 3 || command == 4)  // this is going to return orientation
			{
				location[2] = turnTurtle(location);
				return location;
			}
			else if(command == 6)  // display array
			{

			}
			else if(command == 9)  // end game
			{
			System.out.println("Thank you for playing.");
			System.exit(0);
			}
			else  // this is for moving forward getting # of spaces and not command #
			{
			moveTurtle(command);
			}
		}
	}

	// COMPLETE
	public void drawLine(int[] location)
	{
		int value = location[3];
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
	public void moveTurtle(int[] location, int units)
	{

		for(int k = 0; k < units; k++)
		{
		drawLine(location[3]);
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
}

/*public static void main(String[] args)
{
	TurtleGraphics turtle1 = new TurtleGraphics();

	turtle1.welcomeToGame();

	while (true)
	{
	nextCommand = turtle1.enterCommand();
	turtle1.processCommand(nextCommand);
	}



}*/
