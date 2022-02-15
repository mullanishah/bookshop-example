package com.core.tester;

import static com.core.utils.CommonUtils.getEnrichedGenre;
import static com.core.utils.CommonUtils.getSimpleDatFormatter;
import java.util.Collection;
import java.util.HashMap;
import com.core.pojo.Book;
import com.core.utils.CommonUtils;

/**
 * @author Shahrukh
 * @since 06-Feb-2022
 */
public class DisplayBookTester {
	
	
	public static void displayAvailableBooks(HashMap<String, Book> bookMap) {
		
		Collection<Book> bookCollection = bookMap.values();
		System.out.printf("%-25s %-22s %-17s %-15s %-15s%n", "Title", "Author", "Genre/Category", "Publish Date", "Price(Rs)");
		System.out.println("==================================================================================================");	
		for(Book b : bookCollection) {
			System.out.printf("%-25s %-22s %-17s %-15s %-15s%n", b.getBookTitle(), b.getAuthor(), getEnrichedGenre(b.getGenre()), getSimpleDatFormatter().format(b.getPublishDate()), b.getBookPrice());
		}
		System.out.println("==================================================================================================");
	}
	
	public static boolean searchBookOnTitle(HashMap<String, Book> bookMap) throws Exception {
		
		System.out.println("Enter book title to search: ");
		String bookTitle = CommonUtils.getScanner().nextLine();
		if(bookMap.containsKey(bookTitle)) {
			Book searchedBook = bookMap.get(bookTitle);
			System.out.printf("%-25s %-22s %-17s %-15s %-15s%n", "Title", "Author", "Genre/Category", "Publish Date", "Price(Rs)");
			System.out.println("==================================================================================================");	
			System.out.printf("%-25s %-22s %-17s %-15s %-15s%n", searchedBook.getBookTitle(), searchedBook.getAuthor(), getEnrichedGenre(searchedBook.getGenre()), 
							getSimpleDatFormatter().format(searchedBook.getPublishDate()), searchedBook.getBookPrice());
			System.out.println("==================================================================================================");
			return true;
		} else {
			throw new Exception("Book details with title " + bookTitle + " does not found!!");
		}
	}
	
}
