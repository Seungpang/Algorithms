package BJ;
//정렬
//나이순 정렬

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No10814 {
    static class Person implements Comparable<Person> {
        int age;
        int index;
        String name;

        Person(int age, int index, String name) {
            this.age = age;
            this.index = index;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            if (this.age < o.age) {
                return -1;
            } else if (this.age == o.age) {
                if (this.index < o.index) {
                    return -1;
                } else if (this.index == o.index) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] a = new Person[n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            a[i] = new Person(Integer.parseInt(line[0]), i, line[1]);
        }
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(a[i].age).append(" ").append(a[i].name).append("\n");
        }
        System.out.println(sb);
    }
}
