class Solution {
    List<Integer> res = new LinkedList<>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        
        //Traverse the left
        dfs(root.left);
        //Traverse the right
        dfs(root.right);
        //Take the current root
        res.add(root.val);
    }
}
