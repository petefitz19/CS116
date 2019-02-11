public class Phone{
	private String areaCode;
	private String exchange;
	private String number;
	
	public Phone(){
		this.setArea("999");
		this.setExchange("999");
		this.setNumber("9999");
	}
	public Phone(String areaCode, String exchange, String number){
		this.setArea(areaCode);
		this.setExchange(exchange);
		this.setNumber(number);
	}
	public String getArea(){
		return this.areaCode;
	}
	public String getExchange(){
		return this.exchange;
	}
	public String getNumber(){
		return this.number;
	}
	public void setArea(String areaCode){
		if(areaCode.length() == 3)
			this.areaCode = areaCode;
		else System.out.println("Bad Area Code");
	}
	public void setExchange(String exchange){
		if(exchange.length() ==3)
			this.exchange = exchange;
		else System.out.println("Bad Exchange");
	}
	public void setNumber(String number){
		if(number.length() == 4)
			this.number = number;
		else System.out.println("Bad Number");
	}
	public String toString(){
		String ret = "(" + this.getArea() + ") " + this.getExchange() + " - " + this.getNumber();
		return ret;
	}
}