class Solution {
    public int findMin(int[] nums) {
        //define pointers
        int L = 0, N = nums.length, R = N - 1;
        //base case: if array is already sorted & not rotated
        if(nums[L] < nums[R]) return nums[L];
        
        //binary search
        while(L + 1 < R){
            int mid = (L + R)/2;
            //1. if nums[mid] < nums[R] then min is at the left side
            if(nums[mid] < nums[R]){
                R = mid;
            }
            //2. if nums[mid] > nums[R] then min is at the right side
            else{
                L = mid;
            }
        }
        
        
        //return the smallest value between nums[L] and nums[R]
        return Math.min(nums[R], nums[L]);
    }
}
