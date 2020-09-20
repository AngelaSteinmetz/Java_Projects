public class LipogramAnalyzer
{
    private String text;

    /**
       Constructor: Saves the text string
       @param text String to analyze
     */
    public LipogramAnalyzer(String t)
    {
        text = t;
    }

    /**
       Returns the text string with all characters equal to letter 
       replaced with '#'.

       @param letter character to replace
       @return text string with all characters equal to letter 
                    replaced with '#'
     */
    public String mark(char letter)
    {
        text = text.replace( letter, '#' );

        return text;
    }


    /**
       Returns a String that concatenates all "offending"
       words from text that contain letter; the words are
       separated by '\n' characters; the returned string
       does not contain duplicate words: each word occurs
       only once; there are no punctuation or whitespace
       characters in the returned string.
  
       @param letter character to find in text
       @return String containing all words with letter
     */
    public String allWordsWith(char letter)
    {
        String result = "";

        int eIndex = -1; 
        String originalText = text.replace( '#', letter );
        
        while (eIndex < originalText.length() - 1)
        {
            eIndex = originalText.indexOf( letter, eIndex + 1 );
            if (eIndex == -1)
            {
                break;
            }
            
            System.out.println( "String length: " + originalText.length());
            System.out.println( "eIndex = " + eIndex);
            
            int index = eIndex;
            char findWord;
//            if (index == text.length())
//            {
//                index = text.length() - 1;
//            }
//            else
//            {
                findWord = originalText.charAt( eIndex );
                while (Character.isLetterOrDigit( findWord ))
                {
                    index++;
                    if (index == originalText.length())
                    {
                        break;
                    }
                    findWord = originalText.charAt( index );
//                    System.out.println("index = " + index);
                }
//            }
            int endIndex = index--;
            if (endIndex > originalText.length() - 1)
            {
                endIndex = originalText.length();
            }
            System.out.println( "endIndex = " + endIndex);
            
            index = eIndex;
//            if (index == -1)
//            {
//                index++;
//            }
//            else
//            {
                findWord = originalText.charAt( index );
                while (Character.isLetterOrDigit( findWord ))
                {
                    index--;
                    if (index < 0)
                    {
                        break;
                    }
                    findWord = originalText.charAt( index );
//                    System.out.println("index = " + index);
                }
//            }
            int startIndex = index++;
            if (startIndex == - 1)
            {
                startIndex = 0;
            }
            System.out.println( "startIndex = " + startIndex);
            System.out.println();
            
            if (startIndex > -1)
            {
                String eWord;
//                if (startIndex == originalText.length() - 1)
//                {
//                    eWord = "" + originalText.charAt( originalText.length() - 1 );
//                }
                if (endIndex > originalText.length() - 2)
                {
                    eWord = originalText.substring(startIndex);
                }
                else
                {
                    eWord = originalText.substring( startIndex, endIndex++);
                }
                index = 0;
//                eWord = eWord.replace( '#', letter );
                eWord = eWord.trim();

                if (eWord.charAt( 0 ) == ',')
                {
                    eWord = eWord.substring( 1 );
                }
                
                System.out.println( "worked!!" + eWord + "?");
                if (result.indexOf( eWord ) == -1 || eWord.equals( "e" ))
                {
                    result += eWord + "\n"; 
                    
                }
            }
        }
        
        return result;
    }

	// made public for test purposes
    /*
       Returns the word that contains character at pos
       excluding any punctuation or whitespace.
  
       @param pos location of character
       @return word that contains character at pos
     */
    public String extractWord(int pos)
    {
        int index = pos;
        char findWord;
//        if (index == text.length())
//        {
//            index = text.length() - 1;
//        }
//        else
//        {
            findWord = text.charAt( pos );
            while (Character.isLetterOrDigit( findWord ))
            {
                index++;
                if (index == text.length())
                {
                    break;
                }
                findWord = text.charAt( index );
//                System.out.println("index = " + index);
            }
//        }
        int endIndex = index--;
//        System.out.println( "endIndex = " + endIndex);
        
        index = pos;
//        if (index == -1)
//        {
//            index++;
//        }
//        else
//        {
            findWord = text.charAt( index );
            while (Character.isLetterOrDigit( findWord ))
            {
                index--;
                if (index < 0)
                {
                    break;
                }
                findWord = text.charAt( index );
//                System.out.println("index = " + index);
            }
//        }
        int startIndex = index++;
        if (startIndex == - 1)
        {
            startIndex = 0;
        }
//        System.out.println( "startIndex = " + startIndex);
//        System.out.println();
        
            String eWord = text.substring( startIndex, endIndex++);


        return eWord.trim();
    }
}
