package com.core.tester;

import static com.core.utils.CommonUtils.getEnrichedGenre;

import java.io.IOException;
import java.util.ArrayList;

import com.core.operations.CollectionOperations;
import com.core.operations.IOOperations;
import com.core.pojo.Book;
import com.core.utils.CommonUtils;
import com.core.utils.DataFeedUtils;

/**
 * @author Shahrukh
 * @since 06-Feb-2022
 */
public class CheckoutBookTester {

	public static void checkoutBooksFromCart(ArrayList<Book> bookCart) {
		
		if(bookCart == null) {
			System.err.println("No item found in the cart !!");
		} else {
			System.out.printf("%-24s %-15s | %-12s%n", "Title", "Genre", "Price(Rs)");
			System.out.println("-------------------------------------------------------------------");	
			for(Book selectedBook : bookCart) {
				System.out.printf("%-24s %-15s | %-12s%n", selectedBook.getBookTitle(), getEnrichedGenre(selectedBook.getGenre()), selectedBook.getBookPrice());
			}
			System.out.println("-------------------------------------------------------------------");
			System.out.printf("%-32s %-2s", " ", "Total:  | Rs.");
			System.out.format("%.2f %n", CollectionOperations.getSumTotalFromCart(bookCart));
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Amount paid successfully !!");
		}
	}
	
	public static boolean saveLaterBooksInCart(ArrayList<Book> bookCart) throws IOException {
		
		if(IOOperations.saveData(bookCart) == true) {
			System.out.println("Cart saved for later use! Thank you");
			CommonUtils.exit();
		}
		return false;
	}
	
//	public static void main(String[] args) throws Exception {
//		ArrayList<Book> cart = new ArrayList<Book>();
//		for(Book b : DataFeedUtils.getPopulatedData().values()) {
//			if(b.getBookTitle().contains("C"))
//				cart.add(b);
//		}
//		CheckoutBookTester.checkoutBooksFromCart(cart);
//	}
}
