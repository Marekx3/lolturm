package de.lolturm.guide;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import de.lolturm.champion.Champions;
import de.lolturm.connection.ConnectPostgre;
import de.lolturm.enumeration.PositionEnum;
import de.lolturm.itemset.ItemSetBean;
import de.lolturm.rune.RuneBean;
import de.lolturm.skillorder.SkillOrderBean;
import de.lolturm.userid.Userid;
import de.lolturm.userid.UseridBean;

public class Guides {
	
	private static GuideBean guideBean;
	private static UseridBean useridBean;

	public Guides() {

	}
	
	public static GuideBean getGuideBean() {
		return guideBean;
	}

	public static void setGuideBean(GuideBean guideBean) {
		Guides.guideBean = guideBean;
	}

	public static UseridBean getUseridBean() {
		return useridBean;
	}

	public static void setUseridBean(UseridBean useridBean) {
		Guides.useridBean = useridBean;
	}

	public static ArrayList<GuideBean> getGuide(Integer champion, String position) throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();

		ArrayList<GuideBean> guides = new ArrayList<GuideBean>();

		String sql = "SELECT id, guidename, date, champion, \"user\", position, keystone, secondtree, runendesc, bewertung, itemset, itemsetdesc, patch, skillorder, skillorderdesc FROM website.guides WHERE champion = ? AND position = ? ORDER BY id DESC";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, champion);
		preparedStatement.setString(2, position);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			Integer id = result.getInt("id");
			String guideName = result.getString("guidename");
			String date = result.getString("date");
			Integer championResult = result.getInt("champion");
			Integer user = result.getInt("user");
			String positionResult = result.getString("position");
			String keystone = result.getString("keystone");
			String secondtree = result.getString("secondtree");
			String runendesc = result.getString("runendesc");
			Integer bewertung = result.getInt("bewertung");
			String itemset = result.getString("itemset");
			String itemsetdesc = result.getString("itemsetdesc");
			String patch = result.getString("patch");
			String skillorder = result.getString("skillorder");
			String skillorderdesc = result.getString("skillorderdesc");
			GuideBean guideBean = new GuideBean();
			guideBean.setId(id);
			guideBean.setGuideName(guideName);
			SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
			try {
				guideBean.setDate(dt.parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			guideBean.setChampion(Champions.get(championResult));
			guideBean.setUser(Userid.get(user));
			guideBean.setPosition(PositionEnum.getByPosition(positionResult));
			RuneBean runeBean = new RuneBean();
			runeBean.getRunenFromString(keystone, secondtree);
			guideBean.setRunes(runeBean);
			guideBean.setRunesDesc(runendesc);
			guideBean.setBewertung(bewertung);
			guideBean.setItemSet(new ItemSetBean().setItemSetArray(itemset));
			guideBean.setItemSetDesc(itemsetdesc);
			guideBean.setPatch(patch);
			SkillOrderBean skillOrderBean = new SkillOrderBean();
			skillOrderBean.getSkillOrderFromString(skillorder);
			guideBean.setSkillOrder(skillOrderBean);
			guideBean.setSkillOrderDesc(skillorderdesc);
			guides.add(guideBean);
		}
		connection.close();
		return guides;
	}
	
	public static Integer insertGuide() throws SQLException, ClassNotFoundException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		String sql = "INSERT INTO website.guides (guidename, date, champion, \"user\", position, keystone, secondtree, runendesc, itemset, itemsetdesc, patch, skillorder, skillorderdesc) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) RETURNING id";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, guideBean.getGuideName());
		Date date = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		preparedStatement.setString(2, dt.format(date));
		preparedStatement.setInt(3, guideBean.getChampion().getId());
		preparedStatement.setInt(4, guideBean.getUser().getId());
		preparedStatement.setString(5, guideBean.getPosition().getPositon());
		preparedStatement.setString(6, guideBean.getRunes().getKeystoneRunen() + "," + guideBean.getRunes().getKeystoneId());
		preparedStatement.setString(7, guideBean.getRunes().getSecondTreeRunen() + "," + guideBean.getRunes().getSecondTreeId());
		preparedStatement.setString(8, guideBean.getRunesDesc());
		preparedStatement.setString(9, guideBean.getItemSet().getItemSetAsString());
		preparedStatement.setString(10, guideBean.getItemSetDesc());
		preparedStatement.setString(11, guideBean.getPatch());
		preparedStatement.setString(12, guideBean.getSkillOrder().getString());
		preparedStatement.setString(13, guideBean.getSkillOrderDesc());

		ResultSet resultSet = preparedStatement.executeQuery();
		
		connection.close();
		resultSet.next();
		return resultSet.getInt("id");
		
	}

	public static GuideBean getGuide(String guide) throws SQLException, ClassNotFoundException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		String sql = "SELECT id, guidename, date, champion, \"user\", position, keystone, secondtree, runendesc, bewertung, itemset, itemsetdesc, patch, skillorder, skillorderdesc FROM website.guides WHERE id = ?";
		
		GuideBean guideBean = new GuideBean();
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, Integer.parseInt(guide));
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			Integer id = result.getInt("id");
			String guideName = result.getString("guidename");
			String date = result.getString("date");
			Integer championResult = result.getInt("champion");
			Integer user = result.getInt("user");
			String positionResult = result.getString("position");
			String keystone = result.getString("keystone");
			String secondtree = result.getString("secondtree");
			String runendesc = result.getString("runendesc");
			Integer bewertung = result.getInt("bewertung");
			String itemset = result.getString("itemset");
			String itemsetdesc = result.getString("itemsetdesc");
			String patch = result.getString("patch");
			String skillorder = result.getString("skillorder");
			String skillorderdesc = result.getString("skillorderdesc");
			guideBean.setId(id);
			guideBean.setGuideName(guideName);
			SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
			try {
				guideBean.setDate(dt.parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			guideBean.setChampion(Champions.get(championResult));
			guideBean.setUser(Userid.get(user));
			guideBean.setPosition(PositionEnum.getByPosition(positionResult));
			RuneBean runeBean = new RuneBean();
			runeBean.getRunenFromString(keystone, secondtree);
			guideBean.setRunes(runeBean);
			guideBean.setRunesDesc(runendesc);
			guideBean.setBewertung(bewertung);
			guideBean.setItemSet(new ItemSetBean().setItemSetArray(itemset));
			guideBean.setItemSetDesc(itemsetdesc);
			guideBean.setPatch(patch);
			SkillOrderBean skillOrderBean = new SkillOrderBean();
			skillOrderBean.getSkillOrderFromString(skillorder);
			guideBean.setSkillOrder(skillOrderBean);
			guideBean.setSkillOrderDesc(skillorderdesc);
		}

		connection.close();
		return guideBean;
	}

	public static void setUpBewertung() throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		String sql = "UPDATE website.guides SET bewertung = bewertung + 1 WHERE id = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, guideBean.getId());
		preparedStatement.executeUpdate();
		
		if (!checkAlreadyBewertet()) {
			sql = "INSERT INTO website.bewertet (guide, \"user\", wert) VALUES (?,?,?)";
			
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql);
			preparedStatement2.setInt(1, guideBean.getId());
			preparedStatement2.setInt(2, useridBean.getId());
			preparedStatement2.setInt(3, 1);
			preparedStatement2.executeUpdate();
		} else {
			sql = "UPDATE website.bewertet SET wert = wert + 1 WHERE \"user\" = ? AND guide = ?";
			
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql);
			preparedStatement2.setInt(1, useridBean.getId());
			preparedStatement2.setInt(2, guideBean.getId());
			preparedStatement2.executeUpdate();
		}
		
		connection.close();
	}

	public static void setDownBewertung() throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		String sql = "UPDATE website.guides SET bewertung = bewertung - 1 WHERE id = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, guideBean.getId());
		preparedStatement.executeUpdate();
		
		if (!checkAlreadyBewertet()) {
			sql = "INSERT INTO website.bewertet (guide, \"user\", wert) VALUES (?,?,?)";
			
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql);
			preparedStatement2.setInt(1, guideBean.getId());
			preparedStatement2.setInt(2, useridBean.getId());
			preparedStatement2.setInt(3, -1);
			preparedStatement2.executeUpdate();
		} else {
			sql = "UPDATE website.bewertet SET wert = wert - 1 WHERE \"user\" = ? AND guide = ?";
			
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql);
			preparedStatement2.setInt(1, useridBean.getId());
			preparedStatement2.setInt(2, guideBean.getId());
			preparedStatement2.executeUpdate();
		}
		
		
		connection.close();
		
	}

	public static boolean checkAlreadyBewertet() throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		String sql = "SELECT id, guide, \"user\", wert FROM website.bewertet WHERE \"user\" = ? AND guide = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, useridBean.getId());
		preparedStatement.setInt(2, guideBean.getId());
		ResultSet resultSet = preparedStatement.executeQuery();
		
		return resultSet.next();
	}

	public static Integer getBewertet() throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		String sql = "SELECT id, guide, \"user\", wert FROM website.bewertet WHERE \"user\" = ? AND guide = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, useridBean.getId());
		preparedStatement.setInt(2, guideBean.getId());
		ResultSet resultSet = preparedStatement.executeQuery();
		
		resultSet.next();
		return resultSet.getInt("wert");
	}

	public static boolean checkGuide() throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		String sql = "SELECT id FROM website.guides WHERE \"user\" = ? AND id = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, useridBean.getId());
		preparedStatement.setInt(2, guideBean.getId());
		ResultSet resultSet = preparedStatement.executeQuery();

		return resultSet.next();
	}

	public static void updateGuide() throws ClassNotFoundException, SQLException {
		ConnectPostgre connectPostgre = new ConnectPostgre();
		Connection connection = connectPostgre.getConnection();
		
		String sql = "UPDATE website.guides SET guidename = ?, champion = ?, \"user\" = ?, position = ?, keystone = ?, secondtree = ?, runendesc = ?, itemset = ?, itemsetdesc = ?, patch = ?, skillorder = ?, skillorderdesc = ? WHERE id = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, guideBean.getGuideName());
		preparedStatement.setInt(2, guideBean.getChampion().getId());
		preparedStatement.setInt(3, guideBean.getUser().getId());
		preparedStatement.setString(4, guideBean.getPosition().getPositon());
		preparedStatement.setString(5, guideBean.getRunes().getKeystoneRunen() + "," + guideBean.getRunes().getKeystoneId());
		preparedStatement.setString(6, guideBean.getRunes().getSecondTreeRunen() + "," + guideBean.getRunes().getSecondTreeId());
		preparedStatement.setString(7, guideBean.getRunesDesc());
		preparedStatement.setString(8, guideBean.getItemSet().getItemSetAsString());
		preparedStatement.setString(9, guideBean.getItemSetDesc());
		preparedStatement.setString(10, guideBean.getPatch());
		preparedStatement.setString(11, guideBean.getSkillOrder().getString());
		preparedStatement.setString(12, guideBean.getSkillOrderDesc());
		preparedStatement.setInt(13, guideBean.getId());
		preparedStatement.executeUpdate();
		
		connection.close();	
	}
}
