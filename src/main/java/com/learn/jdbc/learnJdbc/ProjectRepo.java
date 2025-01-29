package com.learn.jdbc.learnJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Repository
public class ProjectRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int saveProject(Project project) {

		try {
			return jdbcTemplate.update("insert into project(name,url) values (?,?)", project.getName(),
					project.getUrl());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//will be rolled back
	@Transactional
	public void inititateTransaction(Project project) {

		jdbcTemplate.update("insert into project(name,url) values (?,?)", project.getName(), project.getUrl());

		if (true) {
			throw new RuntimeException("Simulated Exception");
		}
	}
	
	// try to rollout manually when try catch is present 
	@Transactional
	public void inititateTransactionV2(Project project) {

		try {
		jdbcTemplate.update("insert into project(name,url) values (?,?)", project.getName(), project.getUrl());
		

		if (true) {
			throw new RuntimeException("Simulated Exception");
		}
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			jdbcTemplate.update("update   project set name=? where id=?","BASED", 3);
		}
	}
	
	
	//wont be rolled back as try catch is used
	@Transactional
	public void inititateTransactionV3(Project project) {

		try {
		jdbcTemplate.update("insert into project(name,url) values (?,?)", project.getName(), project.getUrl());
		

		if (true) {
			throw new RuntimeException("Simulated Exception");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// rollback only for specific  exceptions and prevent rollback for specific txn
	@Transactional(rollbackFor = RuntimeException.class ,  noRollbackFor = AssertionError.class)
	public void inititateTransactionV4(Project project) {

		jdbcTemplate.update("insert into project(name,url) values (?,?)", project.getName(), project.getUrl());
		

		if (true) {
			throw new AssertionError("Simulated Exception");
		}
	}
}
