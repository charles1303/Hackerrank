package com.solutions;

import java.util.Arrays;
import java.util.Scanner;

public class LargestPermutation {
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String[] nkVals = s.nextLine().split(" ");
		int n = Integer.parseInt(nkVals[0]);
		int k = Integer.parseInt(nkVals[1]);
		
		String[] arrVals = s.nextLine().split(" ");
		//getMaxPermutation(n,k,arrVals);
		getMaxPerm(n,k,arrVals);
	}
	
	private static void getMaxPerm(int n,int k, String[] arrVals){
		 //Create an array to show where each number currently is
		int[] arr = new int[n];
		for(int i = 0; i < arrVals.length; i++)
			arr[i] = Integer.parseInt(arrVals[i]);
	    final int[] posArray = new int[n+1];
	    for(int i = 0; i < n; ++i){
	      posArray[arr[i]] = i;
	      System.out.println("arr[i]===="+arr[i]);
	      System.out.println("i===="+i);
	      System.out.println("pos===="+Arrays.toString(posArray));
	    }
	    
	    System.out.println("arr===="+Arrays.toString(arr));
	    
	    System.out.println("final pos===="+Arrays.toString(posArray));
	    
	    //Make at most K swaps to sort list in reverse chronological order:
	    //  For each natural number 'i' from N to 1...
	    for(int i = n, swaps = k; i > 0; --i){
	      
	      //Get the current position
	      final int currPosition = posArray[i];
	      //System.out.println("actualPos===="+actualPos);
	      
	      //Get the expected position when sorted in reverse
	      final int newPosition = n - i;
	      //System.out.println("expectedPos===="+expectedPos);
	      
	      //If 'i' is not in the correct place...
	      if(currPosition != newPosition){
	        
	        //Swap whatever's in i's place with i
	    	System.out.println("actualPos===="+currPosition);
	    	System.out.println("expectedPos===="+newPosition);
	    	System.out.println("before swap : pos[arr[expectedPos]]===="+posArray[arr[newPosition]]);
	    	posArray[arr[newPosition]] = currPosition;
	        System.out.println("after swap : pos[arr[expectedPos]]===="+posArray[arr[newPosition]]);
	        System.out.println("expectedPos===="+newPosition);
	        System.out.println("arr[expectedPos]===="+arr[newPosition]);
	        System.out.println("arr[actualPos]===="+arr[currPosition]);
	        System.out.println("i===="+i);
	        arr[currPosition] = arr[newPosition];
	        arr[newPosition] = i;
	        
	        //Stop sorting if we're out of swaps
	        if(--swaps < 1){
	          break;
	        }
	      }
	}
	    StringBuffer sb = new StringBuffer();
	    for(int i = 0; i < n; sb.append(arr[i++] + " ")){}
	System.out.print(sb.toString());
	}
	
	private static void getMaxPermutation(int n, int k, String[] arrVals){
		if(n < 1 || n > Math.pow(10, 5)) return;
		if(k < 1 || k > Math.pow(10,9)) return;
		if(n != arrVals.length) return;
		int[] arr = new int[n];
		for(int i = 0; i < arrVals.length; i++)
			arr[i] = Integer.parseInt(arrVals[i]);
		
			for(int j = 0,i = k; j < n && i > 0; j++,i--){
				int maxIndex = findMaxIndex(j,arr);
				if(maxIndex != j){
					int temp = arr[j];
					arr[j] = arr[maxIndex];
					arr[maxIndex] = temp;
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < arr.length; i++){
				sb.append(arr[i]);
				sb.append(" ");
			}
				
			System.out.println(sb.toString());
		
	}
	
	private static int findMaxIndex(int currIndex, int[] arr){
		int maxIndex = currIndex;
		for(int i = currIndex + 1; i < arr.length; i++){
			if(arr[i] > arr[currIndex]){
				maxIndex = i;
			}
		}
		return maxIndex;
		//System.out.println(Arrays.toString(arr));
	}

}
