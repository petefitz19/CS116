package classes.subclasses.subclass;
import classes.subclasses.Books;
public class HCBooks extends Books{
	private String edition;
	public HCBooks(){
		super();
		this.edition = "No Edition";
	}
	public HCBooks(String title, String datePublished, String authors, String edition){
		super(title, datePublished, authors);
		this.edition = edition;
	}
	public String getEdition(){
		return this.edition;
	}
	public void setEdition(String ed){
		this.edition = ed;
	}
	public String toString(){
		String retString;
		retString = super.toString() + "\n" + "Edition: " + this.edition;
		return retString;
	}
}