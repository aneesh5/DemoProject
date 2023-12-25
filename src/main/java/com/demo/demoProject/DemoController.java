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
			return ResponseEntity.status(HttpStatus.CREATED).body(DemoError.CANDIDATE_ADDED.getError());
		}
		catch(IllegalArgumentException e ) {
			logger.error(DemoError.ERROR_ADDING_CANDIDATE.getError(), e.getMessage());
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		catch(Exception e) {
			logger.error(DemoError.ERROR_ADDING_CANDIDATE.getError(), e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping(path = "/castVote")
	public ResponseEntity<?> castVote(HttpServletRequest request,
									@RequestParam(name = "name", required = true) String candidateName) {
		try {
			demoService.castVote(candidateName);
			return ResponseEntity.status(HttpStatus.CREATED).body(String.format(DemoError.VOTE_CASTED.getError(), candidateName));
		}
		catch(IllegalArgumentException e ) {
			logger.error(DemoError.ERROR_CASTING_VOTE.getError(), e.getMessage());
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		catch(Exception e) {
			logger.error(DemoError.ERROR_CASTING_VOTE.getError(), e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping(path = "/countVote")
	public ResponseEntity<?> countVote(HttpServletRequest request,
											@RequestParam(name = "name", required = true) String candidateName) {
		try {
			Integer voteCount = demoService.countVote(candidateName);
			return ResponseEntity.status(HttpStatus.OK).body(String.format(DemoError.VOTE_COUNT.getError(), candidateName, voteCount));
		}
		catch(IllegalArgumentException e ) {
			logger.error(DemoError.ERROR_COUNTING_VOTE.getError(), e.getMessage());
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		catch(Exception e) {
			logger.error(DemoError.ERROR_CASTING_VOTE.getError(), e.getMessage());
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
			logger.error(DemoError.ERROR_LISTING_VOTE.getError(), e.getMessage());
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		catch(Exception e) {
			logger.error(DemoError.ERROR_LISTING_VOTE.getError(), e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping(path = "/getWinner")
	public ResponseEntity<?> getWinner(HttpServletRequest request) {
		try {
			Map.Entry<String, Integer> winnerCandidate = demoService.getWinner();
			return ResponseEntity.status(HttpStatus.OK).body(String.format(DemoError.WINNER.getError(), winnerCandidate.getKey(), winnerCandidate.getValue()));
		}
		catch(IllegalArgumentException e ) {
			logger.error(DemoError.ERROR_GETTING_WINNER.getError(), e.getMessage());
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		catch(Exception e) {
			logger.error(DemoError.ERROR_GETTING_WINNER.getError(), e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
