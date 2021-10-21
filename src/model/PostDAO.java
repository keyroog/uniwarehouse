package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import utilities.DriverManagerConnectionPool;

public class PostDAO {
	
	public synchronized static byte[] load(String id) {

		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		byte[] bt = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			String sql = "SELECT photo FROM lectures WHERE id = " + id;
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();

			if (rs.next()) {
				bt = rs.getBytes("photo");
			}

		} catch (SQLException sqlException) {
			System.out.println(sqlException);
		} 
			finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException sqlException) {
				System.out.println(sqlException);
			} finally {
				if (connection != null)
					try {
						DriverManagerConnectionPool.releaseConnection(connection);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		return bt;
	}

}
