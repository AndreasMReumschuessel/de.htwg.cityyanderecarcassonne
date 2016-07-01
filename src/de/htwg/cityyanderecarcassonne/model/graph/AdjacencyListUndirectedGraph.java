package de.htwg.cityyanderecarcassonne.model.graph;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.htwg.cityyanderecarcassonne.model.IEdge;
import de.htwg.cityyanderecarcassonne.model.impl.Edge;

public class AdjacencyListUndirectedGraph<V> implements UndirectedGraph<V>{

	Map<V, HashMap<V, Double>> adjacencyList;
	List<V> vertexList;
	List<IEdge<V>> edgeList;
	
	private String vNotExist;
	
	public AdjacencyListUndirectedGraph()	{		
		adjacencyList = new HashMap<V, HashMap<V,Double>>();
		vertexList = new LinkedList<>();
		edgeList = new LinkedList<>();
		
		this.vNotExist = "Einer der beiden Knoten ist nicht vorhanden.";
	}

	@Override
	public boolean addVertex(V v) {
		if(!this.containsVertex(v))	{
			adjacencyList.put(v, new HashMap<V,Double>());
			vertexList.add(v);
			return true;
		} else	{
			return false;
		}	
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
			IEdge<V> e = new Edge<>(v, w);
			edgeList.add(e);
			return true;
		}
	}

	@Override
	public boolean addEdge(V v, V w, double weight) {
		if(!(this.containsVertex(v) || this.containsVertex(w)))	{
			throw new IllegalArgumentException(vNotExist);
		} else if(this.containsEdge(v, w))	{
			adjacencyList.get(v).put(w, weight);
			adjacencyList.get(w).put(v, weight);
			return false;
		} else	{
			adjacencyList.get(v).put(w, weight);
			adjacencyList.get(w).put(v, weight);
			IEdge<V> e = new Edge<>(v, w);
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
	public boolean containsEdge(V v, V w) {
		if(!(adjacencyList.containsKey(v) || adjacencyList.containsValue(w)))	{
			throw new IllegalArgumentException(vNotExist);
		} else {
			return adjacencyList.get(v).containsKey(w) && adjacencyList.get(w).containsKey(v);
		}	
	}

	@Override
	public double getWeight(V v, V w) {
		if(!(adjacencyList.containsKey(v) || adjacencyList.containsValue(w)))	{
			throw new IllegalArgumentException(vNotExist);
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
		
		if(!this.containsVertex(v))	{
			throw new IllegalArgumentException("Knoten ist nicht vorhanden.");
		}	
		
		return new LinkedList<>(adjacencyList.get(v).keySet());
		
	}

	@Override
	public List<IEdge<V>> getIncidentEdgeList(V v) {
		List<IEdge<V>> incidentVertexList = new LinkedList<>();
		
		if(!this.containsVertex(v))	{
			throw new IllegalArgumentException("Knoten ist nicht vorhanden.");
		}	
		
		for(IEdge<V> e : edgeList)	{
			if(e.getSource() == v)	{
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
		throw new IllegalArgumentException("Knoten ist nicht Vorhanden");
	}

	@Override
	public List<IEdge<V>> getEdgeList() {
		return edgeList;
	}
	
	@Override	
	public int getVertexIndex(Object v)	{
		return vertexList.indexOf(v);
	}
	
	@Override	
	public V getVertex(int i){
		return vertexList.get(i);
	}
	
}
