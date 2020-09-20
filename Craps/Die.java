import java.math.*;

public class Die
{
    private int numDots;

    /**
     * Sets numDots to a random integer from 1 to 6
     */
    public void roll()
    {
        numDots = 1 + (int)(6 * Math.random());
    }
    
    /**
     * Returns the value of the most recent roll.
     * @return numDots
     */
    public int getNumDots()
    {
        return numDots; 
    }
}