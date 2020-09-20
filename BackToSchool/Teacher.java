public class Teacher extends Person
{
    private String subject;
    private double salary;
    
    /**
     * @param myName name
     * @param myAge age
     * @param myGender gender
     * @param mySubject subject
     * @param mySalary salary
     */
    public Teacher(String myName, int myAge, String myGender, 
        String mySubject, double mySalary)
    {
        super(myName, myAge, myGender);
        subject = mySubject;
        salary = mySalary;
    }
    
    /**
     * gets subject
     * @return subject
     */
    public String getSubject()
    {
        return subject;
    }

    /**
     * gets salary
     * @return salary
     */
    public double getSalary()
    {
        return salary;
    }
    
    /**
     * sets subject
     * @param mySubject subject
     */
    public void setSubject(String mySubject)
    {
        subject = mySubject;
    }
    
    /**
     * sets salary
     * @param mySalary salary
     */
    public void setSalary(double mySalary)
    {
        salary = mySalary;
    }
    
    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + subject +
            ", salary: " + salary;
    }
}