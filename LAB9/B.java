package classes.subclasses;
import classes.abstracts.A;
public class B extends A{
	public  String s;
	public B(){
		this.s="Test String";
		System.out.println("Default constructor: Class B. Executing now.");
	}
	public B(int a, double aa, String s){		
		super(a,aa);
		this.s=s;
		System.out.println("Non-default constructor: Class B. Executing now.");
	}
	public String getS(){
		return this.s;
	}
	public void setS(String s){
		this.s=s;
	}
	public int m1(){
		int  i1= 5*a+(int)this.getAa();
		System.out.println("m1 implementation of B is executing now");
		return i1;
	}
	public String toString(){
		String ret=super.toString();
		ret += ":" + this.getS();
		return ret;
	}

}