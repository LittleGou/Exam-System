package com.exam.dao.impl;

import java.util.ArrayList;

import com.exam.dao.TestDAO;
import com.exam.entity.Question;
import com.exam.utils.Code;
import com.exam.utils.MyDBUtilsForDbcp;

public class TestDAOImpl extends SuperDAOImpl implements TestDAO{

	@Override
	public String getQuestion(Question question) {
		String temp = "";
		String sql = "select * from ocjp where code=? and number=?";
		try{
			conn = MyDBUtilsForDbcp.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, question.getCode());
			pstmt.setInt(2, question.getNumber());
			rs = pstmt.executeQuery();
			if(rs.next()){
				temp = rs.getString("question");
			}
				
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			this.destroyStream();
		}
		return temp;
	}

	@Override
	public ArrayList<String> getChoice(Question question) throws Exception {
		ArrayList<String> choices = new ArrayList<String>();
		String temp = "";
		String sql = "select * from ocjp where code=? and number=?";
		try{
			conn = MyDBUtilsForDbcp.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, question.getCode());
			pstmt.setInt(2, question.getNumber());
			rs = pstmt.executeQuery();
			if(rs.next()){
				temp = rs.getString("choice");
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
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			this.destroyStream();
		}
		return choices;
	}

	@Override
	public Integer getQuantity(Question question) throws Exception {
		Integer temp = null;
		String sql = "select * from ocjp where code=? and number=?";
		try{
			conn = MyDBUtilsForDbcp.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, question.getCode());
			pstmt.setInt(2, question.getNumber());
			rs = pstmt.executeQuery();
			if(rs.next()){
				temp = rs.getInt("quantity");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			this.destroyStream();
		}
		return temp;
	}
	
	@Override
	public boolean getAnswer(Question question) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getComment(Question question) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
