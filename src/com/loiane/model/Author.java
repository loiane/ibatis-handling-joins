package com.loiane.model;

/**
 * Author POJO
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class Author {

	private int id;
	private String name;
	private String email;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("id = ").append(id).append(" ");
		sb.append("name = ").append(name).append(" ");
		sb.append("email = ").append(email);
		return sb.toString();
	}
}
