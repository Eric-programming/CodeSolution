class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root, targetSum);
    }
    private boolean dfs(TreeNode root, int targetSum){
        targetSum -= root.val;
        //Base case: leaf node
        if(root.left == null && root.right == null){
            return targetSum == 0;
        }
        boolean left = false, right = false;
        if(root.left != null){
            left = dfs(root.left, targetSum);
        }
        if(root.right != null){
            right = dfs(root.right, targetSum);
        }
        return left || right;
    }
}
