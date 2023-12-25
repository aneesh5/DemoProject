package com.demo.demoProject;

import java.util.HashMap;
import java.util.Map;

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
		demoDao.addCandidate(name);
	}
	
	@Override
	public void castVote(String name) {
		demoDao.castVote(name);
	}
	
	@Override
	public Integer countVote(String name) {
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
