public class MinimumSubsetSumDifferenceBruteForce {
    public MinimumSubsetSumDifferenceBruteForce() {
    }

    private int[] arr;

    // brute force
    public int solveMinimumDiff(int[] arr) {
        this.arr = arr;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return helper(0, 0, sum);
    }

    private int helper(int index, int leftSum, int rightSum) {
        int curDiff = getDiff(leftSum, rightSum);
        if (index >= arr.length)
            return curDiff;
        if (leftSum >= rightSum)
            return curDiff;

        int take = helper(index + 1, leftSum + arr[index], rightSum - arr[index]);
        int skip = helper(index + 1, leftSum, rightSum);
        return Math.min(take, skip);
    }

    private int getDiff(int a, int b) {
        return Math.abs(a - b);
    }

    public static void main(String[] args) {
        /**
         * Input: {1, 2, 3, 9} Output: 3
         */
        MinimumSubsetSumDifferenceBruteForce test = new MinimumSubsetSumDifferenceBruteForce();
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
