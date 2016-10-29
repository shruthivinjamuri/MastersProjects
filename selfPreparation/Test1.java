package selfPreparation;

import designs.elevator.enums.*;

public class Test1 {

	private final int re;
	
	public Test1(int i){
		this.re= 2;
		System.out.println("Constructor called " + i);
	}
	
	public static void method(){
		System.out.println("jkf");
	}
	
	public static void main(String[] args) {
		System.out.println(Direction.Elevator_Down);
	}
}
