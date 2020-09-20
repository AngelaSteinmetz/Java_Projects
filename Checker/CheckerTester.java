public class CheckerTester
{
    /**
     * Test checker objects.
     * @param args command line arguments (not used)
     */
    public static void main( String[] args )
    {
        Checker aChecker = new SubstringChecker( "artichokes" );
        Checker kChecker = new SubstringChecker( "kale" );
        Checker yumChecker;

        /*** Part (d) ***/

        Checker not1 = new NotChecker(aChecker);
        Checker not2 = new NotChecker(kChecker);
        yumChecker = new AndChecker(not1, not2);

        /****************/

        System.out.println( yumChecker.accept( "chocolate truffles" ) );
        System.out.println( yumChecker.accept( "kale is great" ) );
        System.out.println( yumChecker.accept( "Yuck: artichokes & kale" ) );
    }
}