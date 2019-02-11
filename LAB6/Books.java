package classes.subclasses;
import classes.superclass.Record;
public class Books extends Record{
	private String authors;
	public Books(){
		super();
		this.authors = "No authors";
	}
	public Books(String title, String datePublished, String authors){
		super(title, datePublished);
		this.authors = authors;
	}
	public String getAuthors(){
		return this.authors;
	}
	public void setAuthors(String authors){
		this.authors = authors;
	}
	public String toString(){
		String retString;
		retString = super.toString() + "\n" + "Authors: " + this.authors;
		return retString;
	}

}