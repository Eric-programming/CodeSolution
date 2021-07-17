class Solution {
    int[] cost;
    Integer[] cache;
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        this.cache = new Integer[cost.length];
        int one = helper(0);
        this.cache = new Integer[cost.length];
        int two = helper(1);
        return Math.min(one, two);
    }
    private int helper(int index){
        if(index >= cost.length) return 0;
        if(cache[index] != null) return cache[index];
        int takeStep1 = helper(index + 1);
        int takeStep2 = helper(index + 2);
        cache[index] = Math.min(takeStep1, takeStep2) + cost[index];
        return cache[index];
    }
}
