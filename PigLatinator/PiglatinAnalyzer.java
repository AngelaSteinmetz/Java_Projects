import java.util.Scanner;

public class PiglatinAnalyzer
{
    private String text;

    // Constructor: saves the text string
    /**
     * @param t string to analyze
     */
    public PiglatinAnalyzer(String t)
    {
        text = t;
    }

    /**
     * Converts a string to it piglatin form according to the following rules:
     *   a. If there are no vowels in englishWord, then pigLatinWord is just
     *      englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o',
     *      and 'u', and their uppercase counterparts.)
     *   b. Else, if englishWord begins with a vowel, then pigLatinWord is just
     *      englishWord + "yay".
     *   c. Otherwise (if englishWord has a vowel in it and yet doesn't start
     *      with a vowel), then pigLatinWord is end + start + "ay", where end
     *      and start are defined as follows:
     *        1. Let start be all of englishWord up to (but not including) its
     *           first vowel.
     *        2. Let end be all of englishWord from its first vowel on.
     *        3. But, if englishWord is capitalized, then capitalize end and
     *           "uncapitalize" start.
     *
     * @return   piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;
        String translation = "";
        
        while (phraseToTranslate.length() > 0)
        {
            if (!Character.isLetter(phraseToTranslate.charAt( 0 )))
            {
                translation += phraseToTranslate.charAt( 0 );           
                phraseToTranslate = phraseToTranslate.substring( 1 );
            }
            else
            {
                translation += wordToPigLatin(findWord(0, phraseToTranslate));
                int lastIndex = 0;
                while (Character.isLetter( phraseToTranslate.charAt( lastIndex ) ))
                {
                    lastIndex++;
                    if (lastIndex == phraseToTranslate.length())
                    {
                        break;
                    }
                }
                phraseToTranslate = phraseToTranslate.substring(lastIndex);
                System.out.println(phraseToTranslate + "last index: " + lastIndex);
            }       
        }

        System.out.println(translation);
        return translation;
    }

    /**
     *  Converts an "english" word to its piglatin form
     *
     * @param  englishWord  a string representing an english word
     * @return              piglatin form of the english word
     */
    public String wordToPigLatin(String englishWord)
    {
        String pigLatinWord = "";

        int vowel = containsVowels(englishWord);
        if (vowel == -1)
        {
            pigLatinWord += englishWord + "ay";
        }
        else if (vowel == 0)
        {
            pigLatinWord += englishWord + "yay";
        }
        else
        {
            char firstLetter = englishWord.charAt( 0 );
            if (Character.isUpperCase(firstLetter))
            {
                firstLetter = Character.toLowerCase(firstLetter);
                englishWord = "" + firstLetter + englishWord.substring( 1 );
                String end = englishWord.substring( vowel );
                String start = englishWord.substring( 0, vowel );
                pigLatinWord = end + start + "ay";
                firstLetter = Character.toUpperCase( pigLatinWord.charAt( 0 ) );
                pigLatinWord = "" + firstLetter + pigLatinWord.substring( 1 );
//                firstLetter = end.charAt( 0 );
//                englishWord = "" + firstLetter + end.substring( 1 );
            }
            else
            {
                String end = englishWord.substring( vowel );
                String start = englishWord.substring( 0, vowel );
                pigLatinWord += end + start + "ay";
            }
        }        
        System.out.println("word to pig latin: " + pigLatinWord);
        return pigLatinWord;
    }

    /**
     * returns the index of the vowel, if there is no vowel, returns -1
     * @param word the word to find a vowel in
     * @return index of vowel or -1
     */
    public int containsVowels(String word)
    {
        int index = -1;
        for (int i = 0; i < word.length(); i++)
        {
            char letter = word.charAt( i );
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o'
                            || letter == 'u' || letter == 'A' || letter == 'E' 
                            ||  letter == 'I' || letter == 'O' || letter == 'U')
            {
                index = i;
                break;
            }
        }

        return index;
    }
    
    /**
     * starting from a given position in the given string, 
     * returns the first word
     * @param pos position to start from
     * @param t string to find the word in
     * @return returns the first full word
     */
    public String findWord(int pos, String t)
    {
        int endpos = pos;
        String result = "";
        if (t.length() == 0)
        {
            return result;
        }
        while (Character.isLetter( t.charAt( endpos ) ))
        {
            endpos++;
            if (endpos == t.length())
            {
                break;
            }
        }
        
        result = t.substring( pos, endpos );
        System.out.println(result);
        return result;
    }
}