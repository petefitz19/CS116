package classes.client;
import classes.abstracts.GeometricFigure;
import classes.subclasses.Square;
import classes.subclasses.Triangle;
public class UseGeometric{
	public static void main(String[] args){
		GeometricFigure[] f = new GeometricFigure[10];
		
		f[0] = new Triangle();
		f[1] = new Triangle(25, 20);
		f[2] = new Triangle(50, 20);
		f[3] = new Triangle(40, 40);
		f[4] = new Triangle(30, 10);
		f[5] = new Square();
		f[6] = new Square(20,20);
		f[7] = new Square(30,30);
		f[8] = new Square(40,40);
		f[9] = new Square(50,50);
		
		for(int i = 0; i < f.length; i++){
			System.out.println(f[i].toString());
		}
	}
}