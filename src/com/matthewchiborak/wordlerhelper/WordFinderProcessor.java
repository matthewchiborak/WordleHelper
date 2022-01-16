package com.matthewchiborak.wordlerhelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class WordFinderProcessor {

	WordFinderProcessor(HashSet<String> dictionary){
		this.dictionary = dictionary;
	}
	
	String getResults(char l1, char l2, char l3, char l4, char l5, List<Character> whiteList, List<Character> blacklist){
		this.blackList = blacklist;
		
		String result = "";
		
		//Don't want to print the whole dictionary
		/*if(l1 == ' ' && l2 == ' ' && l3 == ' ' && l4 == ' ' && l5 == ' ')
			return "Please Enter Letter Values";*/
		
		List<String> wordsToTry = createWordsToTry(
				Character.toLowerCase(l1),
				Character.toLowerCase(l2),
				Character.toLowerCase(l3),
				Character.toLowerCase(l4),
				Character.toLowerCase(l5)
				);
		
		Iterator<String> wordIter = wordsToTry.iterator();
		while(wordIter.hasNext()) {
			String focusWord = wordIter.next();
			if(dictionary.contains(focusWord))
			{
				if(whiteList.size() == 0) {
					result += focusWord + ", ";
					continue;
				}
				
				boolean missingALetter = false;
				Iterator<Character> whiteIter = whiteList.iterator();
				while(whiteIter.hasNext()) 
				{
					if(!focusWord.contains(String.valueOf(whiteIter.next())))
					{
						missingALetter = true;
					}
				}
				if(!missingALetter) {
					result += focusWord + ", ";
					continue;
				}
			}
		}
		return result;
	}
	
	private List<String> createWordsToTry(char l1, char l2, char l3, char l4, char l5){
		List<String> wordsToTry = new ArrayList<String>();
		
		List<String> laterCharacters = createWordsToTry(l2, l3, l4, l5);
		Iterator<String> iter = laterCharacters.iterator();
		
		if(l1 != ' ') {
			//Letter is set
			while(iter.hasNext())
				wordsToTry.add(String.valueOf(l1) + iter.next());
		}else {
			while(iter.hasNext()) {
				String focusWord = iter.next();
				for(int i = 97; i < 123; ++i) {
					if(!this.blackList.contains((char)i))
						wordsToTry.add(String.valueOf((char)i) + focusWord);
				}
			}
		}
		
		return wordsToTry;
	}
	
	private List<String> createWordsToTry(char l2, char l3, char l4, char l5){
		List<String> wordsToTry = new ArrayList<String>();
		
		List<String> laterCharacters = createWordsToTry(l3, l4, l5);
		Iterator<String> iter = laterCharacters.iterator();
		
		if(l2 != ' ') {
			//Letter is set
			while(iter.hasNext())
				wordsToTry.add(String.valueOf(l2) + iter.next());
		}else {
			while(iter.hasNext()) {
				String focusWord = iter.next();
				for(int i = 97; i < 123; ++i) {
					if(!this.blackList.contains((char)i))
						wordsToTry.add(String.valueOf((char)i) + focusWord);
				}
			}
		}
		
		return wordsToTry;
	}
	
	private List<String> createWordsToTry(char l3, char l4, char l5){
		List<String> wordsToTry = new ArrayList<String>();
		
		List<String> laterCharacters = createWordsToTry(l4, l5);
		Iterator<String> iter = laterCharacters.iterator();
		
		if(l3 != ' ') {
			//Letter is set
			while(iter.hasNext())
				wordsToTry.add(String.valueOf(l3) + iter.next());
		}else {
			while(iter.hasNext()) {
				String focusWord = iter.next();
				for(int i = 97; i < 123; ++i) {
					if(!this.blackList.contains((char)i))
						wordsToTry.add(String.valueOf((char)i) + focusWord);
				}
			}
		}
		
		return wordsToTry;
	}
	
	private List<String> createWordsToTry(char l4, char l5){
		List<String> wordsToTry = new ArrayList<String>();
		
		List<String> laterCharacters = createWordsToTry(l5);
		Iterator<String> iter = laterCharacters.iterator();
		
		if(l4 != ' ') {
			//Letter is set
			while(iter.hasNext())
				wordsToTry.add(String.valueOf(l4) + iter.next());
		}else {
			while(iter.hasNext()) {
				String focusWord = iter.next();
				for(int i = 97; i < 123; ++i) {
					if(!this.blackList.contains((char)i))
						wordsToTry.add(String.valueOf((char)i) + focusWord);
				}
			}
		}
		
		return wordsToTry;
	}
	
	private List<String> createWordsToTry(char l5){
		List<String> wordsToTry = new ArrayList<String>();
		
		if(l5 != ' ') {
			//Letter is set
			wordsToTry.add(String.valueOf(l5));
		}else {
			for(int i = 97; i < 123; ++i) {
				if(!this.blackList.contains((char)i))
					wordsToTry.add(String.valueOf((char)i));
			}
		}
		return wordsToTry;
	}
	
	private HashSet<String> dictionary;
	List<Character> blackList;
}
