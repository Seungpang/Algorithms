package codility;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        final OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();

        int[] A = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(oddOccurrencesInArray.solution(A)); //7
    }

    public int solution(int[] A) {
        int result = 0;
        for (int i : A) {
            result ^= i;
        }
        return result;
    }
}
