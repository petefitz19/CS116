import java.util.Scanner;
import java.lang.Exception;
public class PhoneClient {
	public static void main(String[] args) {

		// create a Phone
		Phone phone1 = new Phone("312", "867", "5309");
		System.out.println("phone1:"+phone1.toString()+"\n");

		// create a BusinessPhone
		BusinessPhone businessPhone1 = new BusinessPhone("312", "567", "3000", "5148");
		System.out.println("businessPhone1:"+businessPhone1.toString()+"\n");

		// create a BusinessPhone from a Phone
		BusinessPhone businessPhone2 = new BusinessPhone(phone1, "1111");
		System.out.println("businessPhone2:"+businessPhone2.toString()+"\n");

		// change the Phone
		phone1.setArea("773");
		System.out.println("phone1:"+phone1.toString()+"\n");

		// output the BusinessPhone created from the Phone
		System.out.println("businessPhone2:"+businessPhone2.toString()+"\n");

		// call Phone method on a BusinessPhone
		System.out.println("businessPhone1 exchange:" + businessPhone1.getExchange()+"\n");

		// try to create a bad phone number
		Phone phone2 = new Phone("111", "867", "309");
		System.out.println("phone2:"+phone2.toString()+"\n");

		// call a BusinessPhone method on a Phone
		//This should not work. why?
		//String temp = phone1.getExtension();
		try
		{
			String str;
			Phone p;
			BusinessPhone bp;
			Scanner scan = new Scanner(System.in);
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Enter a Number seperated by dashes");
			str = scan.nextLine();
			if(str == "Exit")
				System.exit(0);
			String[] tok = str.split("-");
			if(tok.length == 3){
				p = new Phone(tok[0], tok[1], tok[2]);
				System.out.println("Phone: " + p.toString());
			}
			else if(tok.length==4){
				bp = new BusinessPhone(tok[0], tok[1], tok[2], tok[3]);
				System.out.println("Business Phone: " + bp.toString());
			}
			else System.out.println("Bad Phone Number");
		}
		catch(Exception e){
			System.out.println("Error reading input");
		}
	}
}