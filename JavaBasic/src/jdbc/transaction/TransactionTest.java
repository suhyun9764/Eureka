package jdbc.transaction;

import jdbc.AppConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static jdbc.ConfigConstants.*;

// JDBC를 이용한 MySQL DB Transaction Test
public class TransactionTest {
    static AppConfig appConfig = new AppConfig();

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        String sql = "insert into customer values ( ?,? )";
        int ret = -1;
        boolean isSuccess = false;
        try {

            connection = appConfig.getDBConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);
            pstmt = connection.prepareStatement(sql);

            // insert 3건
            pstmt.setInt(1,1);
            pstmt.setString(2,"홍길동");
            ret = pstmt.executeUpdate();
            System.out.println(ret);
            pstmt.setInt(1,2);
            pstmt.setString(2,"이길동");
            ret = pstmt.executeUpdate();
            System.out.println(ret);
            pstmt.setInt(1,1);
            pstmt.setString(2,"심길동");
            ret = pstmt.executeUpdate();
            System.out.println(ret);
            connection.commit();

            isSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
            isSuccess = false;
            try {
                if(isSuccess)
                connection.rollback();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } finally {
            appConfig.releaseConnection(pstmt,connection);
        }
    }
}
