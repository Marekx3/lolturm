package de.lolturm.renew;

import java.sql.SQLException;
import java.util.Map;

import com.mingweisamuel.zyra.RiotApi;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.lolStaticData.Champion;
import com.mingweisamuel.zyra.lolStaticData.ChampionList;

import de.lolturm.champion.Champions;

public class ChampionUpdate {

	public static void main(String[] args) {
		RiotApi api = RiotApi.newInstance("RGAPI-ee15f32e-25e1-43b6-bfda-ca7400850b0c");

		// get champion data (ignoring locale, version) by champion id
		ChampionList champList = api.staticData.getChampionList(Region.NA);
		Map<String, Champion> all = champList.data;

		try {
			Champions.allChampions(all);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
