package de.lolturm.rune;

import java.util.ArrayList;

public class RuneBean {

	private ArrayList<String> runen;

	public RuneBean() {
		this.runen = new ArrayList<String>();
	}

	public ArrayList<String> getRunen() {
		return runen;
	}

	public void setRunen(ArrayList<String> runen) {
		this.runen = runen;
	}

	public String getKeystoneRunen() {
		return this.runen.get(0) + "," + this.runen.get(1) + "," + this.runen.get(2) + "," + this.runen.get(3);
	}
	
	public ArrayList<String> getKeystoneRunenA() {
		ArrayList<String> runen = new ArrayList<String>();
		runen.add(this.runen.get(0));
		runen.add(this.runen.get(1));
		runen.add(this.runen.get(2));
		runen.add(this.runen.get(3));
		return runen;
	}

	public String getSecondTreeRunen() {
		return this.runen.get(4) + "," + this.runen.get(5);
	}
	
	public ArrayList<String> getSecondTreeRunenA() {
		ArrayList<String> runen = new ArrayList<String>();
		runen.add(this.runen.get(4));
		runen.add(this.runen.get(5));
		return runen;
	}
	
	public String getKeystoneId() {
		return this.runen.get(6);
	}
	public String getSecondTreeId() {
		return this.runen.get(7);
	}

	public void getRunenFromString(String keystone, String secondtree) {
		String[] keystoneA = keystone.split(",");
		String[] secondtreeA = secondtree.split(",");
		
		this.runen.add(keystoneA[0]);
		this.runen.add(keystoneA[1]);
		this.runen.add(keystoneA[2]);
		this.runen.add(keystoneA[3]);
		this.runen.add(secondtreeA[0]);
		this.runen.add(secondtreeA[1]);
		this.runen.add(keystoneA[4]);
		this.runen.add(secondtreeA[2]);
	}
}
