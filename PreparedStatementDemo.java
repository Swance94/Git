package 作业.数据导入与导出;
import java.sql.*;
import java.io.*;
public class PreparedStatementDemo {
	Connection conn;
	ResultSet rs=null;
	PreparedStatement pstmt=null;
	public Connection Connection() {
		String url = "jdbc:mysql://localhost:3306/library?user=root&password=20210327wh@&useSSL=true&"
				+ "characterEncoding=utf-8";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			System.out.println("连接成功！");
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public PreparedStatementDemo() {
		Connection();
	}
	public ResultSet executeQuery(String preparedSql,String[] param){
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if(param!=null) {
				for(int i=0;i<param.length;i++) {
					pstmt.setString(i+1, param[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int executeUpdate(String preparedSql,String[] param) {
		int num = 0;
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if(param!=null) {
				for(int i=0;i<param.length;i++) {
					pstmt.setString(i+1, param[i]);
				}
			}
			num = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

}
