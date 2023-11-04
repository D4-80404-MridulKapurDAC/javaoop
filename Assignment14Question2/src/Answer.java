import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

enum MENU {
	INSERT,DISPLAY,DELETE,CHANGE_STATUS,CHANGE_NAME_BIRTH,EXIT, 
}

public class Answer {
	public static String sqlDriver = "com.mysql.cj.jdbc.Driver";
	public static String sqlPath = "jdbc:mysql://localhost:3306/JAVA";
	public static String usr = "D4_80404_mridul";
	public static String pass = "sunbeam";
	
	static {
		try {		
			Class.forName(sqlDriver);
		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static void main(String[] args) throws Exception{
		try(Connection con = DriverManager.getConnection(sqlPath,usr,pass)){
			MENU ch ;
			Scanner sc = new Scanner(System.in);
			do {
				System.out.println("1INSERT,2DISPLAY,3DELETE,4CHANGE_STATUS,5CHANGE_NAME_BIRTH,6EXIT");
				ch = MENU.values()[sc.nextInt()-1];
				switch(ch) {
				case INSERT:
					insert(con);
					break;
				case DISPLAY:
					display(con);
					break;
				case DELETE:
					delete(con);
					break;
				case CHANGE_STATUS:
					changeStatus(con);
					break;
				case CHANGE_NAME_BIRTH:
					changeNameBirth(con);
					break;
				}
			}while(ch!=MENU.EXIT);
		}catch(Exception e){
			System.out.println("error");
			e.printStackTrace();
		}
	}
	
	public static void insert(Connection con) {
		//id,first_name,last_name,email,password,dob,status,role
		Scanner sc = new Scanner(System.in);
		String fname = sc.next();
		String lname = sc.next();
		String email = sc.next();
		String password = sc.next();
		java.sql.Date birthDate = toSQLdate(sc.next());
		int status = sc.nextInt();
		String role = sc.next();
		String query = "INSERT INTO users VALUES(default,?,?,?,?,?,?,?)";
		try(PreparedStatement stmt = con.prepareStatement(query)){
			stmt.setString(1,fname);
			stmt.setString(2,lname);
			stmt.setString(3,email);
			stmt.setString(4,password);
			stmt.setDate(5,birthDate);
			stmt.setInt(6, status);
			stmt.setString(7,role);
			int count = stmt.executeUpdate();
			System.out.println(count);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static java.sql.Date toSQLdate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			java.util.Date uDate = new java.util.Date();
			uDate = sdf.parse(date);
			java.sql.Date sDate = new java.sql.Date(uDate.getTime());
			return sDate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String toStringDate(java.sql.Date date){
		//id,first_name,last_name,email,password,dob,status,role
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String dateStr = sdf.format(date);
		return dateStr;
	}

	public static void display(Connection con) {
		//id,first_name,last_name,email,password,dob,status,role
		String query = "SELECT * FROM users"; // parameterized query
		try(PreparedStatement stmt = con.prepareStatement(query)){
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String fname = rs.getString("first_name");
					String lname = rs.getString("last_name");
					String email = rs.getString("email");
					String password = rs.getString("password");
					String dob = toStringDate(rs.getDate("dob"));
					Integer status = rs.getInt("status");
					String role = rs.getString("role");
					System.out.printf("%d, %s, %s, %s, %s, %s, %d, %s,\n", id, fname, lname, email,password,dob,status,role);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	private static void changeNameBirth(Connection con) {
		String query = "UPDATE users SET first_name = ? , dob = ? WHERE id = ?"; // parameterized query
		Scanner sc = new Scanner(System.in);
		try(PreparedStatement stmt = con.prepareStatement(query)){
			stmt.setString(1,sc.next());
			stmt.setDate(2, toSQLdate(sc.next()));
			stmt.setInt(3, sc.nextInt());
			int count = stmt.executeUpdate();
			System.out.println(count);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void delete(Connection con) {
		String query = "DELETE FROM users WHERE id = ?";
		Scanner sc = new Scanner(System.in);
		try (PreparedStatement stmt = con.prepareStatement(query)){
			stmt.setInt(1,sc.nextInt());
			int count = stmt.executeUpdate();
			System.out.println(count);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void changeStatus(Connection con) {
		String query = "UPDATE users SET status = 1  WHERE id = ?";
		Scanner sc = new Scanner(System.in);
		try (PreparedStatement stmt = con.prepareStatement(query)){
			stmt.setInt(1,sc.nextInt());
			int count = stmt.executeUpdate();
			System.out.println(count);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
