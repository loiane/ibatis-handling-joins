package com.loiane.model;

import java.util.List;

/**
 * Blog POJO
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class Blog {

	private int id;
	private String name;
	private String url;
	private Author author;
	private List<Post> posts;
	
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
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public List<Post> getPosts() {
		return posts;
	}
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Blog: id = ").append(id).append(" ");
		sb.append("name = ").append(name).append(" ");
		sb.append("url = ").append(url).append("\n");
		sb.append("Author: ").append(author.toString()).append("\n");
		for (Post p: posts){
			sb.append(p.toString()).append("\n");
		}
		return sb.toString();
	}
}
