package HEAP;

public class Car implements Comparable<Car>{
	
	int speed;
	int price;
	String color;
	
	public Car(int speed,int price,String color) {
		this.speed=speed;
		this.price=price;
		this.color=color;
	}
	
	@Override
	public String toString() {
		return "S:"+this.speed+"P:"+this.price+"C:"+this.color;
	}
	

	@Override
	public int compareTo(Car o) {
		return this.speed-o.speed;
	}
}