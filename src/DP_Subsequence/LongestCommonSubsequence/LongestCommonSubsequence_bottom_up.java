class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int t1 = text1.length(), t2 = text2.length();
        int[][] cache = new int[t1 + 1][t2 + 1];
        char[] t1Arr = text1.toCharArray();
        char[] t2Arr = text2.toCharArray();
        for(int i = 0; i < t1 + 1; i++){
            for(int j = 0; j < t2 + 1; j++){
                if(j == 0 || i == 0) continue;
                if(t1Arr[i - 1] == t2Arr[j - 1]){
                    cache[i][j] = 1 + cache[i - 1][j - 1];
                }else{
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
                }
            }
        }
        return cache[t1][t2];
    }
}
