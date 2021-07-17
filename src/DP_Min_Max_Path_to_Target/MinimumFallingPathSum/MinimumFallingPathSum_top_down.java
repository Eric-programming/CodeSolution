class Solution {
    int N;
    int[][] matrix;
    Integer[][] cache;
    public int minFallingPathSum(int[][] matrix) {
        this.N = matrix.length;
        this.matrix = matrix;
        cache = new Integer[N][N];
        int minPathSumToBottom = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            minPathSumToBottom = Math.min(minPathSumToBottom, helper(0,i));
        }
        return minPathSumToBottom;
    }
    private int helper(int row, int col){
        //base case
        if(row < 0 || row >= N || col < 0 || col >= N) return Integer.MAX_VALUE;
        
        if(row == N - 1) return matrix[row][col];
        
        if(cache[row][col] != null) return cache[row][col];
        
        int bottom = helper(row + 1, col);
        int bottomLeft = helper(row + 1, col - 1);
        int bottomRight = helper(row + 1, col + 1);
        
        int minPathSumToBottom = Math.min(bottom, Math.min(bottomLeft, bottomRight));
        
        cache[row][col] = minPathSumToBottom + matrix[row][col];
        
        return cache[row][col];
    }
}
