class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //Sort the array
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);
        
        int[] pre = intervals[0];
        int erase = 0;
        
        for(int i = 1; i < intervals.length; i++){
            //Check if there is overlapping with the pre interval
            if(intervals[i][0] < pre[1]){
                if(intervals[i][1] < pre[1]){
                    pre = intervals[i];
                }
                erase++;
            }else if(pre[1] <= intervals[i][0]){
                //No overlapping
                pre = intervals[i];
            }
        }
        return erase;
    }
}
