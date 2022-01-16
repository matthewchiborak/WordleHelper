package com.matthewchiborak.wordlerhelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.stream.Stream;

public class DictionaryReader {

	DictionaryReader() {}
	
	HashSet<String> GetDictionary(String filepath){
		
		HashSet<String> dictionary = new HashSet<>();
		
		try (Stream<String> stream = Files.lines(Paths.get(filepath))) {
	        stream.forEach(line -> dictionary.add(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dictionary;
	}
}
