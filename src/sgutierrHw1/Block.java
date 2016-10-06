package sgutierrHw1;
public class Block<T> {
	protected final int number; // Block number, as in Block1
	protected final T[] arrayOfElements; // Holds actual elements
	protected final int capacity;
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

	//time complexity O(1)
	public void shrink(){
		if(size == 0){
			System.out.println("size = 0");
			return;
		}else{
			arrayOfElements[size-1] = null;
			size--;
		}
		
	}

	// Returns the element at position index in arrayOfElements time complexity O(1)
	public T getElement(int index){
		return arrayOfElements[index];
	}

  	// Sets the value at position i in arrayOfElements to x. time complexity O(1)
	public void setElement(int i, T x){
		arrayOfElements[i] = x;
	}
	////time complexity O(1)
	public boolean isFull(){
		if(size >= capacity){
			return true;
		}else
			return false;
	}
	////time complexity O(1)
	public boolean isEmpty(){
		 return size == 0;
	}

////time complexity O(n)
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(int i=0; size > i;i++){
			sb.append(arrayOfElements[i]);
			sb.append(" ");
		}
		return sb.toString();
	}

//time complexity O(n)
	protected String toStringForDebugging(){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i< size;i++){
			sb.append(arrayOfElements[i]);
			sb.append(" ");
		}
		sb.append("\n-capacity="+capacity+" size="+size);
		return sb.toString();
	}

}
