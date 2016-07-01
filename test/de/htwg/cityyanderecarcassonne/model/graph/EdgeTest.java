package de.htwg.cityyanderecarcassonne.model.graph;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.htwg.cityyanderecarcassonne.model.IEdge;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.impl.Edge;
import de.htwg.cityyanderecarcassonne.model.regions.RegionBuilding;

public class EdgeTest {
	
	private IEdge<IRegion> edgeConstructor1;
	private IEdge<IRegion> edgeConstructor2;
	private IRegion a;
	private IRegion b;

	@Before
	public void setUp() throws Exception	{
		a = new RegionBuilding();
		b = new RegionBuilding();
		edgeConstructor1 = new Edge<>(a, b);
		edgeConstructor2 = new Edge<>(a, b, 5);
	}

	@Test
	public void getSourceTest() {
		assertEquals(a, edgeConstructor1.getSource());
    }

	@Test
    public void getTargetTest() {
		assertEquals(b, edgeConstructor1.getTarget());
    }

	@Test
    public void getWeightTest() {
		assertEquals(1.0, edgeConstructor1.getWeight(), 0);
		assertEquals(1.0, edgeConstructor2.getWeight(), 5);
    }

	@Test
    public void toStringTest() {
		assertEquals(a + " -- " + b, edgeConstructor1.toString());
		assertEquals(a + " -- " + b + " (" + edgeConstructor2.getWeight() + ")", edgeConstructor2.toString());
    }
}