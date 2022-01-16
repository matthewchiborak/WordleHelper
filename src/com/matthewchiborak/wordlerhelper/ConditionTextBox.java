package com.matthewchiborak.wordlerhelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;

public class ConditionTextBox extends JTextField {

	ConditionTextBox() {
		super();
		
		setSize(450, 25);
	}
	
	public List<Character> getList(){
		List<Character> result = new ArrayList<>();
		
		if(this.getText().length() <= 0)
			return result;
		
		List<String> stringList = Arrays.asList(this.getText().split(","));
		Iterator<String> iter = stringList.iterator();
		while(iter.hasNext())
			result.add(iter.next().charAt(0));
		
		return result;
	}
}
