package KD_Tree;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class handles the list of crime occured
 * This provides method for adding and retreiving the crime data.
 * @author Anshu Anand
 *
 */
public class ListOfCrime {

	private Node front = null;
	private int crimeCounter = 0;

	/**
	 * @Precondition Linked list for list of crime is created
	 * @Postcondition Node is added to linked list
	 * This method adds crime to the list.
	 * @param data
	 */
	public void addCrimeDataFromNode(TreeNode data) {
		Node n = new Node(data);
		n.next = front;
		front = n;
		crimeCounter++;
	}

	/**
	 * @Precondition Linked list is created
	 * @Postcondition Node is removed from linked list
	 * @return
	 */
	public TreeNode deleteFront() {
		TreeNode temp = front.getData();
		front = front.next;
		return temp;
	}

	/**
	 * @Precondition Linked list for list of crime is created
	 * @Postcondition provide all the crime data
	 */
	public void retrieveCrimeData() {
		Node current = front;
		int counter = 0;
		System.out.println("Total Numbers of crime occured in this range is:-" + getCrimeCount());
		System.out.println("-----------------------------------------");
		while (current != null) {
			counter++;
			TreeNode data = current.getData();
			String[] s = data.info.split(",");

			System.out.println("Crime Record:-" + counter);
			System.out.println("Offence:- " + s[0]);
			System.out.println("Street:- " + s[2]);
			System.out.println("Date:- " + s[1]);
			System.out.println("Co-Ordinates:- " + data.cord.getValue());
			System.out.println("-----------------------------------------");

			current = current.next;
		}
		System.out.println("Total Numbers of crime occured in this range is:-" + getCrimeCount());
	}

	/**
	 * @Precondition Linked list for list of crime is created
	 * @Postcondition Provide the nodes data as string
	 */
	@Override
	public String toString() {
		Node current = front;
		String res = "";
		while (current != null) {

			TreeNode data = current.getData();
			String[] s = data.info.split(",");

			res = res.concat(s[0] + ",");
			System.out.println(res);
			current = current.next;
		}
		return res;
	}

	/**
	 * @Precondition Linked list for list of crime is created
	 * @Postcondition provide a kml file on list of crime
	 */
	public void toKML() {
		Node current = front;
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("data/PGHCrimes.kml");
		} catch (IOException e) {

			e.printStackTrace();
		}
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		printWriter.print("<kml xmlns=\"http://earth.google.com/kml/2.2\">\n");
		printWriter.print("<Document>");
		printWriter.print("<Style id=\"style1\">\n");
		printWriter.print("<IconStyle>\n");
		printWriter.print(" <Icon>\n");
		printWriter.print(" <href>http://maps.gstatic.com/intl/en_ALL/mapfiles/ms/micons/blue-dot.png</href>\n");
		printWriter.print(" </Icon>\n");
		printWriter.print(" </IconStyle>\n");
		printWriter.print(" </Style>\n");

		while (current != null) {

			TreeNode data = current.getData();
			String[] s = data.info.split(",");

			String crime = s[0];
			String desc = s[2];
			String[] cord = data.cord.getValue().split(",");

			printWriter.print("<Placemark>\n");
			printWriter.print("<name>" + crime + "</name>\n");
			printWriter.print(" <description>" + desc + "</description>\n");
			printWriter.print("<styleUrl>#style1</styleUrl>\n");
			printWriter.print(" <Point>\n");
			printWriter.print("  <coordinates>" + cord[1]+","+cord[0]+","+"0.000000" + "</coordinates>\n");
			printWriter.print("  </Point>\n");
			printWriter.print("</Placemark>\n");

			current = current.next;
		}

		printWriter.print("</Document>\n");
		printWriter.print("</kml>\n");
		printWriter.close();

	}

	/**
	 *@Precondition Linked list for list of crime is created
	 * @Postcondition provide boolean for emptyness of list
	 * @return
	 */
	public boolean isEmpty() {
		return (front == null);
	}

	/**
	 * @Precondition Linked list for list of crime is created
	 * @Postcondition provide the count
	 * @return
	 */
	public int getCrimeCount() {
		return crimeCounter;
	}
}
