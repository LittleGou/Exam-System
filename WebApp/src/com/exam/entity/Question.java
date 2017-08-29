package com.exam.entity;

import java.util.ArrayList;

public class Question {
	private String paper;
	private Integer number;
	private String content;
	private ArrayList<String> choice;
	private String answers;
	private Integer quantity;
	private String comments;
	
	public String getPaper() {return paper;}
	public void setPaper(String paper) {this.paper = paper;}
	public Integer getNumber() {return number;}
	public void setNumber(Integer number) {this.number = number;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public ArrayList<String> getChoice() {return choice;}
	public void setChoice(ArrayList<String> choice) {this.choice = choice;}
	public String getAnswers() {return answers;}
	public void setAnswers(String answers) {this.answers = answers;}
	public Integer getQuantity() {return quantity;}
	public void setQuantity(Integer quantity) {this.quantity = quantity;}
	public String getComments() {return comments;}
	public void setComments(String comments) {this.comments = comments;}

	
}
