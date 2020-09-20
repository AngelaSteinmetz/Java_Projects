import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortedWordList extends java.util.ArrayList<String>
{
    
    public SortedWordList()
    {
        super();
    }
    
    public SortedWordList(int i)
    {
        super(i);
    }
    
    public boolean contains(Object o)
    {
        String s = (String)o;
        char c = Character.toUpperCase(s.charAt( 0 ));
        s = c + s.substring( 1 );
        int i = Collections.binarySearch( this, s );
        if (i < 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public int indexOf(Object o)
    {
        String s = (String)o;
        char c = Character.toUpperCase(s.charAt( 0 ));
        s = c + s.substring( 1 );
        int i = Collections.binarySearch( this, s );
        if (i < 0)
        {
            return - 1;
        }
        else
        {
            return i;
        }
    }
    
    public String set(int i, String word)
    {
        int before = -1;
        int after = 1;
        if (i != 0 && get(i - 1) != null)
        {
            before = this.get( i - 1 ).compareTo( word );
        }
        if (i < size() && get(i + 1) != null)
        {
            after = this.get( i + 1 ).compareTo( word );
        }
        
        if (before >= 0 || after <= 0 )
        {
            throw new IllegalArgumentException("word = " + word + "i = " + i);
        }
        
        return super.set( i, word );
    }
    
    public void add(int i, String word)
    {
        int before = -1;
        int after = 1;
        if (size() == 0 )
        {
            super.add( 0, word );
        }
//        System.out.println(i + " " + size());
        if (i != 0 && get(i - 1) != null)
        {
            before = this.get( i - 1 ).compareTo( word );
        }
        if (i < size() && get(i) != null)
        {
            after = this.get( i ).compareTo( word );
        }
//        System.out.println(before + " " + after + get(0) + size() + i);
        if (before >= 0 || after <= 0 )
        {
            throw new IllegalArgumentException("word = " + word + " i = " + i);
        }
        super.add( i, word );
    }
    
    public boolean add(String word)
    {
        if (this.contains( word ))
        {
            return false;
        }
        
        if (size() == 0)
        {
            super.add( word );
            return true;
        }
        
        for (int i = 0; i < this.size(); i++)
        {
//            System.out.println(size() + word);
            if (this.get( i ) == null || word.compareTo( this.get( i ) ) < 0)
            {
                add(i, word);
//                System.out.println("?" + get(0));
                return true;
            }
        }
        
        super.add( word );
//        System.out.println("?" + word);
        return true;
    }
    
    public void merge (SortedWordList additionalWords)
    {
        for (int i = 0; i < additionalWords.size(); i++)
        {
            add(additionalWords.get( i ));
        }
    }
}