package utils;

//for light computing. 
public class ArrayList<T> {
	private Object[] array = new Object[8];
	int arrayLength=0;
	
	public void add(T obj) {
		
		if(arrayLength>=array.length*0.90) 
			transmogrify(2);
		
		array[arrayLength]=obj;
		
		arrayLength+=1;
		
		
	}
	
	public int size() {
		return arrayLength;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int i) {
		return  (T) (array[i]);
	}
	public void removeAllValues(T value) {
		ArrayList<Integer> numbers=new ArrayList<Integer>();
		for(int i=0;i<arrayLength;i++) {
			if(array[i].equals(value)){
				numbers.add(i);
			}
		}
		int[] indexes=new int[numbers.size()];
		for(int i=0;i<indexes.length;i++) {
			indexes[i]=numbers.get(i);
		}
		removeIndexs(indexes);
	}
	
	public void remove(int index) {
		int[] output= {
				index
		};
		removeIndexs(output);
	}
	
	public void removeIndexs(int[] indexes) {
		int start=indexes[0];
		int swapLength=0;
		
		for(int i=start;i<arrayLength;i++) {

			if(swapLength<indexes.length) {
				if(i==indexes[swapLength]) {
					swapLength++;
					continue;
				}
			}
			
			array[i-swapLength]=array[i];
			
		}
		
		arrayLength-=swapLength;
		
	}
	
	private void transmogrify(double scalar) {
		Object[] arrayOutput=new Object[(int) (array.length*scalar)];
		
		if(arrayLength > arrayOutput.length) {
			return;
		}
		
		for(int i=0;i<arrayLength;i++) {
			arrayOutput[i]=array[i];
		}
		
		array=arrayOutput;
		
	}
	

	
	public boolean contains(Object obj) {
		
		for(int i=0;i<arrayLength;i++) 
			if(array[i].equals(obj))
				return true;
		
		return false;
		
	}
	
	public Object[] toArray() {
		Object[] output=new Object[arrayLength];
		
		for(int i=0;i<output.length;i++) 
			output[i]=array[i];
		
		return output;
	}
	
	public ArrayList() {
		
	}
}
