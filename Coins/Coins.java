import java.lang.reflect.Field;
import java.util.Scanner;

public class Coins
{
    private int myChange;

    /**
     * @param change input amount of change
     */
    public Coins( int change )
    {
        myChange = change;
    }

    /**
     * calculates list of coins needed to make given amount of change
     */
    public void calculate()
    {
        int quarters;
        int dimes;
        int nickels;
        int pennies;
        quarters = myChange / 25;
        int remainder = myChange % 25;
        dimes = remainder / 10;
        remainder = remainder % 10;
        nickels = remainder / 5;
        remainder = remainder % 5;
        pennies = remainder;
        
        System.out.println( myChange + " cents =>" );
        System.out.println( "Quarter(s)\t" + quarters);
        System.out.println( "Dime(s)\t" + dimes);
        System.out.println( "Nickel(s)\t" + nickels);
        System.out.println( "Penny(s)\t" + pennies);
    }
    
    /**
     * Intended only for debugging.
     * 
     * <p>A generic toString implementation that uses reflection to print
     * names and values of all fields <em>declared in this class</em>.
     * Note that superclass fields are left out of this implementation.</p>
     * 
     * @return a string representation of this Easter.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getType().getName() + " "
                    + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }
            separator = ", ";
        }
        return str + "]";
    }

    /**
     * Tester for the Coins class.
     * @param args command line arguments - not used
     */
    public static void main( String[] args )
    {
        Scanner console = new Scanner( System.in );

        System.out.print( "Please enter the number of cents --> " );
        int cents = console.nextInt();

        Coins change = new Coins( cents );
        change.calculate();
    }
}