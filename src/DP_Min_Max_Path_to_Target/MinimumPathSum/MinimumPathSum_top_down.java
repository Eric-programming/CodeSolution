class Solution {
    int[][] grid;
    Integer[][] cache;
    int M;
    int N;
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        M = grid.length;
        N = grid[0].length;
        this.cache = new Integer[M][N];
        return helper(0,0);
    }
    private int helper(int row, int col){
        //base case
        if(row >= M || col >= N) return Integer.MAX_VALUE;
        
        //Found the bottom right
        if(row == M - 1 && col == N - 1) return grid[row][col];
        
        //Check if we pre computed
        if(cache[row][col] != null) return cache[row][col];
        
        //Minimum Path sum for right & down
        int right = helper(row, col + 1);
        int down = helper(row + 1, col);
        
        //Save the computed result
        cache[row][col] = Math.min(right, down) + grid[row][col];
        
        return cache[row][col];
        
    }
}
