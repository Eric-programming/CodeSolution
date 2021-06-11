class Solution {
    Node head = null;
    Node pre = null;
    public Node treeToDoublyList(Node root) {
        dfs(root);
        if(head == null) return null;
        head.left = pre;
        pre.right = head;
        return head;
    }
    private void dfs(Node root){
        if(root == null) return;
        //Traverse the left side
        dfs(root.left);
        
        //Visited current node
        if(head == null){
            head = root;
        }else{
            pre.right = root;
            root.left = pre;   
        }
        pre = root;
        
        //Traverse the right side
        dfs(root.right);
    }
}
