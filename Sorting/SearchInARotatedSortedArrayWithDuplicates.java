public class Solution {
	public int search(final List<Integer> a, int b) {
	    return search(a, 0, a.size()-1, b);
	}
	
	public int search(List<Integer> a, int left, int right, int x) {
	    int mid = (left+right)/2;
	    
	    if(x==a.get(mid)) {
	        return mid;
	    }
	    
	    if(left>right) {
	        return -1;
	    }
	    
	    if(a.get(left) < a.get(mid)) {
	        if(x>=a.get(left) && x<a.get(mid)) {
	            return search(a, left, mid-1, x);
	        } else {
	            return search(a, mid+1, right, x);
	        }
	    } else if(a.get(mid)<a.get(left)) {
	        if(x>a.get(mid) && x<=a.get(right)) {
	            return search(a, mid+1, right, x);
	        } else {
	            return search(a, left, mid-1, x);
	        }
	    } else if(a.get(left) == a.get(mid)) {
	        if(a.get(mid) != a.get(right)) {
	            return search(a, mid+1, right, x);
	        } else {
	            int result = search(a, left, mid-1, x);
	            if(result == -1) {
	                return search(a, mid+1, right, x);
	            } else {
	                return result;
	            }
	        }
	    }	    
	    return -1;
	}
}
