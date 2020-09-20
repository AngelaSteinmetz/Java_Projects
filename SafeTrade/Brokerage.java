import java.lang.reflect.*;
import java.util.*;

public class Brokerage implements Login
{
    private Map<String, Trader> traders;
    private Set<Trader> loggedTraders;
    private StockExchange exchange;

    /**
     * Constructs new brokerage affiliated with a given stock exchange. 
     * Initializes the map of traders to an empty map (a TreeMap), keyed by trader's name; 
     * initializes the set of active (logged-in) traders to an empty set (a TreeSet). 
     * @param e a stock exchange
     */
    public Brokerage(StockExchange e)
    {
    	exchange = e;
        traders = new TreeMap<String, Trader>();
        loggedTraders = new TreeSet<Trader>();
    }
    
    /**
     * Tries to register a new trader with a given screen name and password. 
     * If successful, creates a Trader object for this trader and adds this 
     * trader to the map of all traders (using the screen name as the key). 
     * @param name screen name of trader
     * @param trader password of trader
     */
    public int addUser(String name, String password)
    {
        if (name.length() < 4 || name.length() > 10)
        {
            return -1;
        }
        if (password.length() < 2 || password.length() > 10)
        {
            return -2;
        }
    	if (!traders.containsKey( name))
    	{
    	    Trader t = new Trader(this, name, password);
    	    traders.put( name, t );
    	    return 0;
    	}
    	return -3;
    }
    
    /**
     * Requests a quote for a given stock from the stock exachange and passes it along 
     * to the trader by calling trader's receiveMessage method. 
     * @param symbol stock symbol
     * @param trader trader who requested a quote
     */
    public void getQuote(String symbol, Trader trader)
    {
        trader.receiveMessage(exchange.getQuote(symbol));
    }

    public int login(String name, String password)
    {
        if (traders.containsKey( name ))
        {
            Trader trader = traders.get( name );
            if (!password.equals( trader.getPassword() ))
            {
                return -2;
            }
            if (loggedTraders.contains( trader ))
            {
                return -3;
            }
            loggedTraders.add( trader );
            if (!trader.hasMessages())
            {
                trader.receiveMessage( "Welcome to SafeTrade!" );
            }
            trader.openWindow();
            return 0;
        }
        return -1;
        
    }
    
    /**
     * Removes a specified trader from the set of logged-in traders. 
     * @param trader trader that logs out
     */
    public void logout(Trader trader)
    {
        loggedTraders.remove( trader );
    }
    
    /**
     * Places an order at the stock exchange. 
     * @param order order placed at stock exchange
     */
    public void placeOrder(TradeOrder order)
    {
//        if (order != null)
//        {
            exchange.placeOrder(order);
//        }
    }
    
    //
    // The following are for test purposes only
    //
    protected Map<String, Trader> getTraders()
    {
        return traders;
    }

    protected Set<Trader> getLoggedTraders()
    {
        return loggedTraders;
    }

    protected StockExchange getExchange()
    {
        return exchange;
    }

    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Brokerage.
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