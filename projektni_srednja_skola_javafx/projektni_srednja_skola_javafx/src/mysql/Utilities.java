package mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilities {

	
	public static String preparePattern(String text) {
		return text.replace('*', '%').replace('?', '_');
	}
	

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement s) {
		if (s != null) {
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection conn, Statement s) {
		close(s);
		close(conn);
	}

	public static void close(Connection conn, ResultSet rs) {
		close(rs);
		close(conn);
	}

	public static void close(Statement s1, Statement s2) {
		close(s1);
		close(s2);
	}
	
	public static void close(Statement s, ResultSet rs) {
		close(rs);
		close(s);
	}

	public static void close(Connection conn, Statement s, ResultSet rs) {
		close(rs);
		close(s);
		close(conn);
	}
}
