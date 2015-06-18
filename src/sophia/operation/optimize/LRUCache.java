package sophia.operation.optimize;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LRUCache {
	
	private LinkedHashMap<Integer, Integer> data;
	private int capacity;
	

	public LRUCache(int capacity){
		data = new LinkedHashMap<Integer, Integer>();
		this.capacity = capacity;
	}
	
	public int get(int key){
		if (data.containsKey(key)){
			int value = data.get(key);
			data.remove(key);
			data.put(key,value);
			return value;
		}
		else{
		   return -1;
		}
		
	}
	
	public void set(int key,int value){
		if(data.containsKey(key)){
			data.remove(key);
			data.put(key,value);
		}else{
			if(data.size() == capacity){
				Iterator<Entry<Integer, Integer>> iterator = data.entrySet().iterator();
				data.remove(iterator.next().getKey());
//				while(iterator.hasNext()){
//					Entry<Integer, Integer> entry = iterator.next();
//					data.remove(entry.getKey());
//					break;
//				}							
			}
			
				data.put(key, value);
		}
		
	}
}
