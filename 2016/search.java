// Samantha Morris
// Word Search, written in Java
// 2016 Local Programming Contest Problem #5

/* Helpful tips:
~~~ Copy your input correctly... i.e. don't put extra spaces. For obvious reasons. ~~~

~~~ Insight #1: Our words could be up to 100 characters long. Thus, each row and column had to repeat so it contained up to 100 chars. 
This takes care of wrapround cases. 

~~~ Sometimes a simple .equals is all you need to make a comparison. Don't overcomplicate task with multiple steps. ~~~

*/

import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class search
{
	public static void main(String[] args) throws Exception
	{
		Scanner in = new Scanner(new File(args[0]));
		int numPuzzles = in.nextInt(); 
		for(int i = 0; i < numPuzzles; i++)
		{
			System.out.println("Word search puzzle #" + (i+1) + ":");
			
			int r = in.nextInt(); 
			int c = in.nextInt();
			in.nextLine(); 
			List<String> cols = new ArrayList<String>();  
			List<String> rows = new ArrayList<String>();  
			
			// Initialize cols arraylist. 
			for(int y = 0; y < c; y++)
			{
				cols.add(""); 
			}
			
			// Initialize rows arraylist. 
			for(int w = 0; w < c; w++)
			{
				rows.add(""); 
			}
			
			for(int v = 0; v < r; v++)
			{
				String row = in.nextLine(); 
				String longRow = "";
				
				// Repeat rows until 100 characters are reached. 
				while(longRow.length()< 100)
				{
					longRow+=row; 
				}
				
				rows.set(v, longRow);  
				
				
				for(int j = 0; j < c; j++)
				{
					// Get the col entry in the arraylist. 
					String col = cols.get(j);
					
					// Append the char to the col entry. 
					col+=row.charAt(j);
					
					// Reset the col entry so it can be modified later. 
					cols.set(j, col); 
				}
			}
			for(int s = 0; s < c; s++)
			{
				String col = cols.get(s); 
				String longCol = "";
				
				// Repeat cols until 100 characters are reached. 
				while(longCol.length() < 100)
				{
					longCol+=col; 
				}
				
				cols.set(s, longCol);
			}
			
			// Get reverses. 
			List<String> reverseRows = reverseList(rows);
			List<String> reverseCols = reverseList(cols); 
			
			
			// WORDSEARCH BEGINS. 
			int wordCount = in.nextInt(); 
			in.nextLine(); 
			
			String[] words = new String[wordCount]; 
			
			// Add each word to the words array. 
			for(int x = 0; x < wordCount; x++)
			{
				// Get the word. 
				String word = in.nextLine(); 
				
				// Iterate through the rows. 
				// Keep track if the word wraps
				// Keep track of number of times a word could occur 
				for(int p = 0; p < r; p++)
				{
					String row = rows.get(p); 
					String revRow = reverseRows.get(p); 
					
					// Find in row, forward. 
					String[] foundinColR = row.split(word); 
					
					// Find in row, reverse. 
					String[] foundinColL = revRow.split(word); 
					
					int cFound; 
					if(foundinColR.length > 1)
					{
						cFound = (foundinColR[0].length()+1)%c;
						if(cFound == 0)
							cFound++; 
						System.out.println("R " + (p+1) + " " + cFound + " " + word); 
					}
					else if(foundinColL.length > 1)
					{
						cFound = (c - foundinColL[0].length())%c;
						System.out.println("L " + (p+1) + " " + cFound + " " + word); 
					}
					
					// The row is the word. 
					else if(row.substring(0,word.length()).equals(word))
					{
						System.out.println("R " + (p+1) + " " + 1 + " " + word); 
					}
					
					// The reversed row is the word. 
					else if(revRow.substring(0,word.length()).equals(word))
					{
						System.out.println("L " + (p+1) + " " + c + " " + word); 
					}
					
				}
				for(int u = 0; u < c; u++)
				{
					String col = cols.get(u); 
					String revCol = reverseCols.get(u); 
					
					// Find in col, forward. 
					String[] foundinRowD = col.split(word); 
					
					// Find in col, reverse. 
					String[] foundinRowU = revCol.split(word); 
					
					int rFound; 
					if(foundinRowD.length > 1)
					{
						rFound = (foundinRowD[0].length()+1)%r; 
						System.out.println("D " + rFound + " " + (u+1) + " " + word); 
					}
					else if(foundinRowU.length > 1)
					{ 
						rFound = (r - foundinRowU[0].length())%r;
						
						// If word starts from bottom. 
						if(rFound == 0)
							rFound = r; 
						System.out.println("U " + rFound + " " + (u+1) + " " + word); 
					}
					
					// The column is the word. 
					else if(col.substring(0,word.length()).equals(word))
					{
						System.out.println("D " + 1 + " " + (u+1) + " " + word); 
					}
					
					// The reversed column is the word. 
					else if(revCol.substring(0,word.length()).equals(word))
					{
						System.out.println("U " + r + " " + (u+1) + " " + word); 
					}
				}
			}
			System.out.println(); 
			
		}
		
		
	}
	
	// Take an array list and reverse each String element. 
	public static List<String> reverseList(List<String> list)
	{
		List<String> reversed = new ArrayList<String>(); 
		for(int i = 0; i < list.size(); i++)
		{
			String revElement = new StringBuilder(list.get(i)).reverse().toString();
			reversed.add(revElement); 
		}
		
		return reversed; 
	}
}