import java.util.*;

public class Permutations1 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        helper(list, new LinkedList<>());
        return res;
    }

    private void helper(List<Integer> list, List<Integer> curComb) {
        if (list.isEmpty()) {
            List<Integer> temp = new LinkedList<>(curComb);
            res.add(temp);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Integer val = list.remove(i);
            curComb.add(val);
            helper(list, curComb);
            // Reverse the changes to get ready for the next iteration
            curComb.remove(curComb.size() - 1);
            list.add(i, val);
        }
    }
}
