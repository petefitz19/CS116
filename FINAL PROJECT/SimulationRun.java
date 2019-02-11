package Traffic.RoadNetwork;

import Traffic.RoadNetwork.*;
import java.util.Scanner;
import java.io.*;
/**
*	SimulationRun.java - a client class of RoadNetwork that allows the user to enter the input for
*	the span, turn rate, entry rate, duration, green ticks, and orange ticks and output the 
*	appropriate formatted data.
*	@author	Peter Fitzpatrick
 *	@version 1.0
*/
public class SimulationRun{
	/* public static void main(String[] args){
		RoadNetwork run = new RoadNetwork(3, 0.5, 0.75, 100, 7, 2);
		run.runSimulation();
		double sum = 0;
		for(int i = 0; i < run.autoData.size(); i++){
			sum += run.waitTimes.get(i);
			System.out.println(run.autoData.get(i).toString() + "\n");
		}
		double avg = sum / run.waitTimes.size();
		double numExits = run.exitLanes.size();
		double totalTime = run.getDuration();
		double flow =  numExits / totalTime;
		System.out.println("\n" + "Average wait time: " + avg + " ticks." + "\n");
		System.out.println("Total Flow Rate: " + flow + " vehicles exit per tick.");
	} */
	/**
	*	Main method which outputs the data from the simulation
	*	@param	args	a String array
	*/
	public static void main(String[] args){
		SimulationRun sim = new SimulationRun();
		RoadNetwork run;
		int span;
		double rate;
		double entryRate;
		int duration;
		int greenTicks;
		int orangeTicks;
		boolean again = true;
		while(again){
			span = sim.readSpan();
			rate = sim.readRate();
			entryRate = sim.readEntryRate();
			duration = sim.readDuration();
			greenTicks = sim.readGreenTicks();
			orangeTicks = sim.readOrangeTicks();
			
			run = new RoadNetwork(span, rate, entryRate, duration, greenTicks, orangeTicks);
			run.runSimulation();
			double sum = 0;
			for(int i = 0; i < run.waitTimes.size(); i++){
				sum += run.waitTimes.get(i);
				int x = run.waitTimes.get(i);
				System.out.println(run.autoData.get(i).toString() + "\n");
			}
			try{
				FileWriter fw = new FileWriter("out.txt", false);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				for(int i = 0; i < run.waitTimes.size(); i++){
					pw.println(run.autoData.get(i).textToString());
				}
				bw.flush();
				pw.close();
			}catch(IOException e){
				System.out.println("Text Errors");
			}
			double avg = sum / run.waitTimes.size();
			double numExits = run.exitLanes.size();
			double totalTime = run.getDuration();
			double flow =  numExits / totalTime;
			System.out.println("\n" + "Average wait time: " + avg + " ticks." + "\n");
			System.out.println("Total Flow Rate: " + flow + " vehicles exit per tick.");
			again = sim.readAgain(); 
		}
	}
	/**	
	*	Returns the span parameter passed in by the user
	*	@return an integer value for the span of the lanes
	*/
	public static int readSpan(){
		Scanner scan = new Scanner(System.in);
		int span;
		
		try{
			System.out.println("Enter the span of the lanes:");
			span = scan.nextInt();
			if(span > 0)
				return span;
			else throw(new Exception());
		}catch(Exception error){
			System.out.println("Invalid Input");
			return readSpan();
		}
	}
	/**	
	*	Returns the turn rate parameter passed in by the user
	*	@return a double value for the turn rate of the vehicles
	*/
	public static double readRate(){
		Scanner scan = new Scanner(System.in);
		double rate;
		
		try{
			System.out.println("Enter the turn rate for the vehicles:");
			rate = scan.nextDouble();
			if(rate > 0.0 && rate < 1.0)
				return rate;
			else throw(new Exception());
		}catch(Exception error){
			System.out.println("Invalid Input");
			return readRate();
		}
	}
	/**	
	*	Returns the entry rate parameter passed in by the user
	*	@return a double value for the entry rate of the vehicles
	*/
	public static double readEntryRate(){
		Scanner scan = new Scanner(System.in);
		double entryRate;
		try{
			System.out.println("Enter the entry rate for the vehicles:");
			entryRate = scan.nextDouble();
			if(entryRate > 0.0 && entryRate < 1.0)
				return entryRate;
			else throw(new Exception());
		}catch(Exception error){
			System.out.println("Invalid Input");
			return readEntryRate();
		}
	}
	/**	
	*	Returns the duration parameter passed in by the user
	*	@return an integer value for the duration of the simulation
	*/
	public static int readDuration(){
		Scanner scan = new Scanner(System.in);
		int duration;
		
		try{
			System.out.println("Enter the amount of ticks you want the program to run for:");
			duration = scan.nextInt();
			if(duration > 0)
				return duration;
			else throw(new Exception());
		}catch(Exception error){
			System.out.println("Invalid Input");
			return readDuration();
		}
	}
	/**	
	*	Returns the orangeTicks parameter passed in by the user
	*	@return an integer value for the time span of the orange light
	*/
	public static int readOrangeTicks(){
		Scanner scan = new Scanner(System.in);
		int orangeTicks;
		try{
			System.out.println("Enter the amount of ticks for the orange light duration:");
			orangeTicks = scan.nextInt();
			if(orangeTicks > 0)
				return orangeTicks;
			else throw(new Exception());
		}catch(Exception error){
			System.out.println("Invalid Input");
			return readOrangeTicks();
		}
	}
	/**	
	*	Returns the greenTicks parameter passed in by the user
	*	@return an integer value for the time span of the green light
	*/
	public static int readGreenTicks(){
		Scanner scan = new Scanner(System.in);
		int greenTicks;
		
		try{
			System.out.println("Enter the amount of ticks for the green light duration:");
			greenTicks = scan.nextInt();
			if(greenTicks > 0)
				return greenTicks;
			else throw(new Exception());
		}catch(Exception error){
			System.out.println("Invalid Input");
			return readGreenTicks();
		}
	}
	/**	
	*	Returns boolean variable that decides if the simulation will run again
	*	@return a boolean value
	*/
	public static boolean readAgain(){
		Scanner scan = new Scanner(System.in);
		String again;
		
		try{
			System.out.println("Try again?:");
			again = scan.nextLine().toUpperCase();
			if(again.equals("YES"))
				return true;
			else if(again.equals("NO"))
				return false;
			else throw(new Exception());
		}catch(Exception error){
			System.out.println("Invalid Input");
			return readAgain();
		}
	}
}