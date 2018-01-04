public class Solution {
    
    public ArrayList<String> res = new ArrayList<String>();
    public ArrayList<String> generateParenthesis(int A) {
        
        validParenth(A, A, "");
        
        return res;
        
        
    }
    
    public void validParenth(int open, int close, String str) {
        
        if(open==0 && close==0) res.add(str);
        
        if(open>close) return;
        
        if(open>0)  validParenth(open-1, close, str+"(");
        
        if(close>0)  validParenth(open, close-1, str+")");
        
    }
}
