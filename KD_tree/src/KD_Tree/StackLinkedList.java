package KD_Tree;

/**
 * This linked list class is for stack
 * 
 * @author Anshu Anand
 *
 */
public class StackLinkedList {

	private Node front = null;

	/**
	 * @Precondition: StackLinkedList is created
	 * @Postcondition: node is inserted in StackLinkedList
	 * @param data
	 */
	public void addFront(TreeNode data) {
		Node n = new Node(data);
		n.next = front;
		front = n;
	}

	/**
	 * @Precondition: StackLinkedList is created
	 * @Postcondition: node is deleted from StackLinkedList
	 * @return
	 */
	public TreeNode deleteFront() {
		TreeNode temp = front.getData();
		front = front.next;
		return temp;
	}

	/**
	 * @Precondition: StackLinkedList is created
	 * @Postcondition: display the nodes from the list
	 */
	public void displayList() {
		Node current = front;
		while (current != null) {
			current.displayNode();
			current = current.next;
		}
	}

	/**
	 * @Precondition: StackLinkedList is created
	 * @Postcondition: check is list is empty
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return (front == null);
	}
}
