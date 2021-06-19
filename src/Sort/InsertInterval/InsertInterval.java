class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Stack<int[]> stack = new Stack<>();
        int n = intervals.length, i = 0;
        
        //Insert the new Interval at the correct position
        while(i <= n){
            //new interval compare with cur interval or there is no current interval
            if(i == n || newInterval[0] <= intervals[i][0]){
                //Add new interval on to stack if there no prev interval
                if(stack.isEmpty()){
                    stack.add(newInterval);
                }else if(newInterval[0] <= stack.peek()[1]){
                    //prev interval is in conflict with new interval
                    stack.peek()[1] = Math.max(stack.peek()[1], newInterval[1]);
                }else{
                    //prev interval is not in conflict with new interval
                    stack.add(newInterval);
                }
                break;
            }
            stack.add(intervals[i]);
            i++;
        }
        //add remaining intervals (fix the overlapping if necessary)
        for(int j = i; j < n; j++){
            int[] prev = stack.peek();
            if(intervals[j][0] <= prev[1]){
                prev[1] = Math.max(intervals[j][1], prev[1]);
            }else{
                stack.add(intervals[j]);
            }
        }
        
        return stack.toArray(new int[stack.size()][2]);
    }
}
