class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;//Keep track min price
        int maxProfit = 0;//Keep track of maxprofit
        int sum = 0;//track the max total profit
        for(int num : prices){
            minPrice = Math.min(minPrice, num);
            maxProfit = Math.max(maxProfit, num - minPrice);
            if(maxProfit > 0){
                sum += maxProfit;
                //reset to find new profit
                maxProfit = 0;
                minPrice = num;
            }
        }
        return sum;
    }
}
