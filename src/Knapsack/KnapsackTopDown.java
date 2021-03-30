public class KnapsackTopDown {
    private int[] profits;
    private int[] weights;
    private Integer[][] cache;

    public KnapsackTopDown(int[] profits, int[] weights) {
        this.profits = profits;
        this.weights = weights;
    }

    // top down
    public int solveKnapsack(int capacity) {
        cache = new Integer[profits.length][capacity + 1];
        return helper(0, capacity, 0);
    }

    private int helper(int index, int capacity, int curProfits) {
        if (capacity < 0)
            return 0;
        if (index >= profits.length) {
            return curProfits;
        }
        if (cache[index][capacity] != null)
            return cache[index][capacity];

        // take current item
        int take = helper(index + 1, capacity - weights[index], curProfits + profits[index]);

        // skip current item
        int skip = helper(index + 1, capacity, curProfits);

        cache[index][capacity] = Math.max(take, skip);
        return cache[index][capacity];
    }

    public static void main(String[] args) {
        /**
         * Input: values = [1, 6, 10, 16] weights = [1, 2, 3, 5] maxWeight = 7
         * 
         * Output: 22
         */
        KnapsackTopDown test0 = new KnapsackTopDown(new int[] { 1, 6, 10, 16 }, new int[] { 1, 2, 3, 5 });
        System.out.println(test0.solveKnapsack(7));// <--- expect 22
        /**
         * Input: values = [60, 50, 70, 30] weights = [5, 3, 4, 2] maxWeight = 8
         * 
         * Output: 120
         */

        KnapsackTopDown test1 = new KnapsackTopDown(new int[] { 60, 50, 70, 30 }, new int[] { 5, 3, 4, 2 });
        System.out.println(test1.solveKnapsack(8));// <--- expect 120

        /**
         * Input: values = [60, 100, 120, 80, 30] weights = [10, 20, 30, 40, 50]
         * maxWeight = 400
         * 
         * Output: 390
         */
        KnapsackTopDown test2 = new KnapsackTopDown(new int[] { 60, 100, 120, 80, 30 },
                new int[] { 10, 20, 30, 40, 50 });
        System.out.println(test2.solveKnapsack(400));// <--- expect 390
    }
}