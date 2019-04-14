package KD_Tree;

/**
 * This class is queue 
 * @author Anshu Anand
 *
 */
public class Queue {

	LinkedList linkList = new LinkedList();
    int count=0;
	
    /**
	 * @Precondition: queue is created
	 * @Postcondition: node is inserted in queue
	 * @param data
	 */
	public void enqueue(TreeNode n) {
		linkList.addLast(n);
		count++;
	}

	/**
	 * @Precondition: queue is created
	 * @Postcondition: node is removed from queue
	 */
	public void dequeue() {
		if (!linkList.isEmpty())
			linkList.removeFront();
		    count--;
    
	}

	/**
	 * @Precondition: queue is created
	 * @Postcondition: node is removed from queue and returned
	 */
	public TreeNode poll() {

		if (linkList.isEmpty()) {
			return null;
		}
		TreeNode o = linkList.poll();
		return o;
	}

	/**
	 *@Precondition: queue is created
	 * @Postcondition: display queue
	 */
	public void displayQueue() {
		linkList.displayList();
		System.out.println();
	}

	/**
	 * @Precondition: queue is created
	 * @Postcondition: check if queue is empty
	 * @return
	 */
	public boolean isEmpty() {
		return linkList.isEmpty();
	}

	/**
	 * @Precondition: queue is created
	 * @Postcondition: return size of queue
	 * @return
	 */
	public int getSize() {
		return count;
	}
}
