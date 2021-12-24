package BJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No7568 {

	static class Person {
		int height;
		int weight;

		public Person(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Person> p = new ArrayList<>();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			int weight = sc.nextInt();
			int height = sc.nextInt();
			p.add(new Person(weight, height));
		}

		for (int i = 0; i < n; i++) {
			int result = 0;
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				if (p.get(i).getHeight() < p.get(j).getHeight() &&
					p.get(i).getWeight() < p.get(j).getWeight()) {
					result++;
				}
			}
			a[i] = result + 1;
		}

		for (int i : a) {
			System.out.print(i+ " ");
		}
	}
}
