class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        //base case
        int n = intervals.length;
        if(n == 0) return true;
        
        //Sort array by start time 
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        //return false if there is overlapping
        for(int i = 0; i < n - 1; i++){
            int[] meeting1 = intervals[i];
            int[] meeting2 = intervals[i + 1];
            if(meeting1[1] > meeting2[0]){
                return false;
            }
        }
        return true;
    }
}
