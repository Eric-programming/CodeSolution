class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        
        while(!q.isEmpty()){
            int size = q.size();
            //Create a dummy node 
            Node pre = new Node();
            for(int i = 0; i < size; i++){
                Node top = q.poll();
                pre.next = top;
                pre = top;
                //Add the next level nodes onto the queue
                if(top.left != null){
                    q.add(top.left);
                }
                if(top.right != null){
                    q.add(top.right);
                }
            }
        }
        return root;
    }
}
