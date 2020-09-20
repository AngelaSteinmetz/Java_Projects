import java.util.*;
import java.lang.reflect.*;
import java.text.DecimalFormat;

public class Stock
{
    public static DecimalFormat money = new DecimalFormat( "0.00" );

    private String stockSymbol;
    private String companyName;
    private double loPrice, hiPrice, lastPrice;
    private int volume;
    private PriorityQueue<TradeOrder> buyOrders, sellOrders;

    /**
     * @param symbol stock symbol
     * @param name full company name
     * @param price opening price for this stock
     */
    public Stock(String symbol, String name, double price)
    {
        this.stockSymbol = symbol;
        this.companyName = name;
        this.loPrice = price;
        this.hiPrice = price;
        this.lastPrice = price;
        this.volume = 0;
        buyOrders = new PriorityQueue<TradeOrder>(10, new PriceComparator(false));
      	sellOrders = new PriorityQueue<TradeOrder>(10, new PriceComparator(true));
    }
   
  
    //
    // The following are for test purposes only
    //
    
    protected String getStockSymbol()
    {
        return stockSymbol;
    }
    
    protected String getCompanyName()
    {
        return companyName;
    }
    
    protected double getLoPrice()
    {
        return loPrice;
    }
    
    protected double getHiPrice()
    {
        return hiPrice;
    }

    protected double getLastPrice()
    {
        return lastPrice;
    }
    
    protected int getVolume()
    {
        return volume;
    }

    protected PriorityQueue<TradeOrder> getBuyOrders()
    {
        return buyOrders;
    }
    
    protected PriorityQueue<TradeOrder> getSellOrders()
    {
        return sellOrders;
    }
  
  
  
    /**
     * Returns a quote string for this stock.
     * @return quote for this stock
     */
    public String getQuote()
    {
        String quote = companyName + " (" + stockSymbol + ")" + "\n"
                + "Price: " + lastPrice + " hi: " + hiPrice
                + " lo: " + loPrice + " vol: " + volume + "\n";

            if ( sellOrders.isEmpty() )
            {
                if ( buyOrders.isEmpty() )
                    return quote += "Ask: none" + " Bid: none";

                return quote += "Ask: none" + " Bid: " + buyOrders.peek().getPrice() + " size: "
                    + buyOrders.peek().getShares();
            }
            else
            {
                if ( buyOrders.isEmpty() )
                    return quote += "Ask: " + sellOrders.peek().getPrice() + " size: " 
                + sellOrders.peek().getShares() + " Bid: none\n";

                return quote += "Ask: " + sellOrders.peek().getPrice() + " size: "
                + sellOrders.peek().getShares()+ " Bid: " + buyOrders.peek().getPrice() 
                + " size: " + buyOrders.peek().getShares();
            }
    }
  
    
  
    /**
     * Places a trading order for this stock. 
     * @param order trading order to be placed
     */
    public void placeOrder(TradeOrder order)
    {
        String message = "";
        if ( order == null )
        {
            return;
        }
        if ( order.isBuy() )
        {
            buyOrders.add( order );
            message = "New order: Buy " + order.getSymbol() + "(" + companyName + ")" + "\n" + order.getShares()
                + " shares at ";
            if ( order.isMarket() )
            {
                message += "market";
            }
            else if ( order.isLimit() )
            {
                message += money.format( order.getPrice() );
            }
        }
        else if ( order.isSell() )
        {
            sellOrders.add( order );
            message = "New order: Sell " + order.getSymbol() + "(" + companyName + ")" + "\n" + order.getShares()
                + " shares at ";

            if ( order.isMarket() )
            {
                message += "market";
            }
            else if ( order.isLimit() )
            {
                message += money.format( order.getPrice() );
            }
        }

        order.getTrader().receiveMessage( message);
        executeOrders();
    }
  
  
  
    /**
     * Executes as many pending orders as possible
     */
    protected void executeOrders()
    {

        while ( !buyOrders.isEmpty() && !sellOrders.isEmpty() )
        {
            TradeOrder buy = buyOrders.peek();
            TradeOrder sell = sellOrders.peek();
            Trader buyer = buy.getTrader();
            Trader seller = sell.getTrader();
            double price = 0;
            int shares = 0;

            if ( ( buy.isLimit() && sell.isLimit() ) && buy.getPrice() >= sell.getPrice() )
            {
                price = sell.getPrice();
            }
            else if ( buy.isLimit() && sell.isMarket() )
            {
                price = buy.getPrice(); 
            }
            else if ( buy.isMarket() && sell.isLimit() )
            {
                price = sell.getPrice();
            }
            else if ( buy.isMarket() && sell.isMarket() )
            {
                price = lastPrice; 
            }
            else
            {
                return;
            }

            if ( buy.getShares() > sell.getShares() )
            {
                shares = sell.getShares();
            }
            else
            {
                shares = buy.getShares();
            }

            buy.subtractShares( shares );
            sell.subtractShares( shares );

            if ( buy.getShares() == 0 )
            {
                buyOrders.remove( buy );
            }

            if ( sell.getShares() == 0 )
            {
                sellOrders.remove( sell );
            }

            if ( price < loPrice )
            {
                loPrice = price;
            }

            if ( price > hiPrice )
            {
                hiPrice = price;
            }
            volume += shares;
            lastPrice = price;
            buyer.receiveMessage( "You bought: " + shares + " " + stockSymbol + " at " + money.format( price ) + " amt "
                + money.format( shares * price ) );
            seller.receiveMessage( "You sold: " + shares + " " + stockSymbol + " at " + money.format( price ) + " amt "
                + money.format( shares * price ) );
        }
    }
  
    
    
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Stock.
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