class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCounter = 0;
        int left = 0, right = 0, n = nums.length;
        int maxLen = 0;
        
        while(right < n){
            //Expand the window
            if(nums[right] == 0){
                zeroCounter++;
            }
            
            //Shrink the window ONLY if zeroCounter is bigger than k
            while(zeroCounter > k){
                if(nums[left++] == 0){
                    zeroCounter--;
                }
            }
            
            //update the maxLen
            maxLen = Math.max(maxLen, right - left + 1);
            
            //move the right pointer one to the right
            right++;
        }
        
        return maxLen;
    }
}
