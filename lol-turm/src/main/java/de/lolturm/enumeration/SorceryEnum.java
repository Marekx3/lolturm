package de.lolturm.enumeration;

import de.lolturm.rune.Rune;

public enum SorceryEnum {
	keystone(new Rune("SUMMONAERY", "SUMMON AERY"), new Rune("ARCANECOMET", "ARCANE COMET"), new Rune("PHASERUSH", "PHASE RUSH")),
	firstRow(new Rune("NULLIFYINGORB", "NULLIFYING ORB"), new Rune("MANAFLOWBAND", "MANAFLOW BAND"), new Rune("THEULTIMATEHAT", "THE ULTIMATE HAT")),
	secondRow(new Rune("TRANSCENDENCE", "TRANSCENDENCE"), new Rune("CELERITY", "CELERITY"), new Rune("ABSOLUTEFOCUS", "ABSOLUTE FOCUS")),
	thirdRow(new Rune("SCORCH", "SCORCH"), new Rune("WATERWALKING", "WATERWALKING"), new Rune("GATHERINGSTORM", "GATHERING STORM"));
	
	private final Rune firstRune;
	private final Rune secondRune;
	private final Rune thirdRune;
	
	private SorceryEnum(Rune firstRune, Rune secondRune, Rune thirdRune) {
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
