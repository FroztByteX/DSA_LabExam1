package Padillo;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Main {

	static Scanner s = new Scanner(System.in);
	static Queue<String> q = new LinkedList<>();

	public static void main(String[] args) {
		addElements();
		generatePermutations();
	}

	static void addElements() {
		while (true) {
			System.out.print("Enter five elements (space-separated): ");
			String element = s.nextLine();

			String[] e = element.split("\\s+");
			if (e.length != 5) {
				System.err.println("[Invalid input! Please enter exactly FIVE elements.]");
				continue;
			}

			for (String el : e) {
				q.add(el);
			}
			break;
		}

		System.out.println("\nQueue: " + q);
		System.out.println("\nDequeuing two elements...");
		q.poll();
		q.poll();
		System.out.println("\nUpdated Queue: " + q);
	}

	static void generatePermutations() {
		System.out.println("===================================================");
		int r = 0;
		while (true) {
			while (true) {
				System.out.print("Enter number of elements to arrange: ");
				try {
					r = s.nextInt();
					s.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.err.println("[Error: Please enter a valid integer.]");
					s.next();
				}
			}

			if (r > q.size() || r <= 0) {
				System.err.println("[Invalid number of elements. Queue only has " + q.size() + " elements.]");
				continue;
			} else {
				break;
			}
		}

		String[] elmnts = q.toArray(new String[0]);
		Queue<String> permQ = new LinkedList<>();

		System.out.println("\nGenerated Permutations:");

		for (String el : elmnts) {
			permQ.add(el);
		}

		int totalPermutations = 0;
		while (!permQ.isEmpty()) {
			String current = permQ.poll();

			if (current.length() == r) {
				System.out.println(current);
				totalPermutations++;
			} else {
				for (String el : elmnts) {
					if (!current.contains(el)) {
						permQ.add(current + el);
					}
				}
			}
		}

		System.out.println("\nTotal Permutations: " + totalPermutations);
		System.out.println("===================================================");
	}
}
