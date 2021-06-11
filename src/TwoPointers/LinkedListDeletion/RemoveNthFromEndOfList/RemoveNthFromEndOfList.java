class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //base case
        if(head == null) return null;
        
        //define slow and fast and pre and dummy
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        ListNode pre = null;
        
        //move fast pointer n node ahead of the slow
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        
        //move both slow and fast pointers in the same speed
        while(fast != null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        //return head
        return dummy.next;
    }
}
