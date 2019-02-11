package classes.client;
import classes.abstracts.GeometricFigure;
import classes.interfaces.SidedObject;
import classes.subclasses.Square2;
import classes.subclasses.Triangle2;
public class UseGeometric2{
	public static void main(String[] args){
		GeometricFigure[] f = new GeometricFigure[10];
		
		f[0] = new Triangle2();
		f[1] = new Triangle2(25, 20);
		f[2] = new Triangle2(50, 20);
		f[3] = new Triangle2(40, 40);
		f[4] = new Triangle2(30, 10);
		f[5] = new Square2();
		f[6] = new Square2(20,20);
		f[7] = new Square2(30,30);
		f[8] = new Square2(40,40);
		f[9] = new Square2(50,50);
		
		for(int i = 0; i < f.length; i++){
			System.out.println(f[i].toString());
		}
	}
}