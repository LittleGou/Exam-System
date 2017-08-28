package com.exam.entity;

public class Question {
	private String code;
	private Integer number;
	private String question;
	private String choice;
	private String answer;
	private Integer quantity;
	private String comment;
	
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}
	public Integer getNumber() {return number;}
	public void setNumber(Integer number) {this.number = number;}
	public String getQuestion() {return question;}
	public void setQuestion(String question) {this.question = question;}
	public String getChoice() {return choice;}
	public void setChoice(String choice) {this.choice = choice;}
	public String getAnswer() {return answer;}
	public void setAnswer(String answer) {this.answer = answer;}
	public Integer getQuantity() {return quantity;}
	public void setQuantity(Integer quantity) {this.quantity = quantity;}
	public String getComment() {return comment;}
	public void setComment(String comment) {this.comment = comment;}
	
}
