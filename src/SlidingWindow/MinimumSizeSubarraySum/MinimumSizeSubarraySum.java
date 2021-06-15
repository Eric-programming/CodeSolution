class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        
        //Define pointers
        int left = 0, n = nums.length, right = 0;
        
        int sum = 0;
        while(right < n){
            //Expand the window
            sum += nums[right];
            
            //Shrink the window
            while(target <= sum){
                int size = right - left + 1;
                minLen = Math.min(size, minLen);
                sum -= nums[left++];
            }
            
            right++;
        }
        
        if(minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}
