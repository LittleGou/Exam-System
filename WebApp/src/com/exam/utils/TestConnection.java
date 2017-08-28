package com.exam.utils;

import java.sql.Connection;

public class TestConnection {

	public static void main(String[] args) {
		Connection conn = null;
		try{
			conn = MyDBUtilsForDbcp.getConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(conn != null){
				try {
					conn.close();
					conn = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
