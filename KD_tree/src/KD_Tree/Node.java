package KD_Tree;



/**
 * This class creates node
 * @author Anshu Anand
 *
 */
public  class Node {

	private TreeNode data;
	Node next;

	/**
	 * @Precondition:None
	 * @Postcondition Create a Node
	 * @param data
	 */
	public Node(TreeNode data) {
		this.data = data;
		next=null;
	}

	/**
	 * @Precondition:Node exist
	 * @Postcondition:Display node
	 */
	public void displayNode() {
		System.out.print(data.getXYvalue() + " ");
	}
	
	/**
	 * @Precondition: Node exist
	 * @Postcondition: Get node data
	 * @return
	 */
	public TreeNode getData() {
		return data;
	}

}
