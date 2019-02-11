package classes.subclasses;
import classes.abstracts.GeometricFigure;
public class Square extends GeometricFigure{
	public Square(){
		super();
	}
	public Square(double height, double width){
		super(height, width);
	}
	public double getArea(){
		return this.getHeight() * this.getWidth();
	}
	public String toString(){
		return "Area of Square: " + this.getArea();
	}

}