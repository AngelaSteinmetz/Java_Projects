import java.util.*;

public class RPN
{
    Scanner scan = new Scanner( System.in );
    
    private Stack<Integer> myStack;
    private Queue<String> myQ;

    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();
    }
    
    /**
     *  **** Used for testing - Do Not Remove ***
     *  
     *  Constructs an RPN Calculator and then redirects the Scanner input
     *  to the supplied string.
     *  
     *  @param console  replaces console input
     */
    public RPN(String console)
    {
        this();
        scan = new Scanner( console );
    }

    /**
     * calculates single digit integers with four integer math operations.
     */
    public void calculate()
    {
        System.out.println("Enter equation one character at a time: ");
        String input = scan.nextLine();
        
        operateInput(input);
               
        printAnswer();        
    }
    
    public void operateInput (String input)
    {
        while (!input.equalsIgnoreCase( "Q" ))
        {
            operation(input);
            input = scan.nextLine();
        }
    }
    
    public void printAnswer()
    {
        while (!myQ.isEmpty())
        {
            System.out.print(myQ.remove() + " ");
        }
        System.out.print( "= " + myStack.pop());
    }
    
    public boolean isAdd(String input)
    {
        return input.equals( "+" );
    }
    
    public void operation(String input)
    {
        myQ.add( input );
        char in = input.charAt( 0 );
        
        if (Character.isDigit( in ))
        {
            myStack.push(Integer.valueOf( input ));
        }
        else if (isAdd(input))
        {
            int result = myStack.pop() + myStack.pop();
            myStack.push( result );
        }
        else if (input.equals( "-" ))
        {
            int second = myStack.pop();
            int first = myStack.pop();
            int result = first - second;
            myStack.push( result );
        }
        else if (input.equals( "*" ))
        {
            int result = myStack.pop() * myStack.pop();
            myStack.push( result );
        }
        else if (input.equals( "/" ))
        {
            int second = myStack.pop();
            int first = myStack.pop();
            int result = first / second;
            myStack.push( result );
        }
    }
    
    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args  command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}
