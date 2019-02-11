package classes.subclasses.subclass;
import classes.subclasses.Books;
public class Ebooks extends Books{
	private String url;
	
	public Ebooks(){
		super();
		this.url = "";
	}
	public Ebooks(String title, String datePublished, String authors, String url){
		super(title, datePublished, authors);
		this.url = url;
	}
	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url = url;
	}
	public String toString(){
		String retString;
		retString = super.toString() + "\n" + "URL: " + this.url;
		return retString;
	}
}