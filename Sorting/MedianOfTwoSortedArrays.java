public class MedianOfTwoArrays {

    public static void main(String[] args) {
        System.out.println(kth(3, new int[]{1,3,5}, new int[]{2,4}, 0, 0));
    }

    public static int kth(int k, int[] nums1, int[] nums2, int s1, int s2) {
        if (s1 >= nums1.length) return nums2[s2 + k - 1];

        if (s2 >= nums2.length) return nums1[s1 + k - 1];

        if (k == 1) return Math.min(nums1[s1], nums2[s2]);

        int m1 = s1 + k / 2 - 1;
        int m2 = s2 + k / 2 - 1;

        int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
        int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;

        if (mid1 < mid2) {
            return kth(k - k / 2, nums1, nums2, m1 + 1, s2);
        } else {
            return kth(k - k / 2, nums1, nums2, s1, m2 + 1);
        }
    }
}
