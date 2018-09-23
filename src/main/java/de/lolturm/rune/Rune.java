package de.lolturm.rune;

public class Rune {

	public String idName;
	public String anzeigeName;

	public Rune(String idName, String anzeigeName) {
		super();
		this.idName = idName;
		this.anzeigeName = anzeigeName;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public String getAnzeigeName() {
		return anzeigeName;
	}

	public void setAnzeigeName(String anzeigeName) {
		this.anzeigeName = anzeigeName;
	}
}
