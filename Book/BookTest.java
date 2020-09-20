public class BookTest
{
    /**
     * The main method in this class checks the Book operations for
     * consistency.
     * @param args is not used.
     */
    public static void main( String[] args )
    {
        Book book = new Book(3);
        System.out.println( book.getNumPages() );
        System.out.println( book.getCurrentPage() );
        for (int x = 0; x < 3; x++)
        {
            book.nextPage();
            System.out.println( book.getCurrentPage() );
        }
    }
}