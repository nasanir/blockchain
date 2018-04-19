package test;

public class Random {
	private int a=2;
	
	public Random(){
		
	}
	
	public Random(Random x){
		x.a=3;
	}
	
	public int  getA(){
		return this.a;
	}
}
