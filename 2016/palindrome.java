// Samantha Morris
// Phenome Palindrome, written in Java
// 2016 Local Programming Contest Problem #2

/* Helpful tips:

~~~ Insight #1: Make use of built-in methods such as str.replace() and StringBuilder(str).reverse().toString(); ~~~

~~~ Tools: ArrayLists, replace method ~~~

*/

import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class palindrome {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File(args[0])); 
		
		// Number of test cases. 
		int testCases = in.nextInt();
		for(int t = 0; t < testCases; t++) {
			System.out.println("Test case #" + (t+1)); 
			
			int p = in.nextInt(); 
			in.nextLine(); 
			
			// Add pairs to the ArrayList. 
			List<String> pairs = new ArrayList<String>(); 
			for(int pair = 0; pair < p; pair++) {
				pairs.add(in.next()); 
				pairs.add(in.next());
			}
			
			// q = number of words 
			int q = in.nextInt(); 
			in.nextLine(); 
			
			for(int i = 0; i < q; i++) {
				String str = in.nextLine(); 
				String original = str; 
				System.out.print(original);
				
				// Iterate through pairs and replace the first pair letter with the second. Modify string. 
				for(int j = 0; j < p*2; j+=2) {
					str = str.replace(pairs.get(j).charAt(0),pairs.get(j+1).charAt(0));
				}
				
				// Reverse modified string. 
				String revString = new StringBuilder(str).reverse().toString();
				
				// Check if the modified string is a palindrome. 
				if(str.equals(revString))
					System.out.print(" YES\n"); 
				else
					System.out.print(" NO\n"); 
				
			}
		}
		
	}
}