package com.demo.demoProject;

import java.util.Map;

public interface IDemoService {

	void addCandidate(String name);
	
	void castVote(String name);
	
	Integer countVote(String name);
	
	String listVotings();
	
	Map.Entry<String, Integer> getWinner();
}
