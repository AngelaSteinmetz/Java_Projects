import java.awt.*;
import javax.swing.*;

public class ParallelLines extends JPanel
{  
    /**
    the paint component
    @param g graphics
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);  // Call JPanel's paintComponent method
        //   to paint the background

        int width = getWidth();    
        int height = getHeight();

        drawIllusion(g, width, height);
    }

    /**
     draws the illusion of crooked lines
     @param g graphics
     @param width width
     @param height height
     */
    public void drawIllusion(Graphics g, int width, int height)
    {
        g.setColor( Color.RED );
        for ( int row = 0; row < 8; row++ )
        {
            int side = 30;
            int x = 100;
            int y = 100 + row * side;
            if (row % 4 == 2)
            {
                x += 20;
            }
            else if (row % 4 == 1 || row % 4 == 3)
            {
                x += 10;
            }
            for ( int col = 0; col < 14; col++ )
            {
                if (col % 2 == 0)
                {
                    g.setColor( Color.BLACK );
                }
                else
                {
                    g.setColor( Color.WHITE );
                }
                g.fillRect( x, y, side, side );
                x += side;
            }   
            g.setColor( Color.BLACK );
            if (row != 0)
            {
                g.drawLine( 100, y, 100 + 14 * side, y);
            }
        } 
    }

    /**
     * runs the program
     * @param args args
     */
    public static void main(String[] args)
    {
        JFrame w = new JFrame("ParallelLines");
        //    w.setBounds(100, 100, 640, 480);
        w.setBounds( 100, 100, 1000, 1000 );
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ParallelLines panel = new ParallelLines();
        panel.setBackground(Color.WHITE);
        Container c = w.getContentPane();
        c.add(panel);
        w.setResizable(true);
        w.setVisible(true);
    }
}