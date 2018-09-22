package de.lolturm.enumeration;

import de.lolturm.rune.Rune;

public enum PrecisionEmun {
	keystone(new Rune("PRESSTHEATTACK", "PRESS THE ATTACK"), new Rune("LETHALTEMPO", "LETHAL TEMPO"), new Rune("FLEETFOOTWORK", "FLEET FOOTWORK")),
	firstRow(new Rune("OVERHEAL", "OVERHEAL"), new Rune("TRIUMPH", "TRIUMPH"), new Rune("PRESENCEOFMIND", "PRESENCE OF MIND")),
	secondRow(new Rune("LEGENDALACRITY", "LEGEND: ALACRITY"), new Rune("LEGENDTENACITY", "LEGEND: TENACITY"), new Rune("LEGENDBLOODLINE", "LEGEND: BLOODLINE")),
	thirdRow(new Rune("COUPDEGRACE", "COUP DE GRACE"), new Rune("CUTDOWN", "CUT DOWN"), new Rune("LASTSTAND", "LAST STAND"));
	
	private final Rune firstRune;
	private final Rune secondRune;
	private final Rune thirdRune;
	
	private PrecisionEmun(Rune firstRune, Rune secondRune, Rune thirdRune) {
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
