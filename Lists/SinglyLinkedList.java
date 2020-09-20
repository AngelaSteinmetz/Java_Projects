import java.util.Iterator;

public class SinglyLinkedList<E> implements Iterable<E>
{
    private ListNode<E> head;
    private int nodeCount;

    // Constructor: creates an empty list
    public SinglyLinkedList()
    {
        head = null;
        nodeCount = 0;
    }

    /**
        Constructor: creates a list that contains all elements from the
        array values, in the same order
        @param values  array containing all elements for this list
     */
    public SinglyLinkedList(E[] values)
    {
        ListNode<E> tail = null;
        for (E value : values) // for each value to insert
        {
            ListNode<E> node = new ListNode<E>(value, null);
            if (head == null)
                head = node;
            else
                tail.setNext(node);
            tail = node;    // update tail
        }

        nodeCount = values.length;
    }

    /**
        Return true if this list is empty; otherwise returns false.
        @return true if this list is empty; otherwise returns false.
     */
    public boolean isEmpty()
    {
        if (nodeCount == 0)
            return true;
        return false;
    }

    /**
        Returns the number of elements in this list.
        @return  number of elements in this list.
     */
    public int size()
    {
        return nodeCount;
    }

    /**
        Returns true if this list contains an Object equal to obj; otherwise returns false.
        @return true if this list contains an Object equal to obj
     */
    public boolean contains(Object obj)
    {
        ListNode<E> n = head;
        if (isEmpty())
        {
            return false;
        }
        while (n.getNext() != null)
        {
            if (n.getValue().equals( obj ))
                return true;
            n = n.getNext();
        }
        if (n.getValue().equals( obj ))
        {
            return true;
        }
        return false;  // fix this
    }

    /**
        Returns the index of the first Object equal to obj; if not found,
        returns -1.

        @param obj  Object to find
        @return  the index of the first Object in equal to obj; if not found,
                  returns -1.
     */
    public int indexOf(Object obj)
    {
        ListNode<E> n = head;
        int count = -1;
        if (isEmpty())
        {
            return -1;
        }
        while (n.getNext() != null)
        {
            count++;
            if (n.getValue().equals( obj ))
                return count;
            n = n.getNext();
        }
        if (n.getValue().equals(obj))
        {
            return count + 1;
        }
        return -1;
    }

    /**
        Adds obj to this collection.  Returns true if successful;
        otherwise returns false.
        
        @param obj  element to add to this collection
        @return  true if successful; otherwise returns false.
     */
    public boolean add(E obj)
    {
        ListNode<E> last = head;
        if (isEmpty())
        {
            head = new ListNode<E>(obj, null);
            nodeCount++;
            return true;
        }
        while (last.getNext() != null)
        {
            last = last.getNext();
        }
        
        last.setNext( new ListNode<E>(obj, null) );
        
        nodeCount++;
        return true;
    }

    /**
        Removes the first element that is equal to obj, if any.
        Returns true if successful; otherwise returns false.

        @param obj  element to remove
        @return  true if successful; otherwise returns false.
     */
    public boolean remove(E obj)
    {
        int index = indexOf(obj);
        if (index == -1)
        {
            return false;
        }
        
        ListNode<E> node = head;
        for (int i = 0; i < index - 1; i++)
        {
            node = node.getNext();
        }
        if (node.getNext().getNext() != null)
            node.setNext( node.getNext().getNext() );
        else
            node.setNext( null );
        nodeCount--;
        return true;
    }

    /**
        Returns the i-th element.

        @param i  element to get from the list
        @return element at index i
        @throws IndexOutOfBoundsException 
     */
    public E get(int i)
    {
        SinglyLinkedListIterator<E> iter = new SinglyLinkedListIterator<E>(head);
        if (isEmpty() || i < 0 || i >= nodeCount)
        {
            throw new IndexOutOfBoundsException();
        }
        E answer = head.getValue();
        iter.next();
        for (int j = 0; j < i; j++)
        {
            answer = iter.next();
        }
        return answer;
    }

    /**
        Replaces the i-th element with obj and returns the old value.
        
        @param i index of element to replace
        @param obj replacement element of element at index i
        @return old value previously located at index i
        @throws IndexOutOfBoundsException 
     */
    public E set(int i, E obj)
    {
        ListNode<E> node = head;
        if (i < 0 || i >= nodeCount)
        {
            throw new IndexOutOfBoundsException();
        }
        for (int j = 0; j < i; j++)
        {
            node = node.getNext();
        }
        E value = node.getValue();
        node.setValue( obj );
        return value;
    }

    /**
        Inserts obj to become the i-th element. Increments the size
        of the list by one.
        
        @param i  insertion point in list for obj
        @param obj element to insert into list
        @throws IndexOutOfBoundsException 
     */
    public void add(int i, E obj)
    {
        ListNode<E> node = head;
        if (i < 0 || i > nodeCount)
        {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0)
        {
            head = new ListNode<E>(obj, node);
        }
        else if (i == nodeCount - 1)
        {
            add(obj);
        }
        else
        {
//            System.out.println("?");
            for (int j = 0; j < i - 1; j++)
            {
                if (node.getNext() == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                node = node.getNext();
            }
            ListNode<E> toAdd = new ListNode<E>(obj, node.getNext());
            node.setNext( toAdd );
        }
        nodeCount++;
        
    }

    /**
        Removes the i-th element and returns its value.
        Decrements the size of the list by one.

        @param i index of element to remove
        @return element removed from this list
     */
    public E remove(int i)
    {       
        if (i < 0 || i >= nodeCount)
        {
            throw new IndexOutOfBoundsException();
        }
        ListNode<E> node = head;
        ListNode<E> removed;
        if (i == 0)
        {
            removed = head;
            head = node.getNext();
            head.setNext( node.getNext().getNext() );
        }
        else if (i == nodeCount - 1)
        {
            while (node.getNext().getNext() != null)
                node = node.getNext();
            removed = node.getNext();
            node.setNext( null );
        }
        else
        {
            for (int j = 0; j < i - 1; j++)
            {
                node = node.getNext();
            }
            removed = node.getNext();
            node.setNext( node.getNext().getNext() );
        }
        nodeCount--;
        return removed.getValue();
    }

    /**
        Returns a string representation of this list.
        @return  a string representation of this list.
     */
    public String toString()
    {
        String result = "[";
        for (E value : this)
        {
            result += value.toString() + ", ";
        }
        result = result.substring( 0, result.length() - 2 );
        result += "]";
        return result;
    }

    /**
        Returns an iterator for this collection.
        @return  an iterator for this collection.
     */
    public Iterator<E> iterator()
    {
        return new SinglyLinkedListIterator<E>(head);
    }
}