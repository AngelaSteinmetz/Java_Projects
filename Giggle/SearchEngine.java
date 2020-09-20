import java.util.*;

/**
   Giggle searches a single file for all lines of text that 
   contain a given word. There is an index of all the 
words in the file you are going to search.  The index is a 
map that associates each word in a text file with a list of all
 lines in the file that contain that word. 

   @author  Madeline Shao
   @version 2/6/18

   @author Period - 4
   @author Assignment - JM24.6 - Search Engine

   @author Sources - none
 */
public class SearchEngine
{
    // Instance variable(s)
    private String myURL; // holds the name for the "url" (file name)
    private Map<String, List<String>> myIndex; // holds the word index

    // Constructor(s)
    public SearchEngine(String url)
    {
        myURL = url;
        myIndex = new HashMap<String, List<String>>(20000);
    }

    // Methods
    public String getURL()
    {
        return myURL;
    }
    
    public void add(String line)
    {
        Set<String> mySet = parseWords(line);
        
        for (String word : mySet)
        {
            if (!myIndex.containsKey( word ))
            {
                myIndex.put( word, new LinkedList<String>() );
                myIndex.get( word ).add( line );
            }
            else
            {
                myIndex.get( word ).add( line );
            }
        }
    }

    public List<String> getHits(String word)
    {
        return myIndex.get( word );
    }
    
    private Set<String> parseWords(String line)
    {
        String[] words = line.split( "\\W+" );
        Set<String> mySet = new TreeSet<String>();
        
        for (String w : words)
        {
            if (w != "")
            {
                w = w.toLowerCase();
                mySet.add( w );
            }
        }
        
        return mySet;
    }
    //*************************************************************
    // For test purposes only
    // not to be used in solution implementation
    public Map<String, List<String>> getIndex()
    {
        return myIndex;
    }
}