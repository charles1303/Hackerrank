package com.solutions;

import java.util.*;

public class CoinChange {
	
	public static long getChangeOptions(int[] coinValues, int amount, int arrayIndex, HashMap<String, Long> memo){
		long noOfOptions = 0;
		int coinValuesAmount = 0;
		String key = amount + "_" + arrayIndex;
		
		if(amount == 0)
			return 1;
		
		if(arrayIndex >= coinValues.length)
			return 0;
		
		//System.out.println("key====="+key);
		//System.out.println("key value====="+memo.get(key));
		//System.out.println("coinValues[arrayIndex]====="+coinValues[arrayIndex]);
		
		System.out.println("************************************************");
		if(memo.containsKey(key)){
			System.out.println("amount====="+amount);
			System.out.println("key "+key+ " with value "+memo.get(key)+" exists");
			return memo.get(key);
		}
			
		
		while(coinValuesAmount <= amount){
			int amountLeft = amount - coinValuesAmount;
			noOfOptions += getChangeOptions(coinValues, amountLeft, arrayIndex + 1, memo);
			coinValuesAmount += coinValues[arrayIndex];
		}
		memo.put(key, noOfOptions);
		return noOfOptions;
	}
	
	public static void main(String[] args){
		//int[] coinValues = {1,2,3};
		//int amount = 4;
		int[] coinValues = {2,5,3,6};
		int amount = 10;
		long ways = getChangeOptions(coinValues, amount, 0, new HashMap<String, Long>());
		System.out.println("ways====="+ways);
	}

}
