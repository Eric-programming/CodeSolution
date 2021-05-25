class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val), max = Math.max(p.val, q.val);
        while(root != null){
            int cur = root.val;
            if(min < cur && max < cur) {
                root = root.left;
            }else if(min > cur && max > cur){
                root = root.right;   
            }else{
                break;
            }
        }
        return root;
    }
}
