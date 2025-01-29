package com.learn.jdbc.learnJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepo projectRepo;
	
	
	public int saveProject(Project  project) {
		return projectRepo.saveProject(project);
	}
	
 


	public void inititateTransaction(Project project) {
		  projectRepo.inititateTransactionV4(project);
	}
}
