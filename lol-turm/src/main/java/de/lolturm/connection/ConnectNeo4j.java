package de.lolturm.connection;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;

public class ConnectNeo4j {
	private Driver driver;
	private String url;
	private String username;
	private String password;

	public ConnectNeo4j() {
		setParms();
		setDriver(this.url, this.username, this.password);
	}

	public void setParms() {
		this.url = "bolt://localhost:7687";
		this.username = "neo4j";
		this.password = "Callme17";
	}

	public void setDriver(String url, String username, String password) {
		this.driver = GraphDatabase.driver(url, AuthTokens.basic(username, password));
	}

	public Driver getDriver() {
		return driver;
	}
}
