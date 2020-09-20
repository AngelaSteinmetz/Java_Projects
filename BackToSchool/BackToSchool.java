public class BackToSchool
{
    /**
     * main method that runs the classes
     * @param args args
     */
    public static void main( String[] args)
    {
//        double[] arr = {65, 4, 78, 2, 90, 45, 32};
        Person bob = new Person( "Coach Bob", 27, "M" );
//        int n = 2;
//        StringBuffer s = new StringBuffer(n);
//        bob.allWords(s, n);
        System.out.println( bob );

        Student lynne = new Student( "Lynne Brooke", 16, "F",
            "HS95129", 3.5 );
        System.out.println( lynne );

        Teacher mrJava = new Teacher( "Duke Java", 34, "M",
            "Computer Science", 50000 );
        System.out.println( mrJava );

        CollegeStudent ima = new CollegeStudent( "Ima Frosh", 18, "F",
            "UCB123", 4.0, 1, "English" );
        System.out.println( ima );
    }
}