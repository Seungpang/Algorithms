package BJ;
// 후보 추천하기

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class No1713 {

    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int N  = sc.nextInt();
        int count = sc.nextInt();

        int[] input = new int[count];
        for (int i = 0; i < count; i++) {
            input[i] = sc.nextInt();
        }

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int num = input[i];
            boolean found = false;

            for (Student s : students) {
                if (s.num == num) {
                    s.recommend++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                if (students.size() == N) {
                    Collections.sort(students);
                    students.remove(0);
                }
                students.add(new Student(num, 1, i));
            }
        }

        students.sort(Comparator.comparing(s -> s.num));
        for (Student s : students) {
            System.out.print(s.num + " ");
        }
    }

    static class Student implements Comparable<Student> {
        int num;
        int recommend;
        int time;

        public Student(final int num, final int recommend, final int time) {
            this.num = num;
            this.recommend = recommend;
            this.time = time;
        }

        @Override
        public int compareTo(final Student o) {
            if (this.recommend ==  o.recommend) {
                return this.time - o.time;
            }
            return this.recommend - o.recommend;
        }
    }
}
