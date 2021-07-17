class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for(int[] row: cache){
            Arrays.fill(row, 1);
        }
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                int bottom = cache[i + 1][j];
                int right = cache[i][j + 1];
                cache[i][j] = bottom + right;
            }
        }
        return cache[0][0];
    }
}
