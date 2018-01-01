public class SmallestMissingPositiveNumber {
    public static void main(String[] args) {
        int[] an = {4,3,7,8,1};
        
        for (int i = 0; i<an.length; i++) {

            if(Math.abs(an[i]-1)<an.length && an[Math.abs(an[i]-1)]>0) {
                an[an[i]-1] = -1*an[an[i]-1];
            }
        }

        for (int m : an) {
            System.out.print(m+" ");
        }
    }
}
//http://www.crazyforcode.com/find-smallest-positive-number-missing-array/
