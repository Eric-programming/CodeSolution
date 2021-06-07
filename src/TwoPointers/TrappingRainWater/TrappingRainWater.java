class Solution {
    public int trap(int[] height) {
        //Define the maps
        int N = height.length;
        
        int[] LeftHighest = new int[N];
        int[] RightHighest = new int[N];
        
        int max = 0;
        //Find the left max value excluding current element
        for(int i = 0; i < N; i++){
            LeftHighest[i] = max;
            max = Math.max(height[i], max);
        }
        max = 0;
        
        //Find the right max value excluding current element
        for(int i = N - 1; i >= 0; i--){
            RightHighest[i] = max;
            max = Math.max(height[i], max);
        }
        
        //Find the total water units
        int total = 0;
        for(int i = 0; i < N; i++){
            int maxLeftHeight = LeftHighest[i];
            int maxRightHeight = RightHighest[i];
            int minHeight = Math.min(maxLeftHeight, maxRightHeight);
            int waterUnits = minHeight - height[i];
            if(waterUnits > 0){
                total += waterUnits;
            }
        }
        return total;
    }
}
