package codility;

import java.util.Arrays;

public class PermMissingElem {

    public static void main(String[] args) {
        final PermMissingElem permMissingElem = new PermMissingElem();
        int[] A = {2, 3, 1, 5};
        System.out.println(permMissingElem.solution(A)); //4
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        for (int i=0; i<A.length; i++) {
            if (A[i] != i+1) {
                return i+1;
            }
        }
        return A.length + 1;
    }
}
