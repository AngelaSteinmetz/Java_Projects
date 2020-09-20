import java.util.Scanner;
import java.io.*;

public class DictionaryMaker
{
    private static final int MINLENGTH = 3, MAXLENGTH = 5;
    public static Scanner fileIn;       //public for test purposes
    public static PrintWriter fileOut;  //public for test purposes

    public static void main(String[] args) throws IOException
    {
        Scanner kboard = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter input file name: ");
        String fileName = kboard.next();

        openInputFile(fileName);
        if (fileIn == null)
        {
            System.out.println("*** Can't open " + fileName + " ***");
            return;
        }

        createOutputFile("RamblecsDictionary.java");
        if (fileOut == null)
        {
            fileIn.close();
            System.out.println("*** Can't create RamblecsDictionary.java ***");
            return;
        }

        int count = copyWords();
        System.out.println("Done: " + count + " words.");

        fileIn.close();
        fileOut.close();
    }

    /**
     *  Opens a file fileName (in the current folder)
     *  and places a reference to it into fileIn
     */ 
    public static void openInputFile(String fileName)
    {
        File file = new File(fileName);
        
        try
        {
            fileIn = new Scanner(file);
        }
        catch(FileNotFoundException ex)
        {
            System.out.print( "not found" );
        }
        
    }

    /**
     *  Creates a new file fileName (in the current folder)
     *  and places a reference to it into fileOut
     */ 
    public static void createOutputFile(String fileName)
    {
        File file = new File(fileName);
        
        try
        {
            fileOut = new PrintWriter(file);
        }
        catch(FileNotFoundException ex)
        {
            System.out.print( "not found" );
        }
    }

    /**
     *  Reads all words from fileIn, selects the words that have
     *  from MINLENGTH to MAXLENGTH letters, converts them
     *  into upper case and writes the words into fileOut in
     *  Java syntax
     *  
     *  @return number of words processed
     */ 
    public static int copyWords()
    {
        fileOut.println("public class RamblecsDictionary");
        fileOut.println("{");
        fileOut.println("\tpublic String words[] = ");
        fileOut.println("\t{");

        String word;
        int number = 0;
        while (fileIn.hasNext())
        {
            word = fileIn.next();
            if (word.length() >= MINLENGTH && word.length() <= MAXLENGTH)
            {
                word = word.toUpperCase();
                fileOut.println( "\t\t\"" + word + "\",");
                number++;
            }
        }
        
        fileOut.println("\t};");
        fileOut.println("}");
        return number;
    }
}