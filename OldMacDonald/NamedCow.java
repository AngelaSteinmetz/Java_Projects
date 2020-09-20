public class NamedCow extends Cow
{
    /**
     * name
     */
    private String myName;
    
    /**
    Initializes a newly created Cow object so that it represents an Animal
    of the specified type that makes the specified sound.

    @param  type       the type of Cow
    @param  sound      the sound the Cow makes
     */
    public NamedCow(String type, String sound)
    {
        super(type, sound);
    }

    /**
     * @param type type
     * @param name name
     * @param sound sound
     */
    public NamedCow(String type, String name, String sound)
    {
        super(type, sound);
        myName = name;
    }
    
    /**
     * returns name
     * @return name
     */
    public String getName()
    {
        return myName;
    }
}