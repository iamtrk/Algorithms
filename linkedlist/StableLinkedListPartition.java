/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

1:  public ListNode partition(ListNode head, int x) {  
2:    ListNode dummy = new ListNode(0);  
3:    dummy.next = head;  
4:    
5:    // find the last node that < x  
6:    ListNode last = dummy;  
7:    while (last.next != null && last.next.val < x) last = last.next;  
8:    
9:    // start from the >=x node  
10:    ListNode nt = last;  
11:    while (nt.next != null) {  
12:      if (nt.next.val < x) {  
13:        ListNode tmp = nt.next;  
14:        nt.next = tmp.next;  
15:        tmp.next = last.next;  
16:        last.next = tmp;  
17:        last = last.next;  
18:      } else {  
19:        nt = nt.next;  
20:      }  
21:    }  
22:    
23:    return dummy.next;  
24:  } 
