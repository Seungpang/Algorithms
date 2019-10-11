package com.company.level1;

public class 정수_제곱근_판별 {
    public long solution(long n) {
        long answer = 0;

        int i = (int)Math.sqrt(n);
        double d = Math.sqrt(n);

        if(i==d)
            return answer=(long)Math.pow(d+1,2);
        return -1;
    }
}
