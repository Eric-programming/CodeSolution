class Solution {
    public int maxProduct(int[] nums) {
        int max_so_far = nums[0], min_so_far = nums[0], res = nums[0];
        int N = nums.length;
        for(int i = 1; i < N; i++){
            int tempMax = max_so_far;
            max_so_far = Math.max(nums[i], Math.max(max_so_far * nums[i], min_so_far * nums[i]));
            min_so_far = Math.min(nums[i], Math.min(tempMax * nums[i], min_so_far * nums[i]));
            res = Math.max(res, max_so_far);
        }        
        return res;
    }
}
