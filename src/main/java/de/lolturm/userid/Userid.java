package de.lolturm.userid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.lolturm.connection.ConnectPostgre;

public class Userid {

	public static UseridBean get(Integer user) throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();

		String sql = "SELECT id, password, username, email, summonername FROM website.userid WHERE id = ?";
		UseridBean useridBean = new UseridBean();

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, user);
		ResultSet result = preparedStatement.executeQuery();

		Integer id = null;
		String password = null;
		String username = null;
		String email = null;
		String summonername = null;

		while (result.next()) {
			id = result.getInt("id");
			password = result.getString("password");
			username = result.getString("username");
			email = result.getString("email");
			summonername = result.getString("summonername");
			useridBean.setId(id);
			useridBean.setPassword(password);
			useridBean.setUsername(username);
			useridBean.setEmail(email);
			useridBean.setSummonername(summonername);
		}
		return useridBean;
	}

	public static void insert(UseridBean useridBean) throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();

		String sql = "INSERT INTO website.userid (username, password, email) VALUES (?,?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, useridBean.getUsername());
		preparedStatement.setString(2, useridBean.getPassword());
		preparedStatement.setString(3, useridBean.getEmail());
		preparedStatement.executeUpdate();
		
		connection.close();
	}

	public static boolean passwordConfirm(String password, String passwordConfirm) {
		return password.equals(passwordConfirm);
	}

	public static boolean checkUsername(String userid) throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		String sql = "SELECT username FROM website.userid WHERE username = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, userid);
		ResultSet result = preparedStatement.executeQuery();
		
		connection.close();
		
		return result.next();
	}

	public static boolean checkEmail(String email) throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		String sql = "SELECT email FROM website.userid WHERE email = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet result = preparedStatement.executeQuery();
		
		connection.close();
		
		return result.next();		
	}

	public static boolean checkPassword(String userid, String password) throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		String sql = "SELECT username, password FROM website.userid WHERE username = ? AND password = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, userid);
		preparedStatement.setString(2, password);
		ResultSet result = preparedStatement.executeQuery();
		
		connection.close();
		
		return result.next();
	}

	public static Integer getId(String userid) throws SQLException, ClassNotFoundException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		String sql = "SELECT id FROM website.userid WHERE username = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, userid);
		ResultSet result = preparedStatement.executeQuery();
		
		connection.close();
		result.next();
		return result.getInt("id");
	}
}
