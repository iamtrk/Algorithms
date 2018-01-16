public class BinaryAddition {
    public static void main(String[] args) {
        System.out.println(add(5, 6));
    }

    public static int add(int a, int b) {
        if(b==0) return a;

        if(a==0) return b;

        int sum = a^b;
        int carry = (a&b) << 1;

        return add(sum, carry);
    }
}
