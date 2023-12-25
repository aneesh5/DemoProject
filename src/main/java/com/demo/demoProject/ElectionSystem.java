package com.demo.demoProject;

import java.util.HashMap;
import java.util.Map;

public class ElectionSystem {
	private Map<String, Integer> candidateVotes = new HashMap<>();

    public void enterCandidate(String candidateName) {
        candidateVotes.put(candidateName, 0);
    }

    public int getVoteCount(String candidateName) {
        return candidateVotes.getOrDefault(candidateName, 0);
    }
    
    public int castVote(String candidateName) {
        if (candidateVotes.containsKey(candidateName)) {
            int currentVotes = candidateVotes.get(candidateName);
            candidateVotes.put(candidateName, currentVotes + 1);
            return currentVotes + 1;
        } else {
            return -1; // Indicate that the candidate is not valid
        }
    }

}
