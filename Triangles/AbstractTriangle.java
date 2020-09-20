public abstract class AbstractTriangle 
{
    private double side;   
    
    /**
     * sets side length to 0
     */
    public AbstractTriangle()
    {
        side = 0;
    }
    
    /**
     * @param sideLength sets side length
     */
    public AbstractTriangle(double sideLength)
    {
        side = sideLength;
//        System.out.println("hi" + sideLength);
    }
    
    /**
     * abstract method that returns perimeter
     * @return perimeter
     */
    public abstract double getPerimeter();
    
    /**
     * abstract method that returns area
     * @return area
     */
    public abstract double getArea();
    
    /**
     * returns ratio of area to perimeter
     * @return ratio
     */
    public double getRatio()
    {
        return getArea() / getPerimeter();
    }
    
    /**
     * returns side length
     * @return side length
     */
    public double getSide()
    {
        return side;
    }
}