public class Message implements Comparable<Message>
{
    private String msg;
    
    public Message(String msg)
    {
        this.msg = msg;
    }

    @Override
    public int compareTo( Message other )
    {
        return msg.compareTo( other.msg );
    }
    
    public String toString()
    {
        return msg;
    }
}