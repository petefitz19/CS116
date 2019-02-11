import java.util.*;
public class PhoneMnemonics{
	private String[] letters = {"0", "1", "ABC", "DEF", "GHI",  "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
	
	public static void main(String[] args){
		boolean x = true;
		while(x){
			PhoneMnemonics p = new PhoneMnemonics();
			String str = p.readNumber();
			Vector<String> list = p.listMnemonics(str);
			System.out.println(list);
			x = readAgain();
		}
	}
	public String readNumber(){
		String phoneNumber;
		try{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a phone number:");
			phoneNumber = scan.nextLine();
			if (!(phoneNumber.matches("[0-9]+")))
				throw(new Exception());
			return phoneNumber;
		}catch(Exception error){
			System.out.println("Invalid Input");
			return readNumber();
		}
	}
	public static boolean readAgain(){
		Scanner scan = new Scanner(System.in);
		String again;
		
		try{
			System.out.println("Try again?:");
			again = scan.nextLine().toUpperCase();
			if(again.equals("YES"))
				return true;
			else if(again.equals("NO"))
				return false;
			else throw(new Exception());
		}catch(Exception error){
			System.out.println("Invalid Input");
			return readAgain();
		}
	}
	public Vector<String> listMnemonics(String number){
		Vector<String> list = new Vector<>();
		String num = number.replaceAll("0", "");
		num = num.replaceAll("1", "");
		int single = Integer.parseInt(num.substring(0, 1));
		for(int i = 0; i < letters[single].length(); i++){
			char letter = letters[single].charAt(i);
			if(num.length() > 1){
				for(String j: (listMnemonics(num.substring(1))))
					list.add(letter + j);
			}
			else{
				list.add("" +letter);
			}
		}
		return list;
	}
}