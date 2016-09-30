public class SuperBlock {
protected int number; 	// as in S0, S1, etc.
protected int maxNumberOfDataBlocks; 
 // number of elements per Block
 protected int maxNumberOfElementsPerBlock; 
 // current number of Blocks in this SuperBlock
 protected int currentNumberOfDataBlocks;

 // Workhorse constructor. Initialize variables.
 public SuperBlock(int number, int maxNumberOfDataBlocks,
     int maxNumberOfElementsPerBlock, int currentNumberOfDataBlocks){
	 this.number = number;
	 this.maxNumberOfDataBlocks = maxNumberOfDataBlocks;
	 this.maxNumberOfElementsPerBlock = maxNumberOfElementsPerBlock;
	 this.currentNumberOfDataBlocks = currentNumberOfDataBlocks;
	 
 }

 // Returns number.
 public int getNumber(){
	 return number;
 }

 // Returns maxNumberOfDataBlocks
 public int getMaxNumberOfDataBlocks(){
	 return maxNumberOfDataBlocks;
 }

 // Returns maxNumberOfElementsPerBlock
 public int getMaxNumberOfElementsPerBlock(){
	 return maxNumberOfElementsPerBlock;
 }

 // Returns currentNumberOfDataBlocks 
 public int getCurrentNumberOfDataBlocks(){
	 return currentNumberOfDataBlocks;
 }

 // Increments CurrentNumberOfDataBlocks
 public int incrementCurrentNumberOfDataBlocks(){
	 return ++currentNumberOfDataBlocks;
 }

 // Decrements currentNumberOfDataBlocks
 public int decrementCurrentNumberOfDataBlocks(){
	 return --currentNumberOfDataBlocks;
 }

 // Create a pretty representation of the SuperBlock for debugging.
 // Example:
//    - maxNumberOfDataBlocks:2	
//    - maxNumberOfElementsPerBlock:2
//    - currentNumberOfDataBlocks:1
 protected String toStringForDebugging(){
 	StringBuilder sb = new StringBuilder("");
 	sb.append("\n- maxNumberOfDataBlocks: "+maxNumberOfDataBlocks);
 	sb.append("\n- maxNumberOfElementsPerBlock: "+maxNumberOfElementsPerBlock);//  -
 	sb.append("\n- currentNumberOfDataBlocks:"+currentNumberOfDataBlocks);//  
 	return sb.toString();
}
}
