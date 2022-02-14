package com.core.operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.core.pojo.Book;

/**
 * @author Shahrukh
 * @since 06/02/2022
 */
public class IOOperations {
	
	/*
	 * Load existing cart from memory, if not exists then return empty cart.
	 * Returns: ArrayList<Book>
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Book> loadCart() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ArrayList<Book> existingCart;
		File cartFile = new File("cart.ser");
		if(cartFile.exists() && cartFile.isFile() && cartFile.canRead()) {
			try(ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(cartFile))){
				existingCart = (ArrayList<Book>) inStream.readObject();
				if(existingCart != null)
					return existingCart;
				else
					return new ArrayList<Book>(5);
			}
		}
		return new ArrayList<Book>(5);
	}

	/*
	 * Save cart elements in memory, if not exists then throws an error.
	 * Returns: Boolean, if operation 
	 */
	public static boolean saveData(ArrayList<Book> cart) throws IOException {
		
		try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("cart.ser"));){
			outStream.writeObject(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
