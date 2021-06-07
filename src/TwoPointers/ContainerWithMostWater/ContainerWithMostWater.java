class Solution {
    public int maxArea(int[] height) {
        int L = 0, N = height.length, R = N - 1;
        int maxArea = 0;
        while(L < R){
            int maxHeight = Math.min(height[L], height[R]);
            int area = maxHeight * (R - L);
            maxArea = Math.max(area, maxArea);
            if(height[L] < height[R]){
                L++;
            }else{
                R--;
            }
        }
        return maxArea;
    }
}
