class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        // Add each element's in nums2 next greater element onto the table
        for(Integer num : nums2){
            while(!stack.isEmpty() && stack.peek() < num){
                    map.put(stack.pop(), num);
            }
            if(stack.isEmpty() || num <= stack.peek()){
                stack.add(num);
            }
        }
        //Add remaining elements onto the table
        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        // Add each element's in nums1 next greater element onto the result arr
        int[] res = new int[nums1.length];
        int i = 0;
        for(Integer num : nums1){
            res[i++] = map.get(num);
        }
        return res;
    }
}
