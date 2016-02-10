import java.util.ArrayList;
import java.util.List;

public class OrderedVECTOR <AnyType> {
	List<AnyType> Vector = new ArrayList<AnyType>();
	int size = Vector.size();

	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return Vector.isEmpty();
	}
	
	public void insert(AnyType var){
		Vector.add(var);
		size++;
	}
	public void remove(AnyType var){
		Vector.remove(--size);
	}
	public void removeAll(AnyType var){
		Vector.removeAll(Vector);
		size = 0;
	}
	public AnyType lastElement(){
		return Vector.remove(--size);
	}
	public String toString(){
		String vector = null;
		if(size != 0){
			for(AnyType i:Vector){
				vector += String.valueOf(i);
			}
		}
		return vector;
	}

}
