package test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import sun.security.jca.JCAUtil;

public class Dbcon {
//	 public final static Connection getconnectin() {
//	 Connection con = null;
//	 String driver = "com.mysql.jdbc.Driver";
//	 String url = "jdbc:mysql://localhost:3306/xsxx";
//	 String user = "root";
//	 String password = "root";
//	 try {
//	 Class.forName(driver);
//	 con = DriverManager.getConnection(url, user, password);
//	 con.setCatalog("xsxx");
//	
//	 } catch (SQLException sqle) {
//	 sqle.printStackTrace();
//	 } catch (Exception e) {
//	 e.printStackTrace();
//	
//	 }
//	 return con;
//	
//	 }
	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static String driver = null;

	static {
		try {
			Properties props = new Properties();
			InputStream in = JCAUtil.class.getResourceAsStream("/jdbc.properties");
			props.load(in);
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			driver = props.getProperty("driver");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱动程序注册失败！！！");
		}
	}

	public static Connection getconnectin() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
	}

	// 添加数据
	public final static void insert(Connection con, Object obj[]) {
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("insert into student(sno,sname,ssex,sage,sclass,smajor) values(?,?,?,?,?,?)");

			stmt.setString(1, obj[0].toString());
			stmt.setString(2, obj[1].toString());
			stmt.setString(3, obj[2].toString());
			stmt.setString(4, obj[3].toString());
			stmt.setString(5, obj[4].toString());
			stmt.setString(6, obj[5].toString());
			stmt.execute();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "成功", "操作提示", JOptionPane.NO_OPTION);
		}
	}

	// 查询数据
	public final static ResultSet query(Connection con) {

		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("select * from student");
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	// 删除数据
	public final static void delete(Connection con, String s) {
		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("delete from student where sno=?");
			stmt.setObject(1, s);
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}

}