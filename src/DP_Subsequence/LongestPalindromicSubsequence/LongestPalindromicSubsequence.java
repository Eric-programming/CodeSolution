class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] arr = s.toCharArray();
        
        int N = arr.length;
        
        int[][] cache = new int[N][N];
        
        for(int i = N - 1; i >= 0; i--){
            cache[i][i] = 1;
            for(int j = i + 1; j < N; j++){
                if(arr[i] == arr[j]){
                    cache[i][j] = 2;
                    if(i + 1 < j){
                        cache[i][j] += cache[i + 1][j - 1];
                    }
                }else{
                    cache[i][j] = Math.max(cache[i + 1][j], cache[i][j - 1]);
                }
            }
        }
        return cache[0][N - 1];
    }
}
