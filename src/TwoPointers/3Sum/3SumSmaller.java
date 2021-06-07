class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int N = nums.length;
        Arrays.sort(nums);
        int Counter = 0;
        for(int i = 0; i < N; i++){
            // if(i != 0 && nums[i] == nums[i-1]) continue;
            int L = i + 1, R = N - 1;
            while(L < R){
                int curSum = nums[i] + nums[L] + nums[R];
                if(curSum < target){
                    Counter += R - L;
                    L++;
                }else{
                    R--;
                }
            }
        }
        return Counter;
    }
}
