package com.exam.dao.impl;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SuperDAOImpl {
	
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	protected BufferedReader bReader;
	
	//Destroy Resource
	protected void destroyStream(){
		try{
			if(bReader != null){ bReader.close(); bReader = null;}
			if(rs != null){ rs.close(); rs = null;}
			if(pstmt != null){pstmt.close(); pstmt = null;}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
