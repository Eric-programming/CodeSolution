class Solution {
    public int removeDuplicates(int[] nums) {
        //cp: current pointer points to current non duplicated item's index
        int cp = 0;
        //ep: explore pointer explores the next unique item's index
        int ep = 1;
        
        int n = nums.length;
        
        while(ep < n){
            if(nums[cp] == nums[ep]){
                ep++;
            }else{
                nums[++cp] = nums[ep++];
            }
        }
        return cp + 1;
    }
}
