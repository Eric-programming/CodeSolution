class Solution {
    public int climbStairs(int n) {
        if(n < 4) return n;
        int prev1 = 3, prev2 = 2, curUniqueWays = 0;
        for(int i = 4; i <= n; i++){
            //current unique way = previous unique ways + second previous unique ways
            curUniqueWays = prev2 + prev1;
            prev2 = prev1;
            prev1 = curUniqueWays;
        }
        return curUniqueWays;
    }
}
