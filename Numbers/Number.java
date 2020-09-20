import java.util.*;


public class Number
{
    private int base;
    private List<Digit> value;
    
    public Number()
    {
        base = 10;
        value = new ArrayList<Digit>();
        value.add( 0, new Digit() );
    }
    
    public Number(int v, int b)
    {
//        System.out.println("value: " + v + " base: " + b);
        base = b;
        value = new ArrayList<Digit>();
//        String s = Integer.toString( Integer.parseInt(String.valueOf( v ), 10), b );
        String s = Integer.toString( v, b );
//        System.out.println(s);
        for (int i = s.length() - 1; i >= 0; i--)
        {
            String d = "" + s.charAt( i );
            int w;
            if (d.equalsIgnoreCase( "A" ))
            {
                w = 10;
            }
            else if (d.equalsIgnoreCase( "B" ))
            {
                w = 11;
            }
            else if (d.equalsIgnoreCase( "C" ))
            {
                w = 12;
            }
            else if (d.equalsIgnoreCase( "D" ))
            {
                w = 13;
            }
            else if (d.equalsIgnoreCase( "E" ))
            {
                w = 14;
            }
            else if (d.equalsIgnoreCase( "F" ))
            {
                w = 15;
            }
            else
            {
                w = Integer.parseInt( d );
            }
            value.add( new Digit(w, b));
        }
    }
    
    public void increment()
    {
        boolean cont = true;
        int num = 0;
        
        while (cont)
        {
           if (value.size() <= num || value.get( num ) == null)
           {
               value.add( num, new Digit(1, base));
               cont = false;
           }
           else
           {
               cont = value.get( num ).increment();
           }
           num++;
        }
    }
    
    public String toString()
    {
        String result = "";
        for (int i = value.size() - 1; i >= 0; i--)
        {
            result += value.get( i );
        }
        return result;
    }
}
