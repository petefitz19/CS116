package classes.superclass;

public class SupplyOrder{
	private String type;
	private int OID;
	private String CID;
	private String PID;
	private String date;
	private int amount;
	private static int count;
	
	public SupplyOrder(){
		this.type = "None";
		this.CID = "None";
		this.PID = "None";
		this.date = "None";
		this.amount = 0;
		this.OID = count++;
	}
	
	public SupplyOrder(String type, String CID, String PID, String date, int amount){
		this.type = type;
		this.CID = CID;
		this.PID = PID;
		this.date = date;
		this.amount = amount;
		this.OID = count++;
	}
	
	//accessors
	public String getType(){
		return this.type;
	}
	public String getCID(){
		return this.CID;
	}
	public String getPID(){
		return this.PID;
	}
	public String getDate(){
		return this.date;
	}
	public int getAmount(){
		return this.amount;
	}
	public int getOID(){
		return this.OID;
	}
	
	//mutators
	public void setType(String type){
		this.type = type;
	}
	public void setCID(String CID){
		this.CID = CID;
	}
	public void setPID(String PID){
		this.PID = PID;
	}
	public void setDate(String date){
		this.date = date;
	}
	public void setAmount(int amount){
		this.amount = amount;
	}
	
	public String toString(){
		String s = "";
		s += "Order ID: " + this.getOID() + "\n";
		s += "Type: " + this.getType() + "\n";
		s += "Customer ID: " + this.getCID() + "\n";
		s += "Product ID: " + this.getPID() + "\n";
		s += "Date: " + this.getDate() + "\n";
		s += "Amount: " + this.getAmount() + "\n";
		return s;
	}
	public int compareDate(SupplyOrder sup){
		String[] tok = this.getDate().split("/");
		String[] tok1 = sup.getDate().split("/");
		int month = Integer.parseInt(tok[0]);
		int month1 = Integer.parseInt(tok1[0]);
		int day = Integer.parseInt(tok[1]);
		int day1 = Integer.parseInt(tok1[1]);
		int year = Integer.parseInt(tok[2]);
		int year1 = Integer.parseInt(tok1[2]);
		if(year > year1)
			return 1;
		else if(year < year1)
			return -1;
		else if(year == year1){
			if(month > month1)
				return 1;
			else if(month < month1)
				return -1;
			else if(month == month1){
				if(day > day1)
					return 1;
				else if(day < day1)
					return -1;
				else if(day == day1)
					return 0;
			}
		}
		return 0;
	}
	public static void main(String[] args){
		SupplyOrder s = new SupplyOrder("R", "Orange Inc.", "C2", "9/22/2004", 7);
		SupplyOrder s1 = new SupplyOrder("R", "Orange Inc.", "C2", "10/22/2004", 7);
		System.out.println(s.compareDate(s1));
	}
}
//R,Orange Inc.,C2,10/22/2003,7,30,12/8/2003
//type, CID, PID, date, amount, period, end date
