public class MinimumSubsetSumDifferencTopDown {
    private int[] arr;
    private Integer[][] cache;

    // brute force
    public int solveMinimumDiff(int[] arr) {
        this.arr = arr;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        cache = new Integer[arr.length][sum + 1];
        return helper(0, 0, sum);
    }

    private int helper(int index, int leftSum, int rightSum) {
        int curDiff = getDiff(leftSum, rightSum);
        if (index >= arr.length)
            return curDiff;
        if (leftSum >= rightSum)
            return curDiff;
        if (cache[index][leftSum] != null)
            return cache[index][leftSum];

        int take = helper(index + 1, leftSum + arr[index], rightSum - arr[index]);
        int skip = helper(index + 1, leftSum, rightSum);
        cache[index][leftSum] = Math.min(take, skip);
        return cache[index][leftSum];
    }

    private int getDiff(int a, int b) {
        return Math.abs(a - b);
    }

    public static void main(String[] args) {
        /**
         * Input: {1, 2, 3, 9} Output: 3
         */
        MinimumSubsetSumDifferencTopDown test = new MinimumSubsetSumDifferencTopDown();
        System.out.println(test.solveMinimumDiff(new int[] { 1, 2, 3, 9 }));
        /**
         * Input: {1, 2, 7, 1, 5} Output: 0
         */

        System.out.println(test.solveMinimumDiff(new int[] { 1, 2, 7, 1, 5 }));

        /**
         * Input: {1, 3, 100, 4} Output: 92
         */
        System.out.println(test.solveMinimumDiff(new int[] { 1, 3, 100, 4 }));
    }
}
