package com.loiane.model;

/**
 * Tag POJO
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class Tag {

	private int id;
	private String value;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Tag: id = ").append(id).append(" ");
		sb.append("value = ").append(value);
		return sb.toString();
	}
}
