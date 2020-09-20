//import java.util.List;
import java.util.Stack;

public class BrowserModel
{
    private BrowserView view;
    private Stack<Integer> backStk;
    private Stack<Integer> forwardStk;
    private int topLine;

    /**
     * constructs BrowserModel
     * @param v BrowserView
     */
    public BrowserModel(BrowserView v)
    {
        view = v;
        backStk = new Stack<Integer>();
        forwardStk = new Stack<Integer>();
        topLine = 0;
        view.update( topLine );
    }

    /**
     * goes to the previous page
     */
    public void back()
    {
        if (!backStk.isEmpty())
        {
            forwardStk.push( topLine );
            topLine = backStk.pop();
            view.update( topLine );
        }
    }
    
    /**
     * goes to the forward page
     */
    public void forward()
    {
        if (!forwardStk.isEmpty())
        {
            backStk.push( topLine );
            topLine = forwardStk.pop();
            view.update( topLine );
        } 
    }
    
    /**
     * returns to the original line 0
     */
    public void home()
    {
        backStk.push(topLine);
        topLine = 0;
        while (!forwardStk.isEmpty())
        {
            forwardStk.pop();
        }
        view.update( topLine );
    }

    /**
     * follows the link clicked by setting the top line
     * @param n the top line in the link
     */
    public void followLink(int n)
    {
        backStk.push( topLine );
        topLine = n;
        view.update( topLine );
    }
    
    /**
     * checks if the backstack is not empty
     * @return if backstack is not empty
     */
    public boolean hasBack()
    {
        return !backStk.isEmpty();
    }
    
    /**
     * checks if the forwardstack is not empty
     * @return if forwardstack is not empty
     */
    public boolean hasForward()
    {
        return !forwardStk.isEmpty();
    }
    
    // The following are for test purposes only
    /**
     * returns the back stack
     * @return backstk
     */
    public Stack<Integer> getBackStk()
    {
        return backStk;
    }

    /**
     * returns the forward stack
     * @return forwardstk
     */
    public Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }

    /**
     * returns the top line
     * @return topline
     */
    public int getTopLine()
    {
        return topLine;
    }
}