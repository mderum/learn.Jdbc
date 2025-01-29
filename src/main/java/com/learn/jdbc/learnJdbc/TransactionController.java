package com.learn.jdbc.learnJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransactionController {

	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/inititateTransaction")
	public void inititateTransaction(Project project) {
		  projectService.inititateTransaction(project);
		
	}
}
