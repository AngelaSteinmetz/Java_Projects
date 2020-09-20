public class ListNode<E>
{
    private E value;
    private ListNode<E> next;

    // Constructor:
    public ListNode( E initValue, ListNode<E> initNext )
    {
        value = initValue;
        next = initNext;
    }

    public E getValue()
    {
        return value;
    }

    public ListNode<E> getNext()
    {
        return next;
    }

    public void setValue( E theNewValue )
    {
        value = theNewValue;
    }

    public void setNext( ListNode<E> theNewNext )
    {
        next = theNewNext;
    }
}
//FINAL
//int count = 0;
//for (ListNode<String> h = head; h.getNext() != null; h = h.getNext())
//{
//    count++;
//}
//ListNode<String> recentMin = null;
//boolean first = true;
//ListNode<String> mostMin = null;
//for (int m = 0; m < count; m++)
//{
//    System.out.println("iteration: " + count);
//    ListNode<String> minPrev;
//    if (first == true)
//    {
//        minPrev = new ListNode<String>("", head);
//    }
//    else
//    {
//        minPrev = mostMin;
//    }
//    System.out.println("head value " + head.getValue());
//    ListNode<String> i = head;
//    while ( i.getNext() != null )
//    {
//        System.out.println("i get next get value " + i.getNext().getValue());
//        if (first == true)
//        {
//            System.out.println("first");
//            if (i.getNext().getValue().compareTo( minPrev.getNext().getValue() ) > 0 )
//            {
//
//                minPrev = i;
//                System.out.println("new mins " + minPrev.getNext().getValue());
//            }
//        }
//        else if (i.getNext().getValue().compareTo( minPrev.getNext().getValue() ) > 0 
//                        && i.getNext().getValue().compareTo( recentMin.getValue() ) < 0)
//        {
//            System.out.print( "not first" );
//            minPrev = i;
//        }
//        i = i.getNext();
//    }
//    
//    ListNode<String> min = minPrev.getNext();
//
//    minPrev.setNext( min.getNext() );
//    
//    if (first == true)
//    {
//        mostMin = min;
//    }
//        min.setNext( head );
//        head = min;
//        recentMin = min;
//
//    first = false;
//    
//    ListNode<String> t = head;
//    while (t != null)
//    {
//        System.out.print( t.getValue() + " " );
//        t = t.getNext();
//    }
//    System.out.println("");
//    System.out.println("min " + min.getValue());
//    System.out.println("");
//}
//
//ListNode<String> test = head;
//while (test.getNext() != null)
//{
//    test = test.getNext();
//}
//
//mostMin.setNext( null );
//test.setNext( recentMin );
//head = test;
//
//ListNode<String> t = head;
//while (t != null)
//{
//    System.out.print( t.getValue() + " " );
//    t = t.getNext();
//}
//System.out.println("");
//System.out.println("END " + head.getValue());

//SECOND DRAFT
//int count = 0;
//for (ListNode<String> cur = head; cur.getNext() != null; cur = cur.getNext())
//{
//    count++;
//}
//for (int i = 0; i < count; i++)
//{
//    ListNode<String> cur = head;
//    for (int j = 0; j < i; j++)
//    {
//        cur = cur.getNext();
//    }
//    
//    ListNode<String> min = cur;
//    for (ListNode<String> c = min; c.getNext() != null; c = c.getNext())
//    {
//        if (c.getNext().getValue().compareTo( min.getNext().getValue() ) < 0)
//        {
//            min = c;
//        }
//    }
//    ListNode<String> tMin = min.getNext();
//    min.setNext( tMin.getNext() );
//    min.setNext( cur.getNext() );
//    cur.setNext( min );
//    System.out.println("help");
//    
//}

//ORIGINAL
//if (head == null)
//{
//    return;
//}
//
//ListNode<String> cur = head;
//
//while (cur != null)
//{
//    ListNode<String> node = cur;
//    ListNode<String> minPrev = cur;
//    while (node.getNext() != null)
//    {
//        if (node.getNext().getValue().compareTo( minPrev.getNext().getValue() ) < 0)
//        {
//            minPrev = node;
//        }
//        node = node.getNext();
//    }
//    ListNode<String> min = minPrev.getNext();
//    minPrev.setNext( min.getNext() );
//    
//    if (cur == head)
//    {
//        min.setNext( cur );
//        head = min;
//    }
//    else if (cur.getNext() == null)
//    {
//        cur.setNext( min );
//        cur = cur.getNext();
//    }
//    else
//    {
//        
//        cur = cur.getNext();
//    }
//}