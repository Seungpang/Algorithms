package codingInterview;
//다시풀어보기

public class LC949 {

    public static void main(String[] args) {
        final LC949 lc949 = new LC949();
        System.out.println(lc949.largestTimeFromDigits(new int[]{1, 2, 3, 4}));
        //23:41
    }

    private int maxTime = -1;

    public String largestTimeFromDigits(int[] arr) {
        this.maxTime = -1;
        permutate(arr, 0);
        if (maxTime == -1) {
            return "";
        } else {
            return String.format("%02d:%02d", maxTime / 60, maxTime % 60);
        }

    }

    private void permutate(int[] array, int start) {
        if (start == array.length) {
            buildTime(array);
            return;
        }
        for (int i =start; i<array.length; i++) {
            swap(array, i, start);
            permutate(array, start+1);
            swap(array, i, start);
        }

    }

    private void buildTime(int[] perm) {
        int hour = perm[0] * 10 + perm[1];
        int minute = perm[2] * 10 + perm[3];
        if (hour < 24 && minute < 60) {
            this.maxTime = Math.max(this.maxTime, hour * 60 + minute);
        }
    }

    private void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
