package KD_Tree;

/**
 * This class handles the nearest neighbor search
 * @author Anshu Anand
 *
 */
public class Neighbor {

	int nodeVisit = 0;

	/**
	 * @Precondition: Tree is created 
	 * @Postcondition Provide nearest point
	 * @param node
	 * @param x
	 * @param y
	 * @param candidate
	 * @return
	 */
	public TreeNode findNearest(TreeNode root, PointVec p) {
		
		TreeNode t = findNearest(root, p.x(), p.y(), null);
		//System.out.println("Numbers of node visited to find nearest crime:-" + nodeVisit);
		return t;
	}

	/**
	 * @Precondition: Tree is created
	 * @Postcondition Provide nearest point
	 * @param node
	 * @param x
	 * @param y
	 * @param candidate
	 * @return
	 */
	private TreeNode findNearest(TreeNode node, double x, double y, TreeNode candidate) {
		
		
		double distance_query_nearest = 0.0;
		if (node == null)
			return candidate;

		final PointVec query = new PointVec(x, y);
		TreeNode nearestNode = candidate;
		PointVec nearest = null;

		if (nearestNode != null) {
			nearest = new PointVec(nearestNode.x, nearestNode.y);
		} else {
			nearest = null;
		}

		if (nearest != null) {
			distance_query_nearest = query.getDistanceFrom(nearest);
		}

		PointVec point = new PointVec(node.x, node.y);
		if (nearest == null || distance_query_nearest > query.getDistanceFrom(point)) {
			nearest = point;
			nearestNode = node;
			
			if (node.isVertical) {

				if (x < node.x) {
					
					nearestNode = findNearest(node.left, x, y, nearestNode);
					nearestNode = findNearest(node.right, x, y, nearestNode);
				} else {
					
					nearestNode = findNearest(node.right, x, y, nearestNode);
					nearestNode = findNearest(node.left, x, y, nearestNode);
				}
			} else {

				if (y < node.y) {
					
					nearestNode = findNearest(node.left, x, y, nearestNode);
					nearestNode = findNearest(node.right, x, y, nearestNode);
				} else {
					
					nearestNode = findNearest(node.right, x, y, nearestNode);
					nearestNode = findNearest(node.left, x, y, nearestNode);
				}
			}
		}
		return nearestNode;
	}

}
