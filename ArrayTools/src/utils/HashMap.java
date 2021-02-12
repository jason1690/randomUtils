package utils;



public class HashMap<K,V> {
	private DataList[] data=new DataList[1000];
	int arrayLength;
	
	public HashMap() {
		
	}
	
	public void put(K key, V value) {
		int index = hash(key);
		if(data[index]==null) {
			data[index]=new DataList().add(new DataEntry(key,value));
		}else {
			data[index].add(new DataEntry(key,value));
		}
	}
	
	@SuppressWarnings("unchecked")
	public V get(K key) {
		int index=hash(key);
		
		if(data[index]==null) {
			return null;
		}
		
		return (V) data[index].getData(key);
		
	}
	
	private int hash(Object key) {
		return key.hashCode()%1000;
	}
	
}

class DataList {
	ArrayList<DataEntry> data=new ArrayList<DataEntry>();
	DataList add(DataEntry data) {
		this.data.add(data);
		return this;
	}
	int size() {
		return data.size();
	}
	DataEntry get(int index) {
		return data.get(index);
	}
	Object getData(Object key) {
		for(int i=0;i<data.size();i++) {
			if(data.get(i).getKey().equals(key)) {
				return data.get(i).getValue();
			}
		}
		return null;
	}
	
}

class DataEntry {
	Object key;
	Object value;
	
	DataEntry(Object key,Object value) {
		this.key=key;
		this.value=value;
	}
	
	Object getKey() {
		return key;
	}
	
	Object getValue() {
		return value;
	}
	
}
