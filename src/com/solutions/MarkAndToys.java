package com.solutions;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {
	
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int totalToys = Integer.parseInt(str.split(" ")[0]);
		int maxAmount = Integer.parseInt(str.split(" ")[1]);
		//s.close();
		//System.out.println("String: " + str);
		//System.out.println("Total Toys: " + totalToys);
		//System.out.println("Total Amt: " + maxAmount);
		str = s.nextLine();
		String[] arr = str.split(" ");
		maxToysBought(totalToys, maxAmount,arr);
		
	}
	
	public static int maxToysBought(int totalToys, double maxAmount,String[] arr){
		
		if(arr.length < 1 || arr.length > Math.pow(10, 5)) return -1;
		if(maxAmount < 1 || maxAmount > Math.pow(10,9)) return -1;
		int[] toyAmt = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			toyAmt[i] = Integer.parseInt(arr[i]);
		}
		System.out.println(Arrays.toString(toyAmt));
		Arrays.sort(toyAmt);
		if(toyAmt[0] < 1 || toyAmt[toyAmt.length - 1] > Math.pow(10, 9)) return -1;
		
		//System.out.println(Arrays.toString(toyAmt));
		
		int totalAmtSpent = 0;
		int toysBoughtCnt = 0;
		for(int i = 0; i < toyAmt.length;i++){
			if((totalAmtSpent + toyAmt[i])  >= maxAmount){
				break;
				
			}else{
				toysBoughtCnt++;
				//System.out.println("totalAmtSpent===="+totalAmtSpent);
				//System.out.println("toyAmt[i]==="+toyAmt[i]);
				totalAmtSpent += toyAmt[i];
				//System.out.println("New Amt===="+totalAmtSpent);
			}
			
		}
		return toysBoughtCnt;
	}
	
	

}
