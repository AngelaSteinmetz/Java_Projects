import java.io.*;
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class HeapOfTrouble
{
    HeapPriorityQueue myHeapPQ;
    int howMany;

    public HeapOfTrouble( String fName )
    {
        myHeapPQ = new HeapPriorityQueue();
        loadFile( fName );
    }

    public HeapOfTrouble()
    {
        this( "test1.txt" );
    }

    private void loadFile( String fileName )
    {
        Scanner inFile;

        try
        {
            System.out.println( "Reading " + fileName );
            System.out.println();
            inFile = new Scanner( new File( fileName ) );

            int numStudents = inFile.nextInt();
            for ( int i = 0; i < numStudents; i++ )
            {
                String id = inFile.next();
                String firstName = inFile.next();
                String lastName = inFile.next();
                int grade = inFile.nextInt();
                myHeapPQ.add( new Student( id, firstName, lastName, grade ) );
//                System.out.println(myHeapPQ);
            }
        }
        catch ( IOException i )
        {
            System.out.println( "Error: " + i.getMessage() );
        }
    }

    /**
       prints out grades in sorted order
     */
    public void sort()
    {
        while (!myHeapPQ.isEmpty())
        {
            System.out.print( myHeapPQ.remove() + ", ");
        }
    }

    public void printbyLevel()
    {
        System.out.println(myHeapPQ);
    }

    public static void main( String[] args )
    {
        Scanner console = new Scanner( System.in );
        String defaultFileName = "test1.txt";
        System.out.print( "Enter the name of the file to read (enter for "
            + defaultFileName + "): " );
        String fileName = console.nextLine().trim();

        if ( fileName.length() <= 3 )
        {
            fileName = defaultFileName;
        }

        HeapOfTrouble heapTest = new HeapOfTrouble( fileName );

        System.out.println("Heap Printed by Level");
        System.out.println("=====================\n");
        heapTest.printbyLevel();
        System.out.println();

        System.out.println("Heap Printed by Priority (sorted)");
        System.out.println("=================================\n");
        heapTest.sort();
    }
}