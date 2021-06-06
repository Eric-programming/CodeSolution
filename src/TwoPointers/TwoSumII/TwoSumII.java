class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int L = 0, R = n - 1;
        while(L < R){
            int curSum = numbers[L] + numbers[R];
            if(curSum == target){
                return new int[] { L + 1, R + 1};
            }else if(curSum < target){
                L++;
            }else{
                R--;
            }
        }
        return new int[] {-1, -1};
    }
}
