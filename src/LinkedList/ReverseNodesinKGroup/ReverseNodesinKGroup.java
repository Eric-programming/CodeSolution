class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //base case
        if(head.next == null) return head;
        if(k == 1) return head;
        
        //define pre and cur
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        
        //reverse the list
        while(cur != null){
            boolean space = checkHasSpace(k, cur);
            if(space){
                pre = reverse(pre, cur, k);
                cur = pre.next;
            }else{
                break;
            }
        }
        //return the head
        return dummy.next;
    }
    private boolean checkHasSpace(int k, ListNode cur){
       for(int i = 1; i <= k; i++){
           if(cur == null) return false;
           cur = cur.next;
       }
        return true;
    }
    private ListNode reverse(ListNode pre, ListNode cur, int k){
        for(int i = 0; i < k - 1; i++){
            ListNode nex = cur.next;
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return cur;
    }
   
}
