package com.learn.jdbc.learnJdbc;

public class Project {
	
	private String url;
	private String name;
	
	@Override
	public String toString() {
		return "Project [url=" + url + ", name=" + name + "]";
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
