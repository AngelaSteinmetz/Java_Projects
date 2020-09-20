public class RightTriangle extends AbstractTriangle
{
//    private double side;
    
    
    /**
     * sets side length to 0
     */
    public RightTriangle()
    {
        super();
    }
    
    /**
     * @param sideLength length of side
     */
    public RightTriangle(double sideLength)
    {
        super(sideLength);
    }
    
    /**
     * @return perimeter
     */
    public double getPerimeter()
    {
        return (2 + Math.sqrt(2.0)) * getSide();
    }
    
    /**
     * @return area
     */
    public double getArea()
    {
        return  getSide() * getSide() / 2;
    }
}