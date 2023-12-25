package com.demo.demoProject;

import java.util.Map;

public interface IDemoService {

	/**
	 * 
	 * @apiNote To add candidate
	 * @param name candidate name
	 */
	void addCandidate(String name);
	
	/**
	 * 
	 * @apiNote To cast voting based on candidate name
	 * @param name candidate name
	 */
	void castVote(String name);
	
	/**
	 * 
	 * @param name
	 * @return Vote count based on requested candidate name
	 */
	Integer countVote(String name);
	
	/**
	 * 
	 * @return list of voting details in JSON format
	 */
	String listVotings();
	
	/**
	 * 
	 * @return winner details
	 */
	Map.Entry<String, Integer> getWinner();
}
