package com.solutions;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSubArray {
	
	public static void main(String args[]){
		//int arr[] = {1,2,3,4};
		//int arr[] = {2,-1,2,3,4,-5};
		//System.out.println(maxSubArray(arr));
		
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		if(cases < 1 || cases > 10) return;
		for(int i = 0; i <cases; i++){
			int arrLen =  s.nextInt();
			s.nextLine();
			//String str = "";
			String str = s.nextLine();
			String arr[] = str.split(" ");
			
			//System.out.println(Arrays.toString(arr));
			//System.out.println(maxSubArray(arrLen,arr));
			maxSubArray(arrLen,arr);
			//s.nextLine();
			
		}
		s.close();
	}
	
	public static int maxSubArray(int arrLen,String[] arrStr) {
		if(arrLen < 1 || arrLen > Math.pow(10, 5)) return -1;
		int arr[] = new int[arrStr.length];
		for(int i = 0; i < arrStr.length; i++){
			//System.out.println("arrStr[i]==="+arrStr[i]);
			arr[i] = Integer.parseInt(arrStr[i]);
		}
			
		Arrays.sort(arr);
		if(arr[0] < -(Math.pow(10,4)) || arr[arr.length - 1] > Math.pow(10,4))
			return -1;
		int positiveSum = 0;
		int max = arr[0];
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
		
		//if(arr[0] > 0)
			//positiveSum += arr[0];
		for (int i = 1; i < arr.length; i++) {
			//if(arr[i] > 0)
				//positiveSum += arr[i];
			sum[i] = Math.max(arr[i], sum[i - 1] + arr[i]);
			max = Math.max(max, sum[i]);
		}
 
		System.out.println(max);
		return max;
	}
	
	
	public static int maxSubArray(int[] arr) {
		int max = arr[0];
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
 
		for (int i = 1; i < arr.length; i++) {
			sum[i] = Math.max(arr[i], sum[i - 1] + arr[i]);
			max = Math.max(max, sum[i]);
		}
 
		return max;
	}
	
	public static int maxSubArrayModulo(int[] arr, int modulo) {
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
		int maxModulo = sum[0]%modulo;
 
		for (int i = 1; i < arr.length; i++) {
			sum[i] = sum[i - 1] + arr[i];
			maxModulo = Math.max(maxModulo, Math.max(arr[i]%modulo, sum[i]%modulo));
		}
 
		return maxModulo;
	}

}
