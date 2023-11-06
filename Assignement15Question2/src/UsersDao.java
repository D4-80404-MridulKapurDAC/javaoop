import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersDao implements AutoCloseable {
	private Connection con;
	private PreparedStatement addUser;
	private PreparedStatement editUser;
	private PreparedStatement deleteUser;
	private PreparedStatement getUserId;
	private PreparedStatement getUserAll;
	
	public UsersDao() throws Exception{
		con = DbUtil.getConnection();
		addUser = con.prepareStatement("INSERT INTO users VALUES (default,?,?,?,?,?,0,voter)");
		editUser = con.prepareStatement("UPDATE users SET first_name = ? , last_name = ? , email = ? , password = ? , dob = ? , status = ? ,role = ? WHERE id = ?");
		deleteUser = con.prepareStatement("DELETE FROM users WHERE id = ?");
		getUserId = con.prepareStatement("SELECT * FROM users WHERE id = ?");
		getUserAll = con.prepareStatement("SELECT * FROM users");
	}
	
	@Override
	public void close() throws Exception {
		try{
			addUser.close();
			editUser.close();
			deleteUser.close();
			getUserId.close();
			getUserAll.close();
			if(con != null)
				con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public java.sql.Date toSQLdate(java.util.Date d){
		return new java.sql.Date(d.getTime());
	}
	
	public int addUser(User u) throws Exception{	
		//firstName
		addUser.setString(1,u.getFname());
		//lastName
		addUser.setString(2,u.getLname());
		//Email
		addUser.setString(3,u.getEmail());
		//password
		addUser.setString(4,u.getPassword());
		//DOB
		addUser.setDate(5,toSQLdate(u.getDob()));
		//status
		//role
		return addUser.executeUpdate();
	}
	
	public int editUser(User u) throws Exception{
		//firstname
		editUser.setString(1,u.getFname());
		//lastName
		editUser.setString(2,u.getLname());
		//Email
		editUser.setString(3,u.getEmail());
		//password
		editUser.setString(4,u.getPassword());
		//dob
		editUser.setDate(5,toSQLdate(u.getDob()));
		//status
		editUser.setInt(6,u.getStatus());
		//role
		editUser.setString(7,u.getRole());
		//id
		editUser.setInt(8,u.getId());
		return editUser.executeUpdate();
	}
	
	public int deleteUser(int id) throws Exception{
		deleteUser.setInt(1, id);
		return deleteUser.executeUpdate();
	}
	
	public List<User> getAllUsers() throws Exception{
		List<User> res = new ArrayList<User>();
		try(ResultSet rs = getUserAll.executeQuery()) {
			while(rs.next()) {
				int id = rs.getInt("id");
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				java.util.Date dob = toUTILDate(rs.getDate("dob"));
				int status = rs.getInt("status");
				String  role = rs.getString("role");
				res.add(new User(id,fname,lname,email,password,dob,status,role));
			}
		}
		return res;
	}
	
	public User getUser(int id) throws Exception{
		User res = null;
		getUserId.setInt(1, id);
		try(ResultSet rs = getUserId.executeQuery()){			
			if(rs.next()) {
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				java.util.Date dob = toUTILDate(rs.getDate("dob"));
				int status = rs.getInt("status");
				String  role = rs.getString("role");
				res = new User(id,fname,lname,email,password,dob,status,role); 
			}
		}
		return res;
	}
	
	private Date toUTILDate(java.sql.Date date) {
		return new java.util.Date(date.getTime());
	}
}
