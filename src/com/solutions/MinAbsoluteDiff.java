package com.solutions;

import java.util.*;

public class MinAbsoluteDiff {

	static int minimumAbsoluteDifference(int n, int[] arr) {
        // Complete this function
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n-1; i++)
        {
            int currentMin = Math.abs(arr[i]-arr[i+1]);
            System.out.println("Min Value=="+currentMin+ " for arr[i]=="+arr[i]+" and arr[i+1]=="+arr[i+1]);
            min = Math.min(min, currentMin);
        }
        
        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = minimumAbsoluteDifference(n, arr);
        System.out.println(result);
        in.close();
    }
}
