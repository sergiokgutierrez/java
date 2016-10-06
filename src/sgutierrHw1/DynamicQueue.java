package sgutierrHw1;

import java.util.NoSuchElementException;

public class DynamicQueue<T> {
	protected DynamicArray<T> front;
	protected DynamicArray<T> rear;  

	// Target complexity: O(1)
	protected DynamicArray<T> getFront(){
		return front;
	}

	// Target complexity: O(1)
	protected DynamicArray<T> getRear(){
		return rear;
	}

	// Workhorse constructor. Initialize variables.
	public DynamicQueue(){
		front  = new DynamicArray<T>();
		rear = new DynamicArray<T>();
		
	}

	// Adds x to the rear of the queue
	// Target complexity: O(1)
	public void enqueue(T x){
		rear.add(x);
	}

	// Target complexity: O(n)
	public T dequeue() throws NoSuchElementException {
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		T temp;
		if(front.size() == 0){
			for(int i=rear.size()-1; i >= 0 ;i--){
				temp = rear.get(i);
				front.add(temp);
				rear.remove();
			}
		}
		temp = front.get(front.size() - 1);
		front.remove();
		return temp;
	}

	// Returns true if the queue is empty
	public boolean isEmpty(){
		return rear.size() == 0 && front.size() == 0;
	}

	// Returns the size of the queue
	public int size(){
		return rear.size() + front.size();
	}

	// Create a pretty representation of the DynamicQueue.
 	// Example:
	// [A, B, C, D]
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (front.size() > 0) {
			for (int i = front.size() - 1; i >= 0; i++) {
				sb.append(front.get(i).toString());
				sb.append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		if (rear.size() > 0) {
			for (int i = 0; i < rear.size(); i++) {
				sb.append(rear.get(i).toString());
				sb.append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		return sb.toString();
	}

	// Create a pretty representation of the DynamicQueue for debugging.
	// Example:
	// front.toString: [A, B] 
	// rear.toString: [C, D]
	protected String toStringForDebugging(){
		StringBuilder sb = new StringBuilder();
		sb.append("front.toString: ");
		sb.append("[");
		for (int i = front.size() - 1; i >= 0; i++) {
			sb.append(front.get(i).toString());
			sb.append(",");
		}
		if (front.size() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		sb.append("rear.toString: ");
		sb.append("[");
		for (int i = 0; i < rear.size(); i++) {
			sb.append(rear.get(i).toString());
			sb.append(",");
		}
		if (rear.size() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		return sb.toString();
	}
}

