class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;
        dfs(root, targetSum, new LinkedList<>());
        return res;
    }
    private void dfs(TreeNode root, int targetSum, List<Integer> path){
        targetSum -= root.val;
        path.add(root.val);
        //Base case: leaf node
        if(root.left == null && root.right == null && targetSum == 0){
            res.add(new LinkedList<>(path));
        }else{
            if(root.left != null){
                dfs(root.left, targetSum, path);
            }
            if(root.right != null){
                dfs(root.right, targetSum, path);
            }
        }
        //Backtrack
        path.remove(path.size() - 1);
    }
}
