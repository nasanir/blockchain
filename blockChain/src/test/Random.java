package test;

public class Random {
	public void a(){
		System.out.println("parent1-a");
	}
	
	public void b(){
		a();
		System.out.println("parent2-b");
	}
}
