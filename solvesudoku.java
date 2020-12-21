/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudukoswing;

/**
 *
 * @author raj
 */
public class solvesudoku {
    private int[][] newboard;
    private int size;

    public solvesudoku(int N) {
        size=N;
    }
    public int[][] getboard()
    {
        return newboard;
    }
    
    //Method for a backtracking algorithm specific to Sudoku boards
    //Returns true or false based on whether it has a solution or not.
    public boolean backtrack(int[][] board)
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]==0)
                {
                    for(int k=1;k<=9;k++)
                    {
                        if(validrow(board,i,k)&&validcol(board,j,k)&&validsq(board,i-i%3,j-j%3,k))
                        {
                            board[i][j]=k;
                            if(backtrack(board))
                            {
                                newboard=board;
                                return true;
                            }
                            else
                            {
                                board[i][j]=0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    /*  Determines if starting state of a Sudoku board is valid. Returns true if yes, false if no.
    board: NxN array representing Soduko board*/
    public boolean validateboard(int[][] board)
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(board[i][j]!=0)
                {
                    int[][]tempboard=new int[size][size];  // tempBoard will be the cloned board for testing
                    for(int t=0;t<size;t++)
                    {
                        tempboard[t]=board[t].clone();
                    }
                    tempboard[i][j]=0;
                    if(!validrow(tempboard,i,board[i][j]) || !validcol(tempboard,j,board[i][j]) || !validsq(tempboard,i-i%3,j-j%3,board[i][j]))
                    {
                        return false;
                    }
                    
                }
                
            }
        }
        return true;   
    }
    /*  Determines whether the candidate number can be placed in a row by traversing it; must not already be present.
    board: NxN array representing Soduko board
    i: number representing selected row
    candidate: number to test if valid in this row*/
    private boolean validrow(int[][] board, int i, int candidate)
    {
        for(int j=0;j<size;j++)
        {
            if(board[i][j]==candidate)
            {
                return false;
            }
        }
        return true;
    }
    /*  Determines whether the candidate number can be placed in a column by traversing it; must not already be present.
    board: NxN array representing Soduko board
    j: integer representing selected column
    candidate: number to test if valid in this column*/
    private boolean validcol(int[][] board, int j, int candidate)
    {
        for(int i=0;i<size;i++)
        {
            if(board[i][j]==candidate)
            {
                return false;
            }
        }
        return true;
    }
    /*  Determines whether the candidate number can be placed in a 3x3 Sudoku square area; must not already be present.
    board: NxN array representing Soduko board
    topI: integer representing the top row of this Sudoku square
    leftJ: integer representing the left most column of this Sudoku square*/
    private boolean validsq(int[][] board, int topI, int leftJ, int candidate)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[topI+i][leftJ+j]==candidate)
                {
                    return false;
                }
            }
        }
        return true;
    } 
}
