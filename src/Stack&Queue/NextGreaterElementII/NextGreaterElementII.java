class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        //Add all next greater element for each element onto res
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                res[stack.pop()] = nums[i];
            }
            //Stack is in decreasing order
            stack.add(i);
        }
        //circle back one more loop
        for(int num : nums){
            while(!stack.isEmpty() && nums[stack.peek()] < num){
                int curIdx = stack.pop();
                res[curIdx] = num; // cur num is the next greater element
            }
            if(stack.isEmpty()) break;
        }
        return res;
    }
}
