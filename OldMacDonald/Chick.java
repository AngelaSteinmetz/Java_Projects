public class Chick implements Animal
{
    /**
     * type
     */
    private String myType;

    /**
     * first sound
     */
    private String mySound1;
    
    /**
     * second sound
     */
    private String mySound2;

    /**
        Initializes a newly created Chick object so that it represents an Animal
        of the specified type that makes the specified sound.

        @param  type       the type of Chick
        @param  sound      the sound the Chick makes
     */
    public Chick(String type, String sound)
    {
        myType = type;
        mySound1 = sound;
        mySound2 = sound;
    }

    /**
     * @param type type
     * @param sound1 first sound
     * @param sound2 second sound
     */
    public Chick(String type, String sound1, String sound2)
    {
        myType = type;
        mySound1 = sound1;
        mySound2 = sound2;
    }

    /**
     * gets a random sound
     * @return random sound
     */
    public String getSound()
    {
        if ((int)(Math.random() * 2) == 1)
        {
            return mySound1;
        }
        return mySound2;
    }

    /**
     * gets type
     * @return type
     */
    public String getType()
    {
        return myType;
    }
}