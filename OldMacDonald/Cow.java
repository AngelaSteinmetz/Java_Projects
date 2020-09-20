public class Cow implements Animal
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
      Initializes a newly created Cow object so that it represents an Animal
      of the specified type that makes the specified sound.

      @param  type       the type of Cow
      @param  sound      the sound the Cow makes
     */
    public Cow(String type, String sound)
    {
        myType = type;
        mySound = sound;
    }

    /**
     * @return sound
     */
    public String getSound()
    {
        return mySound;
    }

    /**
     * @return type
     */
    public String getType()
    {
        return myType;
    }
}