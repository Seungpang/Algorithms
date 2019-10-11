package com.company.level1;

public class x만큼_간격_있_n개의_숫자 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long sum = x;
        for(int i=0; i<n; i++){
            answer[i] = sum;
            sum += x;
        }
        return answer;
    }
}
