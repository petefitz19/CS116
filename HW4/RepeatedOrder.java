package classes.subclass;
import classes.superclass.SupplyOrder;

public class RepeatedOrder extends SupplyOrder{
	//R,Orange Inc.,C2,10/22/2003,7,30,12/8/2003
	//type, CID, PID, date, amount, period, end date
	private int period;
	private String endDate;
	
	public RepeatedOrder(){
		super();
		this.period = 0;
		this.endDate = "None";
	}
	public RepeatedOrder(String type, String CID, String PID, String date, int amount, int period, String endDate){
		super(type, CID, PID, date, amount);
		this.period = period;
		this.endDate = endDate;
	}
	
	//acessors
	public int getPeriod(){
		return this.period;
	}
	public String getEndDate(){
		return this.endDate;
	}
	
	//mutators
	public void setPeriod(int period){
		this.period = period;
	}
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
	
	public String toString(){
		String s = "";
		s += super.toString() + "Period: " + this.getPeriod() + "\n";
		s += "End Date: " + this.getEndDate() + "\n";
		return s;
	}
	public static void main(String[] args){
		SupplyOrder s = new SupplyOrder("R", "Orange Inc.", "C2", "9/22/2004", 7);
		RepeatedOrder s1 = new RepeatedOrder("R", "Orange Inc.", "C2", "9/22/2004", 7, 30,"12/8/2003");
		System.out.println(s.compareDate(s1));
		System.out.println(s.toString());
		System.out.println(s1.toString());
	}
}