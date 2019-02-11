package Client;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import Client.Services.Classes.MyBills;
import Client.Services.BillsType;
import java.text.NumberFormat;

public class MyBillsClient {
	public String[] totalExpensesPerMonth(MyBills[] exp) {
		double Jan = 0.0, Feb = 0.0, Mar = 0.0, Apr = 0.0, May = 0.0, Jun = 0.0, Jul = 0.0, Aug = 0.0, Sep = 0.0, Oct = 0.0, Nov = 0.0, Dec = 0.0, total = 0.0;
		for(int i=0;i<exp.length;i++){
			if(exp[i].getMonth().equals("JANUARY")){
				for(int j=0;j<exp[i].getExpenses().length;j++){
					double [] d=exp[i].getExpenses();
					total+=d[j];
				}
				Jan=total;
				total=0.0;
			}else if(exp[i].getMonth().equals("FEBRUARY")){
				for(int j=0;j<exp[i].getExpenses().length;j++){
					double [] d=exp[i].getExpenses();
					total+=d[j];
				}
				Feb=total;
				total=0.0;
			}else if(exp[i].getMonth().equals("MARCH")){
				for(int j=0;j<exp[i].getExpenses().length;j++){
					double [] d=exp[i].getExpenses();
					total+=d[j];
				}
				Mar=total;
				total=0.0;
			}else if(exp[i].getMonth().equals("APRIL")){
				for(int j=0;j<exp[i].getExpenses().length;j++){
					double [] d=exp[i].getExpenses();
					total+=d[j];
				}
				Apr=total;
				total=0.0;
			}else if(exp[i].getMonth().equals("MAY")){
				for(int j=0;j<exp[i].getExpenses().length;j++){
					double [] d=exp[i].getExpenses();
					total+=d[j];
				}
				May=total;
				total=0.0;
			}else if(exp[i].getMonth().equals("JUNE")){
				for(int j=0;j<exp[i].getExpenses().length;j++){
					double [] d=exp[i].getExpenses();
					total+=d[j];
				}
				Jun=total;
				total=0.0;
			}else if(exp[i].getMonth().equals("JULY")){
				for(int j=0;j<exp[i].getExpenses().length;j++){
					double [] d=exp[i].getExpenses();
					total+=d[j];
				}
				Jul=total;
				total=0.0;
			}else if(exp[i].getMonth().equals("AUGUST")){
				for(int j=0;j<exp[i].getExpenses().length;j++){
					double [] d=exp[i].getExpenses();
					total+=d[j];
				}
				Aug=total;
				total=0.0;
			}else if(exp[i].getMonth().equals("SEPTEMBER")){
				for(int j=0;j<exp[i].getExpenses().length;j++){
					double [] d=exp[i].getExpenses();
					total+=d[j];
				}
				Sep=total;
				total=0.0;
			}else if(exp[i].getMonth().equals("OCTOBER")){
				for(int j=0;j<exp[i].getExpenses().length;j++){
					double [] d=exp[i].getExpenses();
					total+=d[j];
				}
				Oct=total;
				total=0.0;
			}else if(exp[i].getMonth().equals("NOVEMBER")){
				for(int j=0;j<exp[i].getExpenses().length;j++){
					double [] d=exp[i].getExpenses();
					total+=d[j];
				}
				Nov=total;
				total=0.0;
			}else if(exp[i].getMonth().equals("DECEMBER")){
				for(int j=0;j<exp[i].getExpenses().length;j++){
					double [] d=exp[i].getExpenses();
					total+=d[j];
				}
				Dec=total;
				total = 0.0;
			}
		}
		
		NumberFormat form=NumberFormat.getCurrencyInstance();
		String January=form.format(Jan);
		String February=form.format(Feb);
		String March=form.format(Mar);
		String April=form.format(Apr);
		String May1 = form.format(May);
		String June = form.format(Jun);
		String July = form.format(Jul);
		String August = form.format(Aug);
		String September = form.format(Sep);
		String October = form.format(Oct);
		String November = form.format(Nov);
		String December = form.format(Dec);
		
		String[] s = {January, February, March, April, May1, June, July, August, September, October, November, December};
		return s;
	}
	public static void main(String[] args) {
		MyBills abill;
		MyBills[] bills;;
		String str = "";
		int count = 0;
		try
		{
			File myexpenses = new File("Myexpenses.txt");
			Scanner scan = new Scanner(myexpenses);
			Scanner scan1 = new Scanner(myexpenses);
			int counter = 0;
			while(scan1.hasNextLine()){
				counter++;
				scan1.nextLine();
			}
			bills = new MyBills[counter/2];
			while(scan.hasNextLine())
			{
				str=scan.nextLine();
				String[] tok = str.split(":");
				str = scan.nextLine();
				String[] tok1 = str.split(",");
				double[] expenses1 = new double[tok1.length];
				for(int i =0; i<tok1.length; i++){
					expenses1[i] = Double.parseDouble(tok1[i]);
				}
				abill = new MyBills(tok[1], BillsType.valueOf(tok[3]), expenses1, tok1.length);
				bills[count] = abill;
				count++;
			}
			for(int i = 0; i < bills.length; i++){
				System.out.println(bills[i].toString());
			}
			String [] months={"January","Febraury","March","April","May","June","July","August","September","October","November","December"};
			MyBillsClient client = new MyBillsClient();
			String[] val = client.totalExpensesPerMonth(bills);
			for(int i=0;i<val.length;i++){
			if(!(val[i].equals("$0.00"))){
				System.out.println("The total of all the expenses for the month of "+months[i]+" is: "+val[i]);
			}
		}
		}
		catch(IOException ioe)
		{
			System.out.println("Error Occured");
		}
	}
}