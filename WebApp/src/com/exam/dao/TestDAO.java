package com.exam.dao;

import java.util.ArrayList;

import com.exam.entity.Question;

public interface TestDAO extends SuperDAO<Question>{
	
	public abstract String getQuestion(Question question) throws Exception;
	public abstract ArrayList<String> getChoice(Question question) throws Exception;
	public abstract boolean getAnswer(Question question) throws Exception;
	public abstract Integer getQuantity(Question question) throws Exception;
	public abstract boolean getComment(Question question) throws Exception;
}
