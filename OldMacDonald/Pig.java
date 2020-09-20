public class Pig implements Animal
{
    /**
     * type
     */
    private String myType;
    
    /**
     * sound
     */
    private String mySound;

    /**
        Initializes a newly created Pig object so that it represents an Animal
        of the specified type that makes the specified sound.

        @param  type       the type of Pig
        @param  sound      the sound the Pig makes
     */
    public Pig(String type, String sound)
    {
        myType = type;
        mySound = sound;
    }

    /**
     * gets sound
     * @return sound
     */
    public String getSound()
    {
        return mySound;
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