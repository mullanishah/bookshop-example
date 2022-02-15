package com.core.tester;

import static com.core.utils.CommonUtils.getScanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import com.core.operations.IOOperations;
import com.core.pojo.Book;
import com.core.utils.CommonUtils;
import com.core.utils.DataFeedUtils;

/**
 * @author Shahrukh
 * @since 06/02/2022
 */
public class BookShoppingTester {

	public static void main(String[] args) throws Exception {
		
		boolean flag = false;
		int choice = 0;
		
		HashMap<String, Book> availableBooksMap = DataFeedUtils.getPopulatedData();
		Scanner scanner = getScanner();
		ArrayList<Book> bookCart = null;
		try {
			bookCart = IOOperations.loadCart();
			if(bookCart != null) {
				System.out.println("Existing cart restored successfully !!");
			}
		}catch(ClassNotFoundException | IOException e) {
			System.out.println("Error in generating/loading cart: " + e);
		}
		
		while(true != flag) {
			try {
				System.out.println("===================== MENU =====================");		
				System.out.printf("%-25s %-15s%n", "1.Display available books", "2.Add book to cart");
				System.out.printf("%-25s %-15s%n", "3.Remove from cart", "4.Show book cart");
				System.out.printf("%-25s %-15s%n", "5.Check out/payment", "6.Visit again");
				System.out.printf("%-25s %-15s%n", "7.Sort books by price", "8.Search a book");
				System.out.printf("%-25s %-15s%n", "9.Exit", " ");
				System.out.println("Choose your preference: ");
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					DisplayBookTester.displayAvailableBooks(availableBooksMap);
					break;
				case 2:
					scanner.nextLine();
					CartOperationsTester.addBooksToCart(availableBooksMap, bookCart);
					break;
				case 3:
					scanner.nextLine();
					CartOperationsTester.removeBooksFromCart(availableBooksMap, bookCart);
					break;
				case 4:
					CartOperationsTester.displayBooksInCart(bookCart);
					break;
				case 5:
					CheckoutBookTester.checkoutBooksFromCart(bookCart);
					break;
				case 6:
					CheckoutBookTester.saveLaterBooksInCart(bookCart);
					break;
				case 7:
					SortBookTester.sortBooksOnPrice(availableBooksMap);
					break;
				case 8:
					scanner.nextLine();
					DisplayBookTester.searchBookOnTitle(availableBooksMap);
					break;
				case 9:
					CommonUtils.exit();
					break;
				default:
					throw new IllegalArgumentException("Unexpected choice selection: " + choice);
				}
			}catch (Exception e) {
				flag = true;
				e.printStackTrace();
			}
		}
	}

}
