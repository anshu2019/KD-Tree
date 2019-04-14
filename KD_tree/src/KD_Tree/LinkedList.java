package KD_Tree;

/**
 * This is a linked list class , which will be used for creating 2D tree
 * @author Anshu Anand
 *
 */
public class LinkedList {

	/*
	 * field to hold head of list
	 */
	private Node head = null;
	/*
	 * field to hold tail of list
	 */
	private Node tail = null;
	/*
	 * field to hold count
	 */
	private int countNodes=0;
	
	/**
	 * @Precondition list created
	 * @Postcondition returns true false for nodes in the list
	 * This method checks if , Linked-list is empty
	 * @return
	 */
	public boolean isEmpty() {
		return (head == null);
	}

	/**
	 * @Precondition No pre condition
	 * @Postcondition Node is added to linked list
	 * This method adds a node at last
	 * @param data
	 */
	public void addLast(TreeNode data) {
		Node n = new Node(data);
        if (isEmpty()) {
            n.next = head;
            head = n;
            tail = n;
        } else {
        	tail.next = n;
        	tail = n;
        	tail.next = null;
        }
		
	}

	/**
	 * @Precondition linked list should not be null
	 * @Postcondition Node is removed
	 * This method removes the node from the linked list
	 */
	public void removeFront() {
		if (head.next == null)
			tail = null;
		head = head.next;

	}

	/**
	 * @Precondition linked list should not be null
	 * @Postcondition Node is removed
	 * This method removes head ,and returns it.
	 * 
	 * @return
	 */
	public TreeNode poll() {
		if (head.next == null)
			tail = null;
		TreeNode temp = head.getData();
		head = head.next;
		return temp;
	}

	/**
	 *@Precondition linked list should not be null
	 * @Postcondition displays all the nodes from the linkedlist
	 * This method prints the nodes info .
	 */
	public void displayList() {
		Node current = head;
		while (current != null) {
			current.displayNode();
			current = current.next;
		}
	}
	
	/**
	 * @Precondition linked list should not be empty
	 * @Postcondition Count is returned
	 * This method returns node count.
	 * @return
	 */
	 public int CountNodes() {
	        return countNodes;
	    }

}
