package company;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employees[] empl = new Employees[6];
		empl[0] = new Salaried("123","fname1","lname1",1000);
		empl[1] = new Commission("123","fname1","lname1",1000,11);
		empl[2] = new CommissionBase("123","fname1","lname1",1000,11,12);
		empl[3] = new Salaried("123","fname1","lname1",1000);
		empl[4] = new Hourly("123","fname1","lname1",100,100);
		empl[5] = new CommissionBase("123","fname1","lname1",1000,11,5);
		for(Employees e : empl) {
			if(e.typeOf() == "company.CommissionBase") {
				((CommissionBase) e).setBase(((CommissionBase) e).getBase()*1.1);
			}
//			System.out.println(e.typeOf());
			System.out.println(e.toString());
		}
		System.out.println(empl[2].toString());
	}

}
