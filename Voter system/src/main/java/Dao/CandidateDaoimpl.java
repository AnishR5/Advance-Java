package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import static utils.dbconnect.*;

import Pojo.Candidate;

public class CandidateDaoimpl implements CandidateDao {
	Connection cn;
	PreparedStatement pst1,pst2;
	
	public CandidateDaoimpl() throws SQLException {
		cn=openconnection();
		pst1=cn.prepareStatement("select * from candidates");
		pst2=cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		System.out.println("Candidate dao created");
			
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		List<Candidate> candidates = new ArrayList<>();
		System.out.println("in arraylist");
		
		try(ResultSet rst=pst1.executeQuery()){
			System.out.println("in try");
			while(rst.next()) {
				System.out.println("in while");
				candidates.add(new Candidate(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4)));
			}
			
		} 
//		for(Candidate c: candidates) {
//			System.out.println(c+"");
//		}
		return candidates;
	}

	@Override
	public String incrementCandidateVotes(int candidateId) throws SQLException {
		pst2.setInt(1, candidateId);
		int updateCount=pst2.executeUpdate();
		if(updateCount>0) {
			return "success";
		}
		else
			return "fail";
	}
	
	public void cleanUp() throws SQLException {
		if(pst1!=null)
			pst1.close();
		if(pst2!=null)
			pst2.close();
		closeconnection();
		System.out.println("Candidate Dao cleaned up");
	}

}
