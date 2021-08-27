
public class CircularQueuePrac {
	
	private int[] values;
	private int size = 15;
	private int length;
	private int front;
	private int back;
	
	
	public CircularQueuePrac() {
		this.values = new int[size];
		this.front = 0;
		this.back = 0;
		this.length = 0;
	}
	
	public void add(int n) {
		values[back] = n;
		if (back == size - 1) {  //if back was pointing to the last index in the array, then make back point back to the beginning
			back = 0;
		}
		else {
			back++;
		}
		length++;
	}
	
	public void remove() {
		if (front == size - 1) {
			front = 0;
		}
		else front++;
		length--;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int front() {
		return values[front];
	}
	
	public int getLength() {
		return length;
	}
	
}
