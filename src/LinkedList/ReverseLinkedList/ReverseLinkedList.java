class Solution {
    public ListNode reverseList(ListNode head) {
        //Base Case
        if(head == null || head.next == null) return head;
        
        ListNode pre = null, cur = head;
        
        //Traverse the list
        while(cur != null){
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
}
