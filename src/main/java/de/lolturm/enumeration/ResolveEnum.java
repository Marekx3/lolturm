package de.lolturm.enumeration;

import de.lolturm.rune.Rune;

public enum ResolveEnum {
	keystone(new Rune("GRASPOFTHEUNDYING", "GRASP OF THE UNDYING"), new Rune("AFTERSHOCK", "AFTERSHOCK"), new Rune("GUARDIAN", "GUARDIAN")),
	firstRow(new Rune("DEMOLISH", "DEMOLISH"), new Rune("FONTOFLIFE", "FONT OF LIFE"), new Rune("BONEPLATING", "BONE PLATING")),
	secondRow(new Rune("IRONSKIN", "TRANSCENDENCE"), new Rune("MIRRORSHELL", "MIRROR SHELL"), new Rune("CONDITIONING", "CONDITIONING")),
	thirdRow(new Rune("OVERGROWTH", "OVERGROWTH"), new Rune("REVITALIZE", "REVITALIZE"), new Rune("SECONDWIND", "SECOND WIND"));
	
	private final Rune firstRune;
	private final Rune secondRune;
	private final Rune thirdRune;
	
	private ResolveEnum(Rune firstRune, Rune secondRune, Rune thirdRune) {
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
