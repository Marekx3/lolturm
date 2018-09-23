package de.lolturm.champion;

import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import de.lolturm.connection.ConnectPostgre;

import java.sql.*;
import java.util.ArrayList;

public class LTChampions {

	public static void allChampions(Champions all) throws ClassNotFoundException, SQLException {
		for (Champion champion : all) {
			Integer id = champion.getId();
			String name = champion.getName();
			String key = champion.getKey();
			String title = champion.getTitle();
			try {
				LTChampions.setChampions(id, key, name, title);
			} catch (Exception e) {
				LTChampions.updateChampions(id, key, name, title);
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

	public static ArrayList<LTChampionBean> allChampions() throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();

		String sql = "SELECT id, key, name, title FROM website.champions ORDER BY key ASC";
		ArrayList<LTChampionBean> list = new ArrayList<LTChampionBean>();

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
			LTChampionBean champion = new LTChampionBean();
			champion.setId(id);
			champion.setKey(key);
			champion.setName(name);
			champion.setTitle(title);
			list.add(champion);
		}

		connection.close();

		return list;
	}

	public static ArrayList<LTChampionBean> allChampions(String position) throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();

		String sql = "SELECT id, key, name, title FROM website.champions WHERE position LIKE ? ORDER BY key ASC";
		ArrayList<LTChampionBean> list = new ArrayList<LTChampionBean>();

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
			LTChampionBean champion = new LTChampionBean();
			champion.setId(id);
			champion.setKey(key);
			champion.setName(name);
			champion.setTitle(title);
			list.add(champion);
		}

		connection.close();

		return list;
	}

	public static LTChampionBean get(Integer championResult) throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		String sql = "SELECT id, key, name, title FROM website.champions WHERE id = ?";
		LTChampionBean LTChampionBean = new LTChampionBean();
		
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
			LTChampionBean.setId(id);
			LTChampionBean.setKey(key);
			LTChampionBean.setName(name);
			LTChampionBean.setTitle(title);
		}
		return LTChampionBean;
	}
}
