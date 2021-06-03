class Solution {
    public int pivotIndex(int[] nums) {
        //1. Get Sum of the array
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        //2. Define the leftSum & rightSum
        int leftSum = 0, rightSum = sum;
        
        //Find the pivot index
        for(int i = 0; i < nums.length; i++){
            rightSum -= nums[i];
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        //3. return -1 if can't find it
        return -1;
    }
}
