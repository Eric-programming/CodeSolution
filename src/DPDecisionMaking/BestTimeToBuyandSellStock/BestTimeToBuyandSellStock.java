class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if(N < 2) return 0;
        int min = prices[0], maxP = 0;
        for(int i = 1; i < N; i++){
            maxP = Math.max(prices[i]-min, maxP);
            min = Math.min(prices[i], min);
        }
        return maxP;
    }
}
/**
[7,6,6,6,6,4]
[7,1,5,3,6,4]
**/
