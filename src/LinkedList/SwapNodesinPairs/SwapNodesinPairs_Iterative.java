class Solution {
    public ListNode swapPairs(ListNode head) {
        //base case
        if(head == null || head.next == null) return head;
        
        //define pre and cur
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        
        //swap nodes
        while(cur != null && cur.next != null){
            ListNode nex = cur.next;
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
            
            //move cur and pre one to the right
            pre = cur;
            cur = cur.next;
        }
        
        //return the head node
        return dummy.next;
        
    }
}
