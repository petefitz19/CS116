import java.util.Scanner;
public class TestPalindrome{
	public static boolean isPalindrome(String s){
		String str = s.toUpperCase().replaceAll(" ", "");
		if(str.length() <=1){
			return true;
		}
		else if(str.charAt(0) == str.charAt(str.length()-1)){
			return isPalindrome(str.substring(1, str.length()-1));
		}
		return false;
	}
	public static void main(String[] args){
		boolean again = true;
		boolean x;
		while(again){
			try{
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter a String to Test if it is a Palindrome: ");
				String str = scan.nextLine();
				x = isPalindrome(str);
				if(x){
					System.out.println("'" + str + "'" + " is a Palindrome!");
				}
				else System.out.println("'" + str + "'" + " is not a Palindrome!");
				System.out.println("Try Again?");
				String str2 = scan.nextLine().toUpperCase();
				if(str2.equals("YES"))
					again = true;
				else if(str2.equals("NO"))
					again = false;	
			}catch(Exception e){
				System.out.println("User input error occurred.");
			}
		}
	}
}