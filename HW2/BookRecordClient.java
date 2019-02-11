import library.service.classes.BookGenre;
import library.service.classes.BookRecord;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class BookRecordClient{
	static BookRecord[] bookr = new BookRecord[5];
	static int numRecords = 0;
	
	public static void main(String []args){
	//arg[0]: text file //arg[1]: resize factor
		int count = 0;
		int sizef = Integer.parseInt(args[1]);
		try {
			File books = new File("books.txt");
			Scanner scan = new Scanner(books);
			while(scan.hasNextLine()){ //check if full, then resize if counter = length
				String str = scan.nextLine();
				String[] tok = str.split(":");
				String[] tok1 = tok[2].split(",");
				BookGenre genre = BookGenre.valueOf(tok[1]);
				String[] authors = new String[tok1.length+1];
				authors[0] = tok[2];
				for(int i =0; i < tok1.length; i++){
					authors[i] = tok1[i];
				}
				BookRecord b = new BookRecord(tok[0], authors, genre);
				boolean dup = true;
				for(int i = 0; i < numRecords; i++){
					if(b.equals(bookr[i])){
						dup = false;
					}
					dup = true;
				}
				if(dup==true){
					bookr[numRecords] = b;
					numRecords++;
				} else {
					System.out.println("Duplicate Found" + "\n" + b.toString());
				}
				
				if(numRecords==bookr.length){
					BookRecord[] temp = new BookRecord[bookr.length + sizef];
					for(int i = 0; i < bookr.length; i++){
						temp[i] = bookr[i];
					}
					bookr = temp;
					temp = null;
					System.out.println("Resized the array from " + (bookr.length - sizef) + " to " + bookr.length);
				}
			}
				
		} catch(IOException ioe){
			System.out.println("The file can not be read");
		}
	//User interactive part
		while(true){
			String option1, option2;
			System.out.println("Select an option:");
			System.out.println("Type \"S\" to list books of a genre");
			System.out.println("Type \"P\" to print out all the book records");
			System.out.println("Type \"Q\" to Quit");
			Scanner scan = new Scanner(System.in);
			//get input from the user
			option1 = scan.nextLine();
			switch (option1) {
				case "S":System.out.println("Type a genre. The genres are:");
				for (BookGenre d : BookGenre.values()) {
					System.out.println(d);
				}
				option2=scan.nextLine(); //assume the use will type in a valid genre
				//print out records of the selected genre
				ArrayList<Integer> arr = new ArrayList<Integer>();
				for(int i = 0; i < bookr.length; i ++){
					if(bookr[i]!=null){
						if(bookr[i].getGenre()==BookGenre.valueOf(option2))
							arr.add(i);
					}
				}
				for(int i = 0; i < arr.size(); i++){
					System.out.println(bookr[arr.get(i)].toString());
				}
				break;
				case "P": 
				for(int i = 0; i < bookr.length; i ++){
					if(bookr[i] != null){
						System.out.println(bookr[i].toString());
					}
				}
				break;
				case "Q": System.out.println("Quitting program");
				System.exit(0);
				default: System.out.println("Wrong option! Try again");
				break;
			}
		}
	}
}