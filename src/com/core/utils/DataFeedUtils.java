package com.core.utils;

import static com.core.utils.CommonUtils.getSimpleDatFormatter;
import java.util.HashMap;
import java.util.Optional;
import com.core.pojo.Book;
import com.core.pojo.BookGenre;

public class DataFeedUtils {
	
	public static HashMap<String, Book> bookMap = null;
	
	private static Book[] getBookArray() throws Exception {
		return new Book[] {
			new Book("Head First Java", "Kathy Sierra", BookGenre.EDU, 650.55, getSimpleDatFormatter().parse("02-01-1993")),
			new Book("Data Structure", "Sartaj Sahani", BookGenre.EDU, 450, getSimpleDatFormatter().parse("09-11-2004")),
			new Book("Harry Potter", "J.K.Rowling", BookGenre.FF, 2319.88, getSimpleDatFormatter().parse("16-07-1997")),
			new Book("Java SP", "James Gosling", BookGenre.EDU, 2365, getSimpleDatFormatter().parse("23-07-1998")),
			new Book("Marvel: Secret Wars", "Stan Lee, Steve Ditco", BookGenre.CB, 3972, getSimpleDatFormatter().parse("30-05-1984")),
			new Book("C++ Primer", "Stanlee Lipman", BookGenre.EDU, 943.87, getSimpleDatFormatter().parse("17-06-1995")),
			new Book("Adve. of Sherlock Holmes", "Authur Conan Doyle", BookGenre.ADV, 1990.23, getSimpleDatFormatter().parse("13-03-2009")),
			new Book("Let us C", "Yashwant Kanetkar", BookGenre.EDU, 450, getSimpleDatFormatter().parse("29-02-1999")),
			new Book("Tester vol.1", "tester", BookGenre.C, 110.75, getSimpleDatFormatter().parse("11-11-1992"))
		};
	}
	
	public static HashMap<String, Book> getPopulatedData() throws Exception{
		bookMap = Optional.ofNullable(bookMap).
							orElse(new HashMap<String, Book>());
		for(Book book : getBookArray()) {
			bookMap.put(book.getBookTitle(), book);
		}
		return bookMap;
	}

}
