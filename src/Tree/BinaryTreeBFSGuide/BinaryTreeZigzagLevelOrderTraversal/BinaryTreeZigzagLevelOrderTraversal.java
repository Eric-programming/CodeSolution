class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        boolean FL = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> sub = new LinkedList<>();
            
            for(int i = 0; i < size; i++){
                TreeNode first = q.poll();
                if(FL){
                    sub.add(first.val);
                }else{
                    sub.add(0, first.val);
                }
                if(first.left != null){
                    q.add(first.left);
                }
                
                if(first.right != null){
                    q.add(first.right);
                }
            }
            res.add(sub);
            FL = !FL;
        }
        return res;
    }
}
