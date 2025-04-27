package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static jdbc.ConfigConstants.*;

public class AppConfig {

    public Connection getDBConnection(String url, String user, String password) {
        // 2. Connection 객체 선언
        Connection conn = null;
        try {
            // 3. MySQL JDBC 드라이버 로드 (생략 가능, 최신 버전에서는 자동 로딩됨)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 4. 데이터베이스 연결
            System.out.println("✅ MySQL 연결 성공");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close(); // 연결 종료
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void releaseConnection(PreparedStatement pstmt, Connection conn) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
