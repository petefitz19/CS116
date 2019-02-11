package classes.abstracts;

public abstract class A{
	public int a;
	private double aa;
	public A(){
		a=0;
		aa=0;
		System.out.println("Default onstructor: Class A. Executing now.");
	}
	public A(int a, double aa){
		this.a=a;
		this.aa=aa;
		System.out.println(" Non-default constructor: Class A. Executing now.");
	}
	public int getA(){
		return this.a;
	}
	public double getAa(){
		return this.aa;
	}
	public void setA(int a){
		this.a=a;
	}
	public void setAa(double aa){
		this.aa=aa;
	}
	public  int  m2(char a)
	{
		int  x=(int)a;
		System.out.println("m2 of A is executing now");
		return x;
	}
	public int m2(int  x1)
	{
		int y=10+x1; //get the returned value from the first version and add x1
		System.out.println("second version of m2 in A is executing now");
		return y;
	}
	public void m3()
	{
		System.out.println("m3 of A is executing now");
	}
	public String toString(){
		String ret;
		ret=""+this.getA();
		ret += ":" + this.getAa();
		return ret;
		
	}
	public abstract int m1();

}