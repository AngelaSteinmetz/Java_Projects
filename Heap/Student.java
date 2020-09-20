public class Student implements Comparable
{
    private String lynbrookId;
    private String firstName;
    private String lastName;
    private int grade;

    public Student( String id, String fName, String lName, int g )
    {
        lynbrookId = id;
        firstName = fName;
        lastName = lName;
        grade = g;
    }

    public Student()
    {
        this( "", "", "", 0 );
    }

    /**
     * first compares the grade of each student, and if the grades are equal
     *  then compares Lynbrook id's and sort the students in increasing order
     *   by their Lynbrook id. 
     * 
     * @param obj
     * @return 0 if equal, negative if priority higher, positive if priority lower
     */
    public int compareTo( Object obj )
    {
        Student other = (Student)obj;
        if (grade == other.grade)
        {
            int id1 = Integer.parseInt( lynbrookId );
            int id2 = Integer.parseInt( other.lynbrookId );
            return id1 - id2;
        }
        else
        {
            return grade - other.grade;
        }
    }

    public Object clone()
    {
        return new Student( lynbrookId, firstName, lastName, grade );
    }

    public String toString()
    {
        return lynbrookId + " " + firstName + " " + lastName + " " + grade;
    }
}