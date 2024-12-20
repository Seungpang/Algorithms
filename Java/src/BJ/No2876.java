package BJ;
// 그래픽스 퀴즈

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2876 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        int maxStudents = 0;
        int minGrade = 6;

        for (int grade = 1; grade <= 5; grade++) {
            int currentLength = 0;
            int maxLengthForGrade = 0;

            for (int i = 0; i < N; i++) {
                if (A[i] == grade || B[i] == grade) {
                    currentLength++;
                    if (currentLength > maxLengthForGrade) {
                        maxLengthForGrade = currentLength;
                    }
                } else {
                    currentLength = 0;
                }
            }

            if (maxLengthForGrade > maxStudents) {
                maxStudents = maxLengthForGrade;
                minGrade = grade;
            } else if (maxLengthForGrade == maxStudents && grade < minGrade) {
                minGrade = grade;
            }
        }

        System.out.println(maxStudents + " " + minGrade);
    }
}
