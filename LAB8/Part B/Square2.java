package classes.subclasses;
import classes.abstracts.GeometricFigure;
import classes.interfaces.SidedObject;
public class Square2 extends GeometricFigure implements SidedObject{
	private int numSides = 4;
	public Square2(){
		super();
		numSides = 4;
	}
	public Square2(double height, double width){
		super(height, width);
		numSides = 4;
	}
	public double getArea(){
		return this.getHeight() * this.getWidth();
	}
	public String toString(){
		return "Area of Square: " + this.getArea()+ 
				"\n" + "Number of Sides: " + this.displaySides() + "\n";
	}
	public int displaySides(){
		return this.numSides;
	}

}