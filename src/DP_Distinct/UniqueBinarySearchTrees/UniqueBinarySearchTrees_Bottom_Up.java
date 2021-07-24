class Solution {
    public int numTrees(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for(int curN = 2; curN <= n; curN++){
            int total = 0;
            for(int num = 1; num <= curN; num++){
                int leftNodes = num - 1;
                int leftTotalBST = cache[leftNodes];
                int rightNodes = curN - num;
                int rightTotalBST = cache[rightNodes];
                total += (leftTotalBST * rightTotalBST);
            }
            cache[curN] = total;
        }
        return cache[n];
    }
}
