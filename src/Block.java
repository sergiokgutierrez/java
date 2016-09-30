public class Block<T> {
	protected final int number; // Block number, as in Block1
	protected final T[] arrayOfElements; // Holds actual elements

     // Note that it is not possible to use the code
     // T a[] = new T[size]; 
	// which leads to Java’s Generic Array Creation error on 
     // compilation. Consult the textbook for solution to surmount this 
     // minor problem

	// Number of elements that can be stored in this block;
     // this is equal to arrayOfElements.length
	protected final int capacity;

	// Number of spaces that have been allocated for storing elements;
     // initially 0. size <= capacity
	protected int size;

	// Workhorse constructor. Initialize variables and create array.
	@SuppressWarnings("unchecked")
	public Block(int number, int capacity){
		this.size = 0;//size always starts at 0
		this.number = number;
		this.capacity = capacity;
		this.arrayOfElements = (T[])new Object[capacity];
	}

	// Returns Number
	public int getNumber(){
		return number;
	}
	
	// Returns capacity
	public int getCapacity(){
		return capacity;
	}

	// Returns size
	public int size(){
		return size;
	}

	// Increases size field of the Block to allow additional elements to be added.
	// Does not change the actual size of the array held by the Block
	public void grow(){
		size++;
		
	}

	// Set the last element to null and decrease the space allocated 
     // for storing elements. Decreases size.
	public void shrink(){
		if(size == 0){
			System.out.println("size = 0");
			return;
		}else{
			arrayOfElements[size-1] = null;
			size--;
		}
		
	}

	// Returns the element at position index in arrayOfElements.
	public T getElement(int index){
		return arrayOfElements[index];
	}

  	// Sets the value at position i in arrayOfElements to x.
	public void setElement(int i, T x){
		arrayOfElements[i] = x;
	}
	
	public boolean isFull(){
		if(size >= capacity){
			return true;
		}else
			return false;
	}

     // Create a pretty representation of the Block.
     // Example: 
     // A	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(int i=0; size > i;i++){
			sb.append(arrayOfElements[i]);
			sb.append(" ");
		}
		return sb.toString();
	}

     // Create a pretty representation of the Block for debugging.
     // Example: 
     // A
     // - capacity=1 size=1		
	protected String toStringForDebugging(){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<size;i++){
			sb.append(arrayOfElements[i]);
			sb.append(" ");
		}
		sb.append("\n-capacity="+capacity+" size="+size);
		return sb.toString();
	}

}
