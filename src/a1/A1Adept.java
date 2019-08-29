package a1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Read in count of store products to process
		
		int productcount = scan.nextInt();
		
		//Create separate arrays to store product names,
		//and their respective prices.  
				
		String[] productnames = new String[productcount];
		double[] productprices = new double[productcount];
		
		//Read values into arrays
		
		for (int i=0; i < productcount; i++) {
			productnames[i] = scan.next();
			productprices[i] = scan.nextDouble();
		}
		
		//Read in count of customers to process
		int customercount = scan.nextInt();
		
		//Create separate arrays to store customers' first name,
		//last name, number of items bought.  
				
		String[] FirstNames = new String[customercount];
		String[] LastNames = new String[customercount];
		int[] NumofItems = new int[customercount];
		double[] totalcosts = new double[customercount];
		
		//Read values into arrays 
		
		for (int i=0; i < customercount; i++) {
			FirstNames[i] = scan.next();
			LastNames[i] = scan.next();
			NumofItems[i] = scan.nextInt();
			
			int[] itemquantity = new int[NumofItems[i]];
			String[] itemname = new String[NumofItems[i]];
			double[] itemprice = new double[NumofItems[i]];
		
			
			for (int j=0; j < NumofItems[i]; j++) {
				itemquantity[j] = scan.nextInt();
				itemname[j] = scan.next();
				int productidx = Arrays.asList(productnames).indexOf(itemname[j]);
				itemprice[j] = productprices[productidx];
			}
			
			double finalcost = A1Novice.calculateTotalCost(itemquantity, itemprice);
			totalcosts[i] = finalcost;
			
		}
		
		
		// All input parsed, so close scanner
		scan.close();
		
		double maxcost = findValueMax(totalcosts);
		double mincost = findValueMin(totalcosts);
		double sum = calculateValueSum(totalcosts);
		double averagecost = (double) sum / customercount;
		
		String[] newcosts = new String[totalcosts.length];
		for (int i = 0; i < newcosts.length; i++) {
		    newcosts[i] = String.format("%.2f", totalcosts[i]);
		}
		
		int maxidx = Arrays.asList(newcosts).indexOf(String.format("%.2f", maxcost));
		int minidx = Arrays.asList(newcosts).indexOf((String.format("%.2f", mincost)));
		
		System.out.println("Biggest: " + FirstNames[maxidx] + " " + LastNames[maxidx] + " (" + String.format("%.2f", maxcost) + ")");
		System.out.println("Smallest: " + FirstNames[minidx] + " " + LastNames[minidx] + " (" + String.format("%.2f", mincost) + ")");
		System.out.println("Average: " + String.format("%.2f", averagecost));
	}
	
	static double findValueMin(double[] vals) {
		
		// Initialize current minimum to first value in array.
		double cur_min = vals[0];
		
		// Starting with second value (if any), compare each value
		// in array with current minimum and replace if smaller.
		
		for (int i=1; i < vals.length; i++) {
			if (vals[i] < cur_min) {
				cur_min = vals[i];
			}
		}
		
		return cur_min;
	}

	/* findValueMax
	 * Finds and returns the maximum value in an array of integers
	 * 
	 * Input: array of integers vals
	 * 
	 * Output: maximum value found within the array
	 * 
	 * Preconditions:
	 * Input array must not be null and must contain at least one value.
	 */
	
	static double findValueMax(double[] vals) {
		
		// Initialize current minimum to first value in array.
		double cur_max = vals[0];
		
		// Starting with second value (if any), compare each value
		// in array with current minimum and replace if smaller.
		
		for (int i=1; i < vals.length; i++) {
			if (vals[i] > cur_max) {
				cur_max = vals[i];
			}
		}
		
		return cur_max;
	}

	/* calculateValueSum 
	 * Calculates the sum on an array of integers
	 *
	 * Input: array of integers vals
	 * 
	 * Output: integer sum of values in vals
	 * 
	 * Preconditions:
	 * Input array must not be null.
	 */
	
	static double calculateValueSum(double[] vals) {
		
		double sum = 0;
		
		for (int i=0; i<vals.length; i++) {
			sum += vals[i];
		}
		
		return sum;
	}
		
}
