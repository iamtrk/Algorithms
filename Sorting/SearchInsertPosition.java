/* Has application in consistent hashing */
public class Solution {
	public int searchInsert(ArrayList<Integer> a, int b) {
	    int i=0;
	    int j=a.size()-1;
	    
	    while(i<=j) {
	        int mid = i+(j-i)/2;
	        
	        if(b>a.get(mid)) {
	            i=mid+1;
	        } else if(b<a.get(mid)) {
	            j=mid-1;
	        } else return mid;
	    }
	    
	    return i;
	}
}
