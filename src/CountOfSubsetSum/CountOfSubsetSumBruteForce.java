package CountOfSubsetSum;

public class CountOfSubsetSumBruteForce {
    private int[] arr;

    public CountOfSubsetSumBruteForce(int[] arr) {
        this.arr = arr;
    }

    public int SolveCountOfSubsetSum(int num) {
        return helper(0, num);
    }

    private int helper(int index, int curSum) {
        if (curSum == 0)
            return 1;
        if (curSum < 0 || index >= arr.length)
            return 0;

        int take = helper(index + 1, curSum - arr[index]);
        int skip = helper(index + 1, curSum);
        return skip + take;
    }

    public static void main(String[] args) {
        /**
         * Input: values = [1, 1, 2, 3] sum = 4
         * 
         * Output: 3
         */
        CountOfSubsetSumBruteForce test0 = new CountOfSubsetSumBruteForce(new int[] { 1, 1, 2, 3 });
        System.out.println(test0.SolveCountOfSubsetSum(4));// <--- expect 3

        /**
         * Input: values = [1, 2, 7, 1, 5] sum = 9
         * 
         * Output: 3
         */

        CountOfSubsetSumBruteForce test1 = new CountOfSubsetSumBruteForce(new int[] { 1, 2, 7, 1, 5 });
        System.out.println(test1.SolveCountOfSubsetSum(9));// <--- expect 3
    }
}
