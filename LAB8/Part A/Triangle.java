package classes.subclasses;
import classes.abstracts.GeometricFigure;
public class Triangle extends GeometricFigure{
	public Triangle(){
		super();
	}
	public Triangle(double height, double width){
		super(height, width);
	}
	public double getArea(){
		return 0.5 * this.getHeight() * this.getWidth();
	}
	public String toString(){
		return "Area of Triangle: " + this.getArea();
	}

}