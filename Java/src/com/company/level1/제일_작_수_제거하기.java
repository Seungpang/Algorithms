package com.company.level1;

public class 제일_작_수_제거하기 {
    public int[] solution(int[] arr) {
        int[] answer =new int[arr.length-1];
        if(arr.length == 1)
            return new int[]{-1};

        int target = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[target] > arr[i])
                target = i;
        }

        int count=0;
        for(int i=0; i<arr.length; i++){
            if(target == i) continue;
            answer[count++] = arr[i];
        }
        return answer;
    }
}
