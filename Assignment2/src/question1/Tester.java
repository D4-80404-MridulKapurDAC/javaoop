package question1; 

public class Tester {

	public static void main(String[] args) {
		Invoice i1 = new Invoice("P1","Desc rip tion o ne ",-12,-1.2);
		System.out.println("Part Number : "+i1.getPartNum());
		System.out.println("Part Desc : " +i1.getDesc());
		System.out.println("Price : "+i1.getPrice());
		System.out.println("Quantity : "+i1.getQty());
		System.out.println("Total Bill : "+i1.calculate());
	}

}
