import java.util.AbstractSet;
import java.util.LinkedList;
import java.util.Set;

public class Person
{
    private String myName;   // name of the person
    private int myAge;       // person's age
    private String myGender; // 'M' for male, 'F' for female

     /**
     * @param name name
     * @param age age
     * @param gender gender
     */
    public Person( String name, int age, String gender )
    {
        myName = name;
        myAge = age;
        myGender = gender;
    }

    /**
     * gets name field
     * @return returns name
     */
    public String getName()
    {
        return myName;
    }

    /**
     * gets age field
     * @return returns age
     */
    public int getAge()
    {
        return myAge;
    }

    /**
     * gets gender field
     * @return returns gender
     */
    public String getGender()
    {
        return myGender;
    }

    /**
     * sets the person's name
     * @param name name
     */
    public void setName( String name )
    {
        myName = name;
    }

    /**
     * sets the person's age
     * @param age age
     */
    public void setAge( int age )
    {
        myAge = age;
    }

    /**
     * sets the person's gender
     * @param gender gender
     */
    public void setGender( String gender )
    {
        myGender = gender;
    }

    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return myName + ", age: " + myAge + ", gender: " + myGender;
    }
}