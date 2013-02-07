//Andrew Grace
//Text Based Driver of Satelite class
//p101, problem 18

import java.util.*;

public class TextDriver
{
  public static void main (String[] args) 
	{
		Satellite s = new Satellite();				// satellite object
		Scanner myScan = new Scanner(System.in); //get text input
		
		int secondsToRun;
		final int OUTPUT_FREQUENCY = 60; 	//Output info every 60 simulated seconds in simulation loop
		boolean crashed = false;
		
		//Output Welcome Message
		printWelcomeMessage();		

		//Get User Values.  Need to Validate Input.
		System.out.print	(	"\n\nWhat is the starting position X? (in meters): ");
			s.setX(myScan.nextDouble());	
		System.out.print	(	"What is the starting position Y? (in meters): ");
			s.setY(myScan.nextDouble());	
		System.out.print	(	"What is the starting velocity X? (in meters/sec): ");
			s.setVX(myScan.nextDouble());	
		System.out.print	(	"What is the starting velocity Y? (in meters/sec): ");
			s.setVY(myScan.nextDouble());	
		System.out.print	(	"How many seconds should the simulation run? : ");
			secondsToRun = myScan.nextInt();	
					
		//Simulation Loop
		for (int i = 1; i <= secondsToRun; i++)
		{
			s.secondsElapsed(i);
			
			//each value of i represents 1 simulated second
			if (i % OUTPUT_FREQUENCY == 0)			//print output to console every 60 seconds passed,
				printLocationOutput(s, i);

			//Check for crash
			if (!crashed)
			{
				if (s.hasCrashed())
					printCrashMessage(s, i);
			
				crashed = true; //Only print crash message once in simulation
			}
		}
		
		printFinalOutput(s, secondsToRun);
		
		//done main
	}
	
	//Methods For Outputting Info
	static void printWelcomeMessage()
	{
		System.out.print		("\n*************************************************************************");		
		System.out.print		("\nWelcome to the Satelite Class Experiment");
		System.out.print		("\nThe Earth is located at origin 0,0 and has a radius of 12,756,300 meters");
		System.out.print		("\n*************************************************************************");
	}

	static void printLocationOutput(Satellite mySat, int secondsPassed)
	{
		System.out.print ("\n ---------------------------------------");
		System.out.print ("\nElapsed Seconds: " + secondsPassed);
		System.out.printf ("\nCurrent Satelite Position (x, y): (%.2f, %.2f )", mySat.getX(), mySat.getY());
		System.out.printf ("\nCurrent Satelite Velocity (x, y): (%.2f, %.2f )", mySat.getVX(), mySat.getVY());
	}
	
	static void printFinalOutput(Satellite mySat, int secondsPassed)
	{
			//Final Output		
		System.out.print	("\n*************************************************************************");
		System.out.printf  ("\nFinished Simulated Time of: " + secondsPassed + " Seconds");
		System.out.printf ("\nFinal Satelite Position (x, y): (%.2f, %.2f )", mySat.getX(), mySat.getY());
		System.out.printf ("\nFinal Satelite Velocity (x, y): (%.2f, %.2f )", mySat.getVX(), mySat.getVY());
	}
	
	static void printCrashMessage(Satellite mySat, int secondsPassed)
	{
		System.out.print	("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.print ("\nSatelite Crashed!");
		System.out.print  ("\nCrash Time: " + secondsPassed + " Seconds");
		System.out.printf ("\nCrash Position (x, y): (%.2f, %.2f )", mySat.getX(), mySat.getY());
		System.out.printf ("\nCrash Velocity (x, y): (%.2f, %.2f )", mySat.getVX(), mySat.getVY());
		System.out.print	("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
}
