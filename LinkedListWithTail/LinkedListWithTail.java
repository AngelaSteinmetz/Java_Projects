import java.util.NoSuchElementException;

public class LinkedListWithTail<E>
{
    private ListNode<E> head, tail;

    /**
     * Constructs an empty list.
     */
    public LinkedListWithTail()
    {
        head = null;
        tail = null;
    }

    /** 
     * Returns true if this list is empty; otherwise returns false.
     * 
     * @return true if this list contains no elements false otherwise
     */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     * 
     * @return the head of this list, or null if this list is empty
     */
    public E peek()
    {
        if (isEmpty())
        {
            return null;
        }
        return head.getValue();
    }

    /**
     * Appends the specified element to the end of this list.
     * 
     * @param obj - element to be appended to this list
     * @return true if this collection changed as a result of the call
     */
    public boolean add(E obj)
    {
        if (isEmpty())
        {
            head = new ListNode<E>(obj, null);
            tail = head;
        }
        else
        {
            ListNode<E> addition = new ListNode<E>(obj, null);
            tail.setNext(addition);
            tail = addition;
        }
        return true;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     * 
     * @return the head of this list
     * @throws NoSuchElementException - if this list is empty
     */
    public E remove()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        ListNode<E> toRemove = head;
        head = head.getNext();
        return toRemove.getValue();
    }
    
//    public ListNode doTheTrick(ListNode head)
//    {
//      if (head == null || head.getNext() == null)
//        return head;
//      ListNode newHead = head.getNext();
//      newHead = doTheTrick(newHead);
//      head.setNext(newHead.getNext());
//      newHead.setNext(head);
//      return newHead;
//    }

    /**
     * Exercise 20.12
     * 
     * Appends otherList at the end of this list.
     * Append should work in O(1) time, regardless of the list sizes, and
     * it should work properly when either list is empty or both list are empty
     * 
     * @param otherList list to be appended to the end of this list
     */
    public void append( LinkedListWithTail<E> otherList )
    {
        if (otherList.isEmpty())
        {
            return;
        }
        if (isEmpty())
        {
            head = otherList.head;
            tail = otherList.tail;
            return;
        }
        tail.setNext( otherList.head );
        tail = otherList.tail;
    }  

    /**   *** FOR TESTING PURPOSES ONLY ***
     *
     * Returns a string representation of this list.
     * 
     * @return a string representation of this list.
     */
    public String toString()
    {
        String str = "[", separator = "";

        for ( ListNode<E> node = head; node != null; node = node.getNext() )
        {
            str += ( separator + node.getValue() );
            separator = ", ";
        }

        return str + "]";
    }
}