public class NotChecker implements Checker
{
    /**
     * substring to check for
     */
    Checker first;
    
    /**
     * @param a substring to check for
     */
    public NotChecker(Checker a)
    {
        first = a;
    }

    /**
     * checks if string does not contain substring
     * @param text given string
     * @return returns true if string does not contain substring
     */
    public boolean accept(String text)
    {
        return !(first.accept( text ));
    }
}