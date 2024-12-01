package api.checksyntax;

import java.util.HashMap;

public class MapGetterSetter {
	HashMap<Integer, String> testHashMap;
	
	public void setHashMap(HashMap test) {
		
		this.testHashMap = test;
	}
	
	public static void main(String args []) {
		
		HashMap<Integer, String> dataMap = new HashMap<Integer, String>();
		dataMap.put(1, "test");
		
		MapGetterSetter ms = new MapGetterSetter();
		ms.setHashMap(dataMap);
		System.out.println(ms.testHashMap.keySet());
		System.out.println(ms.testHashMap.values());
	}
}
