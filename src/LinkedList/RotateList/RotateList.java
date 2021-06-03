class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //Base case
        if(k == 0 || head == null || head.next == null) return head;
        
        //Convert to circular LL
        int size = 0;
        ListNode pre = null, cur = head;
        while(cur != null){
            size++;
            pre = cur;
            cur = cur.next;
        }
        pre.next = head;
        
        //Traverse to the head node
        k = k % size;
        int rotate = size - k;
        pre = null;
        for(int i = 0; i < rotate; i++){
            pre = head;
            head = head.next;
        }
        pre.next = null;
        return head;
    }
}
