class Solution {
    Integer[] cache;
    public int numTrees(int n) {
        cache = new Integer[n + 1];
        return dfs(n);
    }
    private int dfs(int n){
        //Base case
        if(n < 2) return 1;
        
        //Check cache
        if(cache[n] != null) return cache[n];
        
        int total = 0;
        for(int curNum = 1; curNum <= n; curNum++){
            int leftN = curNum - 1;
            int leftTotalBST = dfs(leftN);
            int rightN = n - curNum;
            int rightTotalBST = dfs(rightN);
            total += (leftTotalBST * rightTotalBST);
        }
        
        cache[n] = total;
        return total;
    }
}
