package classes.subclasses;
import classes.abstracts.A;
public class C extends A{
	public double c;
	public C(){		
		c=0.0;	
		System.out.println("Default constructor: Class C. Executing now.");		
	}
	public C(int a, double aa, double c){
		super(a,aa);		
		this.c=c;
		System.out.println("Non-default constructor: Class C. Executing now.");
	}
	public double getC(){
		return this.c;		
	}
	public void setC(double c){
		this.c=c;
	}
	public int m1()
	{
     	int  i2= a+(int)(c/2);
		System.out.println("m1 implementation of C is executing now");
    	return i2;
	}
	public String toString(){
		String ret=super.toString();
		ret += ":" + this.getC();
		return ret;
	}
}