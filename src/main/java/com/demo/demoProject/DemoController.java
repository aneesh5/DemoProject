package com.demo.demoProject;

import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class DemoController {
	
	@Autowired
	private DemoService demoService;
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(DemoController.class);

	@PostMapping(path = "/entercandidate")
	public ResponseEntity<?> addCandidate(HttpServletRequest request,
											@RequestParam(name = "name", required = true) String candidateName) {
		try {
			demoService.addCandidate(candidateName);
			return ResponseEntity.status(HttpStatus.CREATED).body("Candidate Added Successfully");
		}
		catch(IllegalArgumentException e ) {
			logger.error("Error occured while adding a candidate", e.getMessage());
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		catch(Exception e) {
			logger.error("Error occured while adding a candidate", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping(path = "/castVote")
	public ResponseEntity<?> castVote(HttpServletRequest request,
											@RequestParam(name = "name", required = true) String candidateName) {
		try {
			demoService.castVote(candidateName);
			return ResponseEntity.status(HttpStatus.CREATED).body("Vote Casted Successfully to " + candidateName);
		}
		catch(IllegalArgumentException e ) {
			logger.error("Error occured while adding a candidate", e.getMessage());
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		catch(Exception e) {
			logger.error("Error occured while adding a candidate", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping(path = "/countVote")
	public ResponseEntity<?> countVote(HttpServletRequest request,
											@RequestParam(name = "name", required = true) String candidateName) {
		try {
			Integer voteCount = demoService.countVote(candidateName);
			return ResponseEntity.status(HttpStatus.OK).body("Vote count for " + candidateName + " is : " + voteCount);
		}
		catch(IllegalArgumentException e ) {
			logger.error("Error occured while adding a candidate", e.getMessage());
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		catch(Exception e) {
			logger.error("Error occured while adding a candidate", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping(path = "/listVote")
	public ResponseEntity<?> listVote(HttpServletRequest request) {
		try {
			String voteListings = demoService.listVotings();
			return ResponseEntity.status(HttpStatus.OK).body(voteListings);
		}
		catch(IllegalArgumentException e ) {
			logger.error("Error occured while adding a candidate", e.getMessage());
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		catch(Exception e) {
			logger.error("Error occured while adding a candidate", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping(path = "/getWinner")
	public ResponseEntity<?> getWinner(HttpServletRequest request) {
		try {
			Map.Entry<String, Integer> winnerCandidate = demoService.getWinner();
			return ResponseEntity.status(HttpStatus.OK).body(winnerCandidate.getKey() + " is the winner with " + winnerCandidate.getValue() + " votes");
		}
		catch(IllegalArgumentException e ) {
			logger.error("Error occured while adding a candidate", e.getMessage());
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		catch(Exception e) {
			logger.error("Error occured while adding a candidate", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
