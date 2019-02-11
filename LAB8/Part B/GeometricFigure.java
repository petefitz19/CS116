package classes.abstracts;

public abstract class GeometricFigure{
	private double height;
	private double width;
	
	public GeometricFigure(){
		this.setHeight(10.0);
		this.setWidth(10.0);
	}
	
	public GeometricFigure(double height, double width){
		this.setHeight(height);
		this.setWidth(width);
	}
	public void setHeight(double height){
		this.height = height;
	}
	public void setWidth(double width){
		this.width = width;
	}
	public double getHeight(){
		return this.height;
	}
	public double getWidth(){
		return this.width;
	}
	public abstract double getArea();

}