package com.solutions;

import java.util.*;

public class LuckBalance {

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String firstInput = s.nextLine();
		int n = Integer.parseInt(firstInput.split(" ")[0]);
		int k = Integer.parseInt(firstInput.split(" ")[1]);
		
		if(n < 1 || n > 100) return;
		if(k < 1 || k > n) return;
		String contestInput = "";
		
		PriorityQueue<Integer> importantTests=new PriorityQueue<Integer>(1,new Comparator<Integer>() {
	        @Override
	        public int compare(Integer o1, Integer o2) {
	            return o2-o1;
	        }
	    });
		
		PriorityQueue<Integer> nonImportantTests=new PriorityQueue<Integer>(1,new Comparator<Integer>() {
	        @Override
	        public int compare(Integer o1, Integer o2) {
	            return o1-o2;
	        }
	    });
	    
	    
		for(int i = 0; i < n; i++){
			contestInput = s.nextLine();
			int contestLuck = Integer.parseInt(contestInput.split(" ")[0]);
			int contestImportance = Integer.parseInt(contestInput.split(" ")[1]);
			
			if(contestLuck < 1 || contestLuck > Math.pow(10, 4)) return;
			if(contestImportance < 0 || contestImportance > 1) return;
			
			if(contestImportance == 1){
				importantTests.add(contestLuck);
			}else{
				nonImportantTests.add(contestLuck);
			}
			
		}
		s.close();
		getLuckBal(importantTests,nonImportantTests,k);
		
	}
	
	private static void getLuckBal(PriorityQueue<Integer> importantTests,PriorityQueue<Integer> nonImportantTests,int k){
		int cnt = 0;
		int sum = 0;
		
		for(Iterator<Integer> iterator = importantTests.iterator();iterator.hasNext();){
			if(cnt >= k){
				sum -= importantTests.poll();
			}else{
				nonImportantTests.add(importantTests.poll());
			}
			cnt++;
		}
		for (Iterator<Integer> iterator = nonImportantTests.iterator(); iterator.hasNext();) {
			sum += nonImportantTests.poll();
		}
		
		System.out.println("sum============"+sum);
	}
	
	private static void getLuckBalance(TreeMap<Integer, Integer> contestsMap, int k){
			int maxImportantFailures = 0;
			int totalFailureSum = 0;
			for (Map.Entry<Integer, Integer> entry : contestsMap.entrySet()) {
			    System.out.println("Key 2 = " + entry.getKey() + ", Value 2 = " + entry.getValue());
			    if(entry.getValue() == 1 && maxImportantFailures == 3)
			    	continue;
			    else{
			    	if(entry.getValue() == 1)
			    		maxImportantFailures++;
			    	System.out.println("entry.getKey()======"+entry.getKey());
			    	totalFailureSum += entry.getKey();
			    }
			    
			    
			}
			
			System.out.println("totalFailureSum======"+totalFailureSum);
			
		}
	
	private static void getLuckBalance(HashMap<Integer, Integer> contestsMap, int k){
		
		
		SortedSet<Integer> keys = new TreeSet<Integer>(contestsMap.keySet());
		
		for (Map.Entry<Integer, Integer> entry : contestsMap.entrySet()) {
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		
	}
}
