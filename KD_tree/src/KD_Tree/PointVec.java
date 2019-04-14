package KD_Tree;

/**
 * This class is co-ordinate class for our application
 * @author Anshu Anand
 *
 */
public class PointVec {

	private double x;
	private double y;
	private double[] ds;
	
	/**
	 * @Precondition: None
	 * @Postcondition: Point is created
	 * @param a
	 * @param b
	 */
	public PointVec(double a,double b ) {
		x=a;
		y=b;
	}
	
	/**
	 * @Precondition:point exist
	 * @Postcondition: return x coordinate
	 * @return x
	 */
	public double x() {
		return x;
	}
	
	/**
	 * @Precondition:point exist
	 * @Postcondition: return y coordinate
	 * @return y
	 */
	public double y() {
		return y;
	}
	
	/**
	 * @Precondition:point exist
	 * @Postcondition: return x, y coordinate
	 * @return y
	 */
	public double[] getCordinates() {
		ds = null;
		ds[0]=x;
		ds[1] = y;
		return ds;
		
	}
	
	/**
	 * @Precondition:point exist
	 * @Postcondition: return x,y coordinate in string format
	 * @return y
	 */
	public String getValue() {
		return x+" , "+y;
	}
	
	/**
	 * @Precondition:point exist
	 * @Postcondition: return distnace from the given point
	 * @return y
	 */
	public double getDistanceFrom(PointVec p) {
		double d=0;
		d = Math.sqrt((x-p.x())*(x-p.x()) + (y-p.y())*(y-p.y()));
		return d;
	}
}
