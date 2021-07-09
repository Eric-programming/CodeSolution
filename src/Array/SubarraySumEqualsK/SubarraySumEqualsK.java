class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int curSum = 0;
        hm.put(0, 1);
        int Counter = 0;
        for(int i = 0; i < nums.length; i++){
            curSum += nums[i];
            int ps2 = curSum - k;
            if(hm.containsKey(ps2)){
                Counter += hm.get(ps2);
            }
            hm.put(curSum, hm.getOrDefault(curSum, 0) + 1);
        }
        return Counter;
    }
}
