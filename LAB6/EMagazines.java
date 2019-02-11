package classes.subclasses.subclass;
import classes.subclasses.Magazines;
public class EMagazines extends Magazines{
	private String url;
	
	public EMagazines(){
		super();
		this.url = "";
	}
	public EMagazines(String title, String datePublished, String editor, int issueNo, int volNo, String url){
		super(title, datePublished, editor, issueNo, volNo);
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