package de.htwg.cityyanderecarcassonne.view.gui;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

import de.htwg.cityyanderecarcassonne.model.IRegion;

public class BigMap<T, K, V> {

	private K k;
	private V v;
	private T t;

	private Map<T, V> TtoV;
	private Map<T, K> TtoK;
	private Map<K, T> KtoT;
	private Map<K, V> KtoV;
	private Map<V, K> VtoK;
	private Map<V, T> VtoT;

	public BigMap() {
		TtoV = new HashMap<>();
		TtoK = new HashMap<>();
		KtoT = new HashMap<>();
		KtoV = new HashMap<>();
		VtoK = new HashMap<>();
		VtoT = new HashMap<>();
	}

	public void add(T l, K r, V p) {
		TtoV.put(l, p);
		TtoK.put(l, r);
		KtoT.put(r, l);
		KtoV.put(r, p);
		VtoK.put(p, r);
		VtoT.put(p, l);
	}

	public void removeTandV(Map.Entry<T, V> object)	{
		TtoV.remove(object);
		VtoT.remove(TtoV.get(object));
	}

	public void removeTandK(Map.Entry<T, K> object)	{
		TtoK.remove(object);
		KtoT.remove(TtoK.get(object));
	}
	
	public void removeKandV(Map.Entry<K, V> object)	{
		KtoV.remove(object);
		VtoK.remove(KtoV.get(object));
	}
	
	public void removeEntry(Map.Entry<K, T> object)	{
		KtoT.get(object.getKey());
	}
	
	public V getV(K r) {
		return KtoV.get(r);
	}
	
	public T getT(K r) {
		return KtoT.get(r);
	}

	public Map<T, V> getTtoV() {
		return TtoV;
	}

	public Map<T, K> getTtoK() {
		for (Map.Entry<K, T> test : KtoT.entrySet()) {
			TtoK.put(test.getValue(), test.getKey());
		}
		return TtoK;
	}

	public Map<K, T> getKtoT() {
		return KtoT;
	}

	public Map<K, V> getKtoV() {
		return KtoV;
	}

	public Map<V, K> getVtoK() {
		for (Map.Entry<K, V> test : KtoV.entrySet()) {
			VtoK.put(test.getValue(), test.getKey());
		}
		return this.VtoK;
	}

	public Map<V, T> getVtoT() {
		for (Map.Entry<T, V> test : TtoV.entrySet()) {
			VtoT.put(test.getValue(), test.getKey());
		}
		return VtoT;
	}
	
	@Override
	public String toString()	{
		StringBuilder sb = new StringBuilder();
		
		for(Map.Entry<T, K> e : TtoK.entrySet())	{
			sb.append("T: " + e.getKey().toString() + " , ");
		}
		sb.append("\n");
		
		for(Map.Entry<K, T> e : KtoT.entrySet())	{
			sb.append("K: " + e.getKey().toString() + " , ");
		}
		sb.append("\n");
		
		for(Map.Entry<V, K> e : VtoK.entrySet())	{
			sb.append("V: " + e.getKey().toString() + " , ");
		}
		sb.append("\n");
		
		return sb.toString();
	}

}
