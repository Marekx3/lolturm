package de.lolturm.skillorder;

import java.util.ArrayList;

public class SkillOrderBean {
	
	private ArrayList<String> skillOrder;

	public SkillOrderBean() {
		this.skillOrder = new ArrayList<String>();
	}

	public ArrayList<String> getSkillOrder() {
		return skillOrder;
	}

	public void setSkillOrder(ArrayList<String> skillOrder) {
		this.skillOrder = skillOrder;
	}

	public void getSkillOrderFromString(String skillorder) {
		String[] skillorderA = skillorder.split(",");
				
		for (String string : skillorderA) {
			this.skillOrder.add(string);
		}
	}

	public String getString() {
		String skillOrderS = "";
		for (int i = 0; i < this.skillOrder.size(); i++) {
			skillOrderS += this.skillOrder.get(i) + ",";
		}
		return skillOrderS.substring(0, skillOrderS.length() - 1);
	}
}
