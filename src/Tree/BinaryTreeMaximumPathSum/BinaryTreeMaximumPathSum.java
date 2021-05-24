class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root){
        //Base case
        if(root == null) return 0;
        
        //Left
        int leftMax = Math.max(dfs(root.left), 0);
        
        //Right
        int rightMax = Math.max(dfs(root.right), 0);
        
        //Update the max
        
        max = Math.max(max, leftMax + rightMax + root.val);
        
        return Math.max(leftMax, rightMax) + root.val;
    }

}
