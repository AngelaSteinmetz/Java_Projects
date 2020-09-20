import java.util.*;

public class HeapPriorityQueue
{
    private static final int DFLT_CAPACITY = 101;
    private Object[] items;
    private int numItems;
    private final Comparator<Object> comparator;

    public HeapPriorityQueue()
    {
        this(DFLT_CAPACITY, null);
    }

    public HeapPriorityQueue(Comparator<Object> c)
    {
        this(DFLT_CAPACITY, c);
    }

    public HeapPriorityQueue(int initialCapacity)
    {
        this(initialCapacity, null);
    }

    public HeapPriorityQueue(int initialCapacity, Comparator<Object> c)
    {
        items = new Object[initialCapacity + 1];
        comparator = c;
    }

    /**
     *  Returns true if this priority queue is empty;
     *  otherwise returns false.
     */
    public boolean isEmpty()
    {
        return numItems == 0;
    }

    /**
     *  Returns the highest priority element without removing
     *  it from this priority queue.
     */
    public Object peek()
    {
        if (numItems == 0)
        {
            throw new NoSuchElementException();
        }
        return items[1];
    }

    /**
     *  Adds obj to this priority queue; returns true.
     */
    public boolean add(Object obj)
    {
        numItems++;
        if (numItems >= items.length)  // items[0] is not used
            growCapacity();
        items[numItems] = obj;
        reheapUp();
        return true;
    }

    /**
     *  Removes and returns the highest priority item.
     */
    public Object remove()
    {
        if (numItems == 0)
        {
            throw new NoSuchElementException();
        }

        Object minObject = items[1];
        items[1] = items[numItems];
        numItems--;
        reheapDown();
        return minObject;
    }

    //**************************************************************************

    private boolean lessThan(Object obj1, Object obj2)
    {
        if (comparator != null)
            return comparator.compare(obj1, obj2) < 0;
        else
            return ((Comparable)obj1).compareTo(obj2) < 0;
    }

    public void reheapDown()
    {
        Object o = items[1];
        int i = 1;
        int c1 = 2;
        int c2 = 3;
//        Object child1 = items[2];
//        Object child2 = items[3];
        int minChild;
        if (items[c2] == null || lessThan(items[c1], items[c2]))
        {
            minChild = c1;
        }
        else
        {
            minChild = c2;
        }
        
        while (items[minChild] != null && minChild <= numItems && lessThan(items[minChild], o))
        {
//            System.out.println("min: " + items[minChild]);
//            System.out.println(this);
//            System.out.println("i :" + i);
//            System.out.println("c1: " + items[c1]);
            items[i] = items[minChild];
            items[minChild] = o;
            i = minChild;
            c1 = 2 * i;
            c2 = 2 * i + 1;
            if (items[c2] == null || lessThan(items[c1], items[c2]))
            {
                minChild = c1;
            }
            else
            {
                minChild = c2;
            }
        }

    }

    public void reheapUp()
    {
        int i = numItems;
        Object o = items[numItems];
        while (i / 2 > 0 && lessThan(o, items[i / 2]))
        {
            items[i] = items[i / 2];
            items[i / 2] = o;
            i = i / 2;
        }
    }

    private void growCapacity()
    {
        Object[] tempItems = new Object[2 * items.length - 1];
        System.arraycopy(items, 0, tempItems, 0, items.length);
        items = tempItems;
    }

    /**
    returns the String containing all the elements in level order
    @return the String containing all the elements in level order
     */
    public String toString()
    {
        String result = "";
        for (int i = 1; i <= numItems; i++)
        {
            result += items[i] + " ";
        }
            
        return result;
    }
}