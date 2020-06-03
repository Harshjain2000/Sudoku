public  class Sudoku_Solver {
    Boolean check(char[][] A, int r, int c, char val)
    {
        int boxstartrow = r-r%3, boxstartcol = c-c%3;

        // usedinrow
        for(int i=0; i<9; i++)
        {
            if(A[i][c] == val)
                return false;
        }

        // usedincol
        for(int i=0; i<9; i++)
        {
            if(A[r][i] == val)
                return false;
        }

        // usedinbox
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(A[i + boxstartrow][j + boxstartcol] == val)
                    return false;
            }
        }

        return true;
    }
    Boolean soln(char[][]A, int r, int c)
    {
        if(r == 9)
            return true;

        if(c == 9)
            return soln(A, r+1, 0);

        if(A[r][c] != '.')
            return soln(A, r, c+1);

        for(char ch='1'; ch<='9'; ch++)
        {
            if(check(A, r, c, ch))
            {
                A[r][c] = ch;

                if(soln(A, r, c+1))
                    return true;
                A[r][c] = '.';
            }
        }
        return false;
    }

    void solveSudoku(char[][] A)
    {
        soln(A, 0, 0);
    }

};
