public class BSTPrac {
	
	private Node2 root;
	
	
	public BSTPrac(int value) {  //tree starts off with a root
		root = new Node2(value);
	}
	
	public BSTPrac() {}   //no value initialized in the tree, null root
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void insert(int n) {
		if (isEmpty()) {  //if its empty, insert node as the root
			root = new Node2(n);
			return;
		}
		//if it is not empty, we must determine whether to add to right or left
		insertRec(root, n);
	}
	
	private void insertRec(Node2 n, int i) {
		if( i < n.value ) {  //if value is less than current value we must insert on left
			if (n.left == null) {  //if left is empty, insert
				n.left = new Node2(i);
			}
			else { //if left isnt empty, we must keep going through the tree
				insertRec(n.left, i);
			}
		}
		if (i > n.value){  //if value is greater than current, insert on right
			if (n.right == null) {  //if right is empty, insert value
				n.right = new Node2(i);
			}
			else {  //if right is not empty, keep traversing the tree
				insertRec(n.right, i);
			}
			
		}
		
	}
	
	public int height() {
		if (root == null) {
			return 0;
		}
		else {
			return heightRec(root);
		}
	}
	
	private int heightRec(Node2 node) {
		if (node == null) {  //if there is no node then height is 0
			return 0;
		}
		else if (node.left == null && node.right == null) {  //if its a leaf, then you can return 1
			return 1;
		}
		else if (node.right == null) {  //if no right child, add 1 to height for the current node, then keep traversing down the left
			return 1 + heightRec(node.left);
		}
		else if (node.left == null) {  //if no left child, add 1 to height for current node and keep traversing down the left
			return 1 + heightRec(node.right);
		}
		else {  //this is the case where there is 2 children
			return 1 + Math.max(heightRec(node.left), heightRec(node.right));   //take the max height of the left or right branches
		}
	}
	//same as height only we add all the elements
	public int numOfElem() {
		if (root == null) {
			return 0;
		}
		else {
			return numOfElemRec(root);
		}
	}
	
	private int numOfElemRec(Node2 node) {
		if (node.left == null && node.right == null) {
			return 1;
		}
		else if (node.left == null) {
			return 1 + numOfElemRec(node.right);
		}
		else if (node.right == null) {
			return 1 + numOfElemRec(node.left);
		}
		else {
			return 1 + numOfElemRec(node.left) + numOfElemRec(node.right);
		}
	}
	
	public boolean contains(int n){
		if (root == null) {
			return false;
		}
		else {
			return containsRec(root, n);
		}
		
	}
	
	private boolean containsRec(Node2 node, int n) {
		if (node.value == n) {  //if the node is the value then return true
			return true;
		}
		else if( node.left == null && node.right == null) {  //if it reaches a leaf and the value is not the leaf, then the tree does not conatin the value
			return false;
		}
		else if (node.left == null) {  //if there is no left node and the number is smaller then the current value then it is not in the tree
			if (n < node.value) {
				return false;
			}
			else {
				return containsRec(node.right,n);  // if the number was greater then the current node, check the right branch
			}
		}
		else if (node.right == null) {  
			if (n > node.value) {  //if there is no right node and the value is greater then current value, then it is not in the tree
				return false;
			}
			else {   //if the value is less then the current value, then check left branch
				return containsRec(node.left, n);  
			}
		}
		else {  //2 branches
			if (n > node.value) {   //if the number is greater then the current, check right branch
 				return containsRec(node.right, n);
			}
			else {   //if the number is less then the current, check left branch
				return containsRec(node.left, n);
			}
		}
	}
	
	public boolean isBST() {
		if(root == null) {
			return false;
		}
		return isBSTRec(root);
	}
	
	private boolean isBSTRec(Node2 node) {
		if (node.left == null && node.right == null) {
			return true;  //if it makes it to a leaf then it is sorted properly
		}
		if (node.left == null) {  //only a right branch
			if (node.right.value < node.value) {  //if right is less then value it is sorted wrong
				return false;
			}
			else {
				return isBSTRec(node.right);   //if rihgt is graeter then value check the rest of right
			}
		}
		if (node.right == null) {  //only a left branch
			if (node.left.value > node.value) {  //if left is greater than value it is sorted wrong 
				return false;
			}
			else {
				return isBSTRec(node.left);  //if left is less then value check rest of left branch
			}
		}
		else {  //left and right branch
			if (node.left.value > node.value || node.right.value < node.value) {  //if either the left value is bigger than value or right value is smaller than value, then it is wrong
				return false; 
			}
			else {   //if nothing is wrong with either, we need to check both the left and right sub trees and ensure both are sorted properly
				return isBSTRec(node.left) && isBSTRec(node.right);
			}
		}
	}
	public void delete(int n) {
		if (!contains(n)) {
			return;
		}
		if (root.value == n) {
			int min = getMinRec(root.right);
			root.value = min;
			deleteRec(root.right, min);
			
		}
		else {
			deleteRec(root, n);
		}
	}
	
	public void deleteRec(Node2 node, int n) {
		if (n < node.value) {  //if the value you want to delete is in the left tree
			if (node.left != null) {  //the left tree is not null
				if (node.left.value == n) {   //the left tree has the value you want to delete
					if (node.left.left == null && node.left.right == null) {
						node.left = node.left.left;
					}
					else if (node.left.left == null) {
						node.left = node.left.right;
					}
					else if (node.left.right == null) {
						node.left = node.left.left;
					}
					else {
						int min = getMinRec(node.left.right);
						node.left.value = min;
						deleteRec(node.left, min);
					}
				}
				else {
					deleteRec(node.left,n); //if left node was not value, keep moving down the left
				}
			}
		}
		else {
			if (node.right != null) {
				if (node.right.value == n) {
					if (node.right.right == null && node.right.left == null) {
						node.right = node.right.right;
					}
					else if (node.right.right == null) {
						node.right = node.right.left;
					}
					else if (node.right.left == null) {
						node.right = node.right.right;
					}
					else {
						int min = getMinRec(node.right.right);
						node.right.value = min;
						deleteRec(node.right, min);
					}
				}
				else {
					deleteRec(node.right, n);
				}
			}
		}
	}
	
	
	public int getMin() {
		if (root == null) {
			return 0;
		}
		else {
			return getMinRec(root);
		}
	}
	
	public int getMinRec(Node2 node) {
		if (node.left == null) {  //if theres no more left children, then that is the lowest value
			return node.value;
		}
		else {
			return getMinRec(node.left);  //if more left children, keep going until no more left children
		}
	}
	public void Preorder() {
		PreorderRec(root);
	}
	//print in preorder
	public void PreorderRec(Node2 node) {
		if (node == null) return;
		System.out.print(node.value + " ");
		PreorderRec(node.left);
		PreorderRec(node.right);
	}
	
	public void InOrder() {
		InOrderRec(root);
	}
	
	public void InOrderRec(Node2 node) {
		if (node == null) return;
		InOrderRec(node.left);
		System.out.print(node.value + " ");
		InOrderRec(node.right);
	}
	public void PostOrder() {
		PostOrderRec(root);
	}
	
	public void PostOrderRec(Node2 node) {
		if (node == null) return;
		
		PostOrderRec(node.left);
		PostOrderRec(node.right);
		System.out.print(node.value + " ");
	}
	
	
	
	public String toString() {
		if(isEmpty()) {
			return "[]";
		}
		return toStringRec(root);
	}
	
	private String toStringRec(Node2 node){
		if(node.left == null && node.right == null) {
			return "" + node.value;
		}
		if(node.left == null) {
			return node.value +"->{" + toStringRec(node.right) + "}"; 
		}
		if(node.right == null) {
			return "{" + toStringRec(node.left) + "}<-" + node.value; 
		}
		return "{" +  toStringRec(node.left) + "}<-" + node.value +"->{" + toStringRec(node.right) + "}"; 
	}
	
	public void print() {
		System.out.println(this.toString());
	}

}