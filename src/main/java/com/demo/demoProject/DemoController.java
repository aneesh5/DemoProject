package com.demo.demoProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class DemoController {
	
	@Autowired
	private DemoService demoService;

	@GetMapping(path = "/candidates")
	public ResponseEntity<?> getCandidates(HttpServletRequest request) {
		return ResponseEntity.ok().body(demoService.getCandidates());
	}
}
