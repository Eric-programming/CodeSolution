class Solution {
    public int change(int amount, int[] coins) {
        int N = coins.length, A = amount;
        int[][] cache = new int[N][A + 1];
        //Build the first row
        cache[0][0] = 1;
        for(int col = 1; col <= A; col++){
            int remainAmount = col - coins[0];
            if(remainAmount < 0) continue;
            cache[0][col] = cache[0][remainAmount]; 
        }
        //Build the remaining rows
        for(int row = 1; row < N; row++){
            cache[row][0] = 1;
            for(int col = 1; col <= A; col++){
                int skip = cache[row - 1][col];
                int take = 0;
                if(col - coins[row] >= 0){
                    take = cache[row][col - coins[row]];
                }
                int totalUniqueWays = skip + take;
                cache[row][col] = totalUniqueWays;
            }
        }
        return cache[N - 1][A];
    }
}
