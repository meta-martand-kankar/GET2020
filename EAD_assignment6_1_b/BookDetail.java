package com.book.Assignment_5_b;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class holds the basic attribute's of a book.
 * @author Martand
 *
 */
@XmlRootElement
public class BookDetail {
	private int id;
	private String title;
	private String writer;
	private String publisher;
	private int publishedYear;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "BookDetail [id=" + id + ", title=" + title + ", writer=" + writer + ", publisher=" + publisher
				+ ", publishedYear=" + publishedYear + "]";
	}
	public int getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

	/**
	 * To initialize book objects while taking json input from client.
	 */
	//public BookDetail() {

	//}

	/**
	 * This function initializes the book object.
	 * @param idBook of book
	 * @param title of book
	 * @param writer of book
	 * @param publisher of book
	 * @param publishedyear of book
	 */
//	public BookDetail(int idBook,String title, String writer, String publisher, int publishedyear) {
//		this.id = idBook;
//		this.title = title;
//		this.writer = writer;
//		this.publisher = publisher;
//		this.publishedYear = publishedyear;
//	}

//	public int getId() {
//		return id;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public String getWriter() {
//		return writer;
//	}
//
//	public String getPublisher() {
//		return publisher;
//	}
//
//	
//
//	public int getPublishedYear() {
//		return publishedYear;
//	}
}
