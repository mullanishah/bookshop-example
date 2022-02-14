/**
 * 
 */
package com.core.tester;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

import com.core.pojo.Book;
import com.core.utils.DataFeedUtils;

/**
 * @author Shahrukh
 * @since 06-Feb-2022
 */
public class SortBookTester {
	
	/**
	 * @param bookMap
	 * @return void
	 */
	public static void sortBooksOnPrice(HashMap<String, Book> bookMap) {
		
		Collection<Book> bookCollection = bookMap.values();
		LinkedList<Book> bookList = new LinkedList<Book>(bookCollection);
		Collections.sort(bookList, new Comparator<Book>() {
			@Override
			public int compare(Book b1, Book b2) {
				return ((Double)b1.getBookPrice()).compareTo((Double)b2.getBookPrice());
			}
		});
		System.out.println("Sort based on price (Ascending):");
		System.out.println("==============================================================");
		System.out.printf("%-11s %-25s %-17s%n", "Price(Rs)", "Title", "Author");
		System.out.println("==============================================================");
		bookList.forEach(b -> System.out.printf("%-11s %-25s %-17s%n", 
									b.getBookPrice(), b.getBookTitle(), b.getAuthor()));
		System.out.println("==============================================================");	
	}

}
