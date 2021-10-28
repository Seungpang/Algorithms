package BJ;
//정렬
//국영수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No10825 {

    static class Person implements Comparable<Person> {

        String name;
        int kor, eng, math;

        Person(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        public int compareTo(Person o) {
            if (this.kor > o.kor) {
                return -1;
            } else if (this.kor == o.kor) {
                if (this.eng < o.eng) {
                    return -1;
                } else if (this.eng == o.eng) {
                    if (this.math > o.math) {
                        return -1;
                    } else if (this.math == o.math) {
                        return this.name.compareTo(o.name);
                    }
                }
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] a = new Person[n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            a[i] = new Person(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
        }
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(a[i].name).append("\n");
        }
        System.out.println(sb);
    }
}
