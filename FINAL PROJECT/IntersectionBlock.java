package Traffic.RoadNetwork;

import Traffic.RoadNetwork.BlockType;
import Traffic.RoadNetwork.Block;
/**
 *  IntersectionBlock.java - A subclass of the Block class.
 *	Intersection Blocks lie at the intersection of the lanes and
 *	allow for the vehicles to switch lanes.
 *	@author	Peter Fitzpatrick
 *	@version 1.0
 */
public class IntersectionBlock extends Block{
	
	private IntersectionType itype;//Type of intersection
	private Block neighbor;//Block residing to the left or right of the Intersection Block
	private double turnRate;//Rate at which a turn will be executed
	/**
	*	Constructor for class IntersectionBlock.
	*	Takes in parameters of an integer representing its Block Number, 
	*	the type of intersection block it is as the IntersectionType enum class,
	*	and a double representing the rate at which a vehicle can turn.
	*	@param	no	an integer value representing the number of the Intersection Block.
	*	@param	type	the type of intersection block it is as the IntersectionType enum class.
	*	@param	turnRate	turnRate	double value from 0 to 1 representing the rate at which a vehicle can turn.
	*/
	public IntersectionBlock(int no,IntersectionType type, double turnRate){ //user input for turn rate 0 to 1
		super(BlockType.BLOCK_INTERSECT, no);
		this.setIntersectionType(type);
		this.setTurnRate(turnRate);
	}
	/**
	*	Sets the type of the Intersection Block
	*	@param	itype	an IntersectionType enum value
	*	@see IntersectionType
	*/
	public void setIntersectionType(IntersectionType itype){
		this.itype = itype;
	}
	/**
	*	Returns the type of the intersection block
	*	@return an IntersectionType enum value
	*	@see IntersectionType
	*/
	public IntersectionType getIntersectionType(){
		return this.itype;
	}
	/**
	*	Sets the double value representing the rate at which a vehicle can turn
	*	@param	turnRate	a double value from 0 to 1
	*/
	public void setTurnRate(double turnRate){
		this.turnRate = turnRate;
	}
	/**
	*	Returns the turn rate
	*	@return a double value from 0 to 1
	*/
	public double getTurnRate(){
		return this.turnRate;
	}
	/**
	*	Returns the Block to the left or right of the current Block
	*	@return an object of type Block
	*	@see Block
	*/
	public Block getNeighbor(){
		return this.neighbor;
	}
	/**
	*	Sets the Block to the left or right of the current Block
	*	@param	b	an object of type Block
	*/
	public void SetNeighbors(Block b){
		this.neighbor = b;
	}
	/**
	*	A method to move the vehicle to the next place in the road
	*	@param tick	the current tick that the simulation is on
	*	@return	an object of type Auto
	*/
	@Override
	public Auto MoveForward(int tick){
		double x = Math.random();
		if(x > this.getTurnRate()){
			if(super.getNext().getAuto() == null){ //forward
				Auto temp = super.getAuto();
				super.getNext().setAuto(temp);
				super.setAuto(null);
				super.setProcessedFlag(true);
				return null;
			}
			else{
				this.setProcessedFlag(true);
				return null;
			}
		}
		else{
			if(this.getNeighbor().getAuto() == null){ //turn
				Auto temp = super.getAuto();
				this.getNeighbor().setAuto(temp);
				super.setAuto(null);
				super.setProcessedFlag(true);
				return null;
			}
			else{
				this.setProcessedFlag(true);
				return null;
			}
		}	
	}
}