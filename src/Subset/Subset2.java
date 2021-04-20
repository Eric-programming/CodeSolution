public class Subset2 {
    List<List<Integer>> res = new LinkedList<>();
    int[] arr;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        arr = nums;
        Arrays.sort(arr);
        helper(new LinkedList<>(), 0);
        return res;
    }

    private void helper(List<Integer> sub, int curIdx) {
        res.add(new ArrayList<>(sub));
        for (int i = curIdx; i < arr.length; i++) {
            if (i != curIdx && arr[i] == arr[i - 1])
                continue;
            sub.add(arr[i]);
            helper(sub, i + 1);
            sub.remove(sub.size() - 1);
        }
    }
}
