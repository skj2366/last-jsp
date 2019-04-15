package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Connection;

import org.junit.Test;

import com.common.DBConnector;

public class DBConnectionTest {

//	@Test(expected=ClassNotFoundException.class) //expected : 기대하다. ClassNotFoundException에 대한 오류가 검출되면 true를 반환.
//	public void driverTest() throws ClassNotFoundException {
//		DBConnector.setDriver();
//	}
	@Test
	public void driverTest() {
		DBConnector.setDriver();
	}
	
	@Test
	public void openTest() {
		DBConnector.open();
	}
	
	@Test
	public void getConTest() {
		Connection con = DBConnector.getCon();
//		assertEquals(null, con); //null 이랑 con 이랑 같을거니까 실행 한번 해봐 새끼야 ^^; 맞으면 true, 아니면 false
		assertNotEquals(null, con);// null 이랑 con이랑 다를테니까 실행 한번 해봐 이시키야 ~ 맞으면 true, 아니면 false
	}

}
