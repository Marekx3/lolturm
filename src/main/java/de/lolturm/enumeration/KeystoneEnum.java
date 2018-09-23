package de.lolturm.enumeration;

public enum KeystoneEnum {
	
	Precision(1, "Precision", ""),
	Domination(2, "Domination", ""),
	Sorcery(3, "Sorcery", ""),
	Resolve(4, "Resolve", ""),
	Inspiration(5, "Inspiration", "");

	private final Integer id;
	private final String englischText;
	private final String deutschText;

	private KeystoneEnum(Integer id, String englischText, String deutschText) {
		this.id = id;
		this.englischText = englischText;
		this.deutschText = deutschText;
	}

	public Integer getId() {
		return id;
	}

	public String getEnglischText() {
		return englischText;
	}

	public String getDeutschText() {
		return deutschText;
	}

	public static KeystoneEnum getById(Integer id) {
		for (KeystoneEnum e : values()) {
			if (e.id.equals(id))
				return e;
		}
		return null;
	}

	public static KeystoneEnum getById(String id) {
		Integer idI = Integer.parseInt(id);
		for (KeystoneEnum e : values()) {
			if (e.id.equals(idI))
				return e;
		}
		return null;
	}
}
