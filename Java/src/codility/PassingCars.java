package codility;

public class PassingCars {

    public static void main(String[] args) {
        final PassingCars passingCars = new PassingCars();
        passingCars.solution(new int[]{0, 1, 0, 1,1}); //5
    }

    public int solution(int[] A) {
        int countZero = 0;
        int pairs = 0;

        for (int num : A) {
            if (num == 0) {
                countZero++;
            } else {
                pairs += countZero;
            }

            if (pairs > 1_000_000_000) {
                return -1;
            }
        }
        return pairs;
    }
}
