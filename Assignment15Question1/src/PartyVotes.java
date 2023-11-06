
public class PartyVotes {
	private String party;
	private Integer votes;
	public PartyVotes(String party, Integer votes) {
		super();
		this.party = party;
		this.votes = votes;
	}
	public PartyVotes() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PartyVotes [party=").append(party).append(", votes=").append(votes).append("]");
		return builder.toString();
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public Integer getVotes() {
		return votes;
	}
	public void setVotes(Integer votes) {
		this.votes = votes;
	}
	
}
