package library.service.classes;
import library.service.classes.BookGenre;
public class BookRecord{
	int recordNo;
	String title;
	String[] authors;
	BookGenre genre;
	static int cnt = 10000;
	int pages = 0;
	String tag;
	
	public BookRecord(String title, String genre, String[] authors, String tag, int pages){
		this.setTitle(title);
		this.setGenre(genre);
		this.setAuthors(authors);
		this.setRecordNo();
		this.setTag(tag);
		this.setPages(pages);
	}
	
	public String getTitle(){
		return this.title;
	}	
	public BookGenre getGenre(){
		return this.genre;
	}
	
	public String[] getAuthors(){
		String[] ret = new String[this.authors.length];
		for(int i = 0; i < this.authors.length; i++){
			ret[i] = this.authors[i];
		}
		return ret;
	}
	
	public String getAuthorList(){
		String ret = "";
		for(int i = 0; i < this.authors.length; i++){
			ret += " " + this.authors[i];
		}
		return ret;
	}
	public String getTag(){
		return this.tag;
	}
	public int getPages(){
		return this.pages;
	}
	public int getRecordNo(){
		return this.recordNo;
	}
	
	public void setRecordNo(){
		this.recordNo = BookRecord.cnt++;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public void setGenre(String genre){
		this.genre = BookGenre.valueOf(genre);
	}
	public void setPages(int pages){
		this.pages=pages;
	}
	public void setTag(String tag){
		this.tag=tag;
	}
	public void setAuthors(String[] authorsList){
		this.authors = new String[authorsList.length];
		for(int i = 0; i < authorsList.length; i++){
			this.authors[i] = authorsList[i];
		}
	}
	public String toString(){		
		String str="";
		str = str + "===================================\n";
		str = str + "Record No:" + this.getRecordNo() + "\n";
		str = str + "Tag:" + this.getTag() + "\n";
		str = str + "Title:" + this.getTitle() + "\n";
		str = str + "Genre: " + this.getGenre() + "\n";
		str = str + "Authors: " + this.getAuthorList() + "\n";
		str = str + "No. of Pages: " + this.getPages() + "\n";
		str = str + "===================================\n";
		return str;
	}
	
	public boolean equals(BookRecord aRecord){
		if(!this.title.equals(aRecord.getTitle()))
			return false;
		if(!this.equalsHelper(aRecord))
			return false;
		if(!(this.getPages() == aRecord.getPages()))
			return false;
		return true;
	}
	
	private boolean equalsHelper(BookRecord aRecord){
		for(int i = 0; i < this.authors.length; i++){
			if(!this.authors[i].equals(aRecord.authors[i])){
				return false;
			}
		}
		return true;
	}
}
	