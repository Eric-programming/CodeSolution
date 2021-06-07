class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, n = nums.length, right = n - 1, index = n - 1;
        
        int[] res = new int[n];
        
        while(0 <= index){
            int leftNum = nums[left] * nums[left];
            int rightNum = nums[right] * nums[right];
            if(leftNum < rightNum){
                res[index--] = rightNum;
                right--;
            }else{
                left++;
                res[index--] = leftNum;
            }
        }
        return res;
    }
}
