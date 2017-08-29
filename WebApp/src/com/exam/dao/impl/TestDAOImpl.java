package com.exam.dao.impl;

import java.util.ArrayList;

import com.exam.dao.TestDAO;
import com.exam.entity.Question;
import com.exam.utils.Code;
import com.exam.utils.MyDBUtilsForDbcp;

public class TestDAOImpl extends SuperDAOImpl implements TestDAO{

	@Override
	public Question getAll(Question question) throws Exception {
		String sql = "select * from ocjp where paper=? and number=?";
		try{
			conn = MyDBUtilsForDbcp.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, question.getPaper());
			pstmt.setInt(2, question.getNumber());
			rs = pstmt.executeQuery();
			if(rs.next()){
				question.setContent(rs.getString("content"));
				question.setChoice(breakChoices(rs.getString("choice")));
				question.setAnswers(rs.getString("answers"));
				question.setQuantity(rs.getInt("quantity"));
				question.setComments(rs.getString("comments"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			this.destroyStream();
		}
		return question;
	}

	private ArrayList<String> breakChoices(String temp){
		ArrayList<String> choices = new ArrayList<String>();
		for(int i = 1; i <= Code.CODE.length; i++){
			StringBuilder sb = new StringBuilder();
			String[] split = temp.split(Code.CODE[i]+"\\.");
			if(split.length > 1){
				choices.add(split[0]);
				sb.append(split[1]);
				sb.insert(0, Code.CODE[i] + ".");
				temp = sb.toString();
			}else{
				choices.add(temp);
				break;
			}
		}
		return choices;
	}
}
