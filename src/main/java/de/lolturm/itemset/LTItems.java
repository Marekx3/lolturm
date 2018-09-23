package de.lolturm.itemset;

import com.merakianalytics.orianna.types.core.staticdata.Item;
import com.merakianalytics.orianna.types.core.staticdata.Items;
import de.lolturm.connection.ConnectPostgre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LTItems {
	
	public static LTItemBean get(Integer item) throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		LTItemBean LTItemBean = new LTItemBean();
		
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
			LTItemBean.setId(id);
			LTItemBean.setName(name);
			LTItemBean.setTrinketSlot(trinketSlot);
			LTItemBean.setFiveOnFiveMap(fiveOnFiveMap);
		}
		
		return LTItemBean;
	}

	public static ArrayList<LTItemBean> getAllItems() throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		ArrayList<LTItemBean> items = new ArrayList<LTItemBean>();
		
		String sql = "SELECT id, name, trinketslot, fiveonfivemap FROM website.items";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet result = preparedStatement.executeQuery();
		
		Integer id = null;
		String name = null;
		boolean trinketSlot = false;
		boolean fiveOnFiveMap = false;
		
		while (result.next()) {
			
			LTItemBean LTItemBean = new LTItemBean();
			
			id = result.getInt("id");
			name = result.getString("name");
			trinketSlot = result.getBoolean("trinketslot");
			fiveOnFiveMap = result.getBoolean("fiveonfivemap");
			LTItemBean.setId(id);
			LTItemBean.setName(name);
			LTItemBean.setTrinketSlot(trinketSlot);
			LTItemBean.setFiveOnFiveMap(fiveOnFiveMap);
			
			items.add(LTItemBean);
		}
		
		return items;
	}
	
	public static ArrayList<LTItemBean> getAllFiveOnFiveItems() throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		ArrayList<LTItemBean> items = new ArrayList<LTItemBean>();
		
		String sql = "SELECT id, name, trinketslot, fiveonfivemap FROM website.items WHERE trinketslot = false AND fiveonfivemap = true";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet result = preparedStatement.executeQuery();
		
		Integer id = null;
		String name = null;
		boolean trinketSlot = false;
		boolean fiveOnFiveMap = false;
		
		while (result.next()) {
			
			LTItemBean LTItemBean = new LTItemBean();
			
			id = result.getInt("id");
			name = result.getString("name");
			trinketSlot = result.getBoolean("trinketslot");
			fiveOnFiveMap = result.getBoolean("fiveonfivemap");
			LTItemBean.setId(id);
			LTItemBean.setName(name);
			LTItemBean.setTrinketSlot(trinketSlot);
			LTItemBean.setFiveOnFiveMap(fiveOnFiveMap);
			
			items.add(LTItemBean);
		}
		
		return items;
	}
	
	public static ArrayList<LTItemBean> getAllTrinketItems() throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		ArrayList<LTItemBean> items = new ArrayList<LTItemBean>();
		
		String sql = "SELECT id, name, trinketslot, fiveonfivemap FROM website.items WHERE trinketslot = true AND fiveonfivemap = true";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet result = preparedStatement.executeQuery();
		
		Integer id = null;
		String name = null;
		boolean trinketSlot = false;
		boolean fiveOnFiveMap = false;
		
		while (result.next()) {
			
			LTItemBean LTItemBean = new LTItemBean();
			
			id = result.getInt("id");
			name = result.getString("name");
			trinketSlot = result.getBoolean("trinketslot");
			fiveOnFiveMap = result.getBoolean("fiveonfivemap");
			LTItemBean.setId(id);
			LTItemBean.setName(name);
			LTItemBean.setTrinketSlot(trinketSlot);
			LTItemBean.setFiveOnFiveMap(fiveOnFiveMap);
			
			items.add(LTItemBean);
		}
		
		return items;
	}
	public static void allItems(Items all) throws ClassNotFoundException, SQLException {
		for (Item item : all) {
			Integer id = item.getId();
			String name = item.getName();
			try {
				LTItems.setItems(id, name);
			} catch (Exception e) {
				LTItems.updateItems(id, name);
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
