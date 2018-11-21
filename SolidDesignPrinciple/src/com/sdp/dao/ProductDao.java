package com.sdp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ProductDao {

	private Connection con = null;
	private Statement st = null;
	private ResultSet resultSet = null;

	public Connection getConnection() throws SQLException {
		con = ConnectionManager.getConnection();
		st = (Statement) con.createStatement();
		resultSet = st.executeQuery("select id from product");

		while (resultSet.next()) {
			System.out.println("result--------");
			String id = resultSet.getString("id");
			System.out.println("id :::: " + id);
		}
		return con;
	}

}
