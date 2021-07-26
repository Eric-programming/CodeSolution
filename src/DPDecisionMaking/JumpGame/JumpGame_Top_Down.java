class Solution {
    Boolean[] cache;
    int[] nums;
    public boolean canJump(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        this.cache = new Boolean[n];
        return dfs(0);
    }
    private boolean dfs(int index){
        //Base case
        if(nums.length - 1 <= index) return true;
        
        if(cache[index] != null) return cache[index];
        
        int maxJump = nums[index];
        
        for(int i = 1; i <= maxJump; i++){
            boolean res = dfs(index + i);
            if(res){
                cache[index] = true;
                return cache[index];
            }
        }
        return cache[index] = false;
    }
}
