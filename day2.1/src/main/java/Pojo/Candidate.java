package Pojo;

public class Candidate {
	//id | name    | party    | votes
	private int id;
	private String Name;
	private String Party;
	private int votes;
	public Candidate(int id, String name, String party, int votes) {
		super();
		this.id = id;
		Name = name;
		Party = party;
		this.votes = votes;
	}
	
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", Name=" + Name + ", Party=" + Party + ", votes=" + votes + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getParty() {
		return Party;
	}

	public void setParty(String party) {
		Party = party;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	
	
	

}
