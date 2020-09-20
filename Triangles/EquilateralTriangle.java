public class EquilateralTriangle extends AbstractTriangle
{
//    private double side; 
    
    /**
     * sets side length to 0
     */
    public EquilateralTriangle()
    {
        super();
    }
    
    /**
     * @param sideLength length of side
     */
    public EquilateralTriangle(double sideLength)
    {
        super(sideLength);
    }
    
    /**
     * @return perimeter
     */
    public double getPerimeter()
    {
        return 3 * getSide();
    }
    
    /**
     * @return area
     */
    public double getArea()
    {
        return Math.sqrt(3) / 4 * getSide() * getSide();
    }
  
}