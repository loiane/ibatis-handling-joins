package com.loiane.model;

import java.util.List;

/**
 * Post POJO
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class Post {

	private int id;
	private String title;
	private List<Tag> tags;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Tag> getTags() {
		return tags;
	}
	
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Post: id = ").append(id).append(" ");
		sb.append("title = ").append(title);
		if (tags != null){
			for (Tag t: tags){
				sb.append("\n   ").append(t.toString());
			}
		}
		return sb.toString();
	}
}
