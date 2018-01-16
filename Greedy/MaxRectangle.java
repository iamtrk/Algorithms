public class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<Integer>();
        
        A.add(0);
        
        int sum = 0;
        int i = 0;
        
        while(i<A.size()) {
            if(stack.isEmpty() || A.get(i)>A.get(stack.peek())) {
                stack.push(i);
                i++;
            } else {
                int t = stack.pop();
                sum = Math.max(sum, A.get(t)*(stack.isEmpty()?i:(i-stack.peek()-1)));
            }
            
        }
        
        return sum;
        
    }
}

// http://eric-yuan.me/leetcode-largest-rectangle-histogram/
