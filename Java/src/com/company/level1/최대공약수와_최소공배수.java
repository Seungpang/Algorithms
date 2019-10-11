package com.company.level1;

public class 최대공약수와_최소공배수 {
    public int gcd(int n, int m){
        return (n%m == 0 ? m : gcd(m, n%m));
    }
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n, m);
        answer[1] = n*m /answer[0];
        return answer;
    }
}
