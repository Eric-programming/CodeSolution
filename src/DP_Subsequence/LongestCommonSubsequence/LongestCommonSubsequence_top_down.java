class Solution {
    String text1;
    String text2;
    Integer[][] cache;

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        int t1 = text1.length();
        int t2 = text2.length();
        cache = new Integer[t1 + 1][t2 + 1];
        return helper(t1, t2);
    }

    public int helper(int t1, int t2) {
        if (t1 == 0 || t2 == 0)
            return 0;
        if (cache[t1][t2] != null)
            return cache[t1][t2];
        if (text1.charAt(t1 - 1) == text2.charAt(t2 - 1)) {
            return 1 + helper(t1 - 1, t2 - 1);
        }
        int opt1 = helper(t1 - 1, t2);
        int opt2 = helper(t1, t2 - 1);
        cache[t1][t2] = Math.max(opt1, opt2);
        return cache[t1][t2];
    }
}
