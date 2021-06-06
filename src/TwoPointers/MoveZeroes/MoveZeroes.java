class Solution {
    public void moveZeroes(int[] nums) {
        //ap: Anchor pointer
        int ap = 0;
        //ep: Explore pointer
        int ep = 0;
        //n: length of the arr
        int n = nums.length;
        
        while(ep < n){
            if(nums[ap] != 0){
                //We move both pointers because we need to  prevent an example like this [1,0,1] where we could have ep < ap
                ap++;
                ep = ap;
            }else if(nums[ep] == 0){
                ep++;
            }else{
                //Current conditions: nums[ap] = 0 and nums[ep] != 0 so we swap
                int temp = nums[ap];
                nums[ap] = nums[ep];
                nums[ep] = temp;
            }
        }
    }
}
