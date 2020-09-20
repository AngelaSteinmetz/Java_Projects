import java.util.ArrayList;

public class DocumentIndex extends ArrayList<IndexEntry>
{
    //  Creates an empty DocumentIndex with the default
    // initial capacity.
    public DocumentIndex()
    {
        super();
    }

    //  Creates an empty DocumentIndex with a given
    //  initial capacity.
    public DocumentIndex(int initialCapacity)
    {
        super(initialCapacity);
    }

    //  If word is not yet in this DocumentIndex,
    //  creates a new IndexEntry for word, and inserts
    //  it into this list in alphabetical order;
    //  adds num to this word's IndexEntry by calling
    //  its add(num) method.
    public void addWord(String word, int num)
    {
        int index = foundOrInserted(word);
        get(index).add( num );
    }

    //  For each word in str, calls addWord(word, num).
    public void addAllWords(String str, int num)
    {
        String[] words = str.split( "\\W+" );

        for (String word : words)
        {
            if (!word.equals(""))
            {
                addWord(word, num);
            } 
        }

    }

    // Tries to find an  IndexEntry with a given word in this
    // DocumentIndex.  If not found, inserts a new EndexEntry for
    // word at the appropriate place (in lexicographical order).
    // Returns the index of the found or inserted IndexEntry
    private int foundOrInserted(String word)
    {        
        for (int i = 0; i < size(); i++)
        {
            if (word.equalsIgnoreCase( get(i).getWord() ))
            {
                return i;
            }
            if (word.compareToIgnoreCase( get(i).getWord() ) < 0)
            {
                add(i, new IndexEntry(word));
                return i;
            }
        } 
        if (size() == 0)
        {
            add(0, new IndexEntry(word));
            return 0;
        }
        add(new IndexEntry(word));
        return size() - 1;
    }
}
