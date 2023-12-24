package com.demo.demoProject;

import org.springframework.stereotype.Repository;

@Repository
public class DemoDao {

	private static String candidate;
	
	public String getCandidate() {
		return this.candidate = "Hello King Captaion";
	}
}
