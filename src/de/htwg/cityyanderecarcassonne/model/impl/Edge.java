package de.htwg.cityyanderecarcassonne.model.impl;

import de.htwg.cityyanderecarcassonne.model.IEdge;

/**
 * Klasse für Kanten.
 * @author Oliver Bittel
 * @since 21.10.2011
 * @param <V> Knotentyp.
 */

public class Edge<V>  implements IEdge<V> {

    /**
     * Startknoten.
     */
    protected final V source;
    /**
     * Zielknoten
     */
    protected final V target;
    /**
     * Gewicht.
     */
    protected final double weight;

    /**
     * Erzeugt neue Kante mit Gewicht 1.
     * @param source Startknoten.
     * @param target Zielknoten.
     */
    public Edge(V source, V target) {
        this.source = source;
        this.target = target;
        this.weight = 1.0;
    }

    /**
     * Erzeugt neue Kante mit Gewicht weight.
     * @param source Startknoten.
     * @param target Zielknoten.
     * @param weight Gewicht.
     */
    public Edge(V source, V target, double weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    /**
     * Liefert Startknoten zurück.
     * @return Startknoten.
     */
    @Override
    public V getSource() {
        return this.source;
    }

    /**
     * Liefert Zielknoten zurück.
     * @return Zielknoten.
     */
    @Override
    public V getTarget() {
        return this.target;
    }

    /**
     * Liefert Gewicht der Kante zurück.
     * @return Gewicht.
     */
    @Override
    public double getWeight() {
        return this.weight;
    }

    /**
     * Liefert String-Darstellung der Kante zurück.
     * @return String-Darstellung.
     */
    @Override
    public String toString() {
        if (Double.compare(weight, 1.0) == 0)
            return source + " -- " + target;
        else
            return source + " -- " + target + " (" + weight + ")";
    }
}
