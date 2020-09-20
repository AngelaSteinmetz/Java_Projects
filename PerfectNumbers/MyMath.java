public class MyMath
{
    /**
     * Returns true if n is a prime; otherwise returns false.
     * @param n  number to check if prime
     * @return  true if n is a prime; otherwise returns false
     */
    public static boolean isPrime( int n )
    {
        if ( n <= 1 )
        {   
            return false;
        }
        
        int m = 2;
        int sqrt = (int)(Math.sqrt( n ) + 0.5);
        
        while ( m  <= sqrt )
        {
            if ( n % m == 0 )
            {
                return false;
            }
            if (m == 2)
            {
                m++;
            }
            else
            {
                m += 2;
            }
        }

//        while ( m * m <= n )
//        {
//            if ( n % m == 0 )
//            {
//                return false;
//            }
//            m++;
//        }

        return true;
    }


    /**
     * Question 8-15 Returns the n-th Fibonacci number
     * 
     * Find and read a few informative websites dedicated to Fibonacci numbers.
     * The following recursive method returns the n-th Fibonacci number:
     * 
     *   // Returns the n-th Fibonacci number.
     *   // Precondition: n >= 1
     *   public static long fibonacci(int n)
     *   {
     *     if (n == 1 || n == 2)
     *       return 1;
     *     else
     *       return fibonacci(n - 1) + fibonacci(n - 2);
     *   }
     * Rewrite it without recursion, using one loop.
     *
     * @param n  Fibonacci number to find
     * @return  n-th Fibonacci number
     */
    public static long fibonacci( int n )
    {
        if (n < 1)
        {
            return 0;
        }
        if ( n == 1 || n == 2)
        {
            return 1;
        }
        else
        {
            long temp = 0;
            long curNum = 1;
            long prevNum = 1;
            for (int i = 0; i < n - 2; i++)
            {
                temp = curNum;
                curNum += prevNum;
                prevNum = temp;

            }
            return curNum;
        }
    }


    /**
     * Returns true if n is a perfect number, false otherwise.
     * 
     * @param n  number to test
     * @return   true if n is a perfect number, false otherwise.
     */
    public static boolean isPerfect( int n )
    {

        int sum = 1;
        int div = 2;

        // sum = sum of numbers in [1..div] that divide num
        while (div < n)
        {
            if (n % div == 0)
            {
                sum += div;
            }
            div++;
        }
        return sum == n;
    }


    /**
     * Prints the first n perfect numbers
     * 
     * @param n number of perfect numbers to print
     */
    public static void printPerfectNums( int n )
    {
        System.out.println( "Perfect numbers: " );
        int count = 0;
        for ( int k = 2; count < n; k++ )
        {
            if ( isPerfect( k ) )
            {
                System.out.print( k + " " );
                count++;
            }
        }
        System.out.println();
    }


    /**
     * Prints the first n Mersenne primes
     * 
     * @param n number of Mersenne primes to print
     */
    public static void printMersennePrimes( int n )
    {
        System.out.println( "Mersenne primes: " );

        int numAnswers = 0;
//        int number = 1;
        int power = 1;
        while (numAnswers < n)
        {
            power *= 2;
                       
            if (isPrime(power - 1))
            {
                numAnswers++;
                System.out.print((power - 1) + " ");
            }
//            if (isPrime(number))
//            {
//                int curN = 1;
//                while (Math.pow(2, curN) - 1 <= number)
//                {
//                    if (Math.pow( 2, curN ) - 1 == number)
//                    {
//                        numAnswers++;
//                        System.out.println(numAnswers + ": " + number);
//                    } 
//                    curN++;
//                }
//            }
//            number++;
        }

        System.out.println();
    }

    /**
     * Prints the first n even perfect numbers
     * @param n number of even perfect numbers to print
     */
    public static void printEvenPerfectNums( int n )
    {
        System.out.println( "Even perfect numbers: " );

        int numAnswers = 0;
        int power = 1;
        int number = 0;
        while (numAnswers < n)
        {
            power *= 2;
            number++;
                       
            if (isPrime(power - 1))
            {
                numAnswers++;
                System.out.print((long)((power - 1) * Math.pow(2, number - 1)) 
                    + " ");      
            }
        }
        
//        while (numAnswers <= n)
//        {
//            if (isPrime(number))
//            {
//                long curN = 1;
//                while (Math.pow(2, curN) - 1 <= number)
//                {
//                    if (Math.pow( 2, curN ) - 1 == number)
//                    {
//                        numAnswers++;
//                        System.out.println(numAnswers + ": " + 
//                            (long)number * Math.pow( 2, curN - 1 ));
//                    } 
//                    curN++;
//                }
//            }
//            number += 2;
//        }

        System.out.println();
    }


    /*********************************************************************/

    /**
     * runs the MyMath program
     * @param args arguments
     */
    public static void main( String[] args )
    {
        int n = 19;
        System.out.println( n + "-th Fibonacci number = " + fibonacci( n ) );

        printPerfectNums( 4 );
        printMersennePrimes( 6 );
        printEvenPerfectNums( 6 );
    }
}
/*
19-th Fibonacci number = 4181
Perfect numbers: 
6 28 496 8128 
Mersenne primes: 
3 7 31 127 8191 131071 524287 
Even perfect numbers: 
6 28 496 8128 33550336 8589869056 137438691328 
*/