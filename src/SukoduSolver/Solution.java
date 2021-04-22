class Solution {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    int printTimes = 30;

    public static void main(String[] args) {
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        Solution sln = new Solution();
        sln.solveSudoku(board);
    }

    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        helper(0, 0);
    }

    private boolean helper(int row, int col) {
        if (col == 9) {
            row += 1;
            col = 0;
        }
        if (row == 9)
            return true;
        if (board[row][col] != '.') {
            return helper(row, col + 1);
        }
        for (char i = '1'; i <= '9'; i++) {
            if (!isValid(row, col, i))
                continue;
            board[row][col] = i;
            printBoard("Make a decision", row, col);
            if (helper(row, col + 1) == true)
                return true;
            board[row][col] = '.';
            printBoard("Unchoose a decision", row, col);
        }
        return false;
    }

    private void printBoard(String message, int row, int col) {
        if (printTimes == 0)
            return;
        printTimes--;
        System.out.println(message);
        System.out.println(ANSI_RED + "------------------" + ANSI_RESET);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == row && j == col) {
                    System.out.print(ANSI_RED + "" + board[i][j] + " " + ANSI_RESET);
                } else {
                    System.out.print(board[i][j] + " ");
                }
                if (j == 2 || j == 5) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    private boolean isValid(int row, int col, char cur) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == cur)
                return false;
            if (board[i][col] == cur)
                return false;
        }
        int[] rowBorder = findSE(row);
        int[] colBorder = findSE(col);

        for (int i = rowBorder[0]; i <= rowBorder[1]; i++) {
            for (int j = colBorder[0]; j <= colBorder[1]; j++) {
                if (board[i][j] == cur)
                    return false;
            }
        }
        return true;
    }

    private int[] findSE(int coor) {
        int[] res = new int[2];
        if (coor < 3) {
            res[1] = 2;
        } else if (coor < 6) {
            res[0] = 3;
            res[1] = 5;
        } else if (coor < 9) {
            res[0] = 6;
            res[1] = 8;
        }
        return res;
    }
}