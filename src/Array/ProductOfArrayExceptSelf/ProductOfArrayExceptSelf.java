class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        //Get prefix
        res[0] = 1;
        for(int i = 1; i < res.length; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        //Get product array except self
        int postFix = 1;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] *= postFix;
            postFix *= nums[i];
        }
        return res;
    }
}
