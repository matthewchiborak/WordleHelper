package com.matthewchiborak.wordlerhelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class WordFinderProcessor {

	WordFinderProcessor(HashSet<String> dictionary){
		this.dictionary = dictionary;
	}
	
	public void setBlackLists(List<Character> blackList,
	List<Character> blackListPos1,
	List<Character> blackListPos2,
	List<Character> blackListPos3,
	List<Character> blackListPos4,
	List<Character> blackListPos5) {
		this.blackList = blackList;
		this.blackListPos1 = blackListPos1;
		this.blackListPos2 = blackListPos2;
		this.blackListPos3 = blackListPos3;
		this.blackListPos4 = blackListPos4;
		this.blackListPos5 = blackListPos5;
		
		this.whiteList = new ArrayList<Character>();
		
		for(int i = 0; i < blackListPos1.size(); ++i)
		{
			if(!this.whiteList.contains(blackListPos1.get(i)))
				this.whiteList.add(blackListPos1.get(i));
		}
		for(int i = 0; i < blackListPos2.size(); ++i)
		{
			if(!this.whiteList.contains(blackListPos2.get(i)))
				this.whiteList.add(blackListPos2.get(i));
		}
		for(int i = 0; i < blackListPos3.size(); ++i)
		{
			if(!this.whiteList.contains(blackListPos3.get(i)))
				this.whiteList.add(blackListPos3.get(i));
		}
		for(int i = 0; i < blackListPos4.size(); ++i)
		{
			if(!this.whiteList.contains(blackListPos4.get(i)))
				this.whiteList.add(blackListPos4.get(i));
		}
		for(int i = 0; i < blackListPos5.size(); ++i)
		{
			if(!this.whiteList.contains(blackListPos5.get(i)))
				this.whiteList.add(blackListPos5.get(i));
		}
	}
	
	public String getResults(char l1, char l2, char l3, char l4, char l5){
		String result = "";
	
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
					if(!this.blackList.contains((char)i) && !this.blackListPos1.contains((char)i))
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
					if(!this.blackList.contains((char)i) && !this.blackListPos2.contains((char)i))
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
					if(!this.blackList.contains((char)i) && !this.blackListPos3.contains((char)i))
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
					if(!this.blackList.contains((char)i) && !this.blackListPos4.contains((char)i))
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
				if(!this.blackList.contains((char)i) && !this.blackListPos5.contains((char)i))
					wordsToTry.add(String.valueOf((char)i));
			}
		}
		return wordsToTry;
	}
	
	private HashSet<String> dictionary;
	private List<Character> blackList;
	private List<Character> blackListPos1;
	private List<Character> blackListPos2;
	private List<Character> blackListPos3;
	private List<Character> blackListPos4;
	private List<Character> blackListPos5;
	private List<Character> whiteList;
}
