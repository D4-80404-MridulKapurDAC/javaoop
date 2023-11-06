import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

enum MENU{
	ADD,UPDATE,DELETE,FIND_ID,FIND_ALL,EXIT;
}

public class Answer {
	public static java.util.Date toUtilDate(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			java.util.Date uDate = new java.util.Date();
			uDate = sdf.parse(d);
			return uDate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static User acceptUser(Scanner sc) {
		System.out.print("Enter Id: ");
		int id = sc.nextInt();
		System.out.print("Enter FName: ");
		String fname = sc.next();
		System.out.print("Enter LName: ");
		String lname = sc.next();
		System.out.print("Enter Email: ");
		String email = sc.next();
		System.out.print("Enter Pass: ");
		String password = sc.next();
		System.out.print("Enter dob: ");
		String dob = sc.next();
		java.util.Date d = toUtilDate(dob);
		System.out.print("Enter Status: ");
		int status = sc.nextInt();
		System.out.print("Enter Role: ");
		String role = sc.next();
		User c = new User(id,fname,lname,email,password,d,status,role);	
		return c;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("hello");
		try(UsersDao uDao = new UsersDao()){
			MENU ch;
			do {
				System.out.println("1add,2update,3delete,4id,5all,6exit");
				ch = MENU.values()[sc.nextInt()-1];
				switch(ch) {
					case ADD:
						User temp = acceptUser(sc);
						System.out.println("Added Row : " + uDao.addUser(temp));
						break;
					case UPDATE:
						User upd = acceptUser(sc);
						System.out.println("Updated Rows : " + uDao.editUser(upd));
						break;
					case DELETE:
						System.out.println("Enter id to delete");
						System.out.println("Deleted rows : " + uDao.deleteUser(sc.nextInt()));						
						break;
					case FIND_ID:
						System.out.println("Enter id to find");
						System.out.println(uDao.getUser(sc.nextInt()));
						break;
					case FIND_ALL:
						System.out.println(uDao.getAllUsers());
						break;
					default:
						break;
				}	
			}while(ch != MENU.EXIT);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}











