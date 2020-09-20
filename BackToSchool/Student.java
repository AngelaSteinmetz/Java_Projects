public class Student extends Person
{
    private String myIdNum; // Student Id Number
    private double myGPA;   // grade point average

    /**
     * @param name name
     * @param age age
     * @param gender gender
     * @param idNum ID number
     * @param gpa GPA
     */
    public Student( String name, int age, String gender, String idNum,
                    double gpa )
    {
        // use the super class' constructor
        super( name, age, gender );

        // initialize what's new to Student
        myIdNum = idNum;
        myGPA = gpa;
    }

    /**
     * gets ID number
     * @return ID number
     */
    public String getIdNum()
    {
        return myIdNum;
    }

    /**
     * gets GPA
     * @return GPA
     */
    public double getGPA()
    {
        return myGPA;
    }

    /**
     * sets ID number
     * @param idNum ID number
     */
    public void setIdNum( String idNum )
    {
        myIdNum = idNum;
    }
    
    /**
     * sets GPA
     * @param gpa GPA
     */
    public void setGPA( double gpa )
    {
        myGPA = gpa;
    }

    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", student id: " +
            myIdNum + ", gpa: " + myGPA;
    }
}