/**
How it works, is if we have Gray Code list for n bits (lets call this L), then we can generate grey code
for n+1 bits by merging the following lists { by prepending 0 to the L & 1 to the reversed L }
Ex: {0,1} => {00,01,11,10}
**/

public class Solution {
	public ArrayList<Integer> grayCode(int a) {
	    ArrayList<String> x = new ArrayList<String>();
	    
	    x.add("0");
	    x.add("1");
	    
	    int n = 1;
	    
	    while(n<a) {
	        int size = x.size();
	        ArrayList<String> intr = new ArrayList<>();
	        for(int i=0; i<size; i++) {
	            intr.add("0"+x.get(i));
	        }
	        
	        for(int i=size-1; i>=0; i--) {
	            intr.add("1"+x.get(i));
	        }
	        n++;
	        x = intr;
	    }
	    
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    
	    for(int i=0; i<x.size(); i++) {
	        res.add(Integer.parseInt(x.get(i), 2));
	    }
	    
	    return res;
	}
}
