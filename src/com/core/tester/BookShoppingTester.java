package com.core.tester;

import static com.core.utils.CommonUtils.getScanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import com.core.operations.IOOperations;
import com.core.pojo.Book;
import com.core.utils.DataFeedUtils;

/**
 * @author Shahrukh
 * @since 06/02/2022
 */
public class BookShoppingTester {

	public static void main(String[] args) throws Exception {
		
		boolean flag = false;
		int choice = 0;
		
		HashMap<String, Book> bookMap = DataFeedUtils.getPopulatedData();
		Scanner scanner = getScanner();
		ArrayList<Book> bookCart = null;
		try {
			bookCart = IOOperations.loadCart();
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
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					System.out.println("Enter book title to search: ");
					DisplayBookTester.searchBookOnTitle(scanner.next(), bookMap);
					break;
				case 9:
					exit();
					break;
				default:
					throw new IllegalArgumentException("Unexpected choice selection: " + choice);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void exit() {
		System.out.println("============= EXITING ================");
		System.exit(0);
	}

}
