package library.service.classes;

//import library.service.classes.BookGenre;
//may have to import BookGenre
public class BookRecord{
	private int id;
	static int id1;
	public String title;
	public String[] authors;
	public BookGenre genre;
	
	public BookRecord(){
		id++;
		id1 = id;
		title = "";
		authors = null;
		genre = null;
	}
	
	public BookRecord(String title, String[] authors, BookGenre genre){
		id++;
		id1 = id;
		this.title = title;
		this.authors = authors;
		this.genre = genre;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String[] getAuthors(){
		return authors;
	}
	
	public BookGenre getGenre(){
		return genre;
	}
	
	public boolean equals(BookRecord book){
		if(authors.length != book.getAuthors().length)
			return false;
		else 
			for(int i = 0; i < authors.length; i ++){
				if(!(authors[i].equals(book.getAuthors()[i])))
					return false;
		}
		if(title.equals(book.getTitle()) && genre==book.getGenre())
			return true;
		return false;
	}
	
	public String toString(){
		String s = "";
		for(int i = 0; i < authors.length-1; i++){
			if(authors[i]!=null)
				s+=authors[i] + ", ";	
		}
		//s+=authors[authors.length];
		return "Title: " + title + "\n" + "Authors: " + s + "\n" + "Genre: " + genre + "\n";
	}	
}