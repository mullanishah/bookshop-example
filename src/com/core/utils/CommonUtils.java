package com.core.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class CommonUtils {
	
	private static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
	}
	
	public static SimpleDateFormat getSimpleDatFormatter() {
		return sdf;
	}

}
