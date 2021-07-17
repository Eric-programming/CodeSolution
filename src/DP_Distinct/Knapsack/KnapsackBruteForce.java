public class KnapsackBruteForce {
    private int[] profits;
    private int[] weights;

    public KnapsackBruteForce(int[] profits, int[] weights) {
        this.profits = profits;
        this.weights = weights;
    }

    // brute force
    public int solveKnapsack(int capacity) {
        return helper(0, capacity, 0);
    }

    private int helper(int index, int capacity, int curProfits) {
        if (capacity < 0)
            return 0;
        if (index >= profits.length) {
            return curProfits;
        }

        // take current item
        int take = helper(index + 1, capacity - weights[index], curProfits + profits[index]);

        // skip current item
        int skip = helper(index + 1, capacity, curProfits);

        return Math.max(take, skip);
    }

    public static void main(String[] args) {
        /**
         * Input: values = [1, 6, 10, 16] weights = [1, 2, 3, 5] maxWeight = 7
         * 
         * Output: 22
         */
        KnapsackBruteForce test0 = new KnapsackBruteForce(new int[] { 1, 6, 10, 16 }, new int[] { 1, 2, 3, 5 });
        System.out.println(test0.solveKnapsack(7));// <--- expect 22
        /**
         * Input: values = [60, 50, 70, 30] weights = [5, 3, 4, 2] maxWeight = 8
         * 
         * Output: 120
         */

        KnapsackBruteForce test1 = new KnapsackBruteForce(new int[] { 60, 50, 70, 30 }, new int[] { 5, 3, 4, 2 });
        System.out.println(test1.solveKnapsack(8));// <--- expect 120

        /**
         * Input: values = [60, 100, 120, 80, 30] weights = [10, 20, 30, 40, 50]
         * maxWeight = 400
         * 
         * Output: 390
         */
        KnapsackBruteForce test2 = new KnapsackBruteForce(new int[] { 60, 100, 120, 80, 30 },
                new int[] { 10, 20, 30, 40, 50 });
        System.out.println(test2.solveKnapsack(400));// <--- expect 390
    }
}
