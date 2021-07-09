class Solution {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            hm.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int difference = target - nums[i];
            if(hm.containsKey(difference) && hm.get(difference) != i){
                return new int[]{hm.get(difference), i};
            }
        }
        return new int[] {-1,-1};
    }
}
