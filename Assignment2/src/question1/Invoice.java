package question1;

public class Invoice {
	private String partNum;
	private String desc;
	private int qty;
	private double price;
	
	public Invoice(String partNum, String desc, int qty, double price) {
		this.partNum = partNum;
		this.desc = desc;
		if(qty<0)
			this.qty = 0;
		else
			this.qty = qty;
		if(price < 0.0) 
			this.price  = 0;
		else 
			this.price = price;	
	}
	
	public String getPartNum() {
		return partNum;
	}
	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		if(qty<0)
			this.qty = 0;
		else
			this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if(price < 0.0) 
			this.price  = 0;
		else 
			this.price = price;	
	}
	
	public double calculate(){
		return this.price*this.qty;
	}
	
}
