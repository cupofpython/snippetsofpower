// Samantha Morris
// Binarize, written in Java
// 2016 "Practice" Local Programming Contest Problem #1


import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class binarize {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File(args[0]));
		int n = in.nextInt();
		
		Integer[] pows = new Integer[32];
		
		// Generate array of all powers of 2. 
		for(int i = 0; i < 31; i++)
		{
			pows[i] = (int)Math.pow(2,i);  
		}
		
		for(int i = 0; i < n; i++) {
			int dec = in.nextInt();
			
			System.out.println("Input value: " + dec);
			
			// If input is a power of 2, print it. Otherwise, access power of 2 > input. 
			if(Arrays.asList(pows).contains(dec)) {
				System.out.println(dec + "\n"); 
			}	
			else {
				pows[31] = dec;
				Arrays.sort(pows); 
				int idx = Arrays.binarySearch(pows, dec);
			
				System.out.println(pows[idx+1] + "\n");
			}
		}
	}
}