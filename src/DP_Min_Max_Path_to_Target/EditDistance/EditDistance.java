class Solution {
    public int minDistance(String word1, String word2) {
        //Define Vars
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int m = s1.length, n = s2.length;
        int[][] cache = new int[m + 1][n + 1];
        
        //Build the first row
        for(int i = 0; i < n + 1; i++){
            cache[0][i] = i;
        }
        //Build the remaining rows
        for(int i = 1; i < m + 1; i++){
            cache[i][0] = i;
            for(int j = 1; j < n + 1; j++){
                if(s1[i - 1] == s2[j - 1]){
                    cache[i][j] = cache[i - 1][j - 1];
                }else{
                    int replace = cache[i - 1][j - 1];
                    int delete = cache[i - 1][j];
                    int insert = cache[i][j - 1];
                    cache[i][j] = Math.min(replace, Math.min(delete, insert)) + 1;
                }
            }
        }
        return cache[m][n];
    }
}
