package CountOfSubsetSum;

public class CountOfSubsetSumTopDown {
    private int[] arr;
    private Integer[][] cache;

    public CountOfSubsetSumTopDown(int[] arr) {
        this.arr = arr;
    }

    public int SolveCountOfSubsetSum(int num) {
        cache = new Integer[arr.length][num + 1];
        return helper(0, num);
    }

    private int helper(int index, int curSum) {
        if (curSum == 0)
            return 1;
        if (curSum < 0 || index >= arr.length)
            return 0;

        if (cache[index][curSum] != null)
            return cache[index][curSum];
        int take = helper(index + 1, curSum - arr[index]);
        int skip = helper(index + 1, curSum);
        cache[index][curSum] = skip + take;
        return cache[index][curSum];
    }

    public static void main(String[] args) {
        /**
         * Input: values = [1, 1, 2, 3] sum = 4
         * 
         * Output: 3
         */
        CountOfSubsetSumTopDown test0 = new CountOfSubsetSumTopDown(new int[] { 1, 1, 2, 3 });
        System.out.println(test0.SolveCountOfSubsetSum(4));// <--- expect 3

        /**
         * Input: values = [1, 2, 7, 1, 5] sum = 9
         * 
         * Output: 3
         */

        CountOfSubsetSumTopDown test1 = new CountOfSubsetSumTopDown(new int[] { 1, 2, 7, 1, 5 });
        System.out.println(test1.SolveCountOfSubsetSum(9));// <--- expect 3
    }
}
