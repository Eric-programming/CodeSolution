class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(), res = dummy;
        int carry = 0;
        
        //Traverse the lists
        while(l1 != null || l2 != null){
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = l1Val + l2Val + carry;
            if(sum > 9){
                carry = 1;
            }else{
                carry = 0;
            }
            res.next = new ListNode(sum % 10);
            res = res.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        
        //Add carry over
        if(carry > 0){
            res.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
