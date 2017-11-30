package com.solutions;

import java.util.*;

public class Pairs {
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String firstLine = s.nextLine();
		int n = Integer.parseInt(firstLine.split(" ")[0]);
		int k = Integer.parseInt(firstLine.split(" ")[1]);
		String secondLine = s.nextLine();
		String[] arr = secondLine.split(" ");
		s.close();
		getPairs(arr,n,k);
		
	}
	
		
public static void getPairs(String[] arr,int n,int k){
		
		Map<Integer,Integer> uniqueMap = new HashMap<Integer,Integer>();
		if(n < 2 || n > Math.pow(10, 5)) return;
		if(k < 0 || k >= Math.pow(10, 9)) return;
		int loopStatus = 0;
		int[] num = new int[arr.length];
		for(int i = 0; i < arr.length;i++){
			int no = Integer.parseInt(arr[i]);
			if(no <= 0){
				loopStatus = -1;
			}
			if(no > (Integer.MAX_VALUE - k)){
				loopStatus = -1;
			}
			if(uniqueMap.containsKey(no)){
				loopStatus = -1;
			}
			if(loopStatus < 0)break;
			uniqueMap.put(no, 1);
			num[i] = no;
						
		}
		if(loopStatus < 0) return;	
		Arrays.sort(num);
		getPairs(num,k);
	}
	
	public static void getPairs(int[] num, int k){
		int count = 0;
		for (int i = 0, j = 1; i < num.length && j < num.length;) {
			if (num[j] - num[i] == k) { // found a pair
				count++;
				i++;
				j++;
			} else if (num[j] - num[i] < k) { // difference is less than wanted so increment right pointer
				j++;
			} else { // difference is more than wanted so increment the left pointer 
				i++;
			}

	}
		System.out.println(count);
	}
	
}
