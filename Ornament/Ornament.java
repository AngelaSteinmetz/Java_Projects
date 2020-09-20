import java.awt.*;
import javax.swing.*;

public class Ornament extends JPanel
{
    /**
     * paint tool that paints drawTriangles
     * @param g graphics
     */
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background
        drawTriangles( g, 100, 80, 64 );
    }

    /**
     * Draws an ornament made of triangles in Graphics g with the base midpoint
     * at (x, y) and base half-length r
     * @param g graphics
     * @param x base midpoint x coord
     * @param y base midpoint y coord
     * @param r base half-length
     */
    public void drawTriangles( Graphics g, int x, int y, int r )
    {
        if (r < 4)
        {
            return;
        }
        else
        {
            int temp = x;
            x -= 2 * r * (64 / (2.0 * r) - 1) + 3 * r;
            for (int i = 0; i < 64 / r; i++)
            {
                x += 2 * r;
                g.drawLine( x, y, x + r, y );
                g.drawLine(x + r, y, x, y - r);
                g.drawLine(x, y - r, x - r, y);
                g.drawLine( x - r, y, x, y );
            }  
            
            drawTriangles(g, temp, y, r / 2);
        } 
    }

    /**
     * runs drawTriangles
     * @param args args
     */
    public static void main( String[] args )
    {
        JFrame w = new JFrame( "Triangles" );
        w.setBounds( 300, 300, 200, 120 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Ornament panel = new Ornament();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( false );
        w.setVisible( true );
    }
}