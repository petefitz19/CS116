package classes.client;
import classes.abstracts.A;
import classes.subclasses.B;
import classes.subclasses.C;
import classes.subclasses.D;

public class Client{
	public static void main(String []args){
		System.out.println("First Output\n");
		B b = new B();
		C c = new C();
		A a;
		a = b;
		a.m1();
		a = c;
		a.m1();
		System.out.println("Second Output");
		D d=new D();
		a = d;
		a.m1();
		System.out.println("Third Output");
		d.m2('e');
		d.m2('s');
	}
	
}