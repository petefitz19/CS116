package Traffic.RoadNetwork;
import Traffic.RoadNetwork.BlockType;
/**
 *  Block.java - A superclass for the blocks that make up a lane
 *	@author	Peter Fitzpatrick
 *	@version 1.0
 */
public abstract class Block{		
		private BlockType type; //0:normal,1:intersection,2:traffic-light
		private int BlockNo;
		private Auto vehicle; // object of the vehicle occupying the block
		private Block Next; // the next block on the lane
		private Block Prev; // previous block on the lane
		private boolean ProcessedFlag;//flag for indicate whether the block has been processed during current tick of the simulation
		
		/**
		*	Constructor for class Block.
		*	Takes in parameters of BlockType and 
		*	an integer representing its Block Number.
		*	@param	t	a BlockType that represents the Block.
		*	@param	no	an integer value representing the number of the Block.
		*/
		Block(BlockType t, int no){
			this.setType(t);
			this.setBlockNo(no);
		}
		/**
		*	Returns the type of block
		*	@return a BlockType enum data type
		*	@see BlockType
		*/
		public BlockType getType(){
			return this.type;
		}
		/**
		*	Sets the type of block
		*	@param	t	a BlockType enum value
		*	@see BlockType
		*/
		public void setType(BlockType t){
			this.type=t;
		}
		/**
		*	Returns the number of the Block
		*	@return an integer data type
		*/
		public int getBlockNo(){
			return this.BlockNo;
		}
		/**
		*	Sets the number of the Block
		*	@param	posNo an integer data type
		*/
		public void setBlockNo(int posNo){
			this.BlockNo=posNo;
		}
		/**
		*	Returns the Auto occupying the Block
		*	@return	an Auto data type
		*	@see Auto
		*/
		public Auto getAuto(){
			return this.vehicle;
		}
		/**
		*	Sets the Auto to occupy the Block
		*	@param	v an object of type Auto
		*/
		public void setAuto(Auto v){
			this.vehicle=v;
		}
		/**
		*	Returns the Block in front of the current Block on the lane
		*	@return	a Block data type
		*	@see Block
		*/
		public Block getNext(){
			return this.Next;
		}
		/**
		*	Sets the Block in front of the Current Block on the lane
		*	@param	nextBlock	an object of type Block
		*	@see	Block
		*/
		public void setNext(Block nextBlock){
			this.Next=nextBlock;			
		}
		/**
		*	Returns the Block behind the current Block on the lane
		*	@return	a Block data type
		*	@see Block
		*/
		public Block getPrev(){
			return this.Prev;
		}
		/**
		*	Sets the Block behind the Current Block on the lane
		*	@param	prevBlock	an object of type Block
		*	@see	Block
		*/
		public void setPrev(Block prevBlock){
			this.Prev=prevBlock;			
		}
		/**
		*	Sets the flag for indicating whether the block has been processed during current tick of the simulation
		*	@param	x	a boolean variable
		*/
		public void setProcessedFlag(boolean x){
			this.ProcessedFlag = x;
		}
		/**
		*	Returns the flag for indicating whether the block has been processed during current tick of the simulation
		*	@return	a boolean variable
		*/
		public boolean getProcessedFlag(){
			return this.ProcessedFlag;
		}
		/**
		*	An absract method to move the vehicle to the next place in the road
		*	@param tick	the current tick that the simulation is on
		*	@return	an object of type Auto
		*/
		public abstract Auto MoveForward(int tick);
}