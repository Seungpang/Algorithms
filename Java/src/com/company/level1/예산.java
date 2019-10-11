package com.company.level1;

import java.util.Arrays;

public class 예산 {
    public static void main(String[] args) {
        예산 sol = new 예산();
        int[] a = new int[]{1, 3, 2, 5, 4};
        int num = 9;

        System.out.println(sol.solution(a, num));
    }



    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i=0; i<d.length; i++){
            budget -= d[i];
            if(budget < 0) break;
            answer++;
        }
        return answer;
    }

}

