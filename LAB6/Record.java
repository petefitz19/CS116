package classes.superclass;
public class Record{
	private String title;
	private String datePublished;
	private String ID;
	private static int counter = 1000;
	public Record(){
		this.title = "No title";
		this.datePublished = "99-99-9999";
		this.ID = "" + this.counter;
		this.counter++;
	}
	public Record(String title, String datePublished){
		this.title = title;
		this.datePublished = datePublished;
		this.ID = "" + this.counter;
		this.counter++;
	}
	public String getTitle(){
		return this.title;
	}
	public String getDatePublished(){
		return this.datePublished;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setDatePublished(String date){
		this.datePublished = date;
	}
	public String toString(){
	String retString;
	   retString="==============================\n";
	   retString=retString + "Name: " + this.getTitle() +"\n";
	   retString=retString + "Date Published: " + this.getDatePublished() +"\n";
	   retString=retString + "ID: " + this.ID;
	   
	   return retString;
   }   
}