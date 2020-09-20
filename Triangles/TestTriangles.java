public class TestTriangles
{
    /**
        Test method for the Triangle class
    
        @param args command line arguments - not used
     */
    public static void main(String[] args)
    {
        double side = 10.0;
        AbstractTriangle equilateral = new EquilateralTriangle( side );
        AbstractTriangle right = new RightTriangle( side );

        double equilateralRatio = equilateral.getRatio();
        double rightRatio = right.getRatio();

        System.out.println( "EquilateralTriangle( " +
            equilateral.getSide() + " ): " +
            "getRatio() = " + equilateralRatio );

        System.out.println( "RightTriangle( " +
            right.getSide() + " ): "
            + "getRatio() = " + rightRatio );

        String bigger = "right isosceles";
        String smaller = "equilateral";

        double eArea = equilateral.getArea();
        double rArea = right.getArea();
        double ePerimeter = equilateral.getPerimeter();
        double rPerimeter = right.getPerimeter();
        
        double eRadius = eArea * 2 / ePerimeter;
        double rRadius = rArea * 2 / rPerimeter;
        
        if (eRadius > rRadius)
        {
            smaller = "right isosceles";
            bigger = "equilateral";
        }

        System.out.println();
        System.out.print( "The " + bigger + " triangle " );
        System.out.println( "holds a larger inscribed circle " );
        System.out.println( "than the " + smaller + " triangle." );
    }
}