class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int left = 0, right = 0, n = nums.length;
        List<Integer> res = new ArrayList<>();
        while(right < n){
            //Expand the window
            while(!deque.isEmpty() && deque.peekLast() < nums[right]){
                deque.pollLast();
            }
            deque.offerLast(nums[right]);
            
            //Shrink the window
            if(k <= right - left + 1){
                //Get the max in current window
                res.add(deque.peekFirst());
                
                //update the deque
                if(deque.peekFirst() == nums[left++]){
                    deque.pollFirst();
                }
            }
            
            right++;
        }
        
        //Convert to int[]
        int[] resArr = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
