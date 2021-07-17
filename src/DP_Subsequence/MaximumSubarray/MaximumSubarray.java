class Solution {
    public int maxSubArray(int[] nums) {
        int cur = nums[0], max = cur;
        for(int i = 1; i < nums.length; i++){
            cur = Math.max(cur + nums[i], nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }
}
