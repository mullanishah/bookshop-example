package com.core.tester;

import com.core.pojo.Book;
import com.core.utils.CommonUtils;

public class BookShoppingTester {

	public static void main(String[] args) throws Exception {
		
		Book b = new Book("test vol.1", "tester", "test", 250, CommonUtils.getSimpleDatFormatter().parse("20-05-1997"));
		System.out.println(b);
	}

}
