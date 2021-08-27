
public class QueueWStacks {
		private StackPractice stack1;
		private StackPractice stack2;
		private int length;
		
		public QueueWStacks() {
			this.length = 0;
			this.stack1 = new StackPractice();
			this.stack2 = new StackPractice();
		}
		
		
		public void add(int n) {
			stack1.push(n);
			length++;
		}
		
		public int remove() {
			if (!stack2.isEmpty()) {  //if the second stack is not empty, then pop off of that stack
				int temp = stack2.pop();
				length--;
				return temp;
			}
			else {
				int height = stack1.getHeight();   //we must define this variable outside the for loop as the height of stack1 is changing after every run of the for loop!!!!
				for (int i = 0; i < height; i++) {
					//System.out.println("Run Number " + i );
					int temp1 = stack1.pop();
					//System.out.println(temp1);
					stack2.push(temp1);
				}
				
				int temp = stack2.pop();
				length--;
				return temp;
			}
		}
		
		public void print() {
			System.out.println(stack1.arrayToString());
			System.out.println(stack2.arrayToString());
			
		}
		
		
		
		
}
