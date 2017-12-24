public class NumberOfStairsClimbingWays {

    static int[] sol;
    public static void main(String[] args) {
        int N = 3;
        sol = new int[N+1];
        System.out.println(geNumWays(N));
    }

    static int geNumWays(int n) {

        if(n<1) return 0;

        if(sol[n]>0) return sol[n];
        // Number of ways of climbing is :
        // geNumWays(n-3) after taking 3 steps,
        // geNumWays(n-2) after taking 2 steps,
        // geNumWays(n-1) after taking 1 step.
        sol[n] = 1 + geNumWays(n-1) + geNumWays(n-2) + geNumWays(n-3);

        return sol[n];
    }
}
