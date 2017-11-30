package com.solutions;

import java.util.*;

public class GreedyFlorist {
	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		int n = Integer.parseInt(input.split(" ")[0]);
		int k = Integer.parseInt(input.split(" ")[1]);
		
		String[] flowerVals = s.nextLine().split(" ");
		int[] flowers = new int[flowerVals.length];
		for(int i = 0; i <flowerVals.length; i++)
			flowers[i] = Integer.parseInt(flowerVals[i]);
		getMinimumCost(n,k,flowers);
		
	}
	
	private static int getMinimumCost(int n, int k,int[] flowers){
		Arrays.sort(flowers);
		if(n < 1 || n > 100) return -1;
		if(k < 1 || k > 100) return -1;
		if(flowers[flowers.length - 1] > Math.pow(10, 6) || flowers[flowers.length - 1] < 1) return -1;
		if(flowers.length < 0 || flowers.length > n) return -1;
		
		int noOfRotations = 0;
		int cnt = 0;
		int totalAmountPurchased = 0;
		for(int i = (flowers.length - 1); i >= 0; i--){
			if(cnt % k == 0 && cnt != 0)
				noOfRotations++;
			totalAmountPurchased += (noOfRotations + 1) * flowers[i];
			cnt++;
			
		}
		if(totalAmountPurchased > Math.pow(2, 31)) return -1;
		return totalAmountPurchased;
		//System.out.println(totalAmountPurchased);
		
		
	}

}
