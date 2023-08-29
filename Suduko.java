package CryptoLapp;

public class Suduko {
   
    private static final int grid = 9;
   
    private static boolean isNumberInRow(int[][] board,int number,int row)
    {
        for(int i=0;i<grid;i++)
        {
            if(board[row][i] == number)
                return true;
        }
        return false;
    }
   
    private static boolean isNumberInCol(int[][] board,int number,int col)
    {
        for(int i=0;i<grid;i++)
        {
            if(board[i][col] == number)
                return true;
        }
        return false;
    }
   
    private static boolean isNumberInBox(int[][] board,int number,int row,int col)
    {
        int boxrow = row - row%3;
        int boxcol = col - col%3;
       
        for(int i=boxrow;i<boxrow+3;i++)
        {
            for(int j=boxcol;j<boxcol+3;j++)
            {
                if(board[i][j] == number)
                    return true;
            }
        }
        return false;
    }
   
    private static boolean isValidPlacement(int[][] board,int number,int row,int col)
    {
        return !isNumberInRow(board,number,row) &&
        !isNumberInCol(board,number,col) &&
        !isNumberInBox(board,number,row,col);
    }
   
    private static boolean solveBoard(int[][] board)
    {
        for(int i=0;i<grid;i++)
        {
            for(int j=0;j<grid;j++)
            {
                if(board[i][j] == 0)
                {
                    for(int k=1;k<=grid;k++)
                    {
                        if(isValidPlacement(board,k,i,j))
                        {
                            board[i][j] = k;
                            if(solveBoard(board))
                                return true;
                            else
                                board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
   
    private static void printBoard(int[][] board)
    {
        for(int i=0;i<grid;i++)
        {
            if(i%3 == 0 && i != 0)
                System.out.println("-----------");
            for(int j=0;j<grid;j++)
            {
                if(j%3 == 0 && j!=0)
                    System.out.print("|");
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
   
    public static void main(String args[]) {
       
        int[][] board = {
          {7,0,2,0,5,0,6,0,0},
          {0,0,0,0,0,3,0,0,0},
          {1,0,0,0,0,9,5,0,0},
          {8,0,0,0,0,0,0,9,0},
          {0,4,3,0,0,0,7,5,0},
          {0,9,0,0,0,0,0,0,8},
          {0,0,9,7,0,0,0,0,5},
          {0,0,0,2,0,0,0,0,0},
          {0,0,7,0,4,0,2,0,3}
        };
   
        if(solveBoard(board))
            System.out.println("Solved Successfully");
        else
            System.out.println("Unsolved Board :( ");
       
        System.out.println();    
        printBoard(board);

    }
}