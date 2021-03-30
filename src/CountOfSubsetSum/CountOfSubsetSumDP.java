package CountOfSubsetSum;

public class CountOfSubsetSumDP {
    private int[] arr;

    public CountOfSubsetSumDP(int[] arr) {
        this.arr = arr;
    }

    public int SolveCountOfSubsetSum(int sum) {
        int[][] cache = new int[arr.length][sum + 1];
        for (int i = 0; i < cache.length; i++) {
            cache[i][0] = 1;
        }
        int firstElement = arr[0];
        if (firstElement <= sum) {
            cache[0][firstElement] = 1;
        }

        for (int i = 1; i < cache.length; i++) {
            int curElement = arr[i];
            for (int j = 1; j < cache[0].length; j++) {
                int curSum = j;
                int skip = cache[i - 1][curSum];
                int take = 0;
                if (curSum >= curElement) {
                    take = cache[i - 1][curSum - curElement];
                }
                cache[i][j] = take + skip;
            }
        }
        return cache[cache.length - 1][cache[0].length - 1];
    }

    public static void main(String[] args) {
        /**
         * Input: values = [1, 1, 2, 3] sum = 4
         * 
         * Output: 3
         */
        CountOfSubsetSumDP test0 = new CountOfSubsetSumDP(new int[] { 1, 1, 2, 3 });
        System.out.println(test0.SolveCountOfSubsetSum(4));// <--- expect 3

        /**
         * Input: values = [1, 2, 7, 1, 5] sum = 9
         * 
         * Output: 3
         */

        CountOfSubsetSumDP test1 = new CountOfSubsetSumDP(new int[] { 1, 2, 7, 1, 5 });
        System.out.println(test1.SolveCountOfSubsetSum(9));// <--- expect 3
    }
}
