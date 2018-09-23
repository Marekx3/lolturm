package de.lolturm.itemset;

import java.util.ArrayList;
import java.util.Arrays;

public class LTItemSetBean {
	private ArrayList<Integer> itemSetArray;

	public LTItemSetBean() {
		super();
	}

	public ArrayList<Integer> getItemSetArray() {
		return itemSetArray;
	}

	public void setItemSetArray(ArrayList<Integer> itemSetArray) {
		this.itemSetArray = itemSetArray;
	}
	
	public String getItemSetString(String slot1, String slot2, String slot3, String slot4, String slot5, String slot6, String slot7) {
		return slot1 + "," + slot2 + "," + slot3 + "," + slot4 + "," + slot5 + "," + slot6 + "," + slot7;
	}

	public LTItemSetBean setItemSetArray(String itemset) {
		ArrayList<Integer> itemSetArray = new ArrayList<Integer>();
		
		itemset += ",";
		
		char[] charArray = itemset.toCharArray();
		
		int j = 0;

		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == ',') {
				char[] item = Arrays.copyOfRange(charArray, j, i);
				String itemString = new String(item);
				Integer itemInteger = Integer.parseInt(itemString);
				itemSetArray.add(itemInteger);
				j = i + 1;
			}
		}
		this.itemSetArray = itemSetArray;
		LTItemSetBean LTItemSetBean = new LTItemSetBean();
		LTItemSetBean.setItemSetArray(itemSetArray);
		return LTItemSetBean;
	}

	public String getItemSetAsString() {
		String string = "";
		
		for (Integer integer : this.itemSetArray) {
			string += integer + ",";
		}
		
		string = string.substring(0, string.length()-1);
		return string;
	}
}
