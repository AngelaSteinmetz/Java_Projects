// Implements an iterator for a SinglyLinkedList.
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  implements an iterator for a singlylinkedlist
 *
 *  @author  mshao538
 *  @version Nov 29, 2017
 *  @author  Period: 4
 *  @author  Assignment: JMCh20_4Lists
 *
 *  @author  Sources: Maria & Gary Litvin
 */
public class SinglyLinkedListIterator<E> implements Iterator<E>
{
    private ListNode<E> nextNode;

    // Constructor
    public SinglyLinkedListIterator( ListNode<E> head )
    {
        nextNode = head;
    }

    public boolean hasNext()
    {
        return nextNode != null;
    }

    public E next()
    {
        if ( nextNode == null )
            throw new NoSuchElementException();

        E value = nextNode.getValue();
        nextNode = nextNode.getNext();
        return value;
    }

    // Not implemented.
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}