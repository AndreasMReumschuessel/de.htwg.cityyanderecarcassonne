package de.htwg.cityyanderecarcassonne.graph;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.htwg.cityyanderecarcassonne.model.*;
import de.htwg.cityyanderecarcassonne.model.graph.*;
import de.htwg.cityyanderecarcassonne.model.regions.*;

public class AdjacencyListUndirectedGraphTest {
	
	private UndirectedGraph<IRegion> graph;
	private IRegion a;
	private IRegion b;
	private IRegion c;
	private IRegion d;
	private IRegion e;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws Exception	{
		a = new RegionBuilding();
		b = new RegionLawn();
		c = new RegionBuilding();
		d = new RegionBuilding();
		e = new RegionBuilding();
		graph = new AdjacencyListUndirectedGraph<>();
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(d);
		graph.addVertex(e);
	}	
	
	@Test
	public void addVertexTest() {
		graph.addVertex(a);
		assertTrue(graph.containsVertex(a));
		assertFalse(graph.containsVertex(c));
	}

	@Test
	public void addEdgeTest() {
		graph.addEdge(a, b);
		assertTrue(graph.containsEdge(a, b));
		assertFalse(graph.addEdge(a, b));
		graph.addEdge(a, b, 7);
		assertTrue(graph.containsEdge(a, b));
		assertFalse(graph.addEdge(a, b));
	}
	
	@Test
	public void addEdgeWeightTest() {
		graph.addEdge(a, b, 5);
		assertTrue(graph.containsEdge(a, b));
		assertEquals(5, graph.getWeight(a, b), 0);
	}

	@Test
	public void containsVertexTest() {
		assertTrue(graph.containsVertex(a));
		assertTrue(graph.containsVertex(b));
		assertFalse(graph.containsVertex(c));
	}

	@Test
	public void containsEdgeTest()	{
		graph.addEdge(a, b);
		assertTrue(graph.containsEdge(a, b));
	}

	@Test
	public void getWeightTest() {
		graph.addEdge(a, b, 10);
		assertEquals(10, graph.getWeight(a, b), 0);
		assertEquals(0, graph.getWeight(a, c), 0);
	}

	@Test
	public void getNumberOfVertexesTest() {
		assertEquals(4, graph.getNumberOfVertexes());
	}

	@Test
	public void getNumberOfEdgesTest() {
		graph.addEdge(a, b);
		assertEquals(1, graph.getNumberOfEdges());
	}

	@Test
	public void getVertexListTest() {
		List<IRegion> vertexList = new LinkedList<>();
		vertexList.add(a);
		vertexList.add(b);
		vertexList.add(d);
		vertexList.add(e);
		assertEquals(vertexList, graph.getVertexList());
	}

	@Test
	public void getAdjacentVertexListTest() {
		List<IRegion> adjacentVertexList = new LinkedList<>();
		adjacentVertexList.add(a);
		graph.addEdge(a, b);
		assertEquals(adjacentVertexList, graph.getAdjacentVertexList(b));
		//graph.getAdjacentVertexList(c);
	}

	@Test
	public void getIncidentEdgeListTest() {
		List<Edge<IRegion>> incidentEdgeList = new LinkedList<>();
		Edge<IRegion> edge = new Edge<>(a, b);
		graph.addEdge(a, b);
		graph.addEdge(d, e);
		incidentEdgeList.add(edge);
		//assertEquals(incidentEdgeList, graph.getIncidentEdgeList(a));
	}

	@Test
	public void getDegreeTest() {
		graph.addEdge(a, b);
		assertEquals(1, graph.getDegree(a));
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Knoten nicht Vorhanden");	
		assertEquals(exception, graph.getDegree(c));
	}

	@Test
	public void getEdgeListTest() {
		List<Edge<IRegion>> edgeList = new LinkedList<>();
		Edge<IRegion> edge = new Edge<>(a, b);
		graph.addEdge(a, b);
		edgeList.add(edge);
		//assertEquals(edgeList, graph.getEdgeList());
	}
	
	@Test
	public void getVertexIndexTest()	{
		graph.addVertex(a);
		assertEquals(0, graph.getVertexIndex(a));
	}
	
	@Test
	public void getVertexTest(){
		graph.addVertex(a);
		assertEquals(a, graph.getVertex(0));
	}
}
