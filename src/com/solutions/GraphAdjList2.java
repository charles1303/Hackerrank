package com.solutions;

import java.util.*;

public class GraphAdjList2 {

	class Edge{
		int v;
		int w;
		
		public Edge(int v, int w){
			this.v = v;
			this.w = w;
		}
		
		@Override
		public String toString(){
			return "("+v+","+w+")";
		}
	}
	
	class Graph2{
		ArrayList<Edge>[] coords;
		
		public Graph2(int noOfNodes){
			coords = new ArrayList[noOfNodes+1];
			for(int i = 1; i <= noOfNodes; i++)
				coords[i] = new ArrayList<>();
				
		}
		
		public void addEdge(int u, int v, int w){
			if(u >= this.coords.length) return;
			this.coords[u].add(new Edge(v,w));
		}
		
		
		public String getAllConnected(Integer u){
			StringBuffer buffer = new StringBuffer();
			System.out.println(Arrays.toString(this.coords));
			for(int i = 1; i < this.coords.length; i++){
				if(i == u)
					continue;
				ArrayList<Edge> edges = coords[i];
				boolean found = false;
				for(Edge e: edges){
					if(e.v == u){
						found = true;
						buffer.append(e.w+" ");
						break;
					}
				}
				if(!found)
					buffer.append("-1 ");
			}
			System.out.println(buffer.toString());
			return buffer.toString();
		}
	}
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int noOfQueries = Integer.parseInt(scan.nextLine());
		Graph2 graph = null;
		int noOfNodes = 0;
		int noOfEdges = 0;
		while(noOfQueries != 0){
			
			if(noOfNodes == 0 || noOfEdges == 0){
				String coords = scan.nextLine();
				noOfNodes = Integer.parseInt(coords.split(" ")[0]);
				noOfEdges = Integer.parseInt(coords.split(" ")[1]);
				
			}else{
				graph = new GraphAdjList2().new Graph2(noOfNodes);
				while(noOfEdges != 0){
					String coords = scan.nextLine();
					int point1 = Integer.parseInt(coords.split(" ")[0]);
					int point2 = Integer.parseInt(coords.split(" ")[1]);
					graph.addEdge(point1, point2, 6);
					graph.addEdge(point2, point1, 6);
					noOfEdges--;
				}
				Integer startPoint = Integer.parseInt(scan.nextLine());
				graph.getAllConnected(startPoint);
				noOfQueries--;
				noOfNodes = 0;
			}
		}
		scan.close();
	}
}
