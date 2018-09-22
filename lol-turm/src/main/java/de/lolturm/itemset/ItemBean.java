package de.lolturm.itemset;

public class ItemBean {
	private Integer id;
	private String name;
	private boolean trinketSlot;
	private boolean fiveOnFiveMap;

	public ItemBean() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isTrinketSlot() {
		return trinketSlot;
	}

	public void setTrinketSlot(boolean trinketSlot) {
		this.trinketSlot = trinketSlot;
	}

	public boolean isFiveOnFiveMap() {
		return fiveOnFiveMap;
	}

	public void setFiveOnFiveMap(boolean fiveOnFiveMap) {
		this.fiveOnFiveMap = fiveOnFiveMap;
	}
}
