package utils;

//for light computing. 
public class ArrayList<T> {
	private Object[] array = new Object[8];
	int arrayLength=0;
	
	//adds an object to the array. 
	public void add(T obj) {
		
		if(arrayLength+1>=array.length*0.90) 
			transmogrify(2);
		
		array[arrayLength]=obj;
		arrayLength+=1;
	}
	
	//adds all of the data given to the array.
	public void add(T[] obj) {
		
		while(arrayLength+obj.length>=array.length*0.90) 
			transmogrify(2);
		
		for(int i=0;i<obj.length;i++) {
			array[arrayLength]=obj[i];
			arrayLength+=1;
		}
	}
	
	//returns the amount of the given object in the array.
	public int amountOf(T obj) {
		int amount=0;
		
		for(int i=0;i<arrayLength;i++) 
			if(array[i].equals(obj)) 
				amount++;
			
		return amount;
	}
	
	//return the amount of data in the array.
	public int size() {
		return arrayLength;
	}
	
	//return the casted element of the array from the given index.
	@SuppressWarnings("unchecked")
	public T get(int i) {
		return  (T) (array[i]);
	}
	
	//find all of the objects that match the give value and then removes them all.
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
	
	//removes the give cell from the array
	public void remove(int index) {
		int[] output= {
				index
		};
		removeIndexs(output);
	}
	
	//removes all of the given cells from the array
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
		
		if(arrayLength>8) {
			if(array.length*0.4>arrayLength) {
				transmogrify(0.5);
			}
		}
		
	}
	
	//Modifies the length of the array
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
	
	//returns true if the array contains the given object
	public boolean contains(Object obj) {
		
		for(int i=0;i<arrayLength;i++) 
			if(array[i].equals(obj))
				return true;
		
		return false;
		
	}
	
	//return the object array
	public Object[] toArray() {
		Object[] output=new Object[arrayLength];
		
		for(int i=0;i<output.length;i++) 
			output[i]=array[i];
		
		return output;
	}
	
	//constructor
	public ArrayList() {
		
	}
}
