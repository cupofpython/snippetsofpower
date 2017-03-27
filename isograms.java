// Samantha Morris
// Pair Isogram Problem, written in Java
// 2011 Local Programming Contest Problem


import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class isograms
{
  static int ALPHABET_SIZE = 26;
  public static void main(String[] args) throws Exception
  {
    Scanner in = new Scanner(new File(args[0]));
    int wordCnt = in.nextInt();
    in.nextLine();

    for(int i = 0; i < wordCnt; i++)
    {
      int freqArr[] = new int[ALPHABET_SIZE];
      String word = in.nextLine();
      for(int j = 0; j < word.length(); j++)
      {
        int letter = word.charAt(j)-97;
        freqArr[letter]++;
      }

      // Create flag. True if the two are pair isograms.
      boolean pairIso = true;

      // Iterate through frequency array.
      for(int x = 0; x < ALPHABET_SIZE; x++)
      {
        // Letter usage must be exactly 2 or 0 (unused).
        if(freqArr[x] != 2 && freqArr[x] != 0)
        {
          // If not pair isogram, print result.
          System.out.println(word + " --- not pair isograms");

          // Set flag to false and break from loop.
          pairIso = false;
          break;
        }
      }
        // If pair isogram, print result.
        if(pairIso == true)
        {
          System.out.println(word + " --- pair isograms");

        }
    }
  }

}
