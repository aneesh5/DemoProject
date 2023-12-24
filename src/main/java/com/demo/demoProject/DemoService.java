package com.demo.demoProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService implements IDemoService {
	
	@Autowired
	private DemoDao demoDao;

	@Override
	public String getCandidates() {
		return demoDao.getCandidate();
	}
}
