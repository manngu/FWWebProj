package com.fw.shopping;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DBConnection {
	private static final String DRIVER
	= "com.mysql.cj.jdbc.Driver";
	private static final String URL 
	= "jdbc:mysql://localhost:3306/spring?serverTimezone=Asia/Seoul";
	private static final String UID = "root";
	private static final String UPW = "mysql";

	//커넥션 테스트
	@Test
	public void connectTest() {

		Connection conn = null;

		try {
			Class.forName(DRIVER);

			conn = DriverManager.getConnection(URL, UID, UPW);
			System.out.println("DB 커넥션 성공!");
			System.out.println("conn: " + conn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
