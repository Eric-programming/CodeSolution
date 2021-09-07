class Solution {
     public int maxProfit(int[] prices) {
            int n = prices.length;
            int[] maxProfitBuyStartAt = new int[n];
            for (int buy = n - 2; buy >= 0; buy--) {
                // What's the max profit if i buy at this position
                for (int sell = buy + 1; sell < n; sell++) {
                    if (prices[sell] < prices[buy])
                        continue;
                    int profit = prices[sell] - prices[buy];
                    if (sell + 2 < n) {
                        profit += maxProfitBuyStartAt[sell + 2];
                    }
                    maxProfitBuyStartAt[buy] = Math.max(maxProfitBuyStartAt[buy], profit);
                }
                // What's the max profit if i start buy at current position
                maxProfitBuyStartAt[buy] = Math.max(maxProfitBuyStartAt[buy], maxProfitBuyStartAt[buy + 1]);
            }
            return maxProfitBuyStartAt[0];
        }
    
}


/**
[1,2,3,0,2]
 ^ ^

[1,2,3,0,2]
       ^ ^
**/
