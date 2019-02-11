package Traffic.RoadNetwork;
/**
*	The Auto class will represent the vehicle objects travelling on the lanes. For the
*	purposes of the simulation, all vehicle move with a constant speed, i.e., during
*	each tick of the simulation, a vehicle will move to the next block if it is empty 
*	else it remains in the same block. If the vehicle is in a traffic block, then additional 
*	rules apply. For vehicles on intersection blocks, there is also an option for the
*	vehicles to turn left or right based on the traffic rules.
*	@author	Peter Fitzpatrick
*	@version 1.0
*/
public class Auto{
	private int speed;
	private int entryTime;
	private int exitTime;
	private LaneType entryLane;
	private LaneType exitLane;
	public static int count = 10000;
	private int id;
	/**
	*	Constructor for class Auto.
	*	Takes in parameters of an integer representing he Auto's speed, 
	*	the type of intersection block it is as the IntersectionType enum class,
	*	and a double representing the rate at which a vehicle can turn.
	*	@param	speed	an integer value representing the speed of the Auto.
	*	@param	entryTime	an integer value representing the entry time of the Auto.
	*	@param	entryLane	a LaneType enum value representing the entry lane of the Auto.
	*	@param	exitLane	a LaneType enum value representing the exit lanr of the Auto.
	*/
	public Auto(int speed, int entryTime, LaneType entryLane, LaneType exitLane){
		this.setID();
		this.setSpeed(speed);
		this.setEntryTime(entryTime);
		this.setEntryLane(entryLane);
		this.setExitLane(exitLane);
	}
	//Accessors and Mutators
	/**
	*	Sets the speed for the Auto
	*	@param	speed	an integer value
	*/
	public void setSpeed(int speed){
		this.speed = speed;
	}
	/**
	*	Returns the speed of the Auto
	*	@return the speed of the auto as an integer value
	*/
	public int getSpeed(){
		return this.speed;
	}
	/**
	*	Sets the entry time of the Auto
	*	@param	time	an integer value
	*/
	public void setEntryTime(int time){
		this.entryTime = time;
	}
	/**
	*	Returns the entry time of the Auto
	*	@return the entry time of the auto as an integer value
	*/
	public int getEntryTime(){
		return this.entryTime;
	}
	/**
	*	Sets the exit time of the Auto
	*	@param	time	an integer value
	*/
	public void setExitTime(int time){
		this.exitTime = time;
	}
	/**
	*	Returns the exit time of the Auto
	*	@return the exit time of the auto as an integer value
	*/
	public int getExitTime(){
		return this.exitTime;
	}
	/**
	*	Returns the wait time of the Auto by finding the difference between the
	*	entry and exit times
	*	@return the wait time of the auto as an integer value
	*/
	public int getWaitTime(){
		return this.getExitTime() - this.getEntryTime();
	}
	/**
	*	Sets the entry lane of the Auto
	*	@param	lane	a value of the LaneType enum class
	*	@see	LaneType
	*/
	public void setEntryLane(LaneType lane){
		this.entryLane = lane;
	}
	/**
	*	Returns the entry lane of the Auto
	*	@return a value of the LaneType enum class
	*	@see	LaneType
	*/
	public LaneType getEntryLane(){
		return this.entryLane;
	}
	/**
	*	Sets the exit lane of the Auto
	*	@param	lane	a value of the LaneType enum class
	*	@see	LaneType
	*/
	public void setExitLane(LaneType lane){
		this.exitLane = lane;
	}
	/**
	*	Returns the exit lane of the Auto
	*	@return a value of the LaneType enum class
	*	@see	LaneType
	*/
	public LaneType getExitLane(){
		return this.exitLane;
	}
	/**
	*	Returns the ID of the Auto
	*	@return an integer value
	*/
	public int getID(){
		return this.id;
	}
	/**
	*	Sets the ID of the Auto by incrementing the static integer value, count
	*/
	public void setID(){
		this.id = count++;
	}
	/**
	*	Returns a String representation of the Auto object
	*	@return a String data type
	*/
	public String toString(){
		String ret = "";
		ret += "Vehicle ID: " + this.getID() + "\n";
		ret += "Entry Time: " + this.getEntryTime() + "\n";
		ret += "Entry Lane: " + this.getEntryLane() + "\n";
		ret += "Exit Lane: " + this.getExitLane() + "\n";
		return ret;
	}
	/**
	*	Returns a String representation of the Auto object better suited for printing to a text file
	*	@return a String data type
	*/
	public String textToString(){
		String ret = "";
		ret += "Vehicle ID: " + this.getID() + ", ";
		ret += "Entry Time: " + this.getEntryTime() + ", ";
		ret += "Entry Lane: " + this.getEntryLane() + ", ";
		ret += "Exit Lane: " + this.getExitLane();
		return ret;
	}

}