package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Lv1_나누어_떨어지는_숫자_배열 {

    public static void main(String[] args) {
        int[] arr = {3,2,6};

        Lv1_나누어_떨어지는_숫자_배열 sol = new Lv1_나누어_떨어지는_숫자_배열();
        System.out.println(sol.solution(arr, 5));
    }

    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                arrList.add(arr[i]);
                cnt++;
            }
        }
        Collections.sort(arrList);

        int[] answer = new int[cnt];

        for (int i = 0; i < arrList.size(); i++) {
            answer[i] = arrList.get(i);
        }
        if (cnt == 0)
            answer = new int[]{-1};

        return answer;
    }
}
