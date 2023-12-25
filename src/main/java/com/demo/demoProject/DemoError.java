package com.demo.demoProject;


public enum DemoError {

	ERROR_ADDING_CANDIDATE("Error occured while adding a candidate"),
	
	ERROR_CASTING_VOTE("Error occured while casting vote"),
	
	ERROR_COUNTING_VOTE("Error occured while counting vote"),
	
	ERROR_LISTING_VOTE("Error occured while listing votes"),
	
	ERROR_GETTING_WINNER("Error occured while getting winner"),
	
	WINNER("%s is the winner with %s votes"),
	
	VOTE_COUNT("Vote count for %s candidate is %s"),
	
	VOTE_CASTED("Vote Casted Successfully to %s"),
	
	CANDIDATE_ADDED("Candidate added successfully")
	;
	
	

	

	private final String error;
	
	DemoError(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}
}
