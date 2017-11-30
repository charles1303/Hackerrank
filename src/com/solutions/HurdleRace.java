package com.solutions;

import java.util.*;

public class HurdleRace {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if(n < 1 || n > 100) return;
        if(k < 1 || k > 100) return;
        int[] height = new int[n];
        for(int height_i=0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
            if(height[height_i] < 1 || height[height_i] > 100) return;
        }
        System.out.println(soln(k,height));
        in.close();
	}

	public static int soln(int k, int[] arr){
		Arrays.sort(arr);
		int diff = arr[arr.length - 1] - k;
		return diff < 0 ? 0 : diff;
	}
}
