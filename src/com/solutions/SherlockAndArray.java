package com.solutions;

import java.util.*;

public class SherlockAndArray {
	
	/*public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int cases = Integer.parseInt(s.nextLine());
		for(int i = 0; i < cases; i++){
			int arrLength = Integer.parseInt(s.nextLine());
			String[] arrElements = s.nextLine().split(" ");
			System.out.println(checkEqualSum(arrElements,arrLength));
		}
	}
	
	public static String checkEqualSum(String[] arrString, int arrLength){
		int[] arr = new int[arrString.length];
		int rightSum = 0;
		String isEqual = "NO";
		for(int i = 0; i < arrString.length; i++){
			arr[i] = Integer.parseInt(arrString[i]);
			if(i > 1)
				rightSum += arr[i];
		}
		
		int leftSum = arr[0];
		
		System.out.println("Initial Left Sum ===="+leftSum);
		System.out.println("Initial Right Sum ===="+rightSum);
		
		for(int i = 1; i < (arr.length - 1); i++){
			System.out.println("Left Sum ===="+leftSum);
			System.out.println("Right Sum ===="+rightSum);
			if(leftSum == rightSum){
				isEqual = "YES";
				break;
			}else{
				leftSum += arr[i];
				if(i < arr.length - 2)
				 rightSum -= arr[i+1];
			}
		}
		return isEqual;
	}*/
	
	static String solve(int[] a){
        // Complete this function
        int rightSum = 0;
		String isEqual = "NO";
        for(int i = 0; i < a.length; i++){
        		rightSum += a[i];
        }
        int leftSum = 0;
		for(int i = 0; i < a.length; i++){
			if(leftSum == rightSum- a[i]-leftSum){
				isEqual = "YES";
				break;
			}else{
				leftSum += a[i];
			}
		}
		return isEqual;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        if(T < 1 || T > 10) return;
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            if(n < 1 || n > Math.pow(10,5)) return;
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
                if(a[a_i] < 1 || a[a_i] > (2 * Math.pow(10,4))) return;
            }
            String result = solve(a);
            System.out.println(result);
        }
        in.close();
    }

}
