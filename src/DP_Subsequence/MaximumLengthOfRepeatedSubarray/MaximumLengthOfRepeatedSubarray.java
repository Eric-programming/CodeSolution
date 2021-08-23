class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] cache = new int[m + 1][n + 1];
        int maxValue = 0;
        for(int row = 1; row <= m; row++){
            for(int col = 1; col <= n; col++){
                int num1 = nums1[row - 1];
                int num2 = nums2[col - 1];
                if(num1 == num2){
                    cache[row][col] = cache[row - 1][col - 1] + 1;
                }
                maxValue = Math.max(maxValue, cache[row][col]);
            }
        }
        return maxValue;
    }
}
