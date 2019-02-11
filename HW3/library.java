package library.client.classes;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import library.service.classes.BookGenre;
import library.service.classes.BookRecord;

public class library{
	BookRecord[] books;
	int noRecords=0;
	
	public BookRecord[] sortString(BookRecord[] myArray, int arraySize){
		int insertPt;
		int maxIndex;
		for(int i = arraySize - 1; i >= 1; i--){
			insertPt = i;
			maxIndex = 0;
			
			for(int j = 1; j <= i; j++){
				if(myArray[maxIndex].getTag().compareTo(myArray[j].getTag()) < 0){
					maxIndex = j;
				}
			}
			BookRecord temp = myArray[insertPt];
			myArray[insertPt] = myArray[maxIndex];
			myArray[maxIndex] = temp;
		}
		return myArray;
	}
	
	public BookRecord[] sortPages(BookRecord[] myArray, int arraySize){
		int insertPt;
		int maxIndex;
		for(int i = arraySize - 1; i >= 1; i--){
			insertPt = i;
			maxIndex = 0;
			for(int j = 1; j <= i; j++){
				if(myArray[maxIndex].getPages() < myArray[j].getPages()){
					maxIndex = j;
				}
			}
			BookRecord tmp = myArray[insertPt];
			myArray[insertPt] = myArray[maxIndex];
			myArray[maxIndex] = tmp;
		}
		return myArray;
	}
	public void resize(int resizeFactor){
		int initSize = this.noRecords;
		BookRecord[] newArray = new BookRecord[initSize + resizeFactor];
		for(int i = 0; i < this.books.length; i++){
			newArray[i] = this.books[i];
		}
		this.books = newArray;
		System.out.println("Resized the array from " + initSize + " to " + this.books.length);
	}
	
	public void searchByGenre(BookGenre genre){
		int counter = 0;
		BookRecord[] myArray = new BookRecord[noRecords];
		for(int i = 0; i < this.noRecords; i++){
			if(this.books[i].getGenre()==genre){
				myArray[counter] = this.books[i];
				counter++;
			}
		}
		myArray = sortPages(myArray, noRecords);
		for(int i = 0; i < noRecords; i++){
			if(myArray[i] != null){
				System.out.println(myArray[i].toString());
			}
		}
	}
				
	public void searchTag(String tag){
		int first = 0;
		int end = this.noRecords-1;
		int mid = (first+end)/2;
		while(first <=end){
			if(this.books[mid].getTag().compareTo(tag)==0){
				System.out.println("Found a Match");
				System.out.println(this.books[mid].toString());
				return;
			}
			else if(this.books[mid].getTag().compareTo(tag)<0){
				first = mid+1;
				mid = (first + end)/2;
			}
			else if(this.books[mid].getTag().compareTo(tag)>0){
				end = mid - 1;
				mid = (first + end) / 2;
			}
		}
		System.out.println("no match found");
	}
	public boolean searchForDuplicate(BookRecord aRecord){
		for(int i = 0; i < this.noRecords; i ++){
			if(this.books[i].equals(aRecord))
				return true;
		}
		return false;
	}
	public void print(){
		for(int i = 0; i < this.noRecords; i++){
			System.out.println(this.books[i].toString());
		}
	}
	
	public library(){
		this.books = new BookRecord[5];
	}
	
	public static void main(String[] args){
		int resizeFactor = Integer.parseInt(args[1]);
		library myLib = new library();
		String[] authors;
		BookRecord aRecord;
		Scanner scan;
		String str;
		try{
			File myFile = new File(args[0]);
			scan = new Scanner(myFile);
			while(scan.hasNextLine()){
				str = scan.nextLine();
				String[] tok = str.split(":");
				authors = tok[2].split(",");
				aRecord = new BookRecord(tok[0], tok[1], authors, tok[3], Integer.parseInt(tok[4]));
				if(!myLib.searchForDuplicate(aRecord)){
					myLib.books[myLib.noRecords] = aRecord;
					myLib.noRecords++;
					System.out.println("No of records: " + myLib.noRecords);
				}
				else{
					System.out.println("Found a duplicate.");
					System.out.println(aRecord.toString());
				}
				if(myLib.books.length ==myLib.noRecords){
					myLib.resize(resizeFactor);
				}
			}
		}catch(IOException ioe){
			System.out.println("The file culd not be read");
		}
		myLib.sortString(myLib.books, myLib.noRecords);
		
		String option1, option2;
		scan = new Scanner(System.in);
		while(true){
			System.out.println("Select an option: ");
			System.out.println("Type \"S\" to list books of a genre");
			System.out.println("Type \"P\" to print out all the book records");		
			System.out.println("Type \"T\" to search for a record with a specific tag");
			System.out.println("Type \"Q\" to Quit");
			option1=scan.nextLine();
			
			switch(option1){
				case "S":	System.out.println("Type a genre. They are: ");
							for(BookGenre d : BookGenre.values()){
								System.out.println(d);
							}
							option2 = scan.nextLine();
							myLib.searchByGenre(BookGenre.valueOf(option2));
							break;
				case "P":	myLib.print();
							break;
				case "Q": 	System.out.println("Quitting program");
							System.exit(0);
				case "T":	System.out.println("Type the tag: ");
							option2 = scan.nextLine();
							myLib.searchTag(option2);
							break;
				default:	System.out.println("WRong");
							break;
			}
		}
	}

}