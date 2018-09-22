package de.lolturm.servlet;

import de.lolturm.enumeration.PositionEnum;

public class Denullify {

	public Denullify() {

	}

	public String doString(String parameter) {
		if (parameter == null) {
			return "";
		} else {
			return parameter;
		}
	}

	public PositionEnum doPositionEnum(PositionEnum byPosition) {
		if (byPosition == null) {
			return PositionEnum.Null;
		} else {
			return byPosition;
		}
	}

	public String doInt(String parameter) {
		if (parameter == null) {
			return "9999999";
		} else {
			return parameter;
		}
	}
}