import java.util.*;

public class CombinationSum1 {
    List<List<Integer>> res = new LinkedList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        helper(target, new LinkedList<Integer>(), 0);
        return res;
    }

    private void helper(int target, List<Integer> comb, int index) {
        // Check if we found a combination
        if (target == 0) {
            List<Integer> temp = new LinkedList<>(comb);
            res.add(temp);
            return;
        }
        // DFS all the paths
        for (int i = index; i < candidates.length; i++) {
            int curSum = target - candidates[i];
            // Check if out of bound
            if (curSum < 0)
                continue;
            comb.add(candidates[i]);
            helper(curSum, comb, i);// We can still reuse the same element dfs down the path
            comb.remove(comb.size() - 1);
        }
    }
}
