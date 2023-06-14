package Dao;

import java.sql.SQLException;
import java.util.List;

import Pojo.Candidate;

public interface CandidateDao {
	
	List<Candidate> getAllCandidates() throws SQLException ;
	
	String incrementCandidateVotes(int candidateId) throws SQLException ;
}
