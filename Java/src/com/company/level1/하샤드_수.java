package com.company.level1;

public class 하샤드_수 {
    public boolean solution(int x) {
        boolean answer = false;
        int tmp = x;
        int sum = 0;

        while(tmp/10 != 0){
            sum += tmp%10;
            tmp = tmp/10;
        }
        sum += tmp;

        if(x%sum == 0)
            answer = true;

        return answer;
    }
}
