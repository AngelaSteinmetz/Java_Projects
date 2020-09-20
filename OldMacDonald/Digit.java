public class Digit
{
    private int base;
    private int value;
    
    public Digit()
    {
        base = 10;
        value = 0;
    }
    
    public Digit(int v, int b)
    {
        if (v >= b)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            value = v;
            base = b;
        }
    }
    
    public boolean increment()
    {
        if (value + 1 >= base)
        {
            value = 0;
            return true;
        }
        else
        {
            value++;
            return false;
        }
    }
    
    public String toString()
    {
        if (value < 10)
        {
            return "" + value;
        }
        if (value == 10)
        {
            return "A";
        }
        if (value == 11)
        {
            return "B";
        }
        if (value == 12)
        {
            return "C";
        }
        if (value == 13)
        {
            return "D";
        }
        if (value == 14)
        {
            return "E";
        }
        return "F";
        
    }
}