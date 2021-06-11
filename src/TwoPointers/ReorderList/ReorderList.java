class Solution {
    public void reorderList(ListNode head) {
        //base case
        if(head == null || head.next == null) return;
        
        //define slow and fast
        ListNode slow = head, fast = head, pre = null;
        
        //slow point the middle node in the list
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //break the list
        pre.next = null;
        
        //reverse the last half of the list
        ListNode p1 = head, p2 = reverse(slow);
        
        //reorder the list
        while(p1 != null && p2 != null){
            ListNode nex1 = p1.next, nex2 = p2.next;
            p1.next = p2;
            p2.next = nex1 == null ? nex2 : nex1;
            
            p1 = nex1;
            p2 = nex2;
        }
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode pre = null, cur = head;
        
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
