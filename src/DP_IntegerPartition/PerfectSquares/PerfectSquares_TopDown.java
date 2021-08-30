class Solution {
    Integer[] cache;
    public int numSquares(int n) {
        cache = new Integer[n + 1];
        return dfs(n);
    }
    private int dfs(int n){
        //base case
        if(n == 0) return 0;
        
        if(cache[n] != null) return cache[n];
        
        cache[n] = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++){
            cache[n] = Math.min(cache[n], dfs(n - (i * i)) + 1);
        }
        return cache[n];
    }
}
