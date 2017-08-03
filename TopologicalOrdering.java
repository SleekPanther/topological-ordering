import java.util.*;

public class TopologicalOrdering{
	public static void findTopologicalOrdering(ArrayList<ArrayList<Integer>> graph){
		int[] incomingEdgeCount = new int[graph.size()];
		for(int v = 0; v<graph.size(); v++){
			for(int w : graph.get(v)){
				incomingEdgeCount[w]++;
			}
		}
		
		LinkedList<Integer> nodesWithNoIncomingEdges = new LinkedList<Integer>();
		for(int v = 0; v<incomingEdgeCount.length; v++){
			if(incomingEdgeCount[v]==0){
				nodesWithNoIncomingEdges.add(v);
			}
		}
		
		if(nodesWithNoIncomingEdges.isEmpty()){		//Not a DAG, terminate early
			System.out.println("Failed to find node with no incoming edges. \nMust contain a cycle and therefore no Topological Ordering exists.");
			return;
		}
		
		
		ArrayList<Integer> topolpgicalOrdering = new ArrayList<Integer>();
		while(!nodesWithNoIncomingEdges.isEmpty()){
			int v = nodesWithNoIncomingEdges.remove();
			topolpgicalOrdering.add(v);
			for(int w : graph.get(v)){
				incomingEdgeCount[w]--;
				if(incomingEdgeCount[w]==0){
					nodesWithNoIncomingEdges.add(w);
				}
			}			
		}
		
		if(topolpgicalOrdering.size() == graph.size()){
			System.out.println("Topological Ordering: "+topolpgicalOrdering);
		}else{
			System.out.println("Failed to reach all nodes. Must contain a cycle and therefore no Topological Ordering exists.");
		}
	}
	
	
	public static void main(String[] args){
		System.out.println("Graph 1");
		ArrayList<ArrayList<Integer>> graph1 = new ArrayList<ArrayList<Integer>>();
		graph1.add(new ArrayList<Integer>(Arrays.asList(3, 4, 6)));
		graph1.add(new ArrayList<Integer>(Arrays.asList(2, 4, 5)));
		graph1.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
		graph1.add(new ArrayList<Integer>(Arrays.asList(4)));
		graph1.add(new ArrayList<Integer>(Arrays.asList(5, 6)));
		graph1.add(new ArrayList<Integer>(Arrays.asList(6)));
		graph1.add(new ArrayList<Integer>());
		
		TopologicalOrdering.findTopologicalOrdering(graph1);
		
		
		System.out.println("\nGraph 2");
		ArrayList<ArrayList<Integer>> graph2 = new ArrayList<ArrayList<Integer>>();
		graph2.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
		graph2.add(new ArrayList<Integer>(Arrays.asList(2)));
		graph2.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
		graph2.add(new ArrayList<Integer>(Arrays.asList(4)));
		graph2.add(new ArrayList<Integer>());		//node with not outgoing edges, but still connected
		graph2.add(new ArrayList<Integer>());		//orphan node
		
		TopologicalOrdering.findTopologicalOrdering(graph2);
		
		
		System.out.println("\nGraph 3");
		ArrayList<ArrayList<Integer>> graph3 = new ArrayList<ArrayList<Integer>>();
		graph3.add(new ArrayList<Integer>(Arrays.asList(1)));
		graph3.add(new ArrayList<Integer>(Arrays.asList(2)));
		graph3.add(new ArrayList<Integer>(Arrays.asList(0)));
		
		TopologicalOrdering.findTopologicalOrdering(graph3);
		
		
		System.out.println("\nGraph 4");
		ArrayList<ArrayList<Integer>> graph4 = new ArrayList<ArrayList<Integer>>();
		graph4.add(new ArrayList<Integer>(Arrays.asList(1)));
		graph4.add(new ArrayList<Integer>(Arrays.asList(2)));
		graph4.add(new ArrayList<Integer>(Arrays.asList(0)));
		graph4.add(new ArrayList<Integer>(Arrays.asList(0)));
		
		TopologicalOrdering.findTopologicalOrdering(graph4);
	}
}