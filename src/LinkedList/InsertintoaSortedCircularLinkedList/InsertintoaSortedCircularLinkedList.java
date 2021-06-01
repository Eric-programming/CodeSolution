class Solution {
    public Node insert(Node head, int insertVal) {
        Node insertNode = new Node(insertVal);
        
        //Base case
        if(head == null){
            insertNode.next = insertNode;
            return insertNode;
        };
        
        //Pointer
        Node cur = head;
        
        //Find the right position to insert
        while(cur.next != head){
            int curVal = cur.val, nexVal = cur.next.val;
            if(curVal > nexVal){
                //Case 1: insertVal bigger than all neighbor nodes
                if(curVal < insertVal && nexVal < insertVal) break;
                //Case 2: insertVal smaller than all neighbor nodes
                if(curVal > insertVal && nexVal > insertVal) break;
            }
            //Case 3 insertVal is in between neighbor nodes
            if(curVal <= insertVal && insertVal <= nexVal) break;
            cur = cur.next;
        }
        //Insert at the current position
        Node nex = cur.next;
        cur.next = insertNode;
        insertNode.next = nex;
        return head;
    }
}
