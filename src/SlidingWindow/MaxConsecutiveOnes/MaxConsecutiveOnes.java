class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        
        int left = 0;
        
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                left = right + 1;
            }else{
                maxLen = Math.max(right - left + 1, maxLen);
            }
        }
        
        return maxLen;
    }
}
