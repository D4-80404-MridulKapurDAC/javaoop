import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CandidateDao implements AutoCloseable {
	private Connection con;
	private PreparedStatement insertCan;
	private PreparedStatement updateCan;
	private PreparedStatement deleteCan;
	private PreparedStatement findCanId;
	private PreparedStatement findAllCan;
	private PreparedStatement findCanParty;
	private PreparedStatement partyVotes;
	public CandidateDao() throws Exception {
		con = DbUtil.getConnection();
		insertCan = con.prepareStatement("INSERT INTO candidates VALUES(default,?,?,?)");   
		updateCan = con.prepareStatement("UPDATE candidates SET name=?, party=?, votes=? WHERE id=?");   
		deleteCan = con.prepareStatement("DELETE FROM candidates WHERE id=?");   
		findCanId = con.prepareStatement("SELECT * FROM candidates WHERE id=?");   
		findAllCan = con.prepareStatement("SELECT * FROM candidates");  
		findCanParty = con.prepareStatement("SELECT * FROM candidates WHERE party = ?");
		partyVotes = con.prepareStatement("SELECT party, SUM(votes) votes FROM candidates GROUP BY party");  	
	}
	public void close() {
		try {
			insertCan.close();
			updateCan.close();
			deleteCan.close();
			findCanId.close();
			findAllCan.close();
			findCanParty.close(); 
			partyVotes.close(); 
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int save(Candidate c) throws Exception {
		insertCan.setString(1, c.getName());
		insertCan.setString(2, c.getParty());
		insertCan.setInt(3, c.getVotes());
		int count = insertCan.executeUpdate();
		return count;
	}
	public int update(Candidate c) throws Exception {
		updateCan.setString(1, c.getName());
		updateCan.setString(2, c.getParty());
		updateCan.setInt(3, c.getVotes());
		updateCan.setInt(4, c.getId());
		int count = updateCan.executeUpdate();
		return count;
	}
	public int deleteById(int id) throws Exception{
		deleteCan.setInt(1, id);
		int count = deleteCan.executeUpdate();
		return count;
	}
	public Candidate findById(int id) throws Exception{
		findCanId.setInt(1, id);
		try(ResultSet rs = findCanId.executeQuery()){
			if(rs.next()) {
				return new Candidate(rs.getInt("id"),rs.getString("name"),rs.getString("party"),rs.getInt("votes"));			
			}else {
				return null;
			}
		}
	}
	public List<Candidate> findAll() throws Exception{
		List<Candidate> list = new ArrayList<Candidate>();	
		try(ResultSet rs = findAllCan.executeQuery()){
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String party = rs.getString("party");
				int votes = rs.getInt("votes");
				Candidate c = new Candidate(id, name, party, votes);
				list.add(c);
			}
		}
		return list;
	}
	public List<Candidate> findByParty(String party) throws Exception {
		List<Candidate> list = new ArrayList<Candidate>();
		findCanParty.setString(1, party);
		try(ResultSet rs = findCanParty.executeQuery()) {
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				party = rs.getString("party");
				int votes = rs.getInt("votes");
				Candidate c = new Candidate(id, name, party, votes);
				list.add(c);
			}
		}
		return list;
	}
	
	public List<PartyVotes> partyVotes() throws Exception{
		List<PartyVotes> list = new ArrayList<PartyVotes>();
		try(ResultSet rs = partyVotes.executeQuery()){
			while(rs.next()) {
				list.add(new PartyVotes(rs.getString("party"),rs.getInt("votes")));
			}
		}
		return list;
	}
}
