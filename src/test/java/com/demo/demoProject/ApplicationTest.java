package com.demo.demoProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ApplicationTest {
	
    private static final String CANDIDATE_NAME = "Ajay";
    
    @Test
    public void testEnterCandidate() {
        ElectionSystem electionSystem = new ElectionSystem();

        // Enter a candidate
        electionSystem.enterCandidate(CANDIDATE_NAME);

        // Check if the candidate was added with a vote count of 0
        assertEquals(0, electionSystem.getVoteCount(CANDIDATE_NAME));
    }
    
    @Test
    public void testCastVoteForValidCandidate() {
        ElectionSystem electionSystem = new ElectionSystem();
        electionSystem.enterCandidate(CANDIDATE_NAME);

        // Cast a vote for a valid candidate
        int newVoteCount = electionSystem.castVote(CANDIDATE_NAME);

        // Check if the vote count was incremented
        assertEquals(1, newVoteCount);
    }

    @Test
    public void testCastVoteForInvalidCandidate() {
        ElectionSystem electionSystem = new ElectionSystem();
        electionSystem.enterCandidate(CANDIDATE_NAME);

        // Cast a vote for an invalid candidate
        int newVoteCount = electionSystem.castVote("Aneesh");

        // Check if the vote count remains unchanged (should return -1)
        assertEquals(-1, newVoteCount);
    }
}
