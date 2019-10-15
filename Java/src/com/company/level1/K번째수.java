package com.company.level1;

import java.util.Arrays;

public class K번째수 {
    public static void main(String[] args) {
        K번째수 sol = new K번째수();

        int[] numbers = {6, 10, 2};
        System.out.println(sol.solution(numbers));
    }
    public static String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            arr[i] = String.valueOf(numbers[i]);

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if(arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++)
            sb.append(arr[i]);

        return sb.toString();
    }
}
