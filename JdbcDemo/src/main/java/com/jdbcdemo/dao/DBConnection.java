package com.jdbcdemo.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnection {
	public Connection getConnection() throws SQLException;
}
