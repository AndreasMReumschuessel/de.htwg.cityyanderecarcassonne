package de.htwg.cityyanderecarcassonne.model.graph;

/**
 * Klasse für Kanten.
 * @author Oliver Bittel
 * @since 21.10.2011
 * @param <V> Knotentyp.
 */

public class Edge<V> {

    /**
     * Startknoten.
     */
    final protected V source;
    /**
     * Zielknoten
     */
    final protected V target;
    /**
     * Gewicht.
     */
    final protected String type;

    /**
     * Erzeugt neue Kante mit Gewicht 1.
     * @param source Startknoten.
     * @param target Zielknoten.
     */
    public Edge(V source, V target) {
        this.source = source;
        this.target = target;
        this.type = "leer";
    }

    /**
     * Erzeugt neue Kante mit Gewicht weight.
     * @param source Startknoten.
     * @param target Zielknoten.
     * @param weight Gewicht.
     */
    public Edge(V source, V target, String type) {
        this.source = source;
        this.target = target;
        this.type = type;
    }

    /**
     * Liefert Startknoten zurück.
     * @return Startknoten.
     */
    public V getSource() {
        return this.source;
    }

    /**
     * Liefert Zielknoten zurück.
     * @return Zielknoten.
     */
    public V getTarget() {
        return this.target;
    }

    /**
     * Liefert Gewicht der Kante zurück.
     * @return Gewicht.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Liefert String-Darstellung der Kante zurück.
     * @return String-Darstellung.
     */
    @Override public String toString() {
        if ("leer".equals(type))
            return source + " -- " + target;
        else
            return source + " -- " + target + " (" + type + ")";
    }
}
