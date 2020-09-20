public class HeapSort
{
    // Sorts a[0], ..., a[size-1] in ascending order
    //   using the Mergesort algorithm
    public static void sort(double[] a)
    {
        int n = a.length;
        for (int i = n /2; i >= 1; i--)
        {
            reheapDown(a, i, n);
        }
        
        while (n > 1)
        {
            double temp = a[0];
            a[0] = a[n - 1];
            a[n - 1] = temp;
            
            n--;
            reheapDown(a, 1, n);
        }
//        for (double d : a)
//        {
//            System.out.println( d + " " );
//        }
    }

    // Should be private - made public for testing
    public static void reheapDown(double[] a, int i, int n)
    {
        double o = a[i - 1];
        int m = i - 1;
        int c1 = 2 * (i - 1);
        int c2 = 2 * (i - 1) + 1;
//        Object child1 = items[2];
//        Object child2 = items[3];
        int maxChild;
        if (c1 > n)
        {
            return;
        }
        if (c2 > n || a[c1] > a[c2])
        {
            maxChild = c1;
        }
        else
        {
            maxChild = c2;
        }
        
        while (maxChild < n && a[maxChild] > o)
        {
//            System.out.println("min: " + items[minChild]);
//            System.out.println(this);
//            System.out.println("i :" + i);
//            System.out.println("c1: " + items[c1]);
            a[m] = a[maxChild];
            a[maxChild] = o;
            m = maxChild;
            c1 = 2 * m;
            c2 = 2 * m + 1;
            if (c1 > n)
            {
                break;
            }
            if (c2 > n || a[c1] > a[c2])
            {
                maxChild = c1;
            }
            else
            {
                maxChild = c2;
            }
        }
    }
}