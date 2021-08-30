class Solution {
    Integer[] cache;

    public int integerBreak(int n) {
        cache = new Integer[n + 1];
        return dfs(n);
    }

    private int dfs(int n) {
        if (n < 2)
            return 0;

        if (cache[n] != null)
            return cache[n];

        int maxProductForN = 0;
        for (int i = 1; i < n; i++) {
            int curMaxProduct = Math.max(dfs(n - i), n - i);
            maxProductForN = Math.max(curMaxProduct * i, maxProductForN);
        }
        cache[n] = maxProductForN;
        return maxProductForN;
    }
}
