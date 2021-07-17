class Solution {
    int N;
    int[][] matrix;
    public int minFallingPathSum(int[][] matrix) {
        this.N = matrix.length;
        this.matrix = matrix;
        for(int row = N - 2; row >= 0; row--){
            for(int col = 0; col < N; col++){
                int bottom = helper(row + 1, col);
                int bottomLeft = helper(row + 1, col - 1);
                int bottomRight = helper(row + 1, col + 1);
                matrix[row][col] = Math.min(bottom, Math.min(bottomLeft, bottomRight)) + matrix[row][col];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            min = Math.min(min, matrix[0][i]);
        }
        return min;
    }
    private int helper(int row, int col){
        if(row < 0 || row >= N || col < 0 || col >= N) return Integer.MAX_VALUE;
        return matrix[row][col];
    }
}
