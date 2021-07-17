class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] cache = new int[target + 1];
        cache[0] = 1;
        for(int i = 1; i < target + 1; i++){
            int curSum = i;
            for(int num : nums){
                if(curSum - num >= 0){
                    cache[curSum] += cache[curSum - num];
                }
            }
        }
        return cache[target];
    }
}
