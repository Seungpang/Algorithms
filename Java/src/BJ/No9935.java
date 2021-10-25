package BJ;
//스택
//문자열 폭발

import java.util.Scanner;
import java.util.Stack;


public class No9935 {

    private static class Pair {

        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s = sc.nextLine();
        int n = str.length();
        int m = s.length();
        boolean[] check = new boolean[n];
        if (m == 1) { //폭발 문자열의 길이가 하나인 경우
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == s.charAt(0)) {
                    check[i] = true;
                }
            }
        } else {
            Stack<Pair> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == s.charAt(0)) { //폭발 문자열의 시작과 같다면 폭발 가능성이 있으므로 stack에 push
                    stack.push(new Pair(i, 0));
                } else {
                    if (!stack.empty()) {
                        Pair p = stack.peek();
                        if (str.charAt(i) == s.charAt(
                            p.second + 1)) { //stack에 넣었던 폭발문자열의 다음 위치와 같다면
                            stack.push(new Pair(i, p.second + 1)); //stack에 push하고
                            if (p.second + 1 == m - 1) { //폭발문자열의 마지막 이라면
                                for (int j = 0; j < m; j++) {
                                    Pair top = stack.pop(); // 폭발 시킨다.
                                    check[top.first] = true; //폭발한 곳 check
                                }
                            }
                        } else { // 폭발할 가능성 X
                            while (!stack.empty()) {
                                stack.pop();
                            }
                        }
                    }
                }
            }
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (check[i]) {
                continue;
            }
            sb.append(str.charAt(i));
            flag = true;
        }
        if (flag) {
            System.out.print(sb);
        } else {
            System.out.print("FRULA");
        }
    }
}
