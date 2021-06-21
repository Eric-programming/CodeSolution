class Solution {
    public int findMinDifference(List<String> timePoints) {
        // Convert time to minutes
        int maxMinutes = 0;
        Set<Integer> set = new HashSet<>();
        for (String time : timePoints) {
            Integer minutes = convertToMinutes(time);
            maxMinutes = Math.max(minutes, maxMinutes);
            if (!set.add(minutes))
                return 0;
        }
        // From max minutes to 0 to find the min time difference
        Integer preMinutes = null, minDifference = Integer.MAX_VALUE;
        for (int curMinutes = maxMinutes; curMinutes >= 0; curMinutes--) {
            if (set.contains(curMinutes)) {
                if (preMinutes != null) {
                    minDifference = Math.min(minDifference, preMinutes - curMinutes);
                    minDifference = Math.min(minDifference, (curMinutes + 24 * 60) - preMinutes);
                }
                preMinutes = curMinutes;
            }
        }
        // Final Check
        minDifference = Math.min(minDifference, maxMinutes - preMinutes);
        minDifference = Math.min(minDifference, (preMinutes + 24 * 60) - maxMinutes);
        return minDifference;
    }

    private Integer convertToMinutes(String time) {
        String[] timeArr = time.split(":");// timeArr[0] = hour and timeArr[1] = minutes
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }
}
