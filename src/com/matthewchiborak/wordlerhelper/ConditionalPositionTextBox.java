package com.matthewchiborak.wordlerhelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;

public class ConditionalPositionTextBox extends JTextField {
	
	ConditionalPositionTextBox() {
		super();
		
		setSize(450, 25);
		
		initLists();
	}
	
	private void initLists() {
		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
		list3 = new ArrayList<>();
		list4 = new ArrayList<>();
		list5 = new ArrayList<>();
	}
	
	private void addToList(int pos, char letter) {
		if(pos == 1)
			list1.add(letter);
		if(pos == 2)
			list2.add(letter);
		if(pos == 3)
			list3.add(letter);
		if(pos == 4)
			list4.add(letter);
		if(pos == 5)
			list5.add(letter);
	}
	
	public void process() {
		initLists();
		
		List<String> commaStringList = Arrays.asList(this.getText().split(","));
		
		Iterator<String> commaIter = commaStringList.iterator();
		while(commaIter.hasNext()) 
		{
			String focusWord = commaIter.next();
			
			for(int i = 1; i < focusWord.length(); ++i) {
				addToList(focusWord.charAt(0) - 48, focusWord.charAt(i));
			}
		}
	}
		
	public List<Character> getList(int pos){
		if(pos == 0)
			return list1;
		if(pos == 1)
			return list2;
		if(pos == 2)
			return list3;
		if(pos == 3)
			return list4;
		return list5;
	}
	
	private List<Character> list1;
	private List<Character> list2;
	private List<Character> list3;
	private List<Character> list4;
	private List<Character> list5;
}
