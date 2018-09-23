package de.lolturm.enumeration;

public enum PositionEnum {
	Top("Top", 1), Jungle("Jungle", 2), Mid("Mid", 3), Bot("Bot", 4), Support("Support", 5), Null("null", 0);

	private final String positon;
	private final Integer id;

	private PositionEnum(String positon, Integer id) {
		this.positon = positon;
		this.id = id;
	}

	public String getPositon() {
		return positon;
	}

	public Integer getId() {
		return id;
	}
	
	public static PositionEnum getByPosition(String position) {
	    for(PositionEnum e : values()) {
	        if(e.positon.equals(position)) return e;
	    }
	    return null;
	}
}
