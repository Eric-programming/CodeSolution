class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }
    private Node dfs(Node node){
        Node pre = null;
        while(node != null){
            pre = node;
            if(node.child != null){
                //Change the tail node
                Node tail = dfs(node.child);
                tail.next = node.next;
                if(node.next != null){
                    node.next.prev = tail;
                }
                
                //Change the head node
                node.next = node.child;
                node.child.prev = node;
                node.child = null;
                
                //Reset the pointers
                node = tail.next;
                pre = tail;
            }else{
                node = node.next;
            }
        }
        return pre;
    }
}
