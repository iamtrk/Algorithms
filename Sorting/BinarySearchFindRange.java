public class Solution {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
	    
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    
	    res.add(first(a, 0, a.size()-1, b));
	    res.add(last(a, 0, a.size()-1, b, a.size()-1));
	    
	    return res;
	}
	
	public int first(List<Integer> a, int lo, int hi, int x) {
	    if(hi>=lo) {
	        int mid = lo + (hi-lo)/2;
	        
	        if((mid==0 || x>a.get(mid-1)) && a.get(mid)==x) {
	            return mid;
	        } else if(x > a.get(mid)) return first(a, mid+1, hi, x);
	        else return first(a, lo, mid-1, x);
	    }
	    
	    return -1;
	}
	
	public int last(List<Integer> a, int lo, int hi, int x, int n) {
	    if(hi>=lo) {
	        int mid = lo + (hi-lo)/2;
	        
	        if((mid==n || x<a.get(mid+1)) && a.get(mid)==x) {
	            return mid;
	            //TODO: Why can't we use (>) here, test cases failing when (>) is used.
	        } else if(x<a.get(mid)) return last(a, lo, mid-1, x, n);
	        else return last(a, mid+1, hi, x, n);
	    }
	    
	    return -1;
	}
}
