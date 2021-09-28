/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode node){       
        int left = 0, right = 0;
        
        if(node.left != null){
            left = dfs(node.left);
        }
        
        if(node.right != null){
            right = dfs(node.right);
        }
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
}
