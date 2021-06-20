class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        Stack<int[]> stack = new Stack<>();// O(1) insertion
        int p1 = 0, n1 = firstList.length, p2 = 0, n2 = secondList.length;

        while (p1 < n1 && p2 < n2) {
            int[] p1Interval = firstList[p1];
            int[] p2Interval = secondList[p2];
            // Add interval intersection
            if (isInConflict(p1Interval, p2Interval)) {
                int start = Math.max(p1Interval[0], p2Interval[0]);
                int end = Math.min(p2Interval[1], p1Interval[1]);
                int[] intersection = { start, end };
                stack.add(intersection);
            }

            // move the pointer with the smallest end time
            if (p1Interval[1] < p2Interval[1]) {
                p1++;
            } else {
                p2++;
            }
        }

        return stack.toArray(new int[stack.size()][2]);
    }

    private boolean isInConflict(int[] p1Interval, int[] p2Interval) {
        // Example: p1 = [5,10] p2 = [1,5]
        if (p2Interval[0] <= p1Interval[1] && p1Interval[0] <= p2Interval[1])
            return true;
        // Example: p1 = [1,5] p2 = [5,10]
        if (p1Interval[0] <= p2Interval[1] && p2Interval[0] <= p1Interval[1])
            return true;
        return false;
    }
}
