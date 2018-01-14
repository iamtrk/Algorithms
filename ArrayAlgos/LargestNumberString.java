public class LargestNumberString {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(30);
        a.add(34);
        a.add(5);
        a.add(9);
        System.out.println(largestNumber(a));
    }

    public static String largestNumber(final List<Integer> A) {

        boolean allzeros = true;
        for(int i=0; i<A.size(); i++) {
            allzeros = allzeros && (A.get(i) == 0);
        }

        if(allzeros) {
            return "0";
        }

        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                // Given numbers 30 & 3, it ll evaluate whether 303 or 330 is bigger.
                long one = Long.parseLong(Integer.toString(o1)+Integer.toString(o2));
                long two = Long.parseLong(Integer.toString(o2)+Integer.toString(o1));

                if(one > two) {
                    return 1;
                } else if(one < two) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        String r = "";
        for(int i=A.size()-1; i>=0; i--) {
            r = r + A.get(i);
        }

        return r;
    }

}
