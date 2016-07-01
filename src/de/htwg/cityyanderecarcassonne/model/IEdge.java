package de.htwg.cityyanderecarcassonne.model;

public interface IEdge<V> {

    /**
     * Liefert Startknoten zurück.
     * @return Startknoten.
     */
    public V getSource();

    /**
     * Liefert Zielknoten zurück.
     * @return Zielknoten.
     */
    public V getTarget();

    /**
     * Liefert Gewicht der Kante zurück.
     * @return Gewicht.
     */
    public double getWeight();

    /**
     * Liefert String-Darstellung der Kante zurück.
     * @return String-Darstellung.
     */
    public String toString();
	
}
