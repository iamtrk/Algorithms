public class frogjumpI {

    public static void main(String[] args) {

        int[] A = {2, 1, 1, 4, 2, 3, 5, 4};

        int D = 50;

        boolean[] res = new boolean[D+1];
        int count = 0;
        int i=0;
        for ( i=0; i< A.length; i++) {
            if(count != D) {
                if(!res[A[i]]) {
                    res[A[i]] = true;
                    count = count+1;
                }
            } else {
                break;
            }
        }
        if(count != D) {
            System.out.println(-1);
        } else {
            System.out.println(i-1);
        }
    }
}
