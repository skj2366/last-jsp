package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "osfu";
	private static final String PWD = "12345678";
	private static final String CLASS_NAME = "oracle.jdbc.driver.OracleDriver";
	private static Connection con = null;

	public static void setDriver() {
		try {
			Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// Junit을 사용해서 db CLASS 하나만을 테스트해서 접속이 잘 되는지 확인하기 위해서 메서드 생성.

//	public static void setDriver2() throws Exception{
//		Class.forName(CLASS_NAME);
//		if(CLASS_NAME.indexOf("oracle")==-1) {
//			throw new Exception("해당 서버는 오라클드라이버만 지원합니다.");
//		}
//	}

	public static void open() {
		setDriver();
		try {
			con = DriverManager.getConnection(URL,USER,PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}	
	

	public static Connection getCon() {
		open();
		return con;
	}
	
	public static void close() throws SQLException {
		if(con!=null) {
			if(!con.isClosed()) {
				close();
			}
		}
	}

}
