import java.awt.geom.*;
import java.util.*;
import gpdraw.*;

public class IrregularPolygon
{
    private DrawingTool pen;// = new DrawingTool( new SketchPad( 300, 300, 0 ) );
    private ArrayList<Point2D.Double> myPolygon;
    //constructors
    
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
    }

    // public methods

    public void add( Point2D.Double aPoint )
    {
        myPolygon.add( aPoint );
    }

    public double perimeter()
    {
        double perimeter = 0;
        double x;
        double y;
        for (int i = 0; i < myPolygon.size(); i++)
        {
            Point2D.Double point1;
            Point2D.Double point2;
            if (i == myPolygon.size() - 1)
            {
                point1 = myPolygon.get( i );
                point2 = myPolygon.get( 0 );
            }
            else
            {
                point1 = myPolygon.get( i );
                point2 = myPolygon.get( i + 1 );
            }
            y = Math.abs( point1.getY() - point2.getY() );
            x = Math.abs( point1.getX() - point2.getX() );
            perimeter += Math.sqrt( x * x + y * y );
        }
        
        
        return perimeter;
    }

    public double area()
    {
        double area = 0;
        for (int i = 0; i < myPolygon.size(); i++)
        {
            Point2D.Double point1;
            Point2D.Double point2;
            if (i == myPolygon.size() - 1)
            {
                point1 = myPolygon.get( i );
                point2 = myPolygon.get( 0 );
            }
            else
            {
                point1 = myPolygon.get( i );
                point2 = myPolygon.get( i + 1 );
            }
            area += point1.getX() * point2.getY();
            area -= point1.getY() * point2.getX();
        }
        
        
        return Math.abs( area / 2 );
    }

    public void draw()
    {
        if (!myPolygon.isEmpty())
        {
            pen.up();
            Point2D.Double point = myPolygon.get( 0 );
            double x = point.getX();
            double y = point.getY();
            pen.move( x, y);
            pen.down();
            
            for (int i = 1; i < myPolygon.size(); i++)
            {
                point = myPolygon.get( i );
                x = point.getX();
                y = point.getY();
                pen.move( x, y);
            }
            
            point = myPolygon.get( 0 );
            x = point.getX();
            y = point.getY();
            pen.move( x, y);
        }
    }
}