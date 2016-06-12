package de.htwg.cityyanderecarcassonne.model.graph;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyListUndirectedGraph<V> implements UndirectedGraph<V>{

	HashMap<V, HashMap<V,Double>> adjacencyList;
	List<V> vertexList;
	List<Edge<V>> edgeList;
	
	public AdjacencyListUndirectedGraph()	{		
		adjacencyList = new HashMap<V, HashMap<V,Double>>();
		vertexList = new LinkedList<>();
		edgeList = new LinkedList<>();
	}

	@Override
	public boolean addVertex(V v) {
		if(!this.containsVertex(v))	{
			adjacencyList.put(v, new HashMap<V,Double>());
			vertexList.add(v);
			return true;
		}
		return false;
	}

	@Override
	public boolean addEdge(V v, V w) {
		if(!(this.containsVertex(v) || this.containsVertex(w)) || v.equals(w))	{
			throw new IllegalArgumentException("Einer der beiden Knoten ist nicht vorhanden oder die Knoten sind identisch.");
		} else if(this.containsEdge(v, w))	{
			return false;
		} else	{	
			adjacencyList.get(v).put(w, 1.0);
			adjacencyList.get(w).put(v, 1.0);
			Edge<V> e = new Edge<>(v, w);
			edgeList.add(e);
			return true;
		}
	}

	@Override
	public boolean addEdge(V v, V w, double weight) {
		if(!(this.containsVertex(v) || this.containsVertex(w)))	{
			throw new IllegalArgumentException("Einer der beiden Knoten ist nicht vorhanden.");
		} else if(this.containsEdge(v, w))	{
			adjacencyList.get(v).put(w, weight);
			adjacencyList.get(w).put(v, weight);
			return false;
		} else	{
			adjacencyList.get(v).put(w, weight);
			adjacencyList.get(w).put(v, weight);
			Edge<V> e = new Edge<>(v, w);
			edgeList.add(e);
			return true;
		}
	}

	@Override
	public boolean containsVertex(V v) {
		if(adjacencyList.containsKey(v))	{
			return true;
		}
		return false;
	}

	@Override
	public boolean containsEdge(V v, V w) throws IllegalArgumentException {
		if(!(adjacencyList.containsKey(v) || adjacencyList.containsValue(w)))	{
			throw new IllegalArgumentException("Einer der beiden Knoten ist nicht vorhanden.");
		} else	{
			if(adjacencyList.get(v).containsKey(w) && adjacencyList.get(w).containsKey(v))	{
				return true;
			} else	{
				return false;
			}
		}	
	}

	@Override
	public double getWeight(V v, V w) {
		if(!(adjacencyList.containsKey(v) || adjacencyList.containsValue(w)))	{
			throw new IllegalArgumentException("Einer der beiden Knoten ist nicht vorhanden.");
		} else if(this.containsEdge(v, w))	{
			return adjacencyList.get(v).get(w);
		} else	{
			return 0;
		}
	}

	@Override
	public int getNumberOfVertexes() {
		return vertexList.size();
	}

	@Override
	public int getNumberOfEdges() {
		return edgeList.size();
	}

	@Override
	public List<V> getVertexList() {
		return vertexList;
	}

	@Override
	public List<V> getAdjacentVertexList(V v) {
		//List<V> adjacentVertexList = new LinkedList<>();
		
		if(!this.containsVertex(v))	{
			throw new IllegalArgumentException("Knoten ist nicht vorhanden.");
		}	
		
		return new LinkedList<>(adjacencyList.get(v).keySet());
		
	}

	@Override
	public List<Edge<V>> getIncidentEdgeList(V v) {
		List<Edge<V>> incidentVertexList = new LinkedList<>();
		
		if(!this.containsVertex(v))	{
			throw new IllegalArgumentException("Knoten ist nicht vorhanden.");
		}	
		
		for(Edge<V> e : edgeList)	{
			if(e.source == v)	{
				incidentVertexList.add(e);
			}
		}
		return incidentVertexList;
	}

	@Override
	public int getDegree (V v) {
		if(adjacencyList.get(v) != null)	{
			return adjacencyList.get(v).size();
		}
		throw new IllegalArgumentException("Knoten nicht Vorhanden");
	}

	@Override
	public List<Edge<V>> getEdgeList() {
		return edgeList;
	}
	
	public int getVertexIndex(Object v)	{
		return vertexList.indexOf(v);
	}
}
