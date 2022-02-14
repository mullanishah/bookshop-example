package com.core.operations;

import java.util.ArrayList;
import java.util.HashMap;
import com.core.pojo.Book;

/**
 * @author Shahrukh
 * @Since 06-Feb-2022
 */
public class CollctionOperations {
	
	/**
	 * @param bookTitle, bookMap, existingCart
	 * @return boolean
	 */
	public static boolean addElementToCart(String bookTitle, HashMap<String, Book> bookMap, 
			ArrayList<Book> existingCart) {
		
		if(bookMap.containsKey(bookTitle)) {
			Book bookTobeAdded = bookMap.get(bookTitle); 
			existingCart.add(bookTobeAdded);
			return true;
		}
		return false;
	}
	
	/**
	 * @param bookTitle, existingCart
	 * @return boolean
	 */
	public static boolean removeElementFromCart(String bookTitle, ArrayList<Book> existingCart) {
		
		Book bookToBeRemoved = new Book(bookTitle);
		if(existingCart.contains(bookToBeRemoved)) {
			boolean removeStatus = existingCart.remove(bookToBeRemoved);
			return removeStatus;
		}else {
			return false;
		}
	}
	
	/**
	 * @param existingCart
	 * @return double
	 */
	public static double getSumTotalFromCart(ArrayList<Book> existingCart) {
		
		double totalPrice = 0;
		for(Book book : existingCart) {
			totalPrice += totalPrice + book.getBookPrice();
		}
		existingCart.removeAll(existingCart);
		return totalPrice;
	}

}
