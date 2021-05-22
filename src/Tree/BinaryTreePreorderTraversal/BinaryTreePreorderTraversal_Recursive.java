class Solution {
    List<Integer> res = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        //First add current element
        res.add(root.val);
        //traverse left side
        dfs(root.left);
        //traverse right side
        dfs(root.right);
    }
}
