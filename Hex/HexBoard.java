public class HexBoard extends CharMatrix
{
    private boolean won;
    
    public HexBoard(int rows, int cols)
    {
        super(rows, cols);
        won = false;
    }

    public boolean isBlack(int r, int c)
    {
        return charAt(r, c) == 'b';
    }

    public boolean isWhite(int r, int c)
    {
        return charAt(r, c) == 'w';
    }

    public  boolean isGray(int r, int c)
    {
        return charAt(r, c) == 'x';
    }

    public void setBlack(int r, int c)
    {
        setCharAt(r, c, 'b');
    }

    public void setWhite(int r, int c)
    {
        setCharAt(r, c, 'w');
    }

    public void setGray(int r, int c)
    {
        setCharAt(r, c, 'x');
    }

    /**
     *  Returns true if there is a contiguous chain of black stones
     *  that starts in col 0 and ends in the last column of the board;
     *  otherwise returns false.
     */
    public boolean blackHasWon()
    {
        boolean answer = false;
        
        for (int i = 0; i < numRows(); i++)
        {
            areaFill(i, 0);
        }
        
        for (int i = 0; i < numRows(); i++)
        {
            if (isGray(i, numCols() - 1))
            {
                answer = true;
                break;
            }
        }
        
        for (int r = 0; r < numRows(); r++)
        {
            for (int c = 0; c < numCols(); c++)
            {
                if (isGray(r, c))
                {
                    setBlack(r, c);
                }
            }
        }
        
        won = false;
        return answer;
    }

    /**
     *  Fills the contiguous area that contains r,c with gray color.
     *  Does nothing if r, c is out of bounds or is not black.
     */
    public void areaFill(int r, int c)
    {
        if (!isInBounds(r, c) || !isBlack(r, c))
        {
            return;
        }
        if (c == numCols() - 1)
        {
            won = true;
        }
        setGray(r, c);
        areaFill(r - 1, c - 1);
        areaFill(r - 1, c);
        areaFill(r, c - 1);
        areaFill(r, c + 1);
        areaFill(r + 1, c);
        areaFill(r + 1, c + 1);
    }

    public String toString()
    {
        String s = "";

        for (int r = 0; r < numRows(); r++)
        {
            for (int c = 0; c < numCols(); c++)
            {
                if (isBlack(r, c))
                    s += 'B';      
                else if (isWhite(r, c))
                    s += 'W';
                else if (isGray(r, c))
                    s += 'X';
                else
                    s += '.';
            }
            s += '\n';
        }
        return s;
    }

    //****************************************************************

    private boolean isInBounds(int row, int col)
    {
        return row < numRows() && row >= 0 && col >= 0 && col < numCols();
    }
}