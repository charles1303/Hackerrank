package com.solutions;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JimOrders {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer,Integer> orderMap = new HashMap<>();
        for (int i = 1;i <= n;i++){
            int time = scanner.nextInt()+scanner.nextInt();
            orderMap.put(i,time);
        }
        printOrder(orderMap);
        scanner.close();
    }

	private static void printOrder(Map<Integer, Integer> orderMap) {
		System.out.println(orderMap);
        List<Map.Entry<Integer,Integer>> orderMapList = 
            new LinkedList<>(orderMap.entrySet());
        Collections.sort(orderMapList, (e1,e2) -> (e1.getValue()).compareTo(e2.getValue()));
        System.out.println(orderMap);
        for (Map.Entry<Integer,Integer> entry : orderMapList) {
            System.out.print(entry.getKey() + " ");
        }
	}

}
