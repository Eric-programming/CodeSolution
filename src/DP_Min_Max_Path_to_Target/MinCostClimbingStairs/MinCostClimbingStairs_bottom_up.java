class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev1 = 0, prev2 = 0;
        int N = cost.length;
        for(int i = N - 1; i >= 0; i--){
            int minCostForCurrentStair = Math.min(prev1, prev2) + cost[i];
            prev2 = prev1;
            prev1 = minCostForCurrentStair;
            
        }
        return Math.min(prev2, prev1);
    }
}
