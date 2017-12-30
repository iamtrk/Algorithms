public class maxAbsoluteDifference {

    public static void main(String[] args) {
        int[] a = {1, 3, -1};

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int max4 = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int i=0; i<a.length; i++) {

            max1 = Math.max(max1, -i+a[i]);
            max2 = Math.max(max2,  i-a[i]);
            max3 = Math.max(max3,  i+a[i]);
            max4 = Math.max(max4, -i-a[i]);
        }

        for (int i=0; i<a.length; i++) {

            ans = Math.max(ans, max2-i+a[i]);
            ans = Math.max(ans, max1+i-a[i]);
            ans = Math.max(ans, max4+i+a[i]);
            ans = Math.max(ans, max3-i-a[i]);
        }

        System.out.println(ans);

    }
}
