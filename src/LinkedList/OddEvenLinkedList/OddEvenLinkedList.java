class Solution {
    public ListNode oddEvenList(ListNode head) {
        //base case
        if(head == null || head.next == null) return head;
        
        //define head node of OddList & EvenList
        ListNode OddList = head, EvenList = head.next;
        
        //define curOdd and curEven
        ListNode curOdd = OddList, curEven = EvenList;
        
        //while curOdd & curEven is not null
        while(curOdd.next != null && curEven.next != null){
            //1. curOdd.next = curEven.next then curOdd = curOdd.next
            curOdd.next = curEven.next;
            curOdd = curOdd.next;
            
            //2. curEven.next = curOdd.next then curEven = curEven.next
            curEven.next = curOdd.next;
            curEven = curEven.next;
        }
            
        //Tail node of OddList or curOdd.next = head node of the even list
        curOdd.next = EvenList;
        //return head of odd list
        return OddList;
    }
}
