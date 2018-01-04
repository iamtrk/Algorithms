/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode a, ListNode b) {
	    
	    int al = getLength(a);
	    int bl = getLength(b);
	    
	    
	    int d = Math.abs(al-bl);
	    
	    if(al>bl) {
	        
	        int i = 0;
	        while(i<d) {
	            a=a.next;
	            i++;
	        }
	    } else if(al<bl) {
	        int i = 0;
	        while(i<d) {
	            b=b.next;
	            i++;
	        }
	    }
	    
	    while(a!=null && b!=null) {
	        if(a==b) return a;
	        
	        a = a.next;
	        b = b.next;
	    }
	    
	    return null;
	    
	}
	
	public int getLength(ListNode a) {
	    ListNode h = a;
	    int l = 0;
	    
	    while(h!=null) {
	        h=h.next;
	        l++;
	    }
	    
	    return l;
	}
}
