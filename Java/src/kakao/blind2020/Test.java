package kakao.blind2020;

public class Test {

    public static void main(String[] args) {
        Test a = new Test();
        int[] arr = {-2,0,10,-19,4,6,-8};
        System.out.println(a.checkIfExist(arr));
    }

    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int num = arr[i] * 2;
            for (int j = 0; j < n ; j++) {
                if (num == arr[j])
                    return true;
            }
        }
        return false;
    }
}
