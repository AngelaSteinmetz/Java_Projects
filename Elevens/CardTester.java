public class CardTester
{
	/**
	 * The main method in this class checks the Card operations for
	 * consistency.
	 * @param args is not used.
	 */
    public static void main( String[] args )
    {
        Card aceClubs1 = new Card("ace", "clubs", 1);
        Card aceClubs12 = new Card("ace", "clubs", 1);
        Card sixHearts6 = new Card("6", "hearts", 6);
        
        System.out.println("**** ace of clubs #1 Tests ****");
        System.out.println("  rank: " + aceClubs1.rank());
        System.out.println("  suit: " + aceClubs1.suit());
        System.out.println("  pointValue: " + aceClubs1.pointValue());
        System.out.println("  toString: " + aceClubs1.toString());
        System.out.println();
        
        System.out.println("**** ace of clubs #2 Tests ****");
        System.out.println("  rank: " + aceClubs12.rank());
        System.out.println("  suit: " + aceClubs12.suit());
        System.out.println("  pointValue: " + aceClubs12.pointValue());
        System.out.println("  toString: " + aceClubs12.toString());
        System.out.println();
        
        System.out.println("**** six of hearts Tests ****");
        System.out.println("  rank: " + sixHearts6.rank());
        System.out.println("  suit: " + sixHearts6.suit());
        System.out.println("  pointValue: " + sixHearts6.pointValue());
        System.out.println("  toString: " + sixHearts6.toString());
        System.out.println();
        
        System.out.println("**** matches Tests ****");
        if (aceClubs1.matches( aceClubs12 ))
        {
            System.out.println("matching: true");
        }
        else
        {
            System.out.println("matching: false");
        }
        
        if (aceClubs12.matches( sixHearts6 ))
        {
            System.out.println("matching: true");
        }
        else
        {
            System.out.println("not matching: false");
        }
    }
}
/*
**** ace of clubs #1 Tests ****
rank: ace
suit: clubs
pointValue: 1
toString: ace of clubs (point value = 1)

**** ace of clubs #2 Tests ****
rank: ace
suit: clubs
pointValue: 1
toString: ace of clubs (point value = 1)

**** six of hearts Tests ****
rank: 6
suit: hearts
pointValue: 6
toString: 6 of hearts (point value = 6)

**** matches Tests ****
matching: true
not matching: false
*/