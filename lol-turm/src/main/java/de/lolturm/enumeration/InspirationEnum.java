package de.lolturm.enumeration;

import de.lolturm.rune.Rune;

public enum InspirationEnum {
	keystone(new Rune("UNSEALEDSPELLBOOK", "UNSEALED SPELLBOOK"), new Rune("GLACIALAUGMENT", "GLACIAL AUGMENT"), new Rune("KLEPTOMANCY", "KLEPTOMANCY")),
	firstRow(new Rune("HEXTECHFLASHTRAPTION", "HEXTECH FLASHTRAPTION"), new Rune("BISCUITDELIVERY", "BISCUIT DELIVERY"), new Rune("PERFECTTIMING", "PERFECT TIMING")),
	secondRow(new Rune("MAGICALFOOTWEAR", "MAGICAL FOOTWEAR"), new Rune("FUTURESMARKET", "FUTURE’S MARKET"), new Rune("MINIONDEMATERIALIZER", "MINION DEMATERIALIZER")),
	thirdRow(new Rune("COSMICINSIGH", "COSMIC INSIGHT"), new Rune("APPROACHVELOCITY", "APPROACH VELOCITY"), new Rune("TIMEWARPTONIC", "TIME WARP TONIC"));
	
	private final Rune firstRune;
	private final Rune secondRune;
	private final Rune thirdRune;
	
	private InspirationEnum(Rune firstRune, Rune secondRune, Rune thirdRune) {
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
