package com.solutions;

import java.util.Arrays;

public class LonelyInteger {
	
	private static void getLonelyInteger(int[] arr){
        int val = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            val ^= arr[i];
        }
        System.out.println(val);
    }

}
