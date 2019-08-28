package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		// Set up scanner object to read space-separated values
		// from console input
		
		Scanner scan = new Scanner(System.in);

		// Read in count of numbers to process
		
		int count = scan.nextInt();
		
		//Create separate arrays to store customers' first name,
		//last name, number of items bought.  
		
		String[] FirstNames = new String[count];
		String[] LastNames = new String[count];
		int[] NumofItems = new int[count];
		
		//Read values into arrays
		
		for (int i=0; i < count; i++) {
			FirstNames[i] = scan.next();
			LastNames[i] = scan.next();
			NumofItems[i] = scan.nextInt();
			
			int[] itemcount = new int[NumofItems[i]];
			String[] itemname = new String[NumofItems[i]];
			double[] itemprice = new double[NumofItems[i]];
			
			for (int j=0; j < NumofItems[i]; j++) {
				itemcount[j] = scan.nextInt();
				itemname[j] = scan.next();
				itemprice[j] = scan.nextDouble();
			}
			
			double finalcost = calculateTotalCost(itemcount, itemprice);
			
			System.out.println(FirstNames[i].charAt(0) + ". " + LastNames[i] + ": " + String.format("%.2f",  finalcost));
			
		}
	}

	/* calculateTotalCost
	 * Calculates the total cost of a customer's purchase
	 * 
	 * Input: array of integer values of count of each item and 
	 * array of double values of item prices
	 * 
	 * Output: double value sum of all item counts times respective prices
	 * 
	 * Preconditions: Input arrays must not be null
	 */

	static double calculateTotalCost(int[] itemcnt, double[] prices) {

		double totalcost = 0;

		for (int i=0; i<itemcnt.length; i++) {
			totalcost += itemcnt[i] * prices[i];
		}

		return totalcost;
	}
}