public class AndChecker implements Checker
{
    /**
     * first substring to check for
     */
    Checker first;
    
    /**
     * second substring to check for
     */
    Checker second;
    
    /**
     * @param a first Checker object
     * @param b second Checker object
     */
    public AndChecker(Checker a, Checker b)
    {
        first = a;
        second = b;
    }
    
    /**
     * checks if given string contains both substrings
     * @param text given string
     * @return if string contains  both substrings
     */
    public boolean accept(String text)
    {
        return first.accept( text ) && second.accept( text );
    }
}