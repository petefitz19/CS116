package classes.subclasses;
import classes.subclasses.C;
public class D extends C{
	public String str;
	public D(){
		this.str="";
		System.out.println("Default constructor: Class D. Executing now.");	
	}
	public D(int a, double aa, double c, String str){
		super(a,aa,c);
		System.out.println("Non-default constructor of Class D");
		
	}
	public void m3()
	{
		super.m3();
		System.out.println("I am executing m3 as implemented in  class D");
	}
	public  int m2(char c)
	{
		int x=0;
		if(c=='e'){
			x=super.m2('e');
			System.out.println("The m2(char c) version of D is executing now with returned value= " + x );
		}
		else{
			x=super.m2(100);
			System.out.println("The m2(int x1) version of D is executing now with returned value= " + x );
		}
		return x;
	}


}