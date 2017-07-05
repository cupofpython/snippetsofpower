// Samantha Morris
// Texting Problem, written in Java
// 2011 Local Programming Contest Problem

/* Helpful tips:
~~~  Remember to cast when getting your values! ~~~
Wrong: String outWord = words.get(key)
Right: String outWord = (String)words.get(key)
We don't know it's a string ya dumb dumb.

~~~ Remember to flush between lines! :) ~~~
in.nextLine(); after ints

~~~ Insight #1: Convert the dictionary before the messages. ~~~
Why? Because if we convert the message first, we don't know how many dictionary words
it will map to. But if we convert the dictionary words first, and slap them in an ArrayList,
we know how many dictionary words have REPEATS, and if we come across a message that is
in the dictionary, we know how many dict words have the same digital representation.
** We know if a message is in the dictionary by just using the contains() method.
** We know how many occurrences a digiword has in a dictionary by using Collections.frequency()

~~~ Insight #2: Create a HashMap for the letters of the alphabet (keys) and the Texting
representation (values). This provides easy lookup for each char we read in our dictionary
words, and easy conversion from dictionary word to digital word.

~~~ Use the product rule to get the number of combinations. ~~~
Because COT 3100.

  Techniques: HashMaps, casting, ArrayLists, flags, tomfoolery

  Runtime: O(n^2) :( (but I mean it's all we've got here)

*/

import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class T9
{
  // It's 3AM so I'm just going to suppress these warnings for now. 
  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception
  {
    // HashMap.
    HashMap hm = new HashMap();
    HashMap words = new HashMap();
    hm.put('a',2);
    hm.put('b',2);
    hm.put('c',2);
    hm.put('d',3);
    hm.put('e',3);
    hm.put('f',3);
    hm.put('g',4);
    hm.put('h',4);
    hm.put('i',4);
    hm.put('j',5);
    hm.put('k',5);
    hm.put('l',5);
    hm.put('m',6);
    hm.put('n',6);
    hm.put('o',6);
    hm.put('p',7);
    hm.put('q',7);
    hm.put('r',7);
    hm.put('s',7);
    hm.put('t',8);
    hm.put('u',8);
    hm.put('v',8);
    hm.put('w',9);
    hm.put('x',9);
    hm.put('y',9);
    hm.put('z',9);

    Scanner in = new Scanner(new File(args[0]));
    int dictNum = in.nextInt();
    in.nextLine();
    // Read in the dictionary to an array.
    ArrayList<String> dict = new ArrayList<String>();
    for(int i = 0; i < dictNum; i++)
    {
      String dictWord = in.nextLine();
      // Translate word.
      String digiWord = "";
      for(int j = 0; j < dictWord.length(); j++)
      {
        char letter = dictWord.charAt(j);
        Integer num = (Integer)hm.get(letter);
        int digit = (int)num;
        digiWord += digit;
      }
      // Add digit representation of dictionary word to dictionary ArrayList.
      dict.add(digiWord);

      // Map the dictionary word to the digital word for lookup later.
      words.put(digiWord,dictWord);
    }

    int textNum = in.nextInt();
    in.nextLine();

    // For each text message, i.e. 12 345 6789
    for(int j = 0; j < textNum; j++)
    {
      String line = in.nextLine();
      // Get the digit words split into an array, i.e. [12, 345, 6789]
      String text[] = line.split(" ");

      // Frequency array for the digit representation of the words in each text message.
      int freq[] = new int[text.length];

      // freqFlag remains true if the freq of each word is 1.
      boolean freqFlag = true;

      // invalidFlag is true if message is invalid.
      boolean invalidFlag = false;

      for(int x = 0; x < text.length; x++)
      {
        String word = text[x];
        // If the word is not even in the dictionary, throw an error message.
        if(!dict.contains(word))
        {
          System.out.println("Message #" + (j+1) + ": not a valid text");
          invalidFlag = true;
          break;
        }
        // Log the frequency of the word.
        int wordFreq = Collections.frequency(dict, word);
        freq[x] = wordFreq;
        if(wordFreq > 1)
          freqFlag = false;

      }

      // Only one message possible.
      if(freqFlag == true && invalidFlag == false)
      {
        System.out.print("Message #" + (j+1) + " ");

        // Print dictionary word corresponding to digital representation of word.
        for(int u = 0; u < text.length; u++)
        {
          // Get the dictionary word mapped to text message word:
          String key = text[u];
          String outWord = (String)words.get(key);

          System.out.print(outWord + " ");
        }
        System.out.println();
      }

      // There are multiple messages.
      if(freqFlag == false && invalidFlag == false)
      {
        // Calculate the number of message possibilities (product rule).
        int possibilities = 1;
        for(int y = 0; y < freq.length; y++)
        {
          possibilities*=freq[y];
        }
        System.out.println("Message #" + (j+1) +": there are " + possibilities + " possible messages");
      }

    }
    in.close();

  }
}
