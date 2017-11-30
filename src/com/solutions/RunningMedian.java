package com.solutions;

import java.util.*;
public class RunningMedian {
	
	public static void main(String[] args){
		
		//Descending order for smaller half of integers
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2){
				return i2 - i1;
			}
		});
		
		//Ascending order for larger half of integers
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2){
				return i1 - i2;
			}
		});
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = scan.nextInt();
            //getMedian(maxHeap, minHeap, a[a_i]);
        }
        getMedian(maxHeap, minHeap, a);
        scan.close();
		//getMedian();
        
	}
	
	private static void getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int[] arr){
		
		for (int i = 0; i < arr.length; i++) {
			//Add integer to the correct heap
			if(maxHeap.size() == 0 || arr[i] < maxHeap.peek()){
				maxHeap.add(arr[i]);
			}else{
				minHeap.add(arr[i]);
			}
			
			//Rebalance heaps towards having at most one more than the other 
			PriorityQueue<Integer> biggerHeap = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
			PriorityQueue<Integer> smallerHeap = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;
		
			if(biggerHeap.size() - smallerHeap.size() >= 2){
				smallerHeap.add(biggerHeap.poll());
			}
			
			//get the running median
			if(biggerHeap.size() == smallerHeap.size()){
				System.out.println(((double)(biggerHeap.peek() + smallerHeap.peek())/2));
			}else{
				System.out.println((double)biggerHeap.peek());
			}
		}
		
		
	}
	
	private static void getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int number){
			
		//Add integer to the correct heap
			if(maxHeap.size() == 0 || number < maxHeap.peek()){
				maxHeap.add(number);
			}else{
				minHeap.add(number);
			}
			
			//Rebalance heaps towards having at most one more than the other 
			PriorityQueue<Integer> biggerHeap = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
			PriorityQueue<Integer> smallerHeap = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;
		
			if(biggerHeap.size() - smallerHeap.size() >= 2){
				smallerHeap.add(biggerHeap.poll());
			}
			
			//get the running median
			if(biggerHeap.size() == smallerHeap.size()){
				System.out.println(((double)(biggerHeap.peek() + smallerHeap.peek())/2));
			}else{
				System.out.println((double)biggerHeap.peek());
			}
		
	}
	

	
	private static void getMedian(){
		//Descending order for smaller half of integers
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2){
				return i2 - i1;
			}
		});
		
		//Ascending order for larger half of integers
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2){
				return i1 - i2;
			}
		});
		
		//Add integer to the correct heap
		int[] arr = {12,4,5,3,8,7};
		for (int i = 0; i < arr.length; i++) {
			
			if(maxHeap.size() == 0 || arr[i] < maxHeap.peek()){
				maxHeap.add(arr[i]);
			}else{
				minHeap.add(arr[i]);
			}
			
			//Rebalance heaps towards having at most one more than the other 
			PriorityQueue<Integer> biggerHeap = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
			PriorityQueue<Integer> smallerHeap = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;
		
			if(biggerHeap.size() - smallerHeap.size() >= 2){
				smallerHeap.add(biggerHeap.poll());
			}
			
			System.out.println("maxHeap.size()====="+maxHeap.size());
			System.out.println("minHeap.size()====="+minHeap.size());
			
			System.out.println("maxHeap.toArray()====="+Arrays.toString(maxHeap.toArray()));
			System.out.println("minHeap.toArray()====="+Arrays.toString(minHeap.toArray()));
			
			System.out.println("maxHeap.peek()====="+maxHeap.peek());
			System.out.println("minHeap.peek()====="+minHeap.peek());
			
			//get the running median
			if(biggerHeap.size() == smallerHeap.size()){
				System.out.println("Average");
				System.out.println(((double)(biggerHeap.peek() + smallerHeap.peek())/2));
			}else{
				System.out.println("Middle");
				System.out.println((double)biggerHeap.peek());
			}
		}
		
		System.out.println(Arrays.toString(minHeap.toArray()));
		System.out.println(Arrays.toString(maxHeap.toArray()));
		//steps
		//add larger integer to minHeap
		//compare i.e maxHeap size - minHeap size > 2
		//get median
	}
}
