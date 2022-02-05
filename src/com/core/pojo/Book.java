package com.core.pojo;

import java.util.Date;

import com.core.utils.CommonUtils;

/**
 * @author Shahrukh
 *
 */
public class Book {
	
	private String bookTitle;
	private String author;
	private String genre;
	private double bookPrice;
	private Date publishDate;
	
	public Book(String bookTitle, String author, String genre, double bookPrice, Date publishDate) {
		super();
		this.bookTitle = bookTitle;
		this.author = author;
		this.genre = genre;
		this.bookPrice = bookPrice;
		this.publishDate = publishDate;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
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
		return "Book [Title: " + bookTitle + ", Author: " + author + ", Genre: " + genre + ", Price: " + bookPrice
				+ ", Publish Date: " + CommonUtils.getSimpleDatFormatter().format(publishDate) + "]";
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookTitle == null) ? 0 : bookTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj == null || !(obj instanceof Book)) {
			return false;
		}
		return author.equals(((Book)obj).getAuthor()) 
				&& bookTitle.equalsIgnoreCase(((Book)obj).getBookTitle());
	}
	
	
}
