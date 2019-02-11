package classes.subclasses.subclass;
import classes.subclasses.Magazines;
public class HCMagazines extends Magazines{
	private String edition;
	
	public HCMagazines(){
		super();
		this.edition = "";
	}
	public HCMagazines(String title, String datePublished, String editor, int issueNo, int volNo, String edition){
		super(title, datePublished, editor, issueNo, volNo);
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