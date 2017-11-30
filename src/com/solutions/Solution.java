package com.solutions;

import java.util.Scanner;
import java.util.HashMap;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		test();
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        getLonelyInteger(a);*/
    }
    
    private static void getLonelyInteger(int[] arr){
        int val = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            val ^= arr[i];
        }
        System.out.println(val);
    }
    
    public static void test(){
    	try{
    		throw new Exception();
    	}catch(Exception ex){
    		
    	}
    	System.out.println("Hi Raman");
    }
    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            String operation = scan.next();
            String contact   = scan.next();
            if (operation.equals("add")) {
                trie.add(contact);
            } else if (operation.equals("find")) {
                System.out.println(trie.find(contact));
            }
        }
        scan.close();
    }
}

class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap<>();
    public int size;

    public void putChildIfAbsent(char ch) {
        children.putIfAbsent(ch, new TrieNode());
    }

    public TrieNode getChild(char ch) {
        return children.get(ch);
    }
}

class Trie {
    TrieNode root;

    Trie(){
    	root = new TrieNode();
    } 
    
    public void add(String str) {
        TrieNode curr = root;
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            curr.putChildIfAbsent(ch);
            curr = curr.getChild(ch);
            curr.size++;
        }
    }
    
    public int find(String prefix) {
        TrieNode curr = root;
        
        for (int i = 0; i < prefix.length(); i++) {
            Character ch = prefix.charAt(i);
            curr = curr.getChild(ch);
            if (curr == null) {
                return 0;
            }
        }
        return curr.size;
    }*/
}
