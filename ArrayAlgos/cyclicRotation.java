//https://codility.com/programmers/lessons/2-arrays/cyclic_rotation/
class cyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        
        if(A == null || A.length == 0 || A.length  == 1 || K == 0)
            return A;
        
        
        int N = A.length;
        
        if( N == K)
            return A;
        
        if(K > N)
            K = K % N;
            
        
            
        
        
        int index = 0;
        
        int[] output = new int[N];
        
        for(int i = (N-1)-(K-1); i< N; i++)
        {
            output[index++]  = A[i];
        }
        for(int i = 0; i< (N-1)-(K-1); i++)
        {
            output[index++] = A[i];
        }
        
        return output;
    }
}
