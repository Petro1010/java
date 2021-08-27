
public class QueuePractice {
	
	private int[] values;
	private int size = 30;
	private int length;
	
	public QueuePractice() {
		this.values = new int[size];
		this.length = 0;
	}
	
	
	public void add(int n) {  //add value to queue
		values[length] = n;
		length++;
	}
	
	public int remove() {   //FIFO method
		int temp = values[0];  //stores value at front of queue
		for (int i = 0; i < length; i++) {
			values[i] = values[i + 1];   //shift entire queue over by 1
		}
		length--; //removing an item so length 
		return temp;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int first() {
		return values[0];
	}
	
	public int getLength() {
		return length;
	}

}
