import java.lang.reflect.*;
import java.util.*;

/**
 * Represents a stock trader.
 */
public class Trader implements Comparable<Trader>
{
    private Brokerage brokerage;
    private String screenName, password;
    private TraderWindow myWindow;
    private Queue<String> mailbox;

    /**
     * @param b brokerage for this trader
     * @param name user name
     * @param pswd password
     */
    public Trader(Brokerage b, String name, String pswd)
    {
        brokerage = b;
        screenName = name;
        password = pswd;
        mailbox = new LinkedList<String>();
    }
    
    /**
     * Compares this trader to another by comparing their screen names case blind. 
     * @param other the reference to a trader with which to compare.
     * @return the result of the comparison of this trader and other.
     */
    public int compareTo(Trader other)
    {
        String name1 = screenName.toLowerCase();
        String name2 = other.getName().toLowerCase();
        return name1.compareTo( name2 );
    }
    
    /**
     * Indicates whether some other trader is "equal to" this one, based on 
     * comparing their screen names case blind. This method will throw a ClassCastException 
     * if other is not an instance of Trader. 
     * @param other the reference to an object with which to compare. 
     * @return true if this trader's screen name is the same as other's; false otherwise.
     */
    public boolean equals(Object other)
    {
        if (other instanceof Trader)
        {
            String name1 = screenName.toLowerCase();
            String name2 = ((Trader)other).getName().toLowerCase();
            return name1.equals( name2 );
        }
        else
        {
            throw new ClassCastException();
        }
    }
    
    /**
     * Returns the screen name for this trader
     * @return screen name for this trader
     */
    public String getName()
    {
        return screenName;
    }
    
    /**
     * Returns the password for this trader
     * @return password for this trader
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * Requests a quote for a given stock symbol from the brokerage by 
     * calling brokerage's getQuote. 
     * @param symbol stock symbol for which a quote is requested
     */
    public void getQuote(String symbol)
    {
        brokerage.getQuote(symbol, this);
    }
    
    /**
     * turns true if this trader has any messages in its mailbox. 
     * @return true if this trader has messages; false otherwise.
     */
    public boolean hasMessages()
    {
        return !mailbox.isEmpty();
    }
    
    /**
     * Creates a new TraderWindow for this trader and saves a reference to it in myWindow. 
     * Removes and displays all the messages, if any, from this trader's mailbox by calling
     *  myWindow.show(msg) for each message. 
     */
    public void openWindow()
    {
        myWindow = new TraderWindow(this);
        while (!mailbox.isEmpty())
        {
            myWindow.showMessage(mailbox.remove());
        }
    }
    
    /**
     * Places a given order with the brokerage by calling brokerage's placeOrder. 
     * @param order a trading order to be placed.
     */
    public void placeOrder(TradeOrder order)
    {
//        if (order != null)
//        {
            brokerage.placeOrder( order );
//        }
    }
    
    /**
     * Logs out this trader. Calls brokerage's logout for this trader. 
     * Sets myWindow to null (this method is called from a TraderWindow's 
     * window listener when the "close window" button is clicked). 
     */
    public void quit()
    {
        brokerage.logout( this );
        myWindow = null;
    }
    
    /**
     * Adds msg to this trader's mailbox and displays all messages. 
     * If this trader is logged in (myWindow is not null) removes and 
     * shows all the messages in the mailbox by calling myWindow.showMessage(msg) 
     * for each msg in the mailbox. 
     * @param msg a message to be added to this trader's mailbox.
     */
    public void receiveMessage(String msg)
    {
        mailbox.add( msg );
        if (myWindow != null)
        {
            while (!mailbox.isEmpty())
            {
                myWindow.showMessage(mailbox.remove());
            }
        }
    }


    //
    // The following are for test purposes only
    //
    protected Queue<String> mailbox()
    {
        return mailbox;
    }
    
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Trader.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                if ( field.getType().getName().equals( "Brokerage" ) )
                    str += separator + field.getType().getName() + " "
                        + field.getName();
                else
                    str += separator + field.getType().getName() + " "
                        + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}