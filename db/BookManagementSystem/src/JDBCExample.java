import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample {
    public static void main(String[] args) {
        // 1. DB 접속 정보 설정
        String url = "jdbc:mysql://localhost:3306/mydb"; // DB URL
        String user = "root";  // MySQL 사용자명
        String password = ""; // MySQL 비밀번호

        // 2. Connection 객체 선언
        Connection conn = null;

        try {
            // 3. MySQL JDBC 드라이버 로드 (생략 가능, 최신 버전에서는 자동 로딩됨)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 4. 데이터베이스 연결
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ MySQL 연결 성공!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close(); // 연결 종료
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
