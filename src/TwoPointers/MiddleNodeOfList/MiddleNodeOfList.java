class Solution {
    public ListNode middleNode(ListNode head) {
        //base case
        if(head.next == null) return head;
        
        //define slow and fast
        ListNode slow = head, fast = head;
        
        //traverse the list
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //return slow
        return slow;
    }
}
