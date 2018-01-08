/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode A, int B) {
        if(A == null) return null;
        
        ListNode f1 = new ListNode(0);
        ListNode f2 = new ListNode(0);
        f1.next = A;
        
        ListNode p = A;
        ListNode prev = f1;
        ListNode p2 = f2;
        
        while(p!=null) {
            if(p.val<B) {
                p = p.next;
                prev = prev.next;
            } else {
                p2.next = p;
                prev.next = p.next;
                
                p = prev.next;
                p2 = p2.next;
            }
        }
        
        p2.next = null;
        prev.next = f2.next;
        
        return f1.next;
    }
}
