package com.solutions;

import java.util.*;

class IceCream {
    private int id;
    private int price;

    public IceCream(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}

public class IceCreamParlour {
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int noOfTrips = scan.nextInt();
        for(int i = 0; i < noOfTrips; i++){
        	int totalAmt = scan.nextInt();
        	int noOfFlavours = scan.nextInt();
        	List<IceCream> iceCreams = new ArrayList<>();
        	for(int j = 1; j <= noOfFlavours; j++){
        		int price = scan.nextInt();
        		iceCreams.add(new IceCream(j, price));
        	}
        	
        	Collections.sort(iceCreams, new Comparator<IceCream>(){
        		public int compare(IceCream cream1, IceCream cream2){
        			return cream1.getPrice() - cream2.getPrice();
        		}
        	});
        	doSearch(iceCreams,totalAmt);
        }
        
        scan.close();
    }
	
	private static void doSearch(List<IceCream> iceCreams, int amount){
		for(int i = 0; i < iceCreams.size(); i++){
			int balance = amount - iceCreams.get(i).getPrice();
			
			//int index = doIterativeBinarySearch(iceCreams, balance);
			int index = doRecursiveBinarySearch(0,iceCreams.size() - 1,iceCreams, balance);
			
			if(index != -1){
				int first = iceCreams.get(i).getId();
                int second = iceCreams.get(index).getId();
                if (first != second) { 
                System.out.println(Math.min(first, second) + " " + Math.max(first, second));
                return;
                }
			}
		}
	}
	
	private static int doIterativeBinarySearch(List<IceCream> iceCreams, int amount){
		int leftIndex = 0;
		int rightIndex = iceCreams.size() - 1;
		
		
		while(leftIndex < rightIndex){
			int midIndex = leftIndex +((rightIndex - leftIndex)/2);
			if(amount == iceCreams.get(midIndex).getPrice()){
				return midIndex;
			}
			else if(amount < iceCreams.get(midIndex).getPrice()){
				rightIndex = midIndex - 1;
			}
			else{
				leftIndex = midIndex + 1;
			}
		}
		
		return -1;
	}
	
	private static int doRecursiveBinarySearch(int leftIndex, int rightIndex, List<IceCream> iceCreams, int amount){
		if(leftIndex<=rightIndex){
			int midIndex = leftIndex +((rightIndex - leftIndex)/2);
			if(amount == iceCreams.get(midIndex).getPrice()){
				return midIndex;
			}else if(amount < iceCreams.get(midIndex).getPrice()){
				return doRecursiveBinarySearch(leftIndex, midIndex-1,iceCreams,amount);
			}else if(amount > iceCreams.get(midIndex).getPrice()){
				return doRecursiveBinarySearch(midIndex+1, rightIndex,iceCreams,amount);
			}else{
				return -1;
			}
		}
		
		
		return -1;
	}

	private static void solutionOne() {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            List<IceCream> iceCreams = new ArrayList<>();
            for (int a_i = 0; a_i < n; a_i++) {
                int price = in.nextInt();
                a[a_i] = price;
                iceCreams.add(new IceCream(a_i+1, price));
            }

            // Needs to be sorted for binary search to work
            Collections.sort(iceCreams, new Comparator<IceCream>() {
                @Override
                public int compare(IceCream o1, IceCream o2) { // Sort in ascending order
                    return o1.getPrice() - o2.getPrice();
                }
            });

            // Do search
            search(iceCreams, m);
        }
        in.close();
	}

    private static void search(List<IceCream> a, int m) {

        // Go through all elements, get the remainder and look for that remainder using binary search
        for (int i = 0; i < a.size(); i++) {
            int remaining = m - a.get(i).getPrice();

            int index = binarySearch(a, remaining);

            // Found second element that adds up to m
            if (index != -1) {
                int first = a.get(i).getId();
                int second = a.get(index).getId();

                if (first != second) { // We want unique elements
                    System.out.println(Math.min(first, second) + " " + Math.max(first, second));
                    return;
                }
            }
        }
    }

    // Binary Search - got help with this from the video on the problem page
    private static int binarySearch(List<IceCream> a, int m) {
        int left = 0;
        int right = a.size() - 1;
        
        while (left <= right) {
            int mid = left + ((right - left) / 2); // get the midpoint between left and right on the list
            if (a.get(mid).getPrice() == m) {
                return mid;
            } else if (m < a.get(mid).getPrice()) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1; // Not found
    }

}

//Solution 2

class IceCreamP implements Comparable<IceCreamP>{
    int flavor;
    int index;

    public IceCreamP(int flavor, int index) {
        this.flavor=flavor;
        this.index=index;
    }
   
    public int compareInt(int o) {
        return (int)(this.flavor-o);
       
    }
    @Override
    public int compareTo(IceCreamP o) {
        return (int)(this.flavor-o.flavor);
       
    }

    @Override
    public boolean equals(Object o){
        return (this.flavor==(int)o ? true:false);
       
    }
        
}

class SolutionP {
	   
    public static int binarySearch(int first, int last, IceCreamP[] arr, int search) {
        if(first<=last){
        int mid=(int)(first+last)/2;
        if(arr[mid].equals(search)) return arr[mid].index;
        if(arr[mid].compareInt(search)>0){
            return binarySearch(first,mid-1,arr,search);
        }
        else return binarySearch(mid+1,last,arr,search);
        }
        else if(first==last && arr[first].equals(search)) return arr[first].index;
        else return -1;
        
    }
    public static void main(String[] args) {
        
        int t;
        int n, m;
 
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
       for(int test = 0; test < t; test++) {       
            
            m = in.nextInt();
            n = in.nextInt(); 
            IceCreamP[] arr = new IceCreamP[n];
    
            for (int i = 0; i < n; i++)
                arr[i] = new IceCreamP(in.nextInt(), i + 1);
            
            Arrays.sort(arr);
            //int firstIndex = 100000, secondIndex = 100000;
            for(int i = 0; i < n - 1 ; i++) {
                int search = m - arr[i].flavor;
                if(search >= arr[i].flavor) {
                    int index = binarySearch( i + 1, n - 1, arr, search);
                    if( index != -1 ) {
                        System.out.println( Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
                        break;

                    }
                }
            } 
            
        }
       in.close();
        
    }
                        
}
