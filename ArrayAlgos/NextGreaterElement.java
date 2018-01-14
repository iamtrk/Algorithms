public class NextGreaterElement {
    public static void main(String[] args) {
        int[] array = {1,2,3};

        do {  // Must start at lowest permutation
            System.out.println(Arrays.toString(array));
        } while (nextPermutation(array));
    }

    static boolean nextPermutation(int[] array) {
        // Find longest non-increasing suffix.
        // Example of a non-increasing sequence in 9,5,8,4,2,1 is => 8,4,2,1
        int i = array.length - 1;
        // this loop breaks when array[i]>array[i-1]
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        // Now i is the head index of the suffix i.e at 8.

        // Are we at the last permutation already?
        if (i == 0)
            return false;

        // Let array[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        // Now the value array[j] will become the new pivot
        // Assertion: j >= i

        // Swap the pivot with j
        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        // Successfully computed the next permutation
        return true;
    }
}
