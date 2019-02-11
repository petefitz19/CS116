package Traffic.RoadNetwork;

import Traffic.RoadNetwork.BlockType;
import Traffic.RoadNetwork.Block;
/**
 *  NormalBlock.java - A subclass of the Block class.
 *	A vehicle in this block can move to the next Block if it is empty
 *	@author	Peter Fitzpatrick
 *	@version 1.0
 */
public class NormalBlock extends Block{
	/**
	*	Constructor for class NormalBlock.
	*	Takes in parameters of an integer representing its Block Number
	*	@param	no	an integer value representing the number of the Normal Block.
	*/
	public NormalBlock(int no){
		super(BlockType.BLOCK_NORMAL, no);
	}
	/**
	*	A method to move the vehicle to the next place in the road
	*	@param tick	the current tick that the simulation is on
	*	@return	an object of type Auto
	*/
	@Override
	public Auto MoveForward(int tick){
		if(super.getNext()!= null && super.getNext().getAuto() == null){
			Auto temp = super.getAuto();
			super.getNext().setAuto(temp);
			super.setAuto(null);
			super.setProcessedFlag(true);
			return null;
		}// set this block to null, set next block to auto
		else if(super.getNext()== null){
			Auto temp = super.getAuto();
			super.setAuto(null);
			this.setProcessedFlag(true);
			temp.setExitTime(tick + 1);
			System.out.println("\nEntry Lane: " + temp.getEntryLane());
			return temp;
		}
		else{
			this.setProcessedFlag(true);
			return null;
		}
	}
	
}