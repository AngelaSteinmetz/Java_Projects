public class FunLoops
{
    /**
     * prints the first n magic squares
     * @param n number of magic squares to print
     */
    public void magicsquare( int n )
    {
        System.out.println("Magic Squares");
        int numAnswers = 0;
        long number = 1;
        while (numAnswers < n)
        {
            //find if perfect square
            boolean perfectSq = false;
            // int isSquare = (int)(Math.sqrt(number));
            // perfectSq = isSquare * isSquare == n;
            long numero = 1;
            long square = 0;
            while (square <= number)
            {
                square = numero * numero;
                if (square == number)
                {
                    perfectSq = true;
                    break;
                }
                numero++;
            }

            //find if sum of consecutive numbers
            if (perfectSq)
            {
                boolean consec = false;
                long sumCons = 0;
                long num = 1;
                while (sumCons <= number)
                {
                    sumCons += num;
                    if (sumCons == number)
                    {
                        consec = true;
                        break;
                    }
                    num++;
                }
               
                if (consec)
                {
                    numAnswers++;
                    System.out.println(numAnswers + ": " + number);
                }
            }
            
            number++;
        }
    }

    /**
     * finds the least common multiple of two integers
     * @param a integer
     * @param b integer
     * @return least common multiple
     */
    public int lcm( int a, int b )
    {
        int a1 = a;
        int b1 = b;

        while ( b1 != a1 )
        {
            if ( b1 > a1 )
            {
                a1 += a;
            }
            else 
            {
                b1 += b;
            }
        }

        return b1;  
    }

    /**
     * runs the program
     * @param args args
     */
    public static void main(String[] args)
    {
        FunLoops fun = new FunLoops();

        fun.magicsquare(4);
        System.out.println();

        System.out.println("LCM (15, 18) = " + fun.lcm(15, 18));
        System.out.println("LCM (40, 12) = " + fun.lcm(40, 12));
        System.out.println("LCM (2, 7) = " + fun.lcm(2, 7));
        System.out.println("LCM (100, 5) = " + fun.lcm(100, 5));
        System.out.println();

        fun.magicsquare(10);
    }
}