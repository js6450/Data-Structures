import java.util.Comparator;

public class Circle {
	double Radius;
	public Circle(double Radius){
		this.Radius = Radius;
	}
	public double getRadius(){
		return this.Radius;
	}
	public double getArea(){
		double area;
		area = Math.PI * Math.pow(this.Radius, 2);
		return area;
	}
	public double getCircum(){
		double circum;
		circum = 2.0 * Math.PI * this.Radius;
		return circum;
	}
	public String toString(){
		return "The radius is " + this.Radius + " and area is " + this.getArea() + " and circumference is " + this.getCircum();
	}

		
}

class compArea implements Comparator<Circle>{
    public int compare(Circle circle1, Circle circle2) {
         return ((Double)circle1.getArea()).compareTo((Double)circle2.getArea());
    }
}

class compCircum implements Comparator<Circle>{   
    public int compare(Circle circle1, Circle circle2) {
         return ((Double)circle1.getCircum()).compareTo((Double)circle2.getCircum());
    }
}
class Run{
	public static <AnyType> AnyType findMax( AnyType[] arr, Comparator<? super AnyType> cmp){
	       int maxIndex = 0;
	       for (int i =1; i< arr.length; i++){
	           if(cmp.compare(arr[i],arr[maxIndex])>0){
	               maxIndex=i;  
	           }    
	       }        
	       return arr[maxIndex];
	   }
	public static void main(String[] args){
		Circle[] c = new Circle[10];
		for(int i = 0; i < c.length; i++){
			c[i] = new Circle(Math.random() * 10);
		}
		System.out.println("The circle with the biggest area has area of: ");
		System.out.println(findMax(c , new compArea()));
		System.out.println("The circle with the biggest circumference has circumference of: ");
		System.out.println(findMax(c, new compCircum()));
	}
}