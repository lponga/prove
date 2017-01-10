package com.lponga.language;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Language {
	String language;
	static Map<String, String> translationsMap = new HashMap<String, String>();
	
	public Language(String language) {
		this.language = language;
		initializeVocabulary(language);
	}
	
	void initializeVocabulary(String language) {
		BufferedReader r = openReaderStream(language+".txt");
		if (r != null)
			for (String line = readLineFromStream(r); line != null; line = readLineFromStream(r)) {
				String key = line.substring(0, line.indexOf('='));
				String translation = line.substring(line.indexOf('=') + 1);
				translationsMap.put(key, translation);
			}
		closeStream(r);
	}
	
	public void printAllTranslations() {
		for (Iterator<Entry<String, String>> it = translationsMap.entrySet().iterator(); it.hasNext();) {
			Entry<String, String> entry = it.next();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}

	private static BufferedReader openReaderStream(String filename) {
		try {
			return new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// qui non metto nessun errore perche` se la lingua non esiste significa che e` la prima volta che viene usata per cui poi si crea il file
			//System.out.println("FileNotFoundException filename=" + filename);
			//e.printStackTrace();
		}

		return null;
	}

	private static BufferedWriter openWriterStream(String filename) {
		try {
			return new BufferedWriter(new FileWriter(filename));
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException filename=" + filename);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException filename=" + filename);
			e.printStackTrace();
		}

		return null;
	}

	private static String readLineFromStream(BufferedReader r) {
		try {
			if (r != null)
				return r.readLine();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	private static void closeStream(Closeable r) {
		try {
			if (r != null)
				r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void insertTranslation(String key, String translation) {
		translationsMap.put(key, translation);
		saveTranslations();
	}

	public Entry<String, String> retrieveRandomTranslation() {
		Date now = new Date();
		Random rnd = new Random();
		rnd.setSeed(now.getTime());
		int pos = rnd.nextInt(translationsMap.size());
		for (Iterator<Entry<String, String>> it = translationsMap.entrySet().iterator(); it.hasNext(); pos--) {
			Entry<String, String> entry = it.next();
			if (pos==0) return entry;
		}
		return null;
	}

	public void saveTranslations() {
		BufferedWriter w = openWriterStream(language+".txt");
		if (w != null)
			for (Iterator<Entry<String, String>> it = translationsMap.entrySet().iterator(); it.hasNext();) {
				Entry<String, String> entry = it.next();
				try {
					w.write(entry.getKey() + "=" + entry.getValue() + "\n");
				} catch (IOException e) {
					System.out.println("Error saving: " + entry.getKey() + "=" + entry.getValue());
					e.printStackTrace();
				}
			}
		closeStream(w);
	}

}
