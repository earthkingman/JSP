package pack_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import pack_DBCP.DBConnectionMgr;

public class Go_Out {

	// DBCP 연동 기초 작업 1
	private DBConnectionMgr pool;
	
	// DBCP 연동 기초작업2
	public Go_Out() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void DBConnection() {
		try {
			Connection conn = pool.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 출퇴근 값 확인하는 Select하는 메서드
	public String GO_Select(String ymd) {
		
		String result = "";
		
		try {
			Connection conn = pool.getConnection(); // DB 연결
			
			String sql = "SELECT GOWORK FROM T_ATTEND WHERE YMDXXX=?"; // 쿼리문 작성
			
			PreparedStatement pstmt = conn.prepareStatement(sql); // 매개변수가 필요할 때
			
			// Statement stmt = conn.prepareStatement(sql); 매개변수 없을 때
			
			pstmt.setString(1, ymd); // 매개변수에 값을 지정
			
			
			// select 값이 있는지 없는지 확인을 해야하기 때문에 ResultSet을 사용
			
			ResultSet rs = null; // 값을 받아오기 위한 ResultSet 객채생성
			
			rs = pstmt.executeQuery(); // 쿼리문 실행해서 값이 rs에 저장
			
			while(rs.next()) { // 반복문, rs.next() false 나올때까지 계속
				
				result = rs.getString("GOWORK");
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	// insert하는 메서드
	
	
	public void Insert_Work(String ymd,String nowtime) {
		
		try {
			Connection conn = pool.getConnection(); // DB 연결
			
			// 출근일때는 INSERT
			String sql = "INSERT INTO T_ATTEND(YMDXXX, GOWORK) VALUES(?, ?)"; // 쿼리문 작성
			
			PreparedStatement pstmt = conn.prepareStatement(sql); // 매개변수가 필요할 때
			
			pstmt.setString(1, ymd); // 매개변수에 값을 지정
			
			pstmt.setString(2, nowtime); // 매개변수에 값을 지정
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void Update_Work(String ymd,String nowtime) {
		
		try {
			Connection conn = pool.getConnection(); // DB 연결
			
			// 퇴근일때는 UPDATE
			
			String sql = "UPDATE T_ATTEND SET OFFWOR = ? WHERE YMDXXX = ?"; // 쿼리문 작성
				
		    PreparedStatement pstmt = conn.prepareStatement(sql); // 매개변수가 필요할 때
		
			pstmt.setString(1, nowtime); // 매개변수에 값을 지정
			
			pstmt.setString(2, ymd); // 매개변수에 값을 지정

			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
