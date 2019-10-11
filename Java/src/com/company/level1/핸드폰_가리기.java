package com.company.level1;

public class 핸드폰_가리기 {
    public String solution(String phone_number) {
        String answer = "";

        for(int i=0; i<phone_number.length(); i++){
            answer += phone_number.length() -i <= 4 ? phone_number.charAt(i) : "*";
        }
        return answer;
    }
}
