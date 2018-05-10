package com.chenzhicheng.course.javaee.exp6.model;
import java.io.Serializable;

public class LyTable implements Serializable {
	private String username;
	private String date;
	private String title;
	private String content;

	public LyTable(){

    }

	public LyTable(String username, String date, String title, String content) {
		this.username = username;
		this.date = date;
		this.title = title;
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
