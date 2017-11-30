package com.solutions;

import java.util.*;

import com.solutions.GraphAdjList2.Graph2;
public class GraphAdjList {
	
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
	
	class Graph{
		SortedMap<Integer, ArrayList<Edge>> coords;
		
		public Graph(){
			this.coords = new TreeMap<Integer, ArrayList<Edge>>();
		}
		
		public Graph(int nodes){
			this.coords = new TreeMap<Integer, ArrayList<Edge>>();
			for(int i = 1; i <= nodes; i++)
				this.coords.put(i, new ArrayList<Edge>());
			//this.coords = new TreeMap<Integer, ArrayList<Edge>>();
		}
		
		public void addEdge(int u, int v, int w){
			ArrayList<Edge> edges = null;
			if(!this.coords.containsKey(u)){
				edges = new ArrayList<>();
			}else{
				edges = this.coords.get(u);
			}
			edges.add(new Edge(v,w));
			this.coords.put(u, edges);
			
		}
		
		public boolean isConnected(int u, int v){
			for(Edge e : this.coords.get(u)){
				if(e.v == v)
					return true;
			}
			return false;
		}
		public int[] getAllConnected(Integer u){
			int[] distances = new int[this.coords.size() + 1];
            Arrays.fill(distances, -1); // O(n) space.
            Queue<Integer> que = new LinkedList<>();
            
            que.add(u);
            distances[u] = 0;
            HashSet<Integer> visited = new HashSet<>();
            visited.add(u);
            while(!que.isEmpty()){
            	Integer curr = que.poll();
            	for(Edge edge: coords.get(curr)){
            		if(!visited.contains(edge.v)){
            			que.offer(edge.v);
            			visited.add(edge.v);
            			distances[edge.v] = distances[curr] + edge.w;
            		}
            	}
            	
            }
            return distances;
		}
		
		public String getAllConnected2(Integer u){
			StringBuffer buffer = new StringBuffer();
			System.out.println(this.coords);
			for(Map.Entry<Integer,ArrayList<Edge>> e : this.coords.entrySet()) {
				if(e.getKey() == u)
					continue;
				boolean found = false;
				for(Edge edge: e.getValue()){
					if(edge.v == u){
						buffer.append(edge.w + " ");
						found = true;
						break;
					}
				}
				if(!found){
					buffer.append("-1 ");
				}
					
			}
			return buffer.toString();
		}
	}
	
	
	
	public static void main2(String[] args){
		
		Scanner scan = new Scanner(System.in);
		int noOfQueries = Integer.parseInt(scan.nextLine());
		Graph graph = new GraphAdjList().new Graph();
		while(noOfQueries != 0){
			
			String coords = scan.nextLine();
			if((coords.split(" ")).length < 2){
				int node = Integer.parseInt(coords.split(" ")[0]);
				System.out.println(Arrays.toString(graph.getAllConnected(node)));
				noOfQueries--;
				graph = new GraphAdjList().new Graph();
			}else{
				int point1 = Integer.parseInt(coords.split(" ")[0]);
				int point2 = Integer.parseInt(coords.split(" ")[1]);
				graph.addEdge(point1, point2, 6);
				graph.addEdge(point2, point1, 6);
			}
			
			
		}
		scan.close();
		
	}
	
public static void main(String[] args){
		
	Scanner scan = new Scanner(System.in);
	int noOfQueries = Integer.parseInt(scan.nextLine());
	Graph graph = null;
	int noOfNodes = 0;
	int noOfEdges = 0;
	int[] distances = null;
	Integer startPoint = 0;
	while(noOfQueries != 0){
		
		if(noOfNodes == 0 || noOfEdges == 0){
			String coords = scan.nextLine();
			noOfNodes = Integer.parseInt(coords.split(" ")[0]);
			noOfEdges = Integer.parseInt(coords.split(" ")[1]);
			
		}else{
			graph = new GraphAdjList().new Graph(noOfNodes);
			while(noOfEdges != 0){
				String coords = scan.nextLine();
				int point1 = Integer.parseInt(coords.split(" ")[0]);
				int point2 = Integer.parseInt(coords.split(" ")[1]);
				graph.addEdge(point1, point2, 6);
				graph.addEdge(point2, point1, 6);
				noOfEdges--;
			}
			startPoint = Integer.parseInt(scan.nextLine());
			distances = graph.getAllConnected(startPoint);
			noOfQueries--;
			noOfNodes = 0;
		}
	}
	
	if(distances != null){
		for(int i = 1; i < distances.length; i++){
			if(i == startPoint) continue;
			System.out.print(distances[i] + " ");
		}
	}
	
		scan.close();
		
	}

}
