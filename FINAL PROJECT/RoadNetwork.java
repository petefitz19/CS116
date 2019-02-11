package Traffic.RoadNetwork;
import java.util.ArrayList;
import Traffic.RoadNetwork.NormalBlock;
import Traffic.RoadNetwork.TrafficBlock;
import Traffic.RoadNetwork.IntersectionBlock;
import Traffic.RoadNetwork.Block;
/**
*	RoadNetwork - Uses the Block classes to generate four lanes and 
*	provides the method to run the simulation along with the additional
*	helper methods.
*	@author	Peter Fitzpatrick
*	@version 1.0
*/
public class RoadNetwork{
	//Create 4 ArrayLists of Block Objects
	private ArrayList<Block> NS = new ArrayList<Block>();
	private ArrayList<Block> SN = new ArrayList<Block>();
	private ArrayList<Block> WE = new ArrayList<Block>();
	private ArrayList<Block> EW = new ArrayList<Block>();
	
	private int span;
	private double rate;
	private double entryRate;
	private int duration;
	private int greenTicks;
	private int orangeTicks;
	int lightCounter = 0;
	ArrayList<ArrayList<Block>> intersection = new ArrayList<>();
	ArrayList<Integer> waitTimes = new ArrayList<>();
	ArrayList<LaneType> exitLanes = new ArrayList<>();
	ArrayList<Auto> autoData = new ArrayList<>();
	/**
	*	Constrctor for RoadNetwork. Creates the 4 lanes and initializes them
	*	with the appropriate starting values.
	*	@param	span	the amount of blocks before the intersection. An integer value.
	*	@param	rate	a double value from 0 to 1 which specifies the rate at which the vehicles will turn.
	*	@param	entryRate	a double value from 0 to 1 which specifies the rate at which the vehicles will enter the simulation.
	*	@param	duration	the amount of ticks the simulation will run for as an integer value.
	*	@param	greenTicks	the amount of ticks the green light duration will last for as an integer value.
	*	@param	orangeTicks	the amount of ticks the orange light duration will last for as an integer value.
	*/
	public RoadNetwork(int span, double rate, double entryRate, int duration, int greenTicks, int orangeTicks){ //create get and set methods
		this.setSpan(span);
		this.setRate(rate);
		this.setEntryRate(entryRate);
		this.setDuration(duration);
		this.setGreenTicks(greenTicks);
		this.setOrangeTicks(orangeTicks);
		//creates the default lane 
		
		for(int i = 0; i < 4; i++){
			ArrayList<Block> lane = new ArrayList<Block>();
			for(int j = 0; j < span-1; j++){
				lane.add(new NormalBlock(j));
			}
			lane.add(new TrafficBlock(span - 1, TrafficLight.GREEN));
			lane.add(new IntersectionBlock(span, IntersectionType.RIGHT, this.getRate()));
			lane.add(new IntersectionBlock(span + 1, IntersectionType.LEFT, this.getRate()));
		
			for(int k = 0; k < span; k++){
				lane.add(new NormalBlock(span + 2 + k));
			}
			intersection.add(lane);
		}
		//Assigns each lane to a row of the Nested ArrayList
		NS = intersection.get(0);
		SN = intersection.get(1);
		WE = intersection.get(2);
		EW = intersection.get(3);
		
		//sets the next and prev blocks for each lane
		for(int x = 0; x < NS.size(); x++){ 
			if(x ==0){
				NS.get(0).setNext(NS.get(1));
			}
			else if(x == NS.size()-1){
				NS.get(NS.size()-1).setPrev(NS.get(NS.size()-2));
			}
			else{
				NS.get(x).setNext(NS.get(x+1));
				NS.get(x).setPrev(NS.get(x-1));
			}
		}
		for(int x = 0; x < SN.size(); x++){
			if(x ==0){
				SN.get(0).setNext(SN.get(1));
			}
			else if(x == SN.size()-1){
				SN.get(SN.size()-1).setPrev(SN.get(SN.size()-2));
			}
			else{
				SN.get(x).setNext(SN.get(x+1));
				SN.get(x).setPrev(SN.get(x-1));
			}
		}
		for(int x = 0; x < EW.size(); x++){
			if(x ==0){
				EW.get(0).setNext(EW.get(1));
			}
			else if(x == EW.size()-1){
				EW.get(EW.size()-1).setPrev(EW.get(EW.size()-2));
			}
			else{
				EW.get(x).setNext(EW.get(x+1));
				EW.get(x).setPrev(EW.get(x-1));
			}
		}
		for(int x = 0; x < WE.size(); x++){
			if(x ==0){
				WE.get(0).setNext(WE.get(1));
			}
			else if(x == WE.size()-1){
				WE.get(NS.size()-1).setPrev(WE.get(WE.size()-2));
			}
			else{
				WE.get(x).setNext(WE.get(x+1));
				WE.get(x).setPrev(WE.get(x-1));
			}
		}
		//sets the neighors for intersection blocks in each lane
		((IntersectionBlock)SN.get(span)).SetNeighbors(WE.get(span+2));
		((IntersectionBlock)SN.get(span+1)).SetNeighbors(EW.get(span+1));
		((IntersectionBlock)NS.get(span)).SetNeighbors(EW.get(span+2));
		((IntersectionBlock)NS.get(span+1)).SetNeighbors(WE.get(span+1));
		((IntersectionBlock)WE.get(span)).SetNeighbors(NS.get(span+2));
		((IntersectionBlock)WE.get(span+1)).SetNeighbors(SN.get(span+1));
		((IntersectionBlock)EW.get(span)).SetNeighbors(SN.get(span+2));
		((IntersectionBlock)EW.get(span+1)).SetNeighbors(NS.get(span+1)); 
		
		//Set starting colors for traffic blocks, the other two which are green are initialized in the default lane
		((TrafficBlock)WE.get(span - 1)).setColor(TrafficLight.RED); //might need (TrafficBlock) in front
		((TrafficBlock)EW.get(span - 1)).setColor(TrafficLight.RED);
	}
	
	//Accessors and Mutators
	/**
	*	Returns the span of the lanes
	*	@return an integer value
	*/
	public int getSpan(){
		return this.span;
	}
	/**
	*	Sets the span of the lanes
	*	@param	span	an integer value
	*/
	public void setSpan(int span){
		this.span = span;
	}
	/**
	*	Returns the turn rate of the vehicles
	*	@return a double value
	*/
	public double getRate(){
		return this.rate;
	}
	/**
	*	Sets the turn rate of the vehicles
	*	@param	rate	a double value
	*/
	public void setRate(double rate){
		this.rate = rate;
	}
	/**
	*	Returns the entry rate of the vehicles
	*	@return a double value
	*/
	public double getEntryRate(){
		return this.entryRate;
	}
	/**
	*	Sets the entry rate of the vehicles
	*	@param	entryRate	a double value
	*/
	public void setEntryRate(double entryRate){
		this.entryRate = entryRate;
	}
	/**
	*	Returns the duration of the simulation
	*	@return an integer value
	*/
	public int getDuration(){
		return this.duration;
	}
	/**
	*	Sets the duration of the simulation
	*	@param	duration	an integer value
	*/
	public void setDuration(int duration){
		this.duration = duration;
	}
	/**
	*	Returns the duration of green light
	*	@return an integer value
	*/
	public int getGreenTicks(){
		return this.greenTicks;
	}
	/**
	*	Sets the duration of the green light
	*	@param	greenTicks	an integer value
	*/
	public void setGreenTicks(int greenTicks){
		this.greenTicks = greenTicks;
	}
	/**
	*	Returns the duration of orange light
	*	@return an integer value
	*/
	public int getOrangeTicks(){
		return this.orangeTicks;
	}
	/**
	*	Sets the duration of the orange light
	*	@param	orangeTicks	an integer value
	*/
	public void setOrangeTicks(int orangeTicks){
		this.orangeTicks = orangeTicks;
	}
	/**
	*	Updates the states of the TrafficLight enum variable for the Traffic Block
	*/
	private void updateLights(){
		lightCounter++;
		if(lightCounter == greenTicks){
			((TrafficBlock)(NS.get(span - 1))).setColor(TrafficLight.ORANGE);
			((TrafficBlock)(SN.get(span - 1))).setColor(TrafficLight.ORANGE);
		}
		else if(lightCounter == (greenTicks + orangeTicks)){
			((TrafficBlock)(NS.get(span - 1))).setColor(TrafficLight.RED);
			((TrafficBlock)(SN.get(span - 1))).setColor(TrafficLight.RED);
			((TrafficBlock)(EW.get(span - 1))).setColor(TrafficLight.GREEN);
			((TrafficBlock)(WE.get(span - 1))).setColor(TrafficLight.GREEN);
		}
		else if(lightCounter == (greenTicks + greenTicks + orangeTicks)){
			((TrafficBlock)(EW.get(span - 1))).setColor(TrafficLight.ORANGE);
			((TrafficBlock)(WE.get(span - 1))).setColor(TrafficLight.ORANGE);
		}
		else if(lightCounter > 2* (greenTicks + orangeTicks)){
			((TrafficBlock)(NS.get(span - 1))).setColor(TrafficLight.GREEN);
			((TrafficBlock)(SN.get(span - 1))).setColor(TrafficLight.GREEN);
			((TrafficBlock)(EW.get(span - 1))).setColor(TrafficLight.RED);
			((TrafficBlock)(WE.get(span - 1))).setColor(TrafficLight.RED);
			lightCounter = 0;
		}
	}
	/**
	*	Runs the simulation for the duration passed into the parameters of the constructor
	*/
	public void runSimulation(){
		for(int i = 0; i < duration; i++){
			updateLights();
			for(int j = 0; j < 4; j++){
				ArrayList<Block> road = intersection.get(j);
				if(Math.random() < this.getEntryRate() && road.get(0).getAuto() == null){
					Auto temp = new Auto(1, i, LaneType.values()[j], LaneType.values()[j]);
					road.get(0).setAuto(temp);
				}
				for(int k = road.size()-1; k >= 0; k--){
					Auto a = null;
					if(road.get(k).getAuto() != null){
						a = road.get(k).MoveForward(i);
					}
					if(a != null){
						waitTimes.add(a.getWaitTime());
						exitLanes.add(LaneType.values()[j]);
						a.setExitLane(LaneType.values()[j]);
						autoData.add(a);
					}	
				}
			}
		}
	}
}