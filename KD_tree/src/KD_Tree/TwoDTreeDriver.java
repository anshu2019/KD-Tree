package KD_Tree;

import java.util.Scanner;

public class TwoDTreeDriver {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Initialize the tree
		TwoDTree t = new TwoDTree("data/CrimeLatLonXY.csv");
		//TwoDTree t = new TwoDTree("data/test.csv");
		// Once tree is loaded , show menu
		showMenu(t);

	}

	/**
	 * 
	 */
	private static void showMenu(TwoDTree t) {
		// instantiate scanner
		Scanner userInput = new Scanner(System.in);
		int input;
		System.out.println("----------------------------------------------------");
		System.out.println("What would you like to do?");
		System.out.println("1. Inorder :");
		System.out.println("2. Preorder :");
		System.out.println("3. Levelorder :");
		System.out.println("4. Postorder :");
		System.out.println("5. reverseLevelOrder :");
		System.out.println("6. search for points within rectangle :");
		System.out.println("7. search for nearest neighbor :");
		System.out.println("8. quit :");
		System.out.println("Enter your choice below:");
		input = userInput.nextInt();

		if (input >= 1 && input <= 8) {

			switch (input) {
			case 1:
				System.out.println("Printing In-order sequence...");
				t.traverseInorder();
				System.out.println("Sequence end here----------------------");
				showMenu(t);
				break;
			case 2:
				System.out.println("Printing Pre-order sequence...");
				t.traversePreorder();
				System.out.println("Sequence end here----------------------");
				showMenu(t);
				break;
			case 3:
				System.out.println("Printing level-order sequence...");
				t.traverseLevelOrder();
				System.out.println("Sequence end here----------------------");
				showMenu(t);
				break;
			case 4:
				System.out.println("Printing Post-order sequence...");
				t.traversePostorder();
				System.out.println("Sequence end here----------------------");
				showMenu(t);
				break;
			case 5:
				System.out.println("Printing Reverse level-order sequence...");
				t.traverseReverseLevelOrder();
				System.out.println("Sequence end here----------------------");
				showMenu(t);
				break;
			case 6:
				System.out.println("Enter x value for first coardinate, x1:");
				double x1 = userInput.nextDouble();
				System.out.println("Enter y value for first coardinate, y1:");
				double y1 = userInput.nextDouble();
				System.out.println("Enter x value for first coardinate, x2:");
				double x2 = userInput.nextDouble();
				System.out.println("Enter x value for first coardinate, y2:");
				double y2 = userInput.nextDouble();
				
				PointVec c0 = new PointVec(x1, y1);
				PointVec c1 = new PointVec(x2, y2);
				ListOfCrime lsc =t.getValueInRange(c0,c1);
				lsc.retrieveCrimeData();
				lsc.toKML();
				
				
				showMenu(t);
				break;
			case 7:
				System.out.println("Enter x value for first coardinate, x:");
				double x3 = userInput.nextDouble();
				System.out.println("Enter y value for first coardinate, y:");
				double y3 = userInput.nextDouble();
				
				PointVec c3 = new PointVec(x3, y3);
				t.getNearestNeighbour(c3);
				
				showMenu(t);
				break;
			case 8:
				userInput.close();
				System.out.println("2-d Tree operation completed.");
				break;
			default:

				break;
			}
		} else {
			System.out.println("Invalid input!,Enter an integer:");
			showMenu(t);
		}

	}
}
