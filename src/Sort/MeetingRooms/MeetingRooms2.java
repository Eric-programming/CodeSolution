class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //sort array by the start time
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);
        
        //min heap to keep track of the end time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        //find min rooms
        minHeap.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            if(minHeap.peek() <= cur[0]){
                minHeap.poll();
            }
            minHeap.add(cur[1]);
        }
        //return min rooms
        return minHeap.size();
    }
}
