package com.exam.dao;

import com.exam.entity.Question;

public interface TestDAO extends SuperDAO<Question>{
	
	public abstract Question getAll(Question question) throws Exception;
}
