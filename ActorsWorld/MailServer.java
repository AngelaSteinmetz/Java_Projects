import java.util.*;

public class MailServer extends LinkedList<Message>
{
    private Set<Actor> actors;
    
    public MailServer()
    {
        actors = new TreeSet<Actor>();
    }
    
    public void signUp(Actor actor)
    {
        actors.add( actor );
    }
    
    public void dispatch(Message msg)
    {
        if (msg.getRecipient() != null)
        {
            msg.getRecipient().receive( msg );
        }
        else
        {
            for (Actor actor : actors)
            {
                if (actor.getName() != msg.getSender().getName())
                {
                    actor.receive( msg );
                }
            }
        }
    }
 
    // for testing purposes only
    protected Set<Actor> getActors()
    {
        return actors;
    }
}