class Solution {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        // Base case
        if (N == 1)
            return 1;

        int[] cacheLIS = new int[N], cacheFreq = new int[N];
        cacheLIS[N - 1] = 1;
        cacheFreq[N - 1] = 1;
        int maxLIS = 1;

        for (int i = N - 2; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (nums[i] < nums[j]) {
                    if (cacheLIS[i] < cacheLIS[j]) {
                        cacheLIS[i] = cacheLIS[j];
                        cacheFreq[i] = cacheFreq[j];
                    } else if (cacheLIS[i] == cacheLIS[j]) {
                        cacheFreq[i] += cacheFreq[j];
                    }
                }
            }
            cacheLIS[i]++;
            cacheFreq[i] = Math.max(cacheFreq[i], 1);
            maxLIS = Math.max(maxLIS, cacheLIS[i]);
        }
        int total = 0;
        for (int i = 0; i < N; i++) {
            if (cacheLIS[i] == maxLIS) {
                total += cacheFreq[i];
            }
        }
        return total;
    }
}

/**
1,3,5,4,7
      ^

4,3,2,2,1

2,2,1,1,1
**/
