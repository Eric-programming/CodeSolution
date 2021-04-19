import java.util.*;

public class CombinationSum2 {
    List<List<Integer>> res = new LinkedList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        helper(target, 0, new LinkedList<Integer>());
        return res;
    }

    private void helper(int targetSum, int index, List<Integer> comb) {
        // Check if the target sum is finished
        if (targetSum == 0) {
            res.add(new LinkedList<Integer>(comb));
            return;
        }

        // DFS all paths
        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1])
                continue;
            int sum = targetSum - candidates[i];

            if (sum < 0)
                break;// break because the array is sorted

            comb.add(candidates[i]);
            helper(sum, i + 1, comb);
            comb.remove(comb.size() - 1);
        }
    }
}