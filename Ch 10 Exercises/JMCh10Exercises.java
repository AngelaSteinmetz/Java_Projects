import java.util.*;

public class JMCh10Exercises
{
    Scanner scan;

    /**
     * Constructs a Scanner for input from the console.
     */
    public JMCh10Exercises()
    {
        scan = new Scanner( System.in );
    }

    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str  input for the various methods
     */
    public JMCh10Exercises( String str )
    {
        scan = new Scanner( str );
    }

    // 10-2(a)
    public boolean endsWithStar( String s )
    {
        return !s.isEmpty() && s.charAt(s.length() - 1) == '*'; 
    }

    // 10-2(b)
    public boolean endsWith2Stars( String s )
    {
        return s.length() > 1 && s.charAt(s.length() - 1) == '*' 
                        && s.charAt(s.length() - 2) == '*';
    }

    // 10-6
    public String scroll( String s )
    {
        char first = s.charAt( 0 );
        s = s.substring( 1 ) + first;

        return s; 
    }

    // 10-7
    public String convertName( String name )
    {
        int index = name.indexOf( ',' );
        String answer = name.substring( index + 2 );
        answer += " " + name.substring( 0, index );

        return answer;
    }
    
    // 10-8
    public String negate( String str )
    {
        str = str.replace( '0', 'x' );
        str = str.replace( '1', '0' );
        str = str.replace( 'x', '1' );

        return str; 
    }

    // 10-9
    public boolean isConstant( String s )
    {
        char first = s.charAt( 0 );
        String scroll = s.substring( 1 ) + first;
        
        return scroll.equals( s );
    }

    // 10-10
    public String removeComment( String str )
    {
        if (str.indexOf( "/*" ) == -1 || str.indexOf( "*/" ) == -1)
        {
            return str;
        }
        else
        {
            int startIndex = str.indexOf( "/*" );
            int endIndex = str.indexOf( "*/" );
            String answer = str.substring( 0, startIndex );
            answer += str.substring( endIndex + 2 );
            return answer;
        }
    }

    // 10-11
    public String cutOut( String s, String s2 )
    {
        int index = s.indexOf(s2);
        String answer = s.substring( 0, index );
        answer += s.substring( index + s2.length() );

        return answer;
    }

    // 10-14
    public String removeHtmlTags( String str )
    {
        int startIndex = str.indexOf( '<' );
        int endIndex = str.indexOf( '>' );
        boolean html = true;
        
        for (int i = startIndex + 1; i < endIndex; i++)
        {
            if (!Character.isLetter(str.charAt( i )))
            {
                html = false;
            }
        }
//        System.out.println( "first brackets html = " + html );
        
        int startIndex2 = str.indexOf( '<', endIndex + 1);
        int endIndex2 = str.indexOf( '>', endIndex + 1 );
        
        if (str.charAt( startIndex2 + 1 ) != '/')
        {
            html = false;
//            System.out.println( "/" );
        }
        else
        {
            for (int i = startIndex2 + 2; i < endIndex2; i++)
            {
                if (!Character.isLetter(str.charAt( i )))
                {
                    html = false;
//                    System.out.println( "letter" );
                }
            }
        }

//        System.out.println( "second brackets html = " + html );
//        System.out.println( "start index" + str.charAt( startIndex ) );
//        System.out.println( "end index" + str.charAt( endIndex ) );
//        System.out.println( "start index2" + str.charAt( startIndex2 ) );
//        System.out.println( "end index2" + str.charAt( endIndex2 ) );
        if (html == true)
        {
            String answer = str.substring( 0, startIndex );
            answer += str.substring( endIndex + 1, startIndex2 );
            answer += str.substring( endIndex2 + 1 );
            return answer;
        }
        
        return str;
    }

    // 10-15
    public boolean onlyDigits( String s )
    {
        for (int i = 0; i < s.length(); i++)
        {
            if (!Character.isDigit( s.charAt( i ) ))
            {
                return false;
            }
        }

        return true; // FIX THIS!!!
    }

    // 10-20
    public static boolean isValidISBN( String isbn )
    {
        int answer = 0;
        int coeff = 10;
        
        for (int i = 0; i < isbn.length(); i++)
        {
            int digit;
            if (isbn.charAt( i ) == 'X')
            {
                digit = 10;
            }
            else
            {
                digit = Character.digit( isbn.charAt( i ), 10 );
            }
            answer += digit * coeff;
            coeff--;
//            System.out.println( "coeff: " + coeff );
//            System.out.println("digit: " + digit);
//            System.out.println( "sum: " + answer );
        }

        return answer % 11 == 0;
    }

    // 10-22
    public String shuffle( String s )
    {
        StringBuffer abc = new StringBuffer(s);
        Random r = new Random();
        
        for (int n = s.length() - 1; n > 0; n-- )
        {
            int random = r.nextInt( n );
            char randomC = abc.charAt( random );
            
            abc.setCharAt( random, abc.charAt( n ) );
            abc.setCharAt(n, randomC );
        }

        String answer = abc.toString();
        return answer;
    }

    /**
     * Testing method: instantiates a Ch18Ex1to5 object and then invokes
     * each method.
     * 
     * @param args command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        JMCh10Exercises exercise = new JMCh10Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) 10-2(a) endsWithStar( String s )" );
            System.out.println( "   (2) 10-2(b) endsWith2Stars( String s )" );
            System.out.println( "   (3) 10-6 scroll( String s )" );
            System.out.println( "   (4) 10-7 convertName( String name )" );
            System.out.println( "   (5) 10-8 negate( String str )" );
            System.out.println( "   (6) 10-9 isConstant( String s )" );
            System.out.println( "   (7) 10-10 removeComment( String str )" );
            System.out.println( "   (8) 10-11 cutOut( String s, String s2 )" );
            System.out.println( "   (9) 10-14 removeHtmlTags( String str )" );
            System.out.println( "   (A) 10-15 onlyDigits( String s )" );
            System.out.println( "   (B) 10-20 isValidISBN( String isbn )" );
            System.out.println( "   (C) 10-22 shuffle( String s )" ); 
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        String end1Star = "**endsWith**Star*";
                        System.out.println("endsWithStar(" + end1Star + ") = " +
                            exercise.endsWithStar(end1Star));
                        String ends0Star = "**endsWith**Star*No";
                        System.out.println("endsWithStar(" + ends0Star + ") = " +
                            exercise.endsWithStar(ends0Star));
                        break;
                    case '2':
                        String end2Str = "**endsWith**2Stars**";
                        System.out.println("endsWith2Stars(" + end2Str + ") = " +
                            exercise.endsWith2Stars(end2Str));
                        String endsWith1Star = "**endsWith**2Stars*";
                        System.out.println("endsWith2Stars(" + endsWith1Star + ") = " +
                            exercise.endsWith2Stars(endsWith1Star));
                        break;
                    case '3':
                        String scrollStr = "bdfhjlnprtvxz";
                        System.out.println("scroll(\"" + scrollStr + "\") --> " + 
                            "\"" + exercise.scroll(scrollStr) + "\"");
                        break;
                    case '4':
                        String convStr = "von Neumann, John";
                        System.out.println("convertName(\"" + convStr + "\") --> " +
                            "\"" + exercise.convertName(convStr) + "\"");
                        break;
                    case '5':
                        String negStr = "1001110001010101110";
                        System.out.println("negate(\"" + negStr + "\") --> " +
                            "\"" + exercise.negate(negStr) + "\"");
                        break;
                    case '6':
                        String constStr1 = "0000000000000000000";
                        String constStr2 = "1001110001010101110";
                        System.out.println("isConstant(\"" + constStr1 + "\") = " +
                            exercise.isConstant( constStr1 ) );
                        System.out.println("isConstant(\"" + constStr2 + "\") = " +
                             exercise.isConstant( constStr2 ) );
                        break;
                    case '7':
                        String comment = "/* this should be gone */ int a = 0;";
                        String notComment = "/* this should stay /* int a = 0;";
                        System.out.println("removeComment(\"" + comment + "\") --> " +
                            "\"" + exercise.removeComment( comment ) + "\"");
                        System.out.println("removeComment(\"" + notComment + "\") --> " +
                            "\"" + exercise.removeComment( notComment ) + "\"");
                        break;
                    case '8':
                        String cutstr = "Hi-ho, hi-ho";
                        String cutOutstr = "-ho";
                        System.out.println("cutOut(\"" + cutstr + "\", \"" + cutOutstr + "\") --> " +
                            "\"" + exercise.cutOut( cutstr, cutOutstr ) + "\"");
                        break;
                    case '9':
                        String htmlStr = "Strings are <b>immutable</b>";
                        System.out.println("removeHtmlTags(\"" + htmlStr + "\") --> " +
                            "\"" + exercise.removeHtmlTags(htmlStr) + "\"");
                        break;
                    case 'A':
                    case 'a':
                        String digitStr = "123456789";
                        String dStr = "1234V5678";
                        System.out.println("onlyDigits(\"" + digitStr + "\") = " +
                            exercise.onlyDigits(digitStr) );
                        System.out.println("onlyDigits(\"" + dStr + "\") = " +
                            exercise.onlyDigits(dStr) );
                        break;
                    case 'B':
                    case 'b':
                        String validISBN = "096548534X";
                        String invalidISBN = "1234567890";
                        System.out.println("isValidISBN(\"" + validISBN + "\") = " +
                            exercise.isValidISBN(validISBN) );
                        System.out.println("isValidISBN(\"" + invalidISBN + "\") = " +
                            exercise.isValidISBN(invalidISBN) );
                        break;
                    case 'C':
                    case 'c':
                        String str = "The quick brown fox";
                        System.out.println("shuffle(\"" + str +  "\") --> " +
                            "\"" + exercise.shuffle( str ) + "\"");
                        System.out.println("shuffle(\"" + str +  "\") --> " +
                             "\"" + exercise.shuffle( str ) + "\"");
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}