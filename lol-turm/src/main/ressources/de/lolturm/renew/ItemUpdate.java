package de.lolturm.renew;

import java.sql.SQLException;
import java.util.Map;

import com.mingweisamuel.zyra.RiotApi;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.lolStaticData.Item;
import com.mingweisamuel.zyra.lolStaticData.ItemList;

import de.lolturm.itemset.Items;

public class ItemUpdate {

	public static void main(String[] args) {
		RiotApi api = RiotApi.newInstance("RGAPI-ee15f32e-25e1-43b6-bfda-ca7400850b0c");

		// get champion data (ignoring locale, version) by champion id
		ItemList champList = api.staticData.getItemList(Region.NA);
		Map<Integer, Item> all = champList.data;

		try {
			Items.allItems(all);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		for (Item item : all.values()) {
//			System.out.println(item.name);
//		}
	}

}
