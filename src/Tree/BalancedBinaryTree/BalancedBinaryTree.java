class Solution {
    final int UNBALANCED = -1;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return dfs(root) != UNBALANCED;
    }
    private int dfs(TreeNode root){
        //Base case: leaf node
        if(root.left == null && root.right == null) return 1;
        
        //Left Subtree DFS
        int leftH = 0;
        if(root.left != null){
            leftH = dfs(root.left);
        }
        if(leftH == UNBALANCED) return UNBALANCED;
        
        //Right Subtree DFS
        int rightH = 0;
        if(root.right != null){
           rightH = dfs(root.right);
        }
        if(rightH == UNBALANCED) return UNBALANCED;
        
        //Check current tree
        if(Math.abs(rightH - leftH) <= 1) return Math.max(rightH, leftH) + 1;
        return UNBALANCED;
    }
}
