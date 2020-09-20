import java.util.*;

public class Farm
{
    /**
     * array to store animals in 
     */
    private Animal[] a = new Animal[3];

    /**
     * constructs a farm
     */
    public Farm()
    {      
        a[0] = new NamedCow("cow", "Elsie", "moo moo");
        //a[0] = new NamedCow("cow", "Elsie", "moo");
        a[1] = new Chick("chick","cluck cluck", "cheep cheep");
        //a[1] = new Chick("chick", "cluckity cluck", "cheep");
        a[2] = new Pig("pig","oink oink");
    }

    /**
     * "plays" animals sounds
     */
    public void animalSounds()
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i].getType() + " goes " + a[i].getSound());
        }
        NamedCow named = (NamedCow)a[0];
        System.out.println( named.getType() + " is named " + named.getName() );
    }
}