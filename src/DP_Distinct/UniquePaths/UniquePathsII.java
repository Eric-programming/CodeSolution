class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] grid = obstacleGrid;
        int m = grid.length, n = grid[0].length;
        int[][] cache = new int[m + 1][n + 1];
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(grid[i][j] == 1) continue;
                if(i == m - 1 && j == n - 1){
                    cache[i][j] = 1;
                }else{
                    int bottom = cache[i + 1][j];
                    int right = cache[i][j + 1];
                    cache[i][j] = bottom + right;
                }
            }
        }
        return cache[0][0];
    }
}
