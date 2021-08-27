
public class StackPractice {
	
	private int[] values;
	private int height;
	private int stackSize = 10;
	
	public StackPractice() { //constructor
		this.values = new int[stackSize]; //new int array of size specified in definition
		this.height = 0; //a new stack will always have height of 0;
	}
	
	//push on to stack method
	
	public void push(int n) {
		if (height == values.length) resizeUp();
		values[height] = n;
		height++;
	}
	//pop value off top of the stack
	public int pop() {
		if (height < values.length/2 && height > stackSize) {  //when the array is less then half full but the height is still more then the original stack size we can resize it down
			resizeDown();
		}
		height--;                     //when popping, the value does not need to be erased as it will just be over written later
		return values[height];       // we want the value at height - 1, as arrays index start at 0, so for example when there is one value and height is 1, that one value will be at index 0
	}
	
	//see if stack is empty
	public boolean isEmpty() {
		return height == 0;  //if height is 0 stack is empty
	}
	//value at the top of the stack
	public int peek() {
		if (isEmpty()) {
			return 0;
		}
		return values[height - 1];
	}
    
	public int getHeight() {  //accessor method which allows users to see height without altering it
		return height;
	}
	
	//dynamic implementation of array
	//first, implement a resize method of the stack (to do this, just transfer all stack values into a bigger array)
	private void resize(int newSize) {
		int[] temp = new int[newSize];
		for (int i = 0; i < height; i++ ) {
			temp[i] = values[i];
		}
		values = temp;
	}
	
	private void resizeUp() {
		resize(2*values.length);   //resize array up to twice original size
	}
	private void resizeDown() {
		resize((3/4)*values.length); //resize array down to 3/4 of original size
	}
	
	//Recursive methods of stack
	//Remove the bottom of the stack
	public void removeBottom() {
		if (height == 1) {  //if height is equal to one, then the bottom will be the only element, so remove it
			pop();
		}
		else {              //keep removing until height gets down to one, remove the last element completely, then add all elements that were taken off back onto the stack
			int temp = pop();
		    removeBottom();
		    push(temp);
		}
		
	}
	
	public String arrayToString() {
		String arrayStr="{";
		for (int i = 0; i < values.length ;i++) {
			if (i == values.length - 1) {
				arrayStr+= values[i];
			}
			else {
				arrayStr+= values[i] +",";
			}
			
		}
			
		return arrayStr + "}";
	}
}
