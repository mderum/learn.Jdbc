package com.learn.jdbc.learnJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public int saveProject(Project project) {
		
		try {
			return jdbcTemplate.update("insert into project(name,url) values (?,?)",project.getName(),project.getUrl());
		}catch (Exception e) {
			e.printStackTrace();
			return 0 ;
		}
		
	}
}
