package classes.subclasses;
import classes.superclass.Record;
public class Newspapers extends Record{
	private String editor;
	private String edition;
	
	public Newspapers(){
		super();
		this.editor = "No editors";
		this.edition = "No edition";
	}
	public Newspapers(String title, String datePublished, String editor, String edition){
		super(title, datePublished);
		this.editor = editor;
		this.edition = edition;
	}
	public String getEditors(){
		return this.editor;
	}
	public String getEdition(){
		return this.edition;
	}
	public void setEditors(String ed){
		this.editor = ed;
	}
	public void setEdition(String ed){
		this.edition = ed;
	}
	public String toString(){
		String retString;
		retString = super.toString() + "\n" + "Editors: " + this.editor + "\n" + "Edition: " + this.edition;
		return retString;
	}
}