class Solution {
    public int removeDuplicates(int[] nums) {
        boolean seenDup = false;
        //cp: current pointer points to current non duplicated item's index
        int cp = 0;
        //ep: explore pointer explores the next unique item's index
        int ep = 1;
        int n = nums.length;
        
        while(ep < n){
            if(nums[cp] == nums[ep]){
                if(seenDup){
                    ep++;
                }else{
                    seenDup = true;
                    cp++;
                    nums[cp] = nums[ep];
                    ep++;
                }
            }else{
                nums[++cp] = nums[ep++];
                seenDup = false;
            }
        }
        
        return cp + 1;
    }
}

//0,0,1,1,2,3,2,3,3
//          ^     ^
