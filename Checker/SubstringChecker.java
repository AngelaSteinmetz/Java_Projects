public class SubstringChecker implements Checker
{
    private String sub;

    /**
     * @param s substring to check for in given strings
     */
    public SubstringChecker(String s)
    {
        sub = s;
    }

    /**
     * checks if given string contains substring
     * @param text given string
     * @return whether given string contains the substring
     */
    public boolean accept(String text)
    {
        return text.indexOf( sub ) != -1;
    }
}