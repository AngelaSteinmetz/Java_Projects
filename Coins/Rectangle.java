import java.awt.Color;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Rectangle
{
    private int myChange;
    private int width;
    private int height;
    private static String message = "Hello, World";

    /**
     * @param change input amount of change
     */
    public Rectangle( int w, int h )
    {
        if (w >= 0 && h >= 0)
        {
            width = w;
            height = h;
        }
    }
    
    public Rectangle( int side )
    {
        if (side >= 0)
        {
            width = side;
            height = side;
        }
    }
    
    public Rectangle()
    {
        width = 1;
        height = 1;
    }

    public boolean isSquare ()
    {
        return width == height;          
    }
    
    public void quadratize ()
    {
        int area = width * height;
        int side = (int)(Math.sqrt( area ) + 0.5);
        height = side;
        width = side;
    }
    
    public static void hello()
    {
      System.out.println(message);
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
    
    public int mysterySum(int n)
    {
        if (n <= 0)
            return 2;
          else
            return mysterySum(n-1) * mysterySum(n-1);

    }



    /**
     * Tester for the Coins class.
     * @param args command line arguments - not used
     */
    public static void main( String[] args )
    {
//        Scanner console = new Scanner( System.in );
//
//        System.out.print( "Please enter the first number --> " );
//        int number = console.nextInt();
//
//        
        
        hello();
        
        Rectangle square = new Rectangle( 4 );
        if (square.isSquare())
        {
            System.out.println( "square" );
        }
        else
        {
            System.out.println( "notSquare" );
        }
        
        Rectangle unitSquare = new Rectangle( );
        if (unitSquare.isSquare())
        {
            System.out.println( "square" );
        }
        else
        {
            System.out.println( "notSquare" );
        }
        
        Rectangle notSquare = new Rectangle( 4, 8 );
        if (notSquare.isSquare())
        {
            System.out.println( "square" );
        }
        else
        {
            System.out.println( "notSquare" );
        }
 
        notSquare.quadratize();
        System.out.println( notSquare.width + " " + notSquare.height);
    }
}