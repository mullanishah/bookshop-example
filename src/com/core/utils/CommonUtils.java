package com.core.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import com.core.pojo.BookGenre;

public class CommonUtils {
	
	private static SimpleDateFormat sdf;
	private static Scanner scanner;
	
	static {
		scanner = new Scanner(System.in);
		sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
	}
	
	public static Scanner getScanner() {
		return scanner;
	}

	public static SimpleDateFormat getSimpleDatFormatter() {
		return sdf;
	}

	public static String getEnrichedGenre(BookGenre genre) {
		return genre.getValue().toString();
	}
}
