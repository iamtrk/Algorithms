/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode A) {
        if(A==null || A.next==null) return A;
        
        // h is a dummy node.
        ListNode h = new ListNode(0);
        h.next = A;
        ListNode p = h;
        
        while(p.next!=null && p.next.next!=null) {
        // use t1 to track first node.
            ListNode t1 = p;
            p = p.next;
            t1.next = p.next;
            
            //use t2 to track next node of the pair
            ListNode t2 = p.next.next;
            p.next.next = p;
            p.next = t2;
        }
        
        return h.next;
    }
}
