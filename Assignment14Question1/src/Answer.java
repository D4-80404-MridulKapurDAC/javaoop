import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

enum MENU {
	INSERT,DISPLAY,INCREMENT,DELETE,FIND_ID,FIND_PARTY,TOTAL_VOTES,EXIT
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
	
	public static void insert(Connection con) {
		String query = "INSERT INTO candidates VALUES(default, ?, ?, ?)"; // parameterized query
		try(PreparedStatement stmt = con.prepareStatement(query)){
			Scanner sc = new Scanner(System.in);
			stmt.setString(1,sc.next());
			stmt.setString(2,sc.next());
			stmt.setInt(3,sc.nextInt());
			int count = stmt.executeUpdate();
			System.out.println(count);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void display(Connection con) {
		String query = "SELECT * FROM candidates"; // parameterized query
		try(PreparedStatement stmt = con.prepareStatement(query)){
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String party = rs.getString("party");
					int votes = rs.getInt("votes");
					System.out.printf("%d, %s, %s, %d\n", id, name, party, votes);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
		try(Connection con = DriverManager.getConnection(sqlPath,usr,pass)){
			MENU ch ;
			Scanner sc = new Scanner(System.in);
			do {
				System.out.println("1INSERT,2DISPLAY,3INCREMENT,4DELETE,5FIND_ID,6FIND_PARTY,7TOTAL_VOTES,8EXIT");
				ch = MENU.values()[sc.nextInt()-1];
				switch(ch) {
					case INSERT:
						insert(con);
						break;
					case DISPLAY:
						display(con);
						break;
					case INCREMENT:
						increment(con);
						break;
					case DELETE:
						delete(con);
						break;
					case FIND_ID:
						find_id(con);
						break;
					case FIND_PARTY:
						find_party(con);
						break;
					case TOTAL_VOTES:
						total_votes(con);
						break;
				}
			}while(ch!=MENU.EXIT);
		}catch(Exception e){
			System.out.println("error");
			e.printStackTrace();
		}
	}

	private static void total_votes(Connection con) {
		String query = "SELECT SUM(votes) as TOTAL FROM candidates WHERE party=?"; // parameterized query
		Scanner sc = new Scanner(System.in);
		try(PreparedStatement stmt = con.prepareStatement(query)){
			System.out.println("Enter Party : ");
			stmt.setString(1,sc.next());
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int total = rs.getInt("TOTAL");
					System.out.printf("TOTAL %d\n", total);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void find_party(Connection con) {
		String query = "SELECT * FROM candidates WHERE party=?"; // parameterized query
		try(PreparedStatement stmt = con.prepareStatement(query)){
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Party Name : ");
			stmt.setString(1,sc.next());
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String party = rs.getString("party");
					int votes = rs.getInt("votes");
					System.out.printf("%d, %s, %s, %d\n", id, name, party, votes);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void find_id(Connection con) {
		String query = "SELECT * FROM candidates WHERE id = ?";
		Scanner sc = new Scanner(System.in);
		try (PreparedStatement stmt = con.prepareStatement(query)){
			stmt.setInt(1,sc.nextInt());
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String party = rs.getString("party");
					int votes = rs.getInt("votes");
					System.out.printf("%d, %s, %s, %d\n", id, name, party, votes);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void delete(Connection con) {
		String query = "DELETE FROM candidates WHERE id = ?";
		Scanner sc = new Scanner(System.in);
		try (PreparedStatement stmt = con.prepareStatement(query)){
			stmt.setInt(1,sc.nextInt());
			int count = stmt.executeUpdate();
			System.out.println(count);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void increment(Connection con) {
		String query = "UPDATE candidates SET votes = votes + ? WHERE id = ?";
		Scanner sc = new Scanner(System.in);
		try (PreparedStatement stmt = con.prepareStatement(query)){
			stmt.setInt(1,sc.nextInt());
			stmt.setInt(2,sc.nextInt());
			int count = stmt.executeUpdate();
			System.out.println(count);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
