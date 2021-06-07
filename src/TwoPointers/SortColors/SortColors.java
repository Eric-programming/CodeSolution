class Solution {
    public void sortColors(int[] nums) {
        //pz: pointer zero
        int pz = 0;
        //po: pointer one
        int po = 0;
        //pt: pointer two
        int pt = nums.length - 1;
        
        while(po <= pt){
            if(nums[po] == 2){
                swap(nums, po, pt);
                pt--;
            }else if(nums[po] == 0){
                swap(nums, po, pz);
                po++;
                pz++;
            }else{
                po++;
            }
        }
    }
    private void swap(int[] nums, int p1, int p2){
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
