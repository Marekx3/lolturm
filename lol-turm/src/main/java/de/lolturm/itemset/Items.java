package de.lolturm.itemset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.mingweisamuel.zyra.lolStaticData.Item;

import de.lolturm.connection.ConnectPostgre;

public class Items {
	
	public static ItemBean get(Integer item) throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		ItemBean itemBean = new ItemBean();
		
		String sql = "SELECT id, name, trinketslot, fiveonfivemap FROM website.items WHERE id = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, item);
		
		ResultSet result = preparedStatement.executeQuery();
		
		Integer id = null;
		String name = null;
		boolean trinketSlot = false;
		boolean fiveOnFiveMap = false;
		
		while (result.next()) {
			id = result.getInt("id");
			name = result.getString("name");
			trinketSlot = result.getBoolean("trinketslot");
			fiveOnFiveMap = result.getBoolean("fiveonfivemap");
			itemBean.setId(id);
			itemBean.setName(name);
			itemBean.setTrinketSlot(trinketSlot);
			itemBean.setFiveOnFiveMap(fiveOnFiveMap);
		}
		
		return itemBean;
	}

	public static ArrayList<ItemBean> getAllItems() throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		ArrayList<ItemBean> items = new ArrayList<ItemBean>();
		
		String sql = "SELECT id, name, trinketslot, fiveonfivemap FROM website.items";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet result = preparedStatement.executeQuery();
		
		Integer id = null;
		String name = null;
		boolean trinketSlot = false;
		boolean fiveOnFiveMap = false;
		
		while (result.next()) {
			
			ItemBean itemBean = new ItemBean();
			
			id = result.getInt("id");
			name = result.getString("name");
			trinketSlot = result.getBoolean("trinketslot");
			fiveOnFiveMap = result.getBoolean("fiveonfivemap");
			itemBean.setId(id);
			itemBean.setName(name);
			itemBean.setTrinketSlot(trinketSlot);
			itemBean.setFiveOnFiveMap(fiveOnFiveMap);
			
			items.add(itemBean);
		}
		
		return items;
	}
	
	public static ArrayList<ItemBean> getAllFiveOnFiveItems() throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		ArrayList<ItemBean> items = new ArrayList<ItemBean>();
		
		String sql = "SELECT id, name, trinketslot, fiveonfivemap FROM website.items WHERE trinketslot = false AND fiveonfivemap = true";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet result = preparedStatement.executeQuery();
		
		Integer id = null;
		String name = null;
		boolean trinketSlot = false;
		boolean fiveOnFiveMap = false;
		
		while (result.next()) {
			
			ItemBean itemBean = new ItemBean();
			
			id = result.getInt("id");
			name = result.getString("name");
			trinketSlot = result.getBoolean("trinketslot");
			fiveOnFiveMap = result.getBoolean("fiveonfivemap");
			itemBean.setId(id);
			itemBean.setName(name);
			itemBean.setTrinketSlot(trinketSlot);
			itemBean.setFiveOnFiveMap(fiveOnFiveMap);
			
			items.add(itemBean);
		}
		
		return items;
	}
	
	public static ArrayList<ItemBean> getAllTrinketItems() throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		ArrayList<ItemBean> items = new ArrayList<ItemBean>();
		
		String sql = "SELECT id, name, trinketslot, fiveonfivemap FROM website.items WHERE trinketslot = true AND fiveonfivemap = true";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet result = preparedStatement.executeQuery();
		
		Integer id = null;
		String name = null;
		boolean trinketSlot = false;
		boolean fiveOnFiveMap = false;
		
		while (result.next()) {
			
			ItemBean itemBean = new ItemBean();
			
			id = result.getInt("id");
			name = result.getString("name");
			trinketSlot = result.getBoolean("trinketslot");
			fiveOnFiveMap = result.getBoolean("fiveonfivemap");
			itemBean.setId(id);
			itemBean.setName(name);
			itemBean.setTrinketSlot(trinketSlot);
			itemBean.setFiveOnFiveMap(fiveOnFiveMap);
			
			items.add(itemBean);
		}
		
		return items;
	}
	
	public static void allItems(Map<Integer, Item> all) throws ClassNotFoundException, SQLException {
		for (Item item : all.values()) {
			Integer id = item.id;
			String name = item.name;
			try {
				Items.setItems(id, name);
			} catch (Exception e) {
				Items.updateItems(id, name);
			}

		}
	}

	private static void updateItems(Integer id, String name) throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();

		String sql = "UPDATE website.champions SET id = ?, name = ? WHERE id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setInt(3, id);

		preparedStatement.executeUpdate();

		connection.close();		
	}

	private static void setItems(Integer id, String name) throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();

		String sql = "INSERT INTO website.items (id, name) VALUES (?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);

		preparedStatement.executeUpdate();

		connection.close();
	}
}
