import java.util.Arrays;

/**
	Our Cryptogram Solver program is interactive. After opening an encrypted text file,
	the user sees the encrypted text on the left side of the screen and the decoded text on
	the right. Initially, nothing is decoded — the decoded text has only dashes for all the
	letters. The user then enters substitutions for one or several letters, clicks the
	“Refresh” button, and immediately sees an updated version of the decoded text. In
	addition, the program can offer decoding hints based on the frequencies of letters in
	the encrypted text.
	Cryptogram Solver can also create cryptograms. If you enter random substitutions
	for all letters (or click the “Encode” menu item) and then enter your text fragment on
	the left side (by typing it in, loading it from a text file, or cutting and pasting it from
	another program), then the text shown on the right side will be an encrypted version
	of your text.
*/
public class Enigma
{
    private char[] lookupTable;

    public Enigma(int numLetters)
    {
        lookupTable = new char[numLetters];
        for (int i = 0; i < numLetters; i++)
        {
            lookupTable[i] = '-';
        }
    }

    public void setSubstitution(int index, char ch)
    {
        lookupTable[index] = ch;
    }

    public String decode(String text)
    {
        StringBuffer buffer = new StringBuffer(text.length());

        while (text.length() != 0)
        {
            Character ch = text.charAt( 0 );
            if (!Character.isAlphabetic( ch ))
            {
                buffer.append( ch );
            }
            else
            {
                int i = Character.getNumericValue( ch ) - Character.getNumericValue( 'A' );
                if (Character.isUpperCase( ch ))
                {
                    buffer.append( Character.toUpperCase( lookupTable[i] ) );
                }
                else
                {
                    buffer.append( Character.toLowerCase( lookupTable[i] ) );
                }
//                for (int i = 0; i < lookupTable.length; i++)
//                {
//                    String s = Character.toString( lookupTable[i] );
//                    if (s.equalsIgnoreCase( Character.toString(ch ) ))
//                    {
//                        
//                        break;
//                    }
//                }
            }
            if (text.length() != 1)
            {
                text = text.substring( 1 );
            }
            else
            {
                text = "";
            }
        }

        return buffer.toString();
    }

//    Use an algorithm similar to "sorting by counting," described in Chapter 18.  
//    For each element counts[i] in the letter counts array find the number of elements 
//    counts[-] such that counts[-] < counts[i] or counts[-] == counts[i] and - < i.  
//    This number (call it rand) is the rand of the i-th letter of the alphabet in terms 
//    of its frequency in the encrypted text.  So hints[i] should be set to  
//    lettersByFrequency.charAt(rand).

    public String getHints(String text, String lettersByFrequency)
    {
        String answer = "";
        int[] count = countLetters(text);
        char[] result = new char[count.length];
//        for (int i = 0; i < count.length; i++)
//        {
//            System.out.println( i + ": " + count[i]);
//        }
        
//        System.out.println("frequency number");
        for (int i = 0; i < count.length; i++)
        {
            int counts = 0;
            for (int j = 0; j < count.length; j++)
            {
                if (count[j] < count[i] || (count[j] == count[i] && j < i))
                {
                    counts++;
                }
            }
//            System.out.println(i +": " + counts);
            result[i] = lettersByFrequency.charAt( counts );
        }
//        
//        for (int i = 0; i < lettersByFrequency.length(); i++)
//        {
//            int min = findMin(count);
//            String end = answer.substring( min + 1 );
//            answer = answer.substring( 0, min );
//            answer += lettersByFrequency.substring(i, i + 1);
//            answer += end;
//            count[min] = -1;
//        }
        
        for (int k = 0; k < result.length; k++)
        {
            answer += result[k];
        }
        return answer;
    }
    
//    private int findMin(int[] count)
//    {
//        int min = 0;
//        for (int i = 1; i < count.length; i++)
//        {
//            if (count[i] != -1)
//            {
//                if (count[i] < count[min])
//                {
//                    min = i;
//                }
//            }
//        }
//        
//        return min;
//    }


    private int[] countLetters(String text)
    {
        int[] counts = new int[lookupTable.length];

        for (int i = 0; i < text.length(); i++)
        {
            Character ch = text.charAt( i );
            if (Character.isAlphabetic( ch ))
            {
                ch = Character.toUpperCase( ch );
                counts[Character.getNumericValue( ch ) - Character.getNumericValue( 'A' )]++;
            }
        }


        return counts;
    }

    //*************************************************************
    // For test purposes only
    // not to be used in solution implementation

    public char[] getLookupTable()
    {
        return lookupTable;
    }

    public int[] getCountLetters(String text)
    {
        return countLetters(text);
    }

}