class Solution {
    int[] arr;
    Integer[] cache;
    public int coinChange(int[] coins, int amount) {
        arr = coins;
        cache = new Integer[amount + 1];
        return helper(amount);
    }
    private int helper(int amount){
        //base case
        if (amount == 0) return 0;
        //-1 mean not found
        if (amount < 0) return -1;
        if(cache[amount] != null){
            return cache[amount];
        }
        int min = Integer.MAX_VALUE;
        for(int num : arr){
            int res = helper(amount - num);
            if(res != -1){
                min = Math.min(min, res + 1);
            }
        }
        //If min is still MAX VALUE then we need -1 for min
        min = min == Integer.MAX_VALUE ? -1 : min;
        //if the amount = x, what is the minimum coins we need to make up this amount
        cache[amount] = min;
        return min;
    }
}
