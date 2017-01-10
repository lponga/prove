package com.lponga.language;

import java.io.Console;
import java.util.Map.Entry;

public class LanguageTeacher {
	static int points = 0;
	
	public static void main(String[] args) {
		Console c = System.console();
		if (c == null) {
			System.out.println("no console available");
			System.exit(-1);
		}
		
		String languageStr = c.readLine("Choose language(english,deutch,french): ");

		Language language = new Language(languageStr);
		
		String choice;
		do {
			choice = c.readLine("Press\n\t0 - to exit\n\t1 - to insert a translation\n\t2 - to print all translations\n\t3 - to start test: \n");
			switch (choice) {
			case "1":
				insertTranslation(language, c);
				break;
			case "2":
				language.printAllTranslations();
				break;
			case "3":
				testLanguage(language, c);
				break;
			}
		} while (!choice.equals("0"));
	}



	private static void testLanguage(Language language, Console c) {
		String line;
		do {
			Entry<String,String> entry = language.retrieveRandomTranslation();
			if (entry==null) {
				System.out.println("No entry availables");
				return;
			}
			line = c.readLine("Please insert translation of \'"+entry.getKey()+"\' (enter to finish)=> ");
			System.out.println("line: "+line);
			if (!line.isEmpty())
				if (line.equals(entry.getValue()))
					System.out.println("GOOD! POINTS: "+(++points));			
				else
					System.out.println("BAD! Correct translation is: \'"+entry.getValue()+"\' POINTS: "+(--points));			
		} while (!line.isEmpty());
		
	}

	private static void insertTranslation(Language language, Console c) {
		
		String line;
		do {
			line = c.readLine("Please insert key=translation translations (enter to finish)=> ");
			System.out.println("line: "+line);
			if (line.contains("=")) {
				String key = line.substring(0, line.indexOf('='));
				String translation = line.substring(line.indexOf('=') + 1);
				language.insertTranslation(key, translation);
			}
		} while (!line.isEmpty());
		
	}


}
