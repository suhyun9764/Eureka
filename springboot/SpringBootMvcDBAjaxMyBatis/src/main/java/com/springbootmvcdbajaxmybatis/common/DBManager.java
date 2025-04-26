package com.springbootmvcdbajaxmybatis.common;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// Connection Pool로 부터 Connection 객체 가져오기
// Connection 객체 반납

public class DBManager {
//    public static Connection getConnection() throws NamingException {
//        Connection con = null;
//        try {
//            Context context = new InitialContext();
//            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/madangdb");
//            con = ds.getConnection();
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//
//        return con;
//    }
    
    // Connection Pool 로부터 얻은 Connection 객체의 close() 메서드는 overridng되어있다.
    // Connection을 끊지 않고 Connection Pool에 반납되도록
    public static void releaseConnection(PreparedStatement pstmt, Connection con) {
        try {
            if( pstmt != null ) pstmt.close();
            if( con != null ) con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void releaseConnection(ResultSet rs, PreparedStatement pstmt, Connection con) {
        try {
            if( rs != null ) rs.close();
            if( pstmt != null ) pstmt.close();
            if( con != null ) con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}