class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Base case
        if(root == null) return null;
        
        if(root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //We found p and q in left and right
        if(left != null && right != null) return root;
        
        if(left != null) return left;
        
        return right;
    }
}
