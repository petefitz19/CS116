public class BusinessPhone extends Phone{
	private String extension;
	public BusinessPhone(){
		super();
	}
	public BusinessPhone(String areaCode, String exchange, String number, String extension){
		super(areaCode, exchange, number);
		this.setExtension(extension);
	}
	public BusinessPhone(Phone p, String extension){
		super(p.getArea(), p.getExchange().toString(), p.getNumber().toString());
		this.setExtension(extension);
	}
	public String getExtension(){
		return this.extension;
	}
	public void setExtension(String extension){
		if(extension.length() == 4)
			this.extension = extension;
		else System.out.println("Bad Extension");
	}
	public String toString(){
		String ret = super.toString() + " - " + this.getExtension();
		return ret;
	}
}