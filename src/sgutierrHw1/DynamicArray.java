package sgutierrHw1;
//lets see if this is how it works

import javax.swing.LayoutStyle;

class DynamicArray<T> {
  protected Object[] arrayOfBlocks; 
  protected final int DEFAULTCAPACITY = 4;
  protected int sizeOfArrayOfBlocks; // number of Blocks in arrayOfBlocks
  protected int size; // number of elements in DynamicArray
  protected int numberOfEmptyDataBlocks;
  protected int numberOfNonEmptyDataBlocks;
  protected int numberOfDataBlocks;
  protected int indexOfLastNonEmptyDataBlock;
  protected int indexOfLastDataBlock;
  protected int numberOfSuperBlocks; 
  protected SuperBlock lastSuperBlock; // right-most SuperBlock

  // Workhorse constructor. Initialize variables, create the array
  // and the last SuperBlock, which represents SB0.
  public DynamicArray( ){
		  numberOfDataBlocks = 1;
		  numberOfNonEmptyDataBlocks = 0;
		  indexOfLastDataBlock = 0; 
		  numberOfEmptyDataBlocks = 1;
		  indexOfLastNonEmptyDataBlock = -1;
		  numberOfSuperBlocks = 1;
		  sizeOfArrayOfBlocks = 1;
		  arrayOfBlocks = new Object[DEFAULTCAPACITY];
		  //create first Block
		  arrayOfBlocks[0] = new Block(0,1);//first block#0 and capacity 1
		  //create first SuperBlock
		  lastSuperBlock = new SuperBlock(0, 1, 1, 1); 
		  size = 0;	  
	  
  }
 
  // Returns the Location of element i, which is the index of the Block
  // and the position of i within that Block.
  protected Location locate(int index){ 
	  if(index< 0){
		  System.out.println("out of bounds range\nfor index");
		  return null;
	  }
	  int r = index+1;
//	  int k = (int)(Math.log(r)/Math.log(2));//by default the log is rounded to floor*k=superblock # 
	  int k = log2Floor(r);//compute k the superblock number  
	  int p , fk2 = Math.floorDiv(k, 2);//compute floor of(k/2)
	  if(k % 2 == 0){//if k is even
			p = 2*(power2(fk2)-1);
	  }else {//if k is odd
			p = (2*(power2(fk2)-1)) + power2(fk2);
	  }
	  int b = returnB(r,k);//returns the b
	  int blockIndex = p+b;
	  
	  double ck2 = ((double)k / 2.0);//CEILING(k/2) since java divides only int I have to use doubles
	  ck2 = Math.ceil(ck2);
	  int mask = ( 1 << (int)ck2);
	  mask--;
	  int elementIndex = mask & r;
	  Location location = new Location(blockIndex,elementIndex);

	  return location;
  }

  // Returns the Block at position i in arrayOfBlocks.
  // Target complexity: O(1)
  protected Block<T> getBlock(int index){
	  Location location = locate(index);
	  return (Block<T>) arrayOfBlocks[location.getBlockIndex()];
  }
					
  // Returns the element at position i in the DynamicArray.
  // Throws IllegalArgumentException if index < 0 or 
  // index > size -1;
  // Target complexity: O(1)
  public T get(int i){
	  if(i < 0 || i > size-1){
		  System.out.println("out of bounds\nincorrect range for i");
		  return null;
	  }
	  Location location = locate(i);//location encapsulates blockIndex and elementIndex
	  Block<T>  tb = (Block<T>) arrayOfBlocks[location.getBlockIndex()];//temporary block for easy reading
	  return tb.getElement(location.getElementIndex());
	  
  }

  // Sets the value at position i in DynamicArray to x.
  // Throws IllegalArgumentException if index < 0 or 
  // index > size -1;
  // Target complexity: O(1)
  public void set(int index, T x){
	  if(index<0 || index > size-1){
		  System.out.println("out of bounds\nincorrect range for i");
		  return;
	  }
	  Location location = locate(index);//location encapsulates blockIndex and elementIndex
	  Block<T>  tb = (Block<T>) arrayOfBlocks[location.getBlockIndex()];//temporary block for easy reading
	  tb.setElement(location.getElementIndex(),x);//set element x in location.getElementIndex()
  }

  // Allocates one more spaces in the DynamicArray. This may
  // require the creation of a Block and the last SuperBlock may change. 
  // Also, expandArray is called if the arrayOfBlocks is full when
  // a Block is created. 
  // Called by add.
  // Target complexity: O(1)
  protected void grow(){
	  
	  Block <T> block = (Block<T>)arrayOfBlocks[indexOfLastDataBlock]; 
	  if(block.isFull()){
		   if( indexOfLastDataBlock + 1 > arrayOfBlocks.length-1){//if the arrayOfBlocks is full it self is full and double it size (doesn't change values)
			   expandArray();
		   }
		   if( arrayOfBlocks[indexOfLastDataBlock+1] == null){//If block was not created

			  if(lastSuperBlock.isFull()){
//					  ADD NEW SUPERBLOCK		  
				  lastSuperBlock = getNewSuperBlock(lastSuperBlock.getNumber() + 1);//get next superblock
				  numberOfSuperBlocks++;
			  }
			  arrayOfBlocks[indexOfLastDataBlock+1] = new Block<T>(indexOfLastDataBlock+1, lastSuperBlock.getMaxNumberOfElementsPerBlock());
			  numberOfEmptyDataBlocks++;
			  numberOfDataBlocks++;
			  sizeOfArrayOfBlocks++;
			  lastSuperBlock.incrementCurrentNumberOfDataBlocks();			  
		  }

			indexOfLastDataBlock++;
	  }//run this even if full or empty
	  

		block = (Block<T>)arrayOfBlocks[indexOfLastDataBlock];  
	  
	  
	  if(block.isEmpty()){
		  numberOfEmptyDataBlocks--;
		  numberOfNonEmptyDataBlocks++;
		  indexOfLastNonEmptyDataBlock++;
	  }
	  	block.grow();
	  
  }

  // Grows the DynamicArray by one space,sets the last element to x, increases the size of the 
  // DynamicArray, and  
  // Target complexity: O(1)
  public void add(T x){
	  grow();
	  Block <T> tb = getBlock(size); 
	  Location location = locate(size);
	  tb.setElement(location.getElementIndex(), x);
	  size++;
	  
	  
  }

  // Write a null value to the last element, shrinks the DynamicArray by one 
  // space, and decreases the size of the DynamicArray. A Block may be 
  // deleted and the last SuperBlock may change.
  // Also, shrinkArray is called if the arrayOfBlocks is less than or equal
  // to a quarter full when a Block is deleted. 
  // Throws IllegalStateException if the DynamicArray is empty when remove is
  // called.
  // Target complexity: O(1)
  public void remove(){
	  if(size == 0){
		  System.out.println("not able to delete \n size == 0");
		  return;
	  }
	  size--;
	  Block <T> blockToDelete = getBlock(size);
	  Location locationToDelete = locate(size);//block already exists no need to check for null
	  blockToDelete.setElement(locationToDelete.getElementIndex(), null);
	  blockToDelete.shrink();
	  if(blockToDelete.isEmpty()){
		  numberOfEmptyDataBlocks++;
		  numberOfNonEmptyDataBlocks--;
		  indexOfLastNonEmptyDataBlock--;
	  }
	  if(numberOfEmptyDataBlocks == 2){
		  arrayOfBlocks[indexOfLastDataBlock] = null;
		  numberOfDataBlocks--;
		  sizeOfArrayOfBlocks--;
		  numberOfEmptyDataBlocks--;
		  indexOfLastDataBlock--;
		  lastSuperBlock.decrementCurrentNumberOfDataBlocks();
		  if(lastSuperBlock.isEmpty()){
			  lastSuperBlock = getNewSuperBlock(lastSuperBlock.getNumber() -1);
			  lastSuperBlock.fillUp();//fill up lastSuperblock since is being deleted to a previus full one
			  numberOfSuperBlocks--;
		  }
	  }
	  //if one quarter of the array is only full, then double it
	  double fCapacity = arrayOfBlocks.length *(0.25);// 1/4 capicity of array length
	  if( fCapacity > indexOfLastDataBlock)//shirnk array in half
	  {
		  shrinkArray();
	  }

	  
  }

  // Decreases the length of the arrayOfBlocks by half. Create a new
  // arrayOfBlocks and copy the Blocks from the old one to this new array.
  protected void shrinkArray(){
	  int arraySize = arrayOfBlocks.length;
	  Object[] tempArrayOfBlocks = new Object[arraySize]; //create temp array
	  
	  for (int i=0; i<arraySize; i++){//copy elements
		  tempArrayOfBlocks [i] = arrayOfBlocks[i];
	  }
	  arraySize = arraySize / 2;
	  arrayOfBlocks = new Object[arraySize];//resize array by half
	  for (int i=0; i<arraySize; i++){//copy elements back to arrqyOfBlocks
		  arrayOfBlocks [i] = tempArrayOfBlocks[i];
	  }
 
  }

  // Doubles the length of the arrayOfBlocks. Create a new
  // arrayOfBlocks and copy the Blocks from the old one to this new array.
  protected void expandArray(){
	  int arraySize = arrayOfBlocks.length;
	  Object[] tempArrayOfBlocks = new Object[arraySize]; //create temp array
	  
	  for (int i=0; i<arraySize; i++){//copy elements
		  tempArrayOfBlocks [i] = arrayOfBlocks[i];
	  }
	  arrayOfBlocks = new Object[arraySize*2];//resize array by double
	  for (int i=0; i<arraySize; i++){//copy elements
		  arrayOfBlocks [i] = tempArrayOfBlocks[i];
	  }
  }

  // Returns the size of the DynamicArray which is the number of elements that
  // have been added to it with the add(x) method but not removed.  The size 
  // does not correspond to the capacity of the array.
  public int size(){
	  return size;//number of elemnents not the arrays
  }




  // Create a pretty representation of the DynamicArray. This method should
  // return string formatted similarly to ArrayList
  // Examples: [], [X],  [A, B, C, D]
  // 
  // Target Complexity: O(N)
  //   N: number of elements in the DynamicArray
  public String toString(){
	  StringBuilder sb = new StringBuilder();
	  sb.append("[");
	  for(int i=0; i <= indexOfLastDataBlock ; i++){
		  //sb.append("[ ");
		  @SuppressWarnings("unchecked")
		Block<T> temp = (Block<T>) arrayOfBlocks[i];//create a temporary block
		  if(temp == null){
			  sb.append("_");  
		  }else{			  
			  sb.append(temp);
		  }
		  sb.append(", ");
	  }
	  if (indexOfLastDataBlock >= 0) {
		  sb.deleteCharAt(sb.length() - 1);
		  sb.deleteCharAt(sb.length() - 1);
	  }
	  sb.append("]");
	  return sb.toString();
  }

  // Create a pretty representation of the DynamicArray for debugging
  // Example: 
  // DynamicArray: A B 
  // numberOfDataBlocks: 2
  // numberOfEmptyDataBlocks: 0
  // numberOfNonEmptyDataBlocks: 2
  // indexOfLastNonEmptyDataBlock: 1
  // indexOfLastDataBlock: 1
  // numberOfSuperBlocks: 2
  // lastSuperBlock: SB1
  // Block0: A 
  // - capacity: 1 size: 1
  // Block1: B 
  // - capacity: 2 size: 1
  // SB1:
  // - maxNumberOfDataBlocks: 1
  // - numberOfElementsPerBlock: 2
  // - currentNumberOfDataBlocks: 1

protected String toStringForDebugging(){
	 
	 StringBuffer sb = new StringBuffer(); 
	 
	 sb.append("\nnumberOfDataBlocks: "+numberOfDataBlocks);
	 sb.append("\nnumberOfNonEmptyDataBlocks: "+numberOfNonEmptyDataBlocks);
	 sb.append("\nindexOfLastDataBlock: "+indexOfLastDataBlock);
	 sb.append("\nnumberOfEmptyDataBlocks: "+numberOfEmptyDataBlocks);
	 sb.append("\nindexOfLastNonEmptyDataBlock: "+indexOfLastNonEmptyDataBlock);
	 sb.append("\nnumberOfSuperBlocks: "+numberOfSuperBlocks);
	 sb.append("\nlastSuperBlock = "+ lastSuperBlock.number);
	 sb.append("\n");
	  for(int i=0; i <= indexOfLastDataBlock ; i++){
		  
		  @SuppressWarnings("unchecked")
		Block<T> temp = (Block<T>) arrayOfBlocks[i];
		  sb.append("\nBlock"+temp.getNumber()+" : ");
		  sb.append("\t"+temp.toStringForDebugging()+"\n");
	  }
	  
	 sb.append("\nSB"+lastSuperBlock.number+":");
	 sb.append(lastSuperBlock.toStringForDebugging()+"\n");
	 

	 sb.append("\nsize: "+size);
	 
	 return sb.toString();

  }
  /*
   * my methods
   */
  
 public SuperBlock getNewSuperBlock(int superBlockNumber){
	  /*
	   * ADD NEW SUPERBLOCK
	   */
	  int k= superBlockNumber;
	  int fk2 = Math.floorDiv(k, 2);//compute floor of(k/2)
	  int tMaxNumberOfDataBlocks = power2(fk2);
	  int ck2 = (int) Math.ceil(k / 2.0);
	  int maxNumberOfElementsPerBlock = power2(ck2);
	  return new SuperBlock(k, tMaxNumberOfDataBlocks, maxNumberOfElementsPerBlock, 0);
	  
 	}
  
  public int returnB(int r, int k){
		int lb = bitNum(r);//returns leading bit
		
		int mask = 1 << (lb-1);
		mask--;
		int b = r & mask;
		int lastShift = lb - ((int)Math.floorDiv(k,2)+1);
		b = b >> lastShift;//substract leading bit by floor (k/2)
		return b;
  }

  /*
   ***************NORDSTROM METHODS************
   */
  // returns floor(log2(n)
  public int log2Floor(int n)
  {
     return bitNum(n) - 1;
  }
  
  // returns ceil(log2((n)
  public int log2Ceil(int n)
  {
     return bitNum(n - 1);
  }
  
  // returns 2 to the power n
  public static int power2(int n)
  {
     return 1 << n;
  }
  
	// returns the number of bits in n ignoring leading 0 bits NORDSTROM
	  private static int bitNum(int n)
	  {
	     int  count = 0;
	     while (n != 0)
	     {
	        n = n >>> 1;
	        count++;
	     }
	     return count;
	  }
}
