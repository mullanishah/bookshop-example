package com.core.tester;

import static com.core.utils.CommonUtils.getEnrichedGenre;
import static com.core.utils.CommonUtils.getSimpleDatFormatter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

import com.core.operations.CollectionOperations;
import com.core.pojo.Book;
import com.core.utils.CommonUtils;

/**
 * @author Shahrukh
 * @since 06-Feb-2022
 */
public class CartOperationsTester {
	
	public static void addBooksToCart(HashMap<String, Book> bookMap, ArrayList<Book> bookCart) {
		
		System.out.println("Enter book title: ");
		String bookTitle = CommonUtils.getScanner().nextLine();
		if(CollectionOperations.addElementToCart(bookTitle.toLowerCase(), bookMap, bookCart)) {
			System.out.println("Book details added to the cart!!");
		} else {
			System.out.println("Book details with title " + bookTitle + " does not found!!");
		}
	}
	
	public static void removeBooksFromCart(HashMap<String, Book> bookMap, ArrayList<Book> bookCart) {
		
		System.out.println("Enter book title: ");
		String bookTitle = CommonUtils.getScanner().nextLine();
		if(CollectionOperations.removeElementFromCart(bookTitle.toLowerCase(), bookCart)) {
			System.out.println("Book details removed from the cart!!");
		} else {
			System.out.println("Book details with title " + bookTitle + " does not found!!");
		}
	}
	
	public static void displayBooksInCart(ArrayList<Book> bookCart) {
		
		if(bookCart == null) {
			System.err.println("No item found in the cart !!");
		} else {
			System.out.printf("%-22s %-22s %-14s | %-12s%n", "Title", "Author", "Genre", "Price(Rs)");
			System.out.println("====================================================================================");	
			for(Book selectedBook : bookCart) {
				System.out.printf("%-22s %-22s %-14s | %-12s%n", selectedBook.getBookTitle(), selectedBook.getAuthor(), getEnrichedGenre(selectedBook.getGenre()), 
						selectedBook.getBookPrice());
			}
			System.out.println("=====================================================================================");
		}
	}
}
