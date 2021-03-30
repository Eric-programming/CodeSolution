public class KnapsackDP {
    private int[] profits;
    private int[] weights;

    public KnapsackDP(int[] profits, int[] weights) {
        this.profits = profits;
        this.weights = weights;
    }

    // Dynamic Programming approach
    public int solveKnapsack(int capacity) {
        // by default all elements are 0
        int[][] cache = new int[profits.length][capacity + 1];

        for (int i = 1; i < cache[0].length; i++) {
            int curCapacity = i;
            if (weights[0] <= curCapacity) {
                cache[0][i] = profits[0];
            }
        }
        for (int i = 1; i < cache.length; i++) {
            for (int j = 1; j < cache[0].length; j++) {
                int skip = cache[i - 1][j];
                int take = 0;
                int curCapacity = j;
                if (weights[i] <= curCapacity) {
                    take = profits[i] + cache[i - 1][curCapacity - weights[i]];
                }
                cache[i][j] = Math.max(take, skip);
            }
        }

        return cache[profits.length - 1][capacity];

    }

    public static void main(String[] args) {
        /**
         * Input: values = [1, 6, 10, 16] weights = [1, 2, 3, 5] maxWeight = 7
         * 
         * Output: 22
         */
        KnapsackDP test0 = new KnapsackDP(new int[] { 1, 6, 10, 16 }, new int[] { 1, 2, 3, 5 });
        System.out.println(test0.solveKnapsack(7));// <--- expect 22
        /**
         * Input: values = [60, 50, 70, 30] weights = [5, 3, 4, 2] maxWeight = 8
         * 
         * Output: 120
         */

        KnapsackDP test1 = new KnapsackDP(new int[] { 60, 50, 70, 30 }, new int[] { 5, 3, 4, 2 });
        System.out.println(test1.solveKnapsack(8));// <--- expect 120

        /**
         * Input: values = [60, 100, 120, 80, 30] weights = [10, 20, 30, 40, 50]
         * maxWeight = 400
         * 
         * Output: 390
         */
        KnapsackDP test2 = new KnapsackDP(new int[] { 60, 100, 120, 80, 30 }, new int[] { 10, 20, 30, 40, 50 });
        System.out.println(test2.solveKnapsack(400));// <--- expect 390
    }
}