import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.*;

// Dijkstra Class
public class Dijkstrawithpath{
	
	private static Integer[][] mygraph = {{0, 10, 0, 5, 0}, {0, 0, 1, 2, 0},{0, 0, 0, 0, 4}, {0, 3, 9, 0, 2}, {7, 0, 6, 0, 0} }; 
	private static Map<Integer, Character> vertices;
	private static Map<Integer, Integer> distance;
	private static Set<Integer> mindistvertex;
	private static Integer[] var;    
	private static final int MAX = 100;

//	Function to perform Dijkstra
	private static void djikstra(Integer[][] graph, Character src) throws Exception
	{
		Integer indexID = getIndex(src); 
		vertices.forEach((ind, nodeName) -> distance.put(ind, MAX));
		var[indexID] = -1;
		distance.put(indexID, 0);
		mindistvertex.clear();

		for (int i = 0; i < graph.length - 1; i++) 
		{
			 
			int nearest = findNearest(distance, mindistvertex);
			mindistvertex.add(nearest);

			
			for (int j = 0; j < graph.length; j++) 
			{
				if (!mindistvertex.contains(j) && graph[nearest][j] != 0  && distance.get(nearest) != MAX && distance.get(nearest) + graph[nearest][j] < distance.get(j)) 
				{
					distance.put(j, distance.get(nearest) + graph[nearest][j]);
					var[j] = nearest;
				}
			}
		}
	}

// Function to Get Index of a Vertex
	private static Integer getIndex(Character nodeName) throws Exception 
	{
		for (Map.Entry<Integer, Character> entrySet: vertices.entrySet()) 
		{
			if (entrySet.getValue() == nodeName) 
			{
				return entrySet.getKey();
			}
		}
		throw new Exception();
	}

// Function to find Shortest Weight node that has a connection to current node
	private static Integer findNearest(Map<Integer, Integer> dis, Set<Integer> mindistvertex) 
	{        
		Integer minimum = MAX;
		Integer nodeIndex = null;

		for (Integer i = 0; i < mygraph.length; i++)
		{
			if (!mindistvertex.contains(i) && dis.get(i) <= minimum) 
			{
				minimum = dis.get(i);
				nodeIndex = i;
			}
		}
		return nodeIndex;        
	}
	
//	Function to get Full PATH
	private static void path(Integer ind,Character src1,Integer dist)
	{
		int dist1=(int)dist;
		if (-1 != var[ind]) 
		{
			path(var[ind], src1, dist1);
			System.out.print(vertices.get(ind) + " ");
		}
		else
		{
			System.out.print(src1+" ");
		}
	}

	
//	MAIN Function where program starts Execution
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		mindistvertex = new HashSet<>();
        distance = new HashMap<>();
        var = new Integer[mygraph.length];		
        vertices = new HashMap<>();
        
//      Adding Vertices
        vertices.put(0, 's');
        vertices.put(1, 't');
        vertices.put(2, 'x');
        vertices.put(3, 'y');
        vertices.put(4, 'z');
        
//      Start from Vertex S
		
        Character src = 's';//source node -> S -> 0
        
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Distance from source node S :\n");
		
        djikstra(mygraph, src);

        distance.forEach((ind, distance) -> {
            System.out.print("Cost of Vertex "+ src + "  to Vertex : " + vertices.get(ind) + " Weight : " + distance);
            System.out.print("\nThe Whole Path from src to vertex "+ vertices.get(ind) +" is : ");
            int dist = distance;
            path(ind,src,dist);
            System.out.println("\n");
        });
        
//     Start from Vertex Z   
        
        Character src1 = 'z'; //source node -> Z -> 4

        System.out.println("------------------------------------------------------------------------");
        System.out.println("Distance From source node Z :\n");
        
        djikstra(mygraph, src1);  

        distance.forEach((ind, distance) -> {
            System.out.print("Cost of Vertex " + src1 + "  to Vertex : " + vertices.get(ind) + " Weight : " + distance);
            System.out.print("\nThe Whole Path from src to vertex "+ vertices.get(ind) +" is : ");
            int dist = distance;
            path(ind,src1,dist);
            System.out.println("\n");
        });
        
        System.out.println("------------------------------------------------------------------------");
	}

}

