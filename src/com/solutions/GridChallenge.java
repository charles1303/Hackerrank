package com.solutions;

import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {
	/*
	 * 1 5 ebacd fghij olmkn trpqs xywuv
	 * Next : https://www.hackerrank.com/challenges/greedy-florist?h_r=next-challenge&h_v=zen
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();

		while (testCases > 0) {
			testCases--;
			int noOfLines = scanner.nextInt();
			char charMatrix[][] = new char[noOfLines][noOfLines];
			for (int i = 0; i < noOfLines; i++) {
				String charInput = scanner.next();
				charMatrix[i] = charInput.toCharArray();
				Arrays.sort(charMatrix[i]);
			}
			checkMatrixSort(noOfLines, charMatrix);
		}
		scanner.close();
	}

	private static void checkMatrixSort(int noOfLines, char[][] charMatrix) {
		int flag = 0;
		outerLoop: for (int i = 0; i < noOfLines; i++) {
			for (int j = 0; j < noOfLines - 1; j++) {
				if (charMatrix[j][i] > charMatrix[j + 1][i]) {
					flag = 1;
					break outerLoop;
				}
			}
		}
		if (flag == 1)
			System.out.println("NO");
		else
			System.out.println("YES");
	}

}
