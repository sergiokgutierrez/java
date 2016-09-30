public class DynamicQueue<T> {
	protected DynamicArray<T> front;
	protected DynamicArray<T> rear;

	// Workhorse constructor. Initialize variables.
	public DynamicQueue(){
		
	}

	// Adds x to the rear of the queue
	// Target complexity: O(1)
	public void enqueue(T x){
		
	}

	// Removes and returns the element at the front of the queue
	// Throws NoSuchElementException if this queue is empty.
	// Target complexity: O(n)
	public T dequeue(){
		return null;
	}

	// Returns true if the queue is empty
	public boolean isEmpty(){
		return false;
	}

	// Returns the size of the queue
	public int size(){
		return 0;
	}

	// Create a pretty representation of the DynamicQueue.
 	// Example:
	// A B C D
	public String toString(){
		return null;
	}

	// Create a pretty representation of the DynamicQueue for debugging.
	// Example:
	// front.toString: A B 
	// rear.toString: C D
	protected String toStringForDebugging(){
		return null;
	}
}
