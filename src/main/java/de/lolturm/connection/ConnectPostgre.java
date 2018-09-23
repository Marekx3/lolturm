package de.lolturm.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectPostgre {

	private Connection connection;
	private String driver;
	private String url;
	private String username;
	private String password;

	public ConnectPostgre() throws SQLException, ClassNotFoundException {
		setParms();
		setConnection(this.url, this.username, this.password);
	}

	public void setParms() {
		this.url = "jdbc:postgresql:lolturm";
		this.driver = "org.postgresql.Driver";
		this.username = "postgres";
		this.password = "Callme17";
	}

	public void setConnection(String url, String username, String password) throws SQLException, ClassNotFoundException {
		Class.forName(this.driver);
		this.connection = DriverManager.getConnection(url, username, password);
	}

	public Connection getConnection() {
		return connection;
	}
}
