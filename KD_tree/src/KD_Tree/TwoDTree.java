package KD_Tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class handles creation of 2D tree and other operations on 2D tree data
 * @author Anshu Anand
 *
 */
public class TwoDTree {

	private TreeNode root;
	private int size;

	// Keep one copy of queue , this will help in doing level order tarversal on
	// tree
	// queue will keep order of entry

	/**
	 * @Pre-condition: The String crimeDataLocation contains the path to a file
	 *                 formatted in the exact same way as CrimeLatLonXY.csv
	 * @Post-condition: The 2d tree is constructed and may be printed or queried.
	 * @param dataPath
	 */
	public TwoDTree(String dataPath) {
		size = 0;
		root = null;

		try {
			this.readDataFromFile(dataPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Pre-condition: Data for each node available
	 * @Post-condition: Crime data inserted as node
	 * @param node
	 * @param p
	 * @param isVertical
	 * @param cord
	 * @param inf
	 * @return
	 */
	private TreeNode insert(TreeNode node, PointVec p, final boolean isVertical, PointVec cord, String inf) {
		// if new node, create it

		if (node == null) {
			size++;
			return new TreeNode(p.x(), p.y(), null, null, isVertical, cord, inf);
		}

		// if (node.x == p.x() && node.y == p.y())
		// return node;

		if (node.isVertical && p.x() < node.x || !node.isVertical && p.y() < node.y) {
			node.left = insert(node.left, p, !node.isVertical, cord, inf);

		} else {
			node.right = insert(node.right, p, !node.isVertical, cord, inf);

		}
		return node;
	}

	/**
	 * @Pre-condition: Data for each node available
	 * @Post-condition: Crime data inserted as node
	 * @param p
	 * @param cor
	 * @param inf
	 */
	public void insert(PointVec p, PointVec cor, String inf) {
		root = insert(root, p, true, cor, inf);
	}

	/**
	 * @Pre-condition: File path to be read by file reader
	 * @Post-condition: File is read and proceeded for tree creation
	 * @param path
	 * @throws IOException
	 */
	private void readDataFromFile(String path) throws IOException {
		// Open the file
		FileInputStream fstream = null;
		int iterCount = 0;

		try {
			fstream = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			if (iterCount == 0) {
				iterCount++;
				continue;
			}
			String data = strLine;
			String[] d = data.split(",");
			initiateTree(d);
			iterCount++;
		}

		// Close the input stream
		br.close();
		System.out.println("Crime file loaded into 2d tree with " + getSize() + " records");
		// printTree(root,0);
	}

	/**
	 * @Pre-condition: Data to be inserted in node
	 * @Post-condition: node is inserted
	 * @param d
	 */
	private void initiateTree(String[] d) {
		if (d != null) {

			String inf = d[4] + "," + d[5] + "," + d[3];

			double x = Double.parseDouble(d[0]);
			double y = Double.parseDouble(d[1]);
			double lat = Double.parseDouble(d[7]);
			double lng = Double.parseDouble(d[8]);

			PointVec p = new PointVec(x, y);
			PointVec c = new PointVec(lat, lng);
			// System.out.println(inf);
			// insert in tree
			insert(p, c, inf);
		}

	}

	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @Pre-condition: 2 D tree is created
	 * @Post-condition: Print 2 d tree
	 * @param root
	 */
	public void printTree(TreeNode root, int cnt) {
		if (root == null) {
			return;
		} else {
			cnt++;
			System.out.println(cnt + ">>" + root.getNodeLabel() + ">>");
			if (root.left != null) {
				cnt++;
				System.out.println(cnt + ">>>" + root.left.getNodeLabel());
				printTree(root.left, cnt);
			}
			if (root.right != null) {
				cnt++;
				System.out.println(cnt + ">>>" + root.right.getNodeLabel());
				printTree(root.right, cnt);
			}

		}
	}

	/**
	 * @Pre-condition: The 2d tree has been constructed.
	 * @Ppost-condition: The 2d tree is displayed with a post-order traversal.
	 * @param node
	 * @comment This is Theeta(N), knowing that it has to traverse each node to print.
	 *          T(n) = T(k) + T(n – k – 1) + c where k is left sided nodes and n-k-1 is right sided node.
	 *          Hence T(N) = Theeta(N)
	 */
	void traversePostorder(TreeNode node) {
		if (node == null)
			return;

		// traverse the left node first
		traversePostorder(node.left);
		// traverse the right node first
		traversePostorder(node.right);
		// finally root
		System.out.print(node.getXYvalue() + "\n");
	}

	/**
	 * @Pre-condition: The 2d tree has been constructed.
	 * @Post-condition: The 2d tree is displayed with an in-order traversal.
	 * @param node
	 * @comment This is Theeta(N), knowing that it has to traverse each node to print.
	 *          T(n) = T(k) + T(n – k – 1) + c where k is left sided nodes and n-k-1 is right sided node.
	 *          Hence T(N) = Theeta(N)
	 */
	void traverseInorder(TreeNode node) {
		if (node == null)
			return;
		// traverse the left node first
		traverseInorder(node.left);
		// root
		System.out.print(node.getXYvalue() + "\n");
		// traverse the right node first
		traverseInorder(node.right);
	}

	/**
	 * @Pre-condition: The 2d tree has been constructed. *
	 * @Post-condition: The 2d tree is displayed with a pre-order traversal.
	 * @param node
	 * @comment This is Theeta(N), knowing that it has to traverse each node to print.
	 *          T(n) = T(k) + T(n – k – 1) + c where k is left sided nodes and n-k-1 is right sided node.
	 *          Hence T(N) = Theeta(N)
	 */
	void traversePreorder(TreeNode node) {
		if (node == null)
			return;

		// traverse the left node first
		System.out.print(node.getXYvalue() + "\n");
		// traverse the left node first
		traversePreorder(node.left);
		// traverse the right node first
		traversePreorder(node.right);
	}

	/**
	 * @Pre-condition: The 2d tree has been constructed. *
	 * @Post-condition: The 2d tree is displayed with a level-order traversal.
	 * @param root
	 * @comment: we have to one enque opeartion on each node and one deque opeartion on each node.
	 *           hence T(n) = T(k) +T(k) , where k = number of nodes T(n) = T(2N)
	 *           Hence it is a Theeta(N).
	 */
	void traverseLevelOrder(TreeNode root) {
		Queue q = new Queue();
		int levelNodes = 0;

		if (root == null) {
			return;
		}
		q.enqueue(root);
		while (!q.isEmpty()) {
			levelNodes = q.getSize();
			while (levelNodes > 0) {
				TreeNode n = (TreeNode) q.poll();
				if (n != null)
					System.out.print(" " + n.getXYvalue());
				if (n != null && n.left != null)
					q.enqueue(n.left);
				if (n != null && n.right != null)
					q.enqueue(n.right);
				levelNodes--;
			}
			System.out.println("");
		}
	}

	/**
	 * @Pre-condition: The 2d tree has been constructed.
	 * @Post-condition: The 2d tree is displayed with a reverse level-order
	 *                  traversal. *
	 * @param root
	 * @comment: For each we will do two operation on queue, enqueue and dequeue and similarly 2 stack operation push and peek.
	 *           T(N) = T(n) +T(n) +T(n) +T(n) = T(4n), and hence we can say ,
	 *           It is Theeta (N)
	 */
	void traverseReverseLevelOrder(TreeNode root) {
		Queue q = new Queue();
		Stack s = new Stack();

		int levelNodes = 0;

		if (root == null) {
			return;
		}
		q.enqueue(root);
		while (!q.isEmpty()) {
			levelNodes = q.getSize();
			while (levelNodes > 0) {
				TreeNode n = (TreeNode) q.poll();
				if (n != null)
					s.push(n); // push data to stack ....
				if (n != null && n.left != null)
					q.enqueue(n.left);
				if (n != null && n.right != null)
					q.enqueue(n.right);
				levelNodes--;
			}
			// System.out.println("");
		}

		int stackSize = s.getSize();
		while (stackSize > 0) {
			TreeNode t = s.pop();
			System.out.print(" " + t.getXYvalue());
			stackSize--;
		}
	}

	// Wrapper function for functions
	public void traversePostorder() {
		traversePostorder(root);
	}

	public void traverseInorder() {
		traverseInorder(root);
	}

	public void traversePreorder() {
		traversePreorder(root);
	}

	public void traverseLevelOrder() {
		traverseLevelOrder(root);
	}

	public void traverseReverseLevelOrder() {
		traverseReverseLevelOrder(root);
	}

	/**
	 * @Pre-condition: The 2d tree has been constructed.Root node is provided	 * 
	 * @Post-condition: returns if point is in the rectangle	 * 
	 * @param c0
	 * @param c1
	 * @param root1
	 * @return
	 */
	private boolean containedInRectangle(PointVec c0, PointVec c1, TreeNode root1) {
		boolean res = false;

		if (root1 != null) {
			if ((root1.x > c0.x() && root1.y > c0.y()) && (root1.x < c1.x() && root1.y < c1.y())) {
				System.out.println("in the range" + root1.getXYvalue());
				return true;
			} else {
				return false;
			}

		}
		return res;
	}

	/**
	 * @Pre-condition: The 2d tree has been constructed.	 * 
	 * @Post-condition: returns list of crime
	 * @param c0
	 * @param c1
	 * @return
	 */
	public ListOfCrime getValueInRange(PointVec c0, PointVec c1) {
		ListOfCrime crimeList = new ListOfCrime();
		getRange(root, c0, c1, crimeList);
		// crimeList.retrieveCrimeData();
		return crimeList;
	}

	/**
	 * @Pre-condition: The 2d tree has been constructed.Root node is provided	 * 
	 * @Post-condition: returns all te point in the co-ordinate range
	 * @param node
	 * @param c0
	 * @param c1
	 * @param q
	 */
	private void getRange(TreeNode node, PointVec c0, PointVec c1, ListOfCrime q) {

		if (node == null)
			return;

		if (containedInRectangle(c0, c1, node)) {
			q.addCrimeDataFromNode(node);
		}
		getRange(node.left, c0, c1, q);
		getRange(node.right, c0, c1, q);
	}

	/**
	 * @Pre-condition: The 2d tree has been constructed.Point is provided to be searched	 * 
	 * @Post-condition: returns nearest point
	 * @param p
	 */
	public void getNearestNeighbour(PointVec p) {
		Neighbor nr = new Neighbor();
		TreeNode nearestNode = nr.findNearest(root, p);

		PointVec nd = new PointVec(nearestNode.x, nearestNode.y);
		double nearestDistance = p.getDistanceFrom(nd);

		System.out.println("-----------------------------");
		System.out.println("Found the nearest crime at:-" + nd.getValue());
		System.out.println("Co-Ordinates:- " + nearestNode.cord.getValue());
		System.out.println("Distance from nearest crime in Feet: " + nearestDistance + " Feets");

		String[] s = nearestNode.info.split(",");
		System.out.println("Crime Deatil :- ");
		System.out.println("Offence:- " + s[0]);
		System.out.println("Street:- " + s[2]);
		System.out.println("Date:- " + s[1]);
		System.out.println("");
		System.out.println("Thank you for exploring Pittsburgh crime in 1990s. ");

	}
	
}
