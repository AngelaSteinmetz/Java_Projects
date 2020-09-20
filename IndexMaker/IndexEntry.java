import java.util.ArrayList;

public class IndexEntry
{
    private String word;
    private ArrayList<Integer> numsList;

    // Constructs an IndexEntry for a given word
    // (converted to upper case); sets numsList
    // to an empty ArrayList.
    public IndexEntry(String w)
    {
        word = w.toUpperCase();
        numsList = new ArrayList<Integer>();
    }

    // Returns the word of this IndexEntry object.
    public String getWord()
    {
        return word;
    }

    // If num is not already in the list, adds num
    // at the end of this IndexEntry's list
    // of numbers.
    public void add(int num)
    {
        num = (Integer)(num);
        if (!numsList.contains( num ))
        {
            numsList.add( num );
        }
    }

    // Converts this IndexEntry into a string in the
    // following format: the word followed by a space, followed by
    // numbers separated by a comma and a space.
    public String toString()
    {
        String answer = "" + word + " " + numsList.get(0);
        for (int i = 1; i < numsList.size(); i++)
        {
            answer += ", " + numsList.get( i );
        }
        return answer; 
    }
}