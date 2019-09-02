package a1;

import java.util.Arrays;
import java.util.Scanner;

public class A1Jedi {

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
		int[] totalbought = new int[productcount];
		int[] customerpurchasecount = new int[productcount];
		
		//Read values into arrays 
		
		for (int i=0; i < customercount; i++) {
			FirstNames[i] = scan.next();
			LastNames[i] = scan.next();
			NumofItems[i] = scan.nextInt();
					
			int[] itemquantity = new int[NumofItems[i]];
			String[] itemname = new String[NumofItems[i]];
				
					
			for (int j=0; j < NumofItems[i]; j++) {
				itemquantity[j] = scan.nextInt();
				itemname[j] = scan.next();
				int productidx = Arrays.asList(productnames).indexOf(itemname[j]);
				totalbought[productidx] += itemquantity[j];

			}
			
			
			
			for (int k=0; k < productcount; k++) {
				if (Arrays.asList(itemname).contains(productnames[k])) {
					//int itemidx = Arrays.asList(itemname).indexOf(productnames[k]);
					//int itemqty = itemquantity[itemidx];
					//totalbought[k] += itemqty;
					customerpurchasecount[k] += 1;
				} 
			
				
			}
			
		}
		// All input parsed, so close scanner
		scan.close();
		
		for (int f=0; f < productcount; f++) {
			if (customerpurchasecount[f] == 0) {
				System.out.println("No customers bought " + productnames[f]);
			} else {
				System.out.println(customerpurchasecount[f] + " customers bought " + totalbought[f] + " " + productnames[f]);
			}
		}
		
	}

}