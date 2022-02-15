package com.core.pojo;

import java.io.Serializable;
import java.util.Date;
import com.core.utils.CommonUtils;

/**
 * @author Shahrukh
 * @since 05/02/2022
 */
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String bookTitle;
	private String author;
	//private String genre;
	private BookGenre genre;
	private double bookPrice;
	private Date publishDate;
	
	public Book(String bookTitle, String author, BookGenre genre, double bookPrice, Date publishDate) {
		super();
		this.bookTitle = bookTitle;
		this.author = author;
		this.genre = genre;
		this.bookPrice = bookPrice;
		this.publishDate = publishDate;
	}
	
	public Book(String bookTitle) {
		super();
		this.bookTitle = bookTitle;
	}

	public Book(String bookTitle, String author) {
		super();
		this.bookTitle = bookTitle;
		this.author = author;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BookGenre getGenre() {
		return genre;
	}

	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Book [Title: " + bookTitle + ", Author: " + author + ", Genre: " + CommonUtils.getEnrichedGenre(genre) + ", Price: " + bookPrice
				+ ", Publish Date: " + CommonUtils.getSimpleDatFormatter().format(publishDate) + "]";
	}

	@Override
	public int hashCode() {
		System.out.println("hashCode() called");
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookTitle == null) ? 0 : bookTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals() called");
		if(obj == null || !(obj instanceof Book)) {
			return false;
		} 
		Book book = (Book)obj;
		if(this.author != null && this.bookTitle != null) {
			return this.author.equalsIgnoreCase(book.getAuthor()) || 
					(author.equalsIgnoreCase(book.getAuthor()) && 
				bookTitle.equalsIgnoreCase(book.getBookTitle()));
		} else {
			return bookTitle.equalsIgnoreCase(((Book)obj).getBookTitle());
		}
	}
	
	
}
