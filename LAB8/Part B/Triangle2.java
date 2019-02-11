package classes.subclasses;
import classes.abstracts.GeometricFigure;
import classes.interfaces.SidedObject;
public class Triangle2 extends GeometricFigure implements SidedObject{
	private int numSides = 3;
	public Triangle2(){
		super();
	}
	public Triangle2(double height, double width){
		super(height, width);
	}
	public double getArea(){
		return 0.5 * this.getHeight() * this.getWidth();
	}
	public String toString(){
		return "Area of Triangle: " + this.getArea() + 
				"\n" + "Number of Sides: " + this.displaySides() + "\n";
	}
	public int displaySides(){
		return this.numSides;
	}

}