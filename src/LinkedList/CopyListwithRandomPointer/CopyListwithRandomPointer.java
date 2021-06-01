class Solution {
    public Node copyRandomList(Node head) {
        //base case
        if(head == null) return null;
        //define table
        Map<Node, Node> hm = new HashMap<>();
        
        //define cur pointer = head
        Node cur = head;
        hm.put(cur, new Node(cur.val));
        
        //while cur pointer != null
        while(cur != null){
            //1. get the new node of the cur pointer
            Node curClone = hm.get(cur);
            
            //2. Build the random pointer if doesn't exists in the table
            if(cur.random != null && !hm.containsKey(cur.random)){
                hm.put(cur.random, new Node(cur.random.val));
            }
            Node randomClone = hm.get(cur.random);
            
            //3  get new cur node point to new random node
            curClone.random = randomClone;
            
            //4. Build the next node if doesn't exists in the table
            if(cur.next != null && !hm.containsKey(cur.next)){
                hm.put(cur.next, new Node(cur.next.val));
            }
            Node nexClone = hm.get(cur.next);
            //5. Get the new curNode point to the next new node
            curClone.next = nexClone;
            
            //6. cur pointer move the next node
            cur = cur.next;
        }
            
        
        //return the new head node from the table
        return hm.get(head);
    }
}
