package de.lolturm.champion;

public class ChampionBean {

	private Integer id;
	private String key;
	private String name;
	private String title;

	public ChampionBean(Integer id, String key, String name, String title) {
		super();
		this.id = id;
		this.key = key;
		this.name = name;
		this.title = title;
	}

	public ChampionBean() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
