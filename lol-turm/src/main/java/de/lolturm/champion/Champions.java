package de.lolturm.champion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import com.mingweisamuel.zyra.lolStaticData.Champion;

import de.lolturm.connection.ConnectPostgre;

public class Champions {

	public static void allChampions(Map<String, Champion> all) throws ClassNotFoundException, SQLException {
		for (Champion champion : all.values()) {
			Integer id = champion.id;
			String name = champion.name;
			String key = champion.key;
			String title = champion.title;
			try {
				Champions.setChampions(id, key, name, title);
			} catch (Exception e) {
				Champions.updateChampions(id, key, name, title);
			}

		}
	}

	private static void updateChampions(Integer id, String key, String name, String title)
			throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();

		String sql = "UPDATE website.champions SET id = ?, name = ?, key = ?, title = ? WHERE id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, key);
		preparedStatement.setString(4, title);
		preparedStatement.setInt(5, id);

		preparedStatement.executeUpdate();

		connection.close();
	}

	private static void setChampions(Integer id, String key, String name, String title)
			throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();

		String sql = "INSERT INTO website.champions (id, key, name, title) VALUES (?,?,?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, key);
		preparedStatement.setString(3, name);
		preparedStatement.setString(4, title);

		preparedStatement.executeUpdate();

		connection.close();
	}

	public static ArrayList<ChampionBean> allChampions() throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();

		String sql = "SELECT id, key, name, title FROM website.champions ORDER BY key ASC";
		ArrayList<ChampionBean> list = new ArrayList<ChampionBean>();

		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);

		Integer id = null;
		String key = null;
		String name = null;
		String title = null;

		while (result.next()) {
			id = result.getInt("id");
			key = result.getString("key");
			name = result.getString("name");
			title = result.getString("title");
			ChampionBean champion = new ChampionBean();
			champion.setId(id);
			champion.setKey(key);
			champion.setName(name);
			champion.setTitle(title);
			list.add(champion);
		}

		connection.close();

		return list;
	}

	public static ArrayList<ChampionBean> allChampions(String position) throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();

		String sql = "SELECT id, key, name, title FROM website.champions WHERE position LIKE ? ORDER BY key ASC";
		ArrayList<ChampionBean> list = new ArrayList<ChampionBean>();

		PreparedStatement statement = connection.prepareStatement(sql);
		String preparedString = "%" + position + "%";
		statement.setString(1, preparedString);
		ResultSet result = statement.executeQuery();

		Integer id = null;
		String key = null;
		String name = null;
		String title = null;

		while (result.next()) {
			id = result.getInt("id");
			key = result.getString("key");
			name = result.getString("name");
			title = result.getString("title");
			ChampionBean champion = new ChampionBean();
			champion.setId(id);
			champion.setKey(key);
			champion.setName(name);
			champion.setTitle(title);
			list.add(champion);
		}

		connection.close();

		return list;
	}

	public static ChampionBean get(Integer championResult) throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		String sql = "SELECT id, key, name, title FROM website.champions WHERE id = ?";
		ChampionBean championBean = new ChampionBean();
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, championResult);
		ResultSet result = preparedStatement.executeQuery();
		
		Integer id = null;
		String key = null;
		String name = null;
		String title = null;
		
		while (result.next()) {
			id = result.getInt("id");
			key = result.getString("key");
			name = result.getString("name");
			title = result.getString("title");
			championBean.setId(id);
			championBean.setKey(key);
			championBean.setName(name);
			championBean.setTitle(title);
		}
		return championBean;
	}
}
