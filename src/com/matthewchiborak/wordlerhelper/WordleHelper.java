package com.matthewchiborak.wordlerhelper;

import java.util.HashSet;

public class WordleHelper {

	public static void main(String[] args) {
		
		DictionaryReader dicReader = new DictionaryReader();
		HashSet<String> dictionary = dicReader.GetDictionary("WordList.dic");
				
		WordFinderProcessor processor = new WordFinderProcessor(dictionary);
		
		WordleHelperView view = new WordleHelperView(processor);
		view.setVisible(true);
	}

}
