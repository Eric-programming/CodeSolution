class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        Stack<int[]> stack = new Stack<>();
        
        stack.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++){
            int[] preInterval = stack.peek();
            
            //Merge the interval if in conflict
            if(intervals[i][0] <= preInterval[1]){
                preInterval[1] = Math.max(intervals[i][1], preInterval[1]);
            }else{
                //Add the interval onto the stack if not
                stack.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        
        return stack.toArray(new int[stack.size()][2]);
    }
}
