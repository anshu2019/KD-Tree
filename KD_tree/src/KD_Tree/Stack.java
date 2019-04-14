package KD_Tree;

/**
 * 
 * @author Anshu Anand
 *
 */
public class Stack {

	StackLinkedList sLin = new StackLinkedList();
    int size =0;
    
    /**
     * @Precondition: Stack is created
	 * @Postcondition: node is inserted in stack
     * @param data
     */
	public void push(TreeNode data) {
		sLin.addFront(data);
		size++;
	}

	/**
	 * @Precondition: Stack is created
	 * @Postcondition: node is removed from stack
	 * @return
	 */
	public TreeNode  pop() {
		if (sLin.isEmpty()) {
			return null;
		}
		TreeNode o = sLin.deleteFront();
		return o;
	}

	/**
	 * @Precondition: Stack is created
	 * @Postcondition: display the stack
	 */
	public void displayStack() {
	    System.out.println("  ");
	    sLin.displayList();
	  }
	
	
	/**
	 * @Precondition: Stack is created
	 * @Postcondition:get the size of stack
	 * @return
	 */
	public int  getSize() {
		return size;
	}
}
