class Solution {
    public int integerBreak(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 0;
        cache[2] = 1;
        for(int num = 3; num <= n; num++){
            for(int i = 1; i < num; i++){
                int curMaxProduct = Math.max(cache[num - i], num - i);
                cache[num] = Math.max(cache[num], curMaxProduct * i);
            }
        }
        return cache[n];
    }
}
