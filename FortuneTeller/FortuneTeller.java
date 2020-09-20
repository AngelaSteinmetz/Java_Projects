import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;

public class FortuneTeller extends JApplet implements ActionListener
{
    /**
     * declares and initializes an array of fortunes
     */
    String[] fortune = {"length in arrays is not a method", 
        "you will pass your finals", "you will be successful",
        "you will get a full score on this lab", 
        "you will watch Legends of Tomorrow"};

    /**
     * the display of the applet
     */
    private JTextField display;
    
    /**
     * the sound that plays when you click next
     */
    private AudioClip ding;

    /**
     * initializes applet
     */
    public void init()
    {
        ding = getAudioClip(getDocumentBase(), "ding.wav");

        display = new JTextField("  Press \"Next\" to see your fortune...", 30);
        display.setBackground(Color.WHITE);
        display.setEditable(false);

        JButton go = new JButton("Next");
        go.addActionListener(this);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(display);
        c.add(go);
    }

    /**
     * runs applet
     */
    public void actionPerformed(ActionEvent e)
    {
        ding.play();

        int index = (int)(Math.random() * fortune.length);
        display.setText(fortune[index] );
    }
}