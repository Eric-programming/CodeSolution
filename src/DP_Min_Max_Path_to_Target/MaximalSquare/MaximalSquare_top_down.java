class Solution {
    private final char ONE = '1';
    private final char ZERO = '0';
    private char[][] matrix;
    private int m;
    private int n;
    private int maxWidth = Integer.MIN_VALUE;
    private Integer[][] cache;
    
    public int maximalSquare(char[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
        cache = new Integer[m][n];
        helper(0, 0);
        return maxWidth * maxWidth;
    }
    private int helper(int row, int col){
        //base case
        if(row >= m || col >= n) return 0;
        
        if(cache[row][col] != null) return cache[row][col];
        
        //each cell has 3 dfs path or 3 decisions
        int right = helper(row, col + 1);
        int rightDown = helper(row + 1, col + 1);
        int down = helper(row + 1, col);
        
        int curWidth = convertInt(matrix[row][col]);
        int minWidth = Math.min(right, Math.min(rightDown, down));
        if(curWidth == 1) {
           curWidth += minWidth;
        }
        cache[row][col] = curWidth;
        maxWidth = Math.max(curWidth, maxWidth);
        return curWidth;
    }
    private int convertInt(char element){
        if(element == ONE) return 1;
        return 0;
    }
}
