package KD_Tree;


/**
 * This class is node of the Tree
 * @author Anshu Anand
 *
 */
public class TreeNode
{
    public TreeNode left;
    public TreeNode right;
    public  boolean isVertical;
    public  double  x;
    public  double  y;    
    public  String  info;
    public PointVec cord;
    private String label;

    /**
     * @Precondition: None
	 * @Postcondition:create node
     * @param x
     * @param y
     * @param l
     * @param r
     * @param v
     * @param cor
     * @param inf
     */
    public TreeNode(double x,double y,TreeNode l,TreeNode r,boolean v,PointVec cor,String inf)
    {
        this.x = x;
        this.y = y;
        this.left  = l;
        this.right = r;
        this.isVertical = v;
        this.cord = cor;
        this.info=inf;
        label = "("+x+","+y+")";
    }
    
    /**
     * @Precondition: None
	 * @Postcondition:create node
     * @param label
     */
    public TreeNode(Object label)
    {
        this.x = 0;
        this.y = 0;
        this.left  = null;
        this.right = null;
        this.isVertical = false;
        this.cord = null;
        this.info=null;
        this.label = label.toString();
    }
    
    /**
     * @Precondition: Node created
	 * @Postcondition:return node label
     * @return
     */
    public String getNodeLabel() {
    	return label;
    }
    
    /**
     * @Precondition: Node created
	 * @Postcondition:return x and y value of nodes
     * @return
     */
    public String getXYvalue() {
    	String result = "(" +Double.toString(this.x) +" , "+ Double.toString(this.y)+")";
    	return result;
    }
}


