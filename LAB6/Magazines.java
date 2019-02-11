package classes.subclasses;
import classes.superclass.Record;
public class Magazines extends Record{
	private String editor;
	private int issueNo;
	private int volNo;
	
	public Magazines(){
		super();
		this.editor = "No editors";
		this.issueNo = 0;
		this.volNo = 0;
	}
	public Magazines(String title, String datePublished, String editor, int issueNo, int volNo){
		super(title, datePublished);
		this.editor = editor;
		this.issueNo = issueNo;
		this.volNo = volNo;
	}
	public String getEditors(){
		return this.editor;
	}
	public int getIssueNo(){
		return this.issueNo;
	}
	public int getVolNo(){
		return this.volNo;
	}
	public void setEditor(String editor){
		this.editor = editor;
	}
	public void setIssueNo(int no){
		this.issueNo = no;
	}
	public void setVolNo(int no){
		this.volNo = no;
	}
	public String toString(){
		String retString;
		retString = super.toString() + "\n" + "Editors: " + this.editor + "\n" + "Issue No: " + this.issueNo + "\n" + "VolUme No: " + this.volNo;
		return retString;
	}

}