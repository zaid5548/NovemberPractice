package HEAP;

public class Client_Heap_generic {

	public static void main(String[] args) {

		Car[] cars=new Car[5];
		cars[0]=new Car(1000, 400, "Red");
		cars[1]=new Car(2000, 200, "Yellow");
		cars[2]=new Car(500, 900, "Black");
		cars[3]=new Car(300, 30, "Gray");
		cars[4]=new Car(700, 70, "White");
		
		Heap_Generic<Car> hpg=new Heap_Generic<>();
		hpg.add(cars[0]);
		hpg.add(cars[1]);
		hpg.add(cars[2]);
		hpg.add(cars[3]);
		hpg.add(cars[4]);
		
		System.out.println(hpg.remove());
		System.out.println(hpg.remove());
		System.out.println(hpg.remove());
		System.out.println(hpg.remove());
		System.out.println(hpg.remove());
	}

}
