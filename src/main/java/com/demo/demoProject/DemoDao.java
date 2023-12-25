package com.demo.demoProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class DemoDao {

	private static Map<String, Integer> candidatesMap = new HashMap<String, Integer>();
	
	public void addCandidate(String candidateName) {
		candidatesMap.put(candidateName, 0);
	}
	
	public void castVote(String candidateName) {
		if(candidatesMap.containsKey(candidateName)) {
			candidatesMap.put(candidateName, candidatesMap.get(candidateName) + 1);
		}
		else {
			throw new IllegalArgumentException("Candidate is not present to vote");
		}
		
	}
	
	public Integer countVote(String candidateName) {
		if(candidatesMap.containsKey(candidateName)) {
			return candidatesMap.get(candidateName);
		}
		else {
			throw new IllegalArgumentException("Candidate does not exist to count vote");
		}
	}
	
	public HashMap<String, Integer> listVotings() {
		return (HashMap<String, Integer>) candidatesMap;
	}
	
	public Map.Entry<String, Integer> getWinner() {
		Optional<Map.Entry<String, Integer>> winnerExists = candidatesMap.entrySet().stream().max(Map.Entry.comparingByValue());
		if (winnerExists.isPresent())
			return winnerExists.get();
		else
			throw new IllegalArgumentException("No Candidate has got higher votes");
		
	}
}
