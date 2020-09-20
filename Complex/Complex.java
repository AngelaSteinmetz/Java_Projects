public class Complex
{
    private double a;
    private double b;
    
    public Complex (double aa)
    {
        a = aa;
        b = 0;
    }
    
    public Complex (double aa, double bb)
    {
        a = aa;
        b = bb;
    }
    
    public double abs ()
    {
        double answer = Math.sqrt( a * a + b * b );
        return answer;
    }
    
    public Complex add(Complex other)
    {
        return new Complex (a + other.a, b + other.b);
    }
    
    public Complex add(double d)
    {
        return new Complex(a + d, b);
    }
    
    public Complex multiply(Complex other)
    {
        double newA = a * other.a - b * other.b;
        double newB = b * other.a + a * other.b;
        return new Complex(newA, newB );
    }
    
    public Complex multiply(double d)
    {
        return new Complex (d * a, d * b);
    }

    public String toString()
    {
        String sign = " + ";
        if (b < 0)
        {
            sign = " ";
        }
        return a + sign + b + "i";
    }
}