class Solution {
    public void nextPermutation(int[] nums) {
        //Base case
        int n = nums.length;
        if(n < 2) return;
        
        //Step 1: find elements to replace
        int cur = n - 2, pre = n - 1;
        while(0 <= cur){
            if(nums[cur] < nums[pre]) break;
            cur--;
            pre--;
        }
        if(0 <= cur){
            int replaceIndex = n - 1;
            while(0 < replaceIndex){
                if(nums[cur] < nums[replaceIndex]) break;
                replaceIndex--;
            } 
            swap(nums, replaceIndex, cur);
        }
        reverse(nums, pre, n - 1);
    }
    private void swap(int[] nums, int i1, int i2){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
