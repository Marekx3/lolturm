package de.lolturm.renew;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import de.lolturm.champion.LTChampions;

import java.sql.SQLException;

public class ChampionUpdate {

	public static void main(String[] args) {
        Orianna.setRiotAPIKey("RGAPI-87750144-c82b-489b-b6cf-6cb828f2a5ea");
        Orianna.setDefaultRegion(Region.EUROPE_WEST);
		// get champion data (ignoring locale, version) by champion id
        Champions champList = Orianna.getChampions();

        try {
            LTChampions.allChampions(champList.get());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
