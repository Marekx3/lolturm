package de.lolturm.enumeration;

import de.lolturm.rune.Rune;

public enum DominationEnum {
	keystone(new Rune("ELECTROCUTE", "ELECTROCUTE"), new Rune("PREDATOR", "PREDATOR"), new Rune("DARKHARVEST", "DARK HARVEST")),
	firstRow(new Rune("CHEAPSHOT", "CHEAP SHOT"), new Rune("TASTEOFBLOOD", "TASTE OF BLOOD"), new Rune("SUDDENIMPACT", "SUDDEN IMPACT")),
	secondRow(new Rune("ZOMBIEWARD", "ZOMBIE WARD"), new Rune("GHOSTPORO", "GHOST PORO"), new Rune("EYEBALLCOLLECTION", "EYEBALL COLLECTION")),
	thirdRow(new Rune("RAVENOUSHUNTER", "RAVENOUS HUNTER"), new Rune("INGENIOUSHUNTER", "INGENIOUS HUNTER"), new Rune("RELENTLESSHUNTER", "RELENTLESS HUNTER"));	
	
	private final Rune firstRune;
	private final Rune secondRune;
	private final Rune thirdRune;
	
	private DominationEnum(Rune firstRune, Rune secondRune, Rune thirdRune) {
		this.firstRune = firstRune;
		this.secondRune = secondRune;
		this.thirdRune = thirdRune;
	}
	
	public Rune getFirstRune() {
		return firstRune;
	}
	
	public Rune getSecondRune() {
		return secondRune;
	}
	
	public Rune getThirdRune() {
		return thirdRune;
	}
}
