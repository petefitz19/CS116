package classes.client;
import classes.subclasses.subclass.HCBooks;
import classes.subclasses.subclass.Ebooks;
import classes.subclasses.subclass.EMagazines;
import classes.subclasses.subclass.HCMagazines;
import classes.subclasses.Magazines;
import classes.subclasses.Newspapers;
import classes.subclasses.Books;
public class RecordClient{
	public static void main(String[] args){
		HCBooks Obj1 = new HCBooks();
		EMagazines Obj2 = new EMagazines("Wireless Magazine", "10-01-2017", "Jack Kelso", 10, 12, "http://www.wireless.com/vol12/i10");
		Newspapers Obj3 = new Newspapers("Washington Post", "10-05-2017", "Russell Goode", "Washington DC Edition");
		System.out.println(Obj1.toString());
		System.out.println(Obj2.toString());
		System.out.println(Obj3.toString());
	}
}