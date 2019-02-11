package Client.Services.Classes;

import Client.Services.BillsType;

public class MyBills {
	private String month;
	private BillsType expenseType;
	private double [] expenses;
	private int numDays;
	static int id;
	private int id1;
	
	//In addition it has two attributes one static and the other non static for tracking ids of Expenses
	//objects created. 
		
	public MyBills()
		{
			month = "any month";
			expenseType = null;
			expenses = null;
			numDays = 0;
			id++;
			id1 = id;
		}
	
	public MyBills(String month, BillsType expenseType, double [] expenses, int numDays)
		{
			this.month = month;
			this.expenseType = expenseType;
			this.expenses = expenses;
			this.numDays = numDays;
			id++;
			id1 = id;
		}
	
	public String getMonth() {
		return month;
	}
	
	public BillsType getExpenseType() {
		return expenseType;
	}
	
	public double [] getExpenses() {
		return expenses;
	}
	
	public int getNumDays() {
		return numDays;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public void setExpenseType(BillsType expenseType) {
		this.expenseType = expenseType;
	}
	
	public void setExpenses(double [] expenses) {
		this.expenses = expenses;
	}
	
	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}
	
	public boolean equals(MyBills bill) {
		if(this.expenseType==expenseType && this.numDays== numDays)
			return true;
		else return false;
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i<expenses.length; i++){
			s+=expenses[i] + ", ";
		}
		return "The month is: " + month + ". The type of expense is: " + 
				expenseType + ". The amounts are: " + s + 
				". The number of days for data is: " + numDays +
				". The expense object ID is: " + id1 + " and the static id value is: "
				+ id;
	}
	
}
	