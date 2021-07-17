class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m + 1][n + 1];
        
        int maxWidth = 0;
        
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    int top = cache[i - 1][j];
                    int left = cache[i][j - 1];
                    int topLeft = cache[i - 1][j - 1];
                    int min = Math.min(top, Math.min(left, topLeft));
                    cache[i][j] = min + 1;
                    
                    //Update the max width
                    maxWidth = Math.max(maxWidth, cache[i][j]);
                }
            }
        }
        return maxWidth * maxWidth;
    }
}
