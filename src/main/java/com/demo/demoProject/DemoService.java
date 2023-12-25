package com.demo.demoProject;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DemoService implements IDemoService {
	
	@Autowired
	private DemoDao demoDao;

	@Override
	public void addCandidate(String name) {
		if(StringUtils.isBlank(name)) 
			throw new IllegalArgumentException(DemoError.CANDIDATE_CANNOT_BE_EMPTY.getError());
		
		demoDao.addCandidate(name);
	}
	
	@Override
	public void castVote(String name) {
		if(StringUtils.isBlank(name)) 
			throw new IllegalArgumentException(DemoError.CANDIDATE_CANNOT_BE_EMPTY.getError());
		
		demoDao.castVote(name);
	}
	
	@Override
	public Integer countVote(String name) {
		if(StringUtils.isBlank(name)) 
			throw new IllegalArgumentException(DemoError.CANDIDATE_CANNOT_BE_EMPTY.getError());
		
		return demoDao.countVote(name);
	}
	
	@Override
	public String listVotings() {
		HashMap<String, Integer> mapData = demoDao.listVotings();
		ObjectMapper objectMapper = new ObjectMapper();
	    try {
			String jacksonData = objectMapper.writeValueAsString(mapData);
			return jacksonData;
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	@Override
	public Map.Entry<String, Integer> getWinner() {
		return demoDao.getWinner();
	}
}
