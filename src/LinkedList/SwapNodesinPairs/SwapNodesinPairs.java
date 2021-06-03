class Solution {
    public ListNode swapPairs(ListNode head) {
        //base case
        if(head == null || head.next == null) return head;
        
        ListNode nex = head.next;
        ListNode temp = nex.next;
        head.next = swapPairs(temp);
        nex.next = head;
        return nex;
    }
}
