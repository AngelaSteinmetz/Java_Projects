import java.util.TreeMap;

public class MorseCode
{
    private static final char DOT = '.';
    private static final char DASH = '-';

    private static TreeMap<Character, String> codeMap;
    private static TreeNode<Character> decodeTree;

    public static void start()
    {
        codeMap = new TreeMap<Character, String>();

        // put a space in the root of the decoding tree
        decodeTree = new TreeNode<Character>(' ', null, null);  // autoboxing

        addSymbol('A', ".-");
        addSymbol('B', "-...");
        addSymbol('C', "-.-.");
        addSymbol('D', "-..");
        addSymbol('E', ".");
        addSymbol('F', "..-.");
        addSymbol('G', "--.");
        addSymbol('H', "....");
        addSymbol('I', "..");
        addSymbol('J', ".---");
        addSymbol('K', "-.-");
        addSymbol('L', ".-..");
        addSymbol('M', "--");
        addSymbol('N', "-.");
        addSymbol('O', "---");
        addSymbol('P', ".--.");
        addSymbol('Q', "--.-");
        addSymbol('R', ".-.");
        addSymbol('S', "...");
        addSymbol('T', "-");
        addSymbol('U', "..-");
        addSymbol('V', "...-");
        addSymbol('W', ".--");
        addSymbol('X', "-..-");
        addSymbol('Y', "-.--");
        addSymbol('Z', "--..");
        addSymbol('0', "-----");
        addSymbol('1', ".----");
        addSymbol('2', "..---");
        addSymbol('3', "...--");
        addSymbol('4', "....-");
        addSymbol('5', ".....");
        addSymbol('6', "-....");
        addSymbol('7', "--...");
        addSymbol('8', "---..");
        addSymbol('9', "----.");
        addSymbol('.', ".-.-.-");
        addSymbol(',', "--..--");
        addSymbol('?', "..--..");
    }

    /**
     *  Inserts a letter and its Morse code string into the encoding map
     *  and calls treeInsert to insert them into the decoding tree.
     */
    private static void addSymbol(char letter, String code)
    {
        codeMap.put( letter, code );
        treeInsert(letter, code);
    }
    
    /**
     *  Inserts a letter and its Morse code string into the
     *  decoding tree.  Each dot-dash string corresponds to a path
     *  in the tree from the root to a node: at a "dot" go left, at
     *  a "dash" go right.  The node at the end of the path holds
     *  the symbol for that code string.
     */
    private static void treeInsert(char letter, String code)
    {
        int length = code.length();
        TreeNode<Character> node = decodeTree;
        
        for (int i = 0; i < length - 1; i++)
        {
            char morse = code.charAt( 0 );
            if (morse == '.')
            {
                if (node.getLeft() == null)
                {
                    node.setLeft( new TreeNode<Character>(null) );
                }
                node = node.getLeft();
            }
            else
            {
                if (node.getRight() == null)
                {
                    node.setRight( new TreeNode<Character>(null) );
                }
                node = node.getRight();
            }
            code = code.substring( 1 );
        }
        
        char morse = code.charAt( 0 );
        if (morse == '.')
        {
            if (node.getLeft() == null)
            {
                node.setLeft( new TreeNode<Character>(letter) );
            }
            else
            {
                node.getLeft().setValue( letter );
            }
            
        }
        else
        {
            if (node.getRight() == null)
            {
                node.setRight( new TreeNode<Character>(letter) );
            }
            else
            {
                node.getRight().setValue( letter );
            }
        }
    }

    /**
     *   Converts text into a Morse code message.  Adds a space after
     *   a dot-dash sequence for each letter.  Other spaces in the text
     *   are transferred directly into the encoded message.
     *
     *   @return the encoded message.
     */
    public static String encode(String text)
    {
        StringBuffer morse = new StringBuffer(400);
//        StringBuffer tex = new StringBuffer(text);
//        System.out.println("encode " + text);
        
        while (text.length() > 0)
        {
            char first = text.charAt( 0 );
            if (first == ' ')
            {
                morse.append( ' ' );
                if (text.length() > 1)
                {
                    text = text.substring( 1 );
                }
                else
                {
                    return morse.toString();
                }
                
            }
            else
            {
                if (Character.isLowerCase( first )) //supposed to do this??
                {
                    first = Character.toUpperCase( first );
                }
//                System.out.println("first char: " + first);
                morse.append( codeMap.get( first ) );
                if (text.length()  > 1)
                {
                    morse.append( ' ' );
                }
//                System.out.println("morse: " + morse);
                if (text.length() > 1)
                {
                    text = text.substring( 1 );
//                    System.out.println("what");
                }
                else
                {
                    return morse.toString();
                }
            }
//            System.out.println(text);
//            System.out.println(morse);
        }

        return morse.toString();
    }

    /**
     *   Converts a Morse code message into a text string.  Assumes
     *   that dot-dash sequences for each letter are separated by one
     *   space.  Additional spaces are transferred directly into text.
     *
     *   @return the plain text message.
     */
    public static String decode(String morse)
    {
        StringBuffer text = new StringBuffer(100);
//        System.out.println("decode " + morse);
        
        while (morse.length() > 0)
        {
            char first = morse.charAt( 0 );
            TreeNode<Character> start = decodeTree;
            if (first == ' ')
            {
                text.append( ' ' );
                if (morse.length() > 1)
                {
                    morse = morse.substring( 1 );
                }
                else
                {
                    return text.toString();
                }
            }
            else
            {
//                System.out.println("first: " + first);
                start = decodeTree;
//                System.out.println(start.getLeft().getValue());
                while (first != ' ')
                {
                    if (first == '.')
                    {
//                        System.out.println(start.getLeft().getValue());
                        start = start.getLeft();
                    }
                    else 
                    {
                        start = start.getRight();
                    }
//                    System.out.println(morse);
                    if (morse.length() > 1)
                    {
                        morse = morse.substring( 1 );
                    }
                    else
                    {
                        text.append( start.getValue() );
                        return text.toString();
                    }
                    first = morse.charAt( 0 );
                }
                text.append(start.getValue());
                if (morse.length() > 1)
                {
                    morse = morse.substring( 1 );
                }
                else
                {
                    return text.toString();
                }
            }
        }

        return text.toString();
    }

    //--------------------------------------------------------------------
    // For test purposes only. Not to be used in completing the assignment

    public TreeMap<Character, String> getCodeMap()
    {
        return codeMap;
    }

    public TreeNode<Character> getDecodeTree()
    {
        return decodeTree;
    }
}