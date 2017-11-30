package com.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConnectedCellGrid {
	
	    static int rows,cols,arr[][];
	    public static int cells(int i,int j){
	        if(((i < 0 || j < 0) || (i >= rows || j >= cols))  ||  arr[i][j] == 0 || arr[i][j] == -1 )
	            return 0;
	        arr[i][j] = -1;
	        return 1 + cells(i-1,j-1) + cells(i-1,j) + cells(i-1,j+1) + cells(i,j-1) + cells(i,j+1) + cells(i+1,j-1) + cells(i+1,j) + cells(i+1,j+1);
	    }

	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner scannner = new Scanner(System.in);
	        int large=0;
	        rows = scannner.nextInt();
	        cols = scannner.nextInt();
	        scannner.nextLine();
	        arr = new int[rows][cols];
	        for(int i = 0;i < rows; i++){
	            String input[] = scannner.nextLine().split(" ");
	            for(int j = 0; j < input.length; j++){
	                arr[i][j] = Integer.parseInt(input[j]);
	                //System.out.println(arr[i][j]);
	            }
	        }
	        for(int i = 0;i < rows; i++){
	            for(int j = 0; j< cols; j++){
	                if(arr[i][j] == 1)
	                    large = Math.max(large,cells(i,j));
	            }
	        }
	        System.out.print(large);
	        scannner.close();
	    }
	
	    

}

class ConnectedCellGrid2 {
    
    private static int[][] matrix;
    private static Map<Integer, Integer> regMap = new HashMap<>();
    private static int regKey = 0;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        matrix = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        solve();
    }
    
    private static void solve() {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 1) {
                    processRegion(i, j);
                }
            }
        }
        SortedSet<Integer> res = new TreeSet<Integer>(regMap.values());
        System.out.println(res.last());
    }
    
    private static void processRegion(int i, int j) {
        regMap.put(++regKey, 0);
        visitNodes(i, j);
    }
    
    private static void visitNodes(int i, int j) {
        regMap.put(regKey, regMap.get(regKey) + 1);
        //Mark as visited
        matrix[i][j] = 9;
        for(int x = i - 1; x <= i + 1; x++) {
            for(int y = j - 1; y <= j + 1; y++) {
                if(x == i && y == j) {
                    continue;
                }
                try {
                    if(matrix[x][y] == 1) {
                        visitNodes(x, y);
                    }
                } catch (Exception e) {
                	throw e;
                }
            }
        }
    }
    
}
