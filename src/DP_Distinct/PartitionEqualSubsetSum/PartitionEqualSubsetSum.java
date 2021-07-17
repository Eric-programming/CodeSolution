class Solution {
    Boolean[][] cache;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        //we need even sum
        int half = sum / 2;
        cache = new Boolean[nums.length][half + 1];
        for(int row = 0; row < cache.length; row++){
            cache[row][0] = true;
        }
        for(int curSum = 1; curSum < cache[0].length; curSum++){
            if(curSum == nums[0]){
                cache[0][curSum] = true;
            }else{
                cache[0][curSum] = false;
            }
        }
        for(int curNumIndex = 1; curNumIndex < cache.length; curNumIndex++){
            for(int curSum = 1; curSum < cache[0].length; curSum++){
                boolean take = false;
                int diff = curSum - nums[curNumIndex];
                if(diff >= 0){
                   take = cache[curNumIndex - 1][diff];
                }
                boolean skip = cache[curNumIndex - 1][curSum];
                cache[curNumIndex][curSum] = skip || take;
            }
        }
        return cache[nums.length - 1][half];
    }
}
