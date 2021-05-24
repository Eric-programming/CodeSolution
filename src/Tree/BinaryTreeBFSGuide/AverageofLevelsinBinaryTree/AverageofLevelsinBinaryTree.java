class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
         List<Double> res = new LinkedList<>();
        
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            //Traverse level by level
            int size = q.size();
            double sum = 0;    
            for(int i = 0; i < size; i++){
                TreeNode first = q.poll();
                
                sum += (double) first.val;
                
                if(first.left != null){
                    q.add(first.left);
                }
                
                if(first.right != null){
                    q.add(first.right);
                }
            }
            double avg = sum / size; 
            res.add(avg);
        }
        return res;
    }
}
