public class DieTest
{
    /**
     * main method of DieTest
     * @param args args
     */
    public static void main(String[] args)
    {
        Die die = new Die();
        die.roll();
        System.out.println( die.getNumDots() );
        die.roll();
        System.out.println( die.getNumDots() );
        die.roll();
        System.out.println( die.getNumDots() );
        die.roll();
        System.out.println( die.getNumDots() );
    }
}