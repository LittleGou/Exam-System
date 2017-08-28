package com.exam.utils;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/*
 * 使用单例模式设计这个数据库连接工具类
 * 1.构造方法私有
 * 2.公有的静态的返回单例对象的方法。
 * 
 * */
public class MyDBUtilsForDbcp {

	private static DataSource ds;
	static{
		Properties prop = new Properties();
		try{
			prop.load(MyDBUtilsForDbcp.class.getClassLoader().getResourceAsStream("dbcp.properties"));
			ds = BasicDataSourceFactory.createDataSource(prop); //获得数据源
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private MyDBUtilsForDbcp(){}
	
	public static Connection getConnection() throws Exception{
		return ds.getConnection();
	}
}
