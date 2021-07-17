class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[] cache = new int[N];
        
        cache[N - 1] = 1;
        int maxLIS = 1;
        
        for(int i = N - 2; i >= 0; i--){
            int maxLISForRemainingElements = 0;
            int curVal = nums[i];
            for(int j = i + 1; j < N; j++){
                if(curVal < nums[j]){
                    maxLISForRemainingElements = Math.max(maxLISForRemainingElements, cache[j]);
                }
            }
            cache[i] = maxLISForRemainingElements + 1;
            maxLIS = Math.max(maxLIS, cache[i]);
        }
        
        return maxLIS;
    }
}
