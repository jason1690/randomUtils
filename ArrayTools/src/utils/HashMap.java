package utils;



public class HashMap<K,V> {
	private DataList[] data=new DataList[1000];
	int arrayLength;
	
	//constructor
	public HashMap() {
		
	}
	
	//puts a key and a value into the hashmap
	public void put(K key, V value) {
		int index = hash(key);
		if(data[index]==null) {
			data[index]=new DataList().add(new DataEntry(key,value));
		}else {
			data[index].add(new DataEntry(key,value));
		}
	}
	
	//return the object corresponding to the given key.
	@SuppressWarnings("unchecked")
	public V get(K key) {
		int index=hash(key);
		
		if(data[index]==null) {
			return null;
		}
		
		return (V) data[index].getData(key);
		
	}
	
	//return the hash of the key.
	private int hash(Object key) {
		return key.hashCode()%1000;
	}
	
}

//a class to hold an amount of entries in one cell of the array.
class DataList {
	ArrayList<DataEntry> data=new ArrayList<DataEntry>(4);
	
	//a function add data to the list
	DataList add(DataEntry data) {
		this.data.add(data);
		return this;
	}
	
	//return the size of the list
	int size() {
		return data.size();
	}
	
	//return the entry from the cell given
	DataEntry get(int index) {
		return data.get(index);
	}
	
	//return the object that corresponds to the given key.
	Object getData(Object key) {
		for(int i=0;i<data.size();i++) {
			if(data.get(i).getKey().equals(key)) {
				return data.get(i).getValue();
			}
		}
		return null;
	}
	
}

//a class to story entrys in the data
class DataEntry {
	Object key;
	Object value;
	
	//creates the data entry
	DataEntry(Object key,Object value) {
		this.key=key;
		this.value=value;
	}
	
	//return the key
	Object getKey() {
		return key;
	}
	
	//return the value;
	Object getValue() {
		return value;
	}
	
}
