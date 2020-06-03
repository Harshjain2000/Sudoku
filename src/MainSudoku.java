import java.util.Scanner;
import java.io.*;
import java.lang.*;
public class MainSudoku{

    public static void main(String[] args) {
        char[][][] arry = {{{'9', '.', '.','.','.','.','.','.','7'},
                {'.','2','.','8','.','3','.','4','.'},
                {'1','7','.','.','4','.','.','2','8'},
                {'.','.','5','.','.','.','8','.','.'},
                {'.','4','.','2','5','6','.','1','.'},
                {'.','3','1','.','.','.','4','6','.'},
                {'.','1','9','.','6','.','7','8','.'},
                {'.','5','.','.','.','.','.','9','.'},
                {'7','.','.','4','1','9','.','.','3'}}};
        Game_Sudoku g = new Game_Sudoku();
        System.out.println("If you want to play the mysterious game of sudoku:: press :Y\nOtherwise :N\n");

        Scanner scan = new Scanner(System.in);
        char c = scan.next().charAt(0);

        switch (c) {
            case 'Y':
                System.out.println("Game starts Now...\n");
                g.game(arry[0]);
                break;

            case 'N':
                System.out.println("Alright you exited the game.....");
                break;

            default:
            System.out.println("please press 'Y' or 'N' to start or end respectively...\n");
                break;
        }
    }
};
