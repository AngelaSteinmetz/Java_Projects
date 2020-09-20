public class CollegeStudent extends Student
{
    private String major;
    private int year;
    
    /**
     * @param myName name
     * @param myAge age
     * @param myGender gender
     * @param myID ID
     * @param myGPA GPA
     * @param myMajor major
     * @param myYear year
     */
    public CollegeStudent(String myName, int myAge, String myGender, 
        String myID, double myGPA, int myYear, String myMajor)
    {
        super(myName, myAge, myGender, myID, myGPA);
        major = myMajor;
        year = myYear;
    }
    
    /**
     * gets year
     * @return year
     */
    public int getYear()
    {
        return year;
    }
    
    /**
     * gets major
     * @return major
     */
    public String getMajor()
    {
        return major;
    }

    /**
     * sets year
     * @param myYear year
     */
    public void setYear(int myYear)
    {
        year = myYear;
    }
    
    /**
     * sets major
     * @param myMajor major
     */
    public void setMajor(String myMajor)
    {
        major = myMajor;
    }
    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + year +
            ", major: " + major;
    }
}