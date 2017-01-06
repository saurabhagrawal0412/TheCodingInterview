package chapter17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapList<T, E> {
	private HashMap<T, ArrayList<E>> map = new HashMap<>() ;

	public void put(T key, E item) {
		if(! map.containsKey(key)) {
			map.put(key, new ArrayList<E>()) ;
		}
		map.get(key).add(item) ;
	}

	public void put(T key, ArrayList<E> itemList) {
		map.put(key, itemList) ;
	}

	public ArrayList<E> get(T key) {
		return map.get(key) ;
	}

	public boolean containsKey(T key) {
		return map.containsKey(key) ;
	}

	public boolean containsKeyValue(T key, E value) {
		if(! map.containsKey(key)) {
			return false ;
		}
		ArrayList<E> valueList = map.get(key) ;
		return valueList.contains(value) ;
	}

	public Set<T> keySet() {
		return map.keySet() ;
	}

	public String toString() {
		return map.toString() ;
	}
}
