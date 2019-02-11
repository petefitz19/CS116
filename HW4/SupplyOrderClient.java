package classes.client;

import java.util.*;
import java.io.*;
import classes.superclass.SupplyOrder;
import classes.subclass.RepeatedOrder;

public class SupplyOrderClient{
	static ArrayList<SupplyOrder> orders = new ArrayList<SupplyOrder>();
	static int noRecords = 0;
	
	static void sortByOID(ArrayList<SupplyOrder> order){
		int insertPt; int maxIndex;
		for(int i = order.size()-1; i>=1; i--){
			insertPt = i; maxIndex = 0;
			for(int j = 1; j <=i; j++){
				if(order.get(maxIndex).getOID() < order.get(j).getOID())
					maxIndex = j;
			}
			SupplyOrder temp = order.get(insertPt);
			order.set(insertPt, order.get(maxIndex));
			order.set(maxIndex, temp);
		}
	}
	static void sortByDate(ArrayList<SupplyOrder> order){
		int insertPt; int maxIndex;
		for(int i = order.size()-1; i>=1; i--){
			insertPt = i; maxIndex = 0;
			for(int j = 1; j <=i; j++){
				if(order.get(maxIndex).compareDate(order.get(j)) < 0)
					maxIndex = j;
			}
			SupplyOrder temp = order.get(insertPt);
			order.set(insertPt, order.get(maxIndex));
			order.set(maxIndex, temp);
		}
	}
	
	static void searchAndDelete(int OID){
		int first = 0;
		int end = noRecords - 1;
		int mid = (first + end) / 2;
		while(first <= end){
			if(orders.get(mid).getOID()==OID){
				String s = orders.get(mid).toString();
				orders.remove(mid);
				noRecords--;
				System.out.println("Removed: " + "\n" + s);
				System.out.println("New List Size: " + noRecords);
				return;
			}
			else if(orders.get(mid).getOID() < OID){
				first = mid + 1;
				mid = (first + end) / 2;
			}
			else if(orders.get(mid).getOID() > OID){
				end = mid - 1;
				mid = (first + end) / 2;
			}
		}
		System.out.println("Invalid ID");
	}
	
	public static void main(String[] args){
		SupplyOrder myOrd = new SupplyOrder();
		RepeatedOrder myROrd = new RepeatedOrder();
		Scanner scan;
		String str;
		try{
			File myFile = new File("orders.txt");
			scan = new Scanner(myFile);
			while(scan.hasNextLine()){
				str = scan.nextLine();
				String[] tok = str.split(",");
				String[] tok3 = tok[3].split("/");
				if(tok[0].equals("R")){
					myROrd = new RepeatedOrder(tok[0], tok[1], tok[2], tok[3], Integer.parseInt(tok[4]), Integer.parseInt(tok[5]), tok[6]);
					System.out.println(myROrd.toString());
					orders.add(myROrd);
					noRecords++;
				}
				if(tok[0].equals("O")){
					myOrd = new SupplyOrder(tok[0], tok[1], tok[2], tok[3], Integer.parseInt(tok[4]));
					orders.add(myOrd);
					noRecords++;
				}
			}
			scan.close();
		} catch(IOException ioe){
			System.out.println("The file could not be read");
		}
		sortByOID(orders);
		
		String option1, option2, option4;
		int option3;
		scan = new Scanner(System.in);
		while(true){
			sortByOID(orders);
			System.out.println("Select an Option:");
			System.out.println("Type \"A\" to add an order");
			System.out.println("Type \"D\" to delete an order");
			System.out.println("Type \"L\" to print out all customer IDs in a file");
			System.out.println("Type \"Q\" to Quit");
			option1 = scan.nextLine();
			
			switch(option1){
				case "A":	System.out.println("Type order:");
							option2 = scan.nextLine();
							String[] tok = option2.split(",");
							String[] tok3 = tok[3].split("/");
							if(tok[0].equals("R")){
								myROrd = new RepeatedOrder(tok[0], tok[1], tok[2], tok[3], Integer.parseInt(tok[4]), Integer.parseInt(tok[5]), tok[6]);
								System.out.println("Added Order: ");
								System.out.println(myROrd.toString());
								orders.add(myROrd);
								noRecords++;
								System.out.println("Current Size: " + noRecords);
								break;
							}
							if(tok[0].equals("O")){
							myOrd = new SupplyOrder(tok[0], tok[1], tok[2], tok[3], Integer.parseInt(tok[4]));
							System.out.println("Added Order: ");
							System.out.println(myOrd.toString());
							orders.add(myOrd);
							noRecords++;
							System.out.println("Current Size: " + noRecords);
							break;
							}
							break;
				case "D":	System.out.println("Type Order ID:");
							option3 = scan.nextInt();
							scan.nextLine();
							searchAndDelete(option3);
							break;
				case "L":	System.out.println("Enter Customer ID");
							option4 = scan.nextLine();
							ArrayList<SupplyOrder> ofSameCID = new ArrayList<SupplyOrder>();
							for(SupplyOrder element : orders){
								if(element.getCID().compareTo(option4) == 0){
									ofSameCID.add(element);
								}
							}
							sortByDate(ofSameCID);
							for(SupplyOrder element1 : ofSameCID){
								System.out.println(element1.toString());
							}
							break;
				case "Q":	System.out.println("Quitting Program");
							System.exit(0);
							break;
							
			}
		}		
	}
}