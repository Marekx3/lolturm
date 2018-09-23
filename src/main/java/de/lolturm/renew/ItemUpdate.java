package de.lolturm.renew;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.staticdata.Items;
import de.lolturm.itemset.LTItems;

import java.sql.SQLException;

public class ItemUpdate {

	public static void main(String[] args) {

		Orianna.setRiotAPIKey("RGAPI-87750144-c82b-489b-b6cf-6cb828f2a5ea");
		Orianna.setDefaultRegion(Region.EUROPE_WEST);

		Items itemList = Orianna.getItems();

		try {
			LTItems.allItems(itemList.get());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
