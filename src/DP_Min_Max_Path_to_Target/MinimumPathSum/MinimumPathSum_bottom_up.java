class Solution {
    public int minPathSum(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        Integer[][] cache = new Integer[M][N];
        cache[0][0] = grid[0][0];
        //Build the first row
        for(int col = 1; col < N; col++){
            cache[0][col] = cache[0][col - 1] + grid[0][col];
        }
        //Build the remaining rows
        for(int row = 1; row < M; row++){
            //define the first element
            cache[row][0] = grid[row][0] + cache[row - 1][0];

            //compute the remaining elements
            for(int col = 1; col < N; col++){
                int top = cache[row - 1][col];
                int left = cache[row][col - 1];
                cache[row][col] = Math.min(top, left) + grid[row][col];
            }
        }
        return cache[M - 1][N - 1];
    }
}
