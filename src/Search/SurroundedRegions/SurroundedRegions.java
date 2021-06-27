import java.util.*;

class Solution {
    final char temp = '#';
    final char X = 'X';
    final char O = 'O';
    int m, n;
    char[][] board;

    public void solve(char[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        // iterate the columns border to find O
        for (int row = 0; row < m; row++) {
            dfs(row, 0);
            dfs(row, n - 1);
        }
        // iterate the rows border to find O
        for (int col = 0; col < n; col++) {
            dfs(0, col);
            dfs(m - 1, col);
        }
        // traverse the grid to convert O to X
        for (int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++){
                if(board[row][col] == temp){
                    board[row][col] = O;
                }else if(board[row][col] == O){
                    board[row][col] = X;
                }
            }
        }
        
    }

    private void dfs(int row, int col) {
        if(row < 0 || row == m || col == n || col < 0) return;
        if(board[row][col] != O) return;
        board[row][col] = temp;
        //dfs all directions
        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }
}
