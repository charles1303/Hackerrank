package com.solutions;

import java.util.*;

public class MaxSubArrayModulo {
	
	public static void main(String[] args){
		/*Scanner s = new Scanner(System.in);
		int queries = Integer.parseInt(s.nextLine());
		int maxModulo = 0;
		
		for(int i = 0; i <queries; i++){
			String arrLenModulo = s.nextLine();
			int arrLen =  Integer.parseInt(arrLenModulo.split(" ")[0]);
			int modulo = Integer.parseInt(arrLenModulo.split(" ")[1]);
			String[] arr = s.nextLine().split(" ");
			//getSubArrayModulo2(arr, arrLen, modulo);
			int[] arrNum = new int[arr.length];
			for(int j = 0; j < arr.length ; j++){
				arrNum[j] = Integer.parseInt(arr[j]);
			}
			//maxModulo = getSubArrayModuloDivideAndConquer(arrNum, maxModulo, modulo);
			System.out.println(getSubArrayModuloDivideAndConquer3(arrNum, maxModulo, modulo));
		}
		s.close();*/
		int[] arr = {9,3,3,5,9};
		int[] arr2 ={3,2,7,4};
		int k = 7;
		//getMaxSubArrayModulo(arr,k);
		//int[] maxMod = {Integer.MIN_VALUE};
		//System.out.println(Arrays.toString(getSubArrayModuloDivideAndConquer(arr2,maxMod,k)));
		
		//System.out.println(maxModulo[0]);
	}
	
	private static int[] getSubArrayModuloDivideAndConquer(int[] arr, int[] maxModulo,int modulo){
		if(arr.length == 1) return arr;
		
		int[] first = new int[arr.length/2];
		int[] second = new int[arr.length - first.length];
		System.arraycopy(arr, 0, first, 0, first.length);
		System.arraycopy(arr,first.length,second,0,second.length);
		
		
		getSubArrayModuloDivideAndConquer(first, maxModulo,modulo);
		getSubArrayModuloDivideAndConquer(second, maxModulo, modulo);
		
		System.out.println("FIRST=====" + Arrays.toString(first));
		System.out.println("SECOND====="+Arrays.toString(second));
		
		int firstSum = 0;
		int firstModulo = 0;
		for(int i = 0; i < first.length; i++){
			firstSum += first[i];
			firstModulo = Math.max(firstSum%modulo, firstModulo);
		}
		int midSum = firstSum;
		int midModulo = 0;
		for(int i = 0; i < second.length; i++){
			midSum += second[i];
			midModulo = Math.max(midSum%modulo, midModulo);
		}
		
		int secondSum = 0;
		int endModulo = 0;
		for(int i = 0; i < second.length; i++){
			secondSum += second[i];
			endModulo = Math.max(secondSum%modulo, endModulo);
		}
		maxModulo[0] = Math.max(firstModulo, Math.max(midModulo,endModulo));
		return maxModulo;
	}
	
	public static long maxModulo(long[] arr, final long moduloOperand) {
	    long[] moduloSum = new long[arr.length];
	    TreeSet<Long> treeSet = new TreeSet<>();

	    moduloSum[0] = arr[0] % moduloOperand;
	    treeSet.add(moduloSum[0]);
	    long maxModulo = moduloSum[0];

	    for (int i = 1; i < arr.length; i++) {

	        moduloSum[i] = (moduloSum[i - 1] + arr[i]) % moduloOperand;

	        // find least element in the tree strictly greater than moduloSum[i]
	        Long minGreaterValue = treeSet.higher(moduloSum[i]);

	        if (minGreaterValue == null) {
	            // can't find minGreaterValue, then compare minGreaterValue and moduloSum[i]
	            maxModulo = Math.max(moduloSum[i], maxModulo);
	        } else {
	            maxModulo = Math.max((moduloSum[i] - minGreaterValue + moduloOperand) % moduloOperand, maxModulo);
	        }
	        treeSet.add(moduloSum[i]);
	    }
	    return maxModulo;
	 }
	
	public static class Solution {

	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner in = new Scanner(System.in);
	        int c = in.nextInt();
	        for(int k=0;k<c;k++){
	            int n = in.nextInt();
	            long m = in.nextLong();
	            long[] a = new long[n];
	            long[][] prefix = new long[n][2];
	            boolean found = false;
	            long max = Long.MIN_VALUE;
	            for(int i=0;i<n;i++){
	                a[i] = in.nextLong()%m;
	                if(i>0){
	                    prefix[i][0] = (prefix[i-1][0] + a[i])%m;
	                    prefix[i][1] = i;
	                }else{
	                    prefix[0][0] = a[0];
	                }
	                if(prefix[i][0] > max) max = prefix[i][0];
	                if(max == m-1) found=true;
	            }
	            if(found){
	                System.out.println(max);
	            }else{
	                Arrays.sort(prefix, (x,y) -> Long.compare(x[0],y[0]));
	                for(int i=1;i<n;i++){
	                    if(prefix[i][1] < prefix[i-1][1] && m - (prefix[i][0] - prefix[i-1][0]) > max && prefix[i][0] - prefix[i-1][0] != 0){
	                        max = m - (prefix[i][0] - prefix[i-1][0]);
	                        if(max == m-1) break;
	                    }
	                }
	                System.out.println(max);
	            }
	            
	        }
	    }
	    static long max(long a, long b){
	        return (a>b) ? a:b;
	    }
	}

}
