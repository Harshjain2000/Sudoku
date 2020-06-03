import java.util.Scanner;

public class Game_Sudoku extends Sudoku_Solver {

    public void printer(char [][]array)
   {
       System.out.print("\nSudoku looks like:\n");
       for(int i=0;i<9;i++)
       {
           for(int j=0;j<9;j++)
           {
               System.out.printf("%c ",array[i][j]);
           }
           System.out.print("\n");
       }
       return ;
   }

    public int counter(char [][]array)
    {
        int count = 0;
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
               if(array[i][j] == '.')
               {
                   count++;
               }
            }
        }
        return count;
    }

    public void duplicate(char[][]answer,char[][]sudo)
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                answer[i][j] = sudo[i][j];
            }
        }
    }

    public void game(char [][]sudo)
    {
        int x0,y0,count=0;
        char c0;
        char [][]answer = new char[9][9];
        duplicate(answer,sudo);
        count = counter(sudo);
        solveSudoku(answer);

        Scanner scan = new Scanner(System.in);

        while(true) {
            printer(sudo);
            System.out.println("For getting Solution of respective answer press 'Y' else to continue press 'N':");
            char indexchar = scan.next().charAt(0);
            if(indexchar == 'Y')
            {
                printer(answer);
                break;
            }
            System.out.print("tell the row you want to make changes and press enter: ");
            x0 = scan.nextInt();
            System.out.print("tell the column you want to make changes and press enter: ");
            y0 = scan.nextInt();
            System.out.print("Enter the digit and press enter: ");
            c0 = scan.next().charAt(0);
            if(answer[x0-1][y0-1] == c0) {
                count--;
                sudo[x0-1][y0-1] = c0;
                if(count == 0)
                {
                    System.out.println("yah! you win the game");
                    break;
                }
            }
            else{
                System.out.println("This is wrong please make it correct...");
            }
        }
        return ;
    }
};
