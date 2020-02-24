package com.book.Assignment_5_b;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class communicates with database to perform various operations of client
 * @author Martand
 *
 */
public class mysqlDao {
	private ArrayList<BookDetail> bookList = new ArrayList<BookDetail>(); 

	/**
	 * This function adds a book to database table
	 * @param bookObject book to be added
	 * @return the updated list of books present in database table
	 */
	public ArrayList<BookDetail> addBook(BookDetail bookObject){
		int counter = 1;
		try {
			Connection con = mysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into book values(id,?,?,?,?)"); 
			ps.setString(counter++, bookObject.getTitle());
			ps.setString(counter++, bookObject.getWriter());
			ps.setString(counter++, bookObject.getPublisher());
			ps.setInt(counter++, bookObject.getPublishedYear());
			System.out.println(bookObject.getTitle());
			if(ps.executeUpdate()>0) {
				System.out.println("Added successfully");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return getAllBooks();
	}

	/**
	 * This function is used to fetch all the books from database table
	 * @return list of books in database
	 */
	public ArrayList<BookDetail> getAllBooks() {
		try {
			Connection con = mysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from book");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BookDetail bd = new BookDetail();
				bd.setId(rs.getInt(1));
				bd.setTitle(rs.getString(2));
				bd.setWriter(rs.getString(3));
				bd.setPublisher(rs.getString(4));
				bd.setPublishedYear(rs.getInt(5));
				bookList.add(bd);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	/**
	 * This function is used to get the book by title
	 * @param title of the book
	 * @return book object if found
	 */
	public BookDetail getByTitle(String title) {
		try {
			Connection con = mysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from book where title=?");
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
			rs.next();
			BookDetail bd = new BookDetail();
			bd.setId(rs.getInt(1));
			bd.setTitle(rs.getString(2));
			bd.setWriter(rs.getString(3));
			bd.setPublisher(rs.getString(4));
			bd.setPublishedYear(rs.getInt(5));
			return bd;
			//return new BookDetail( rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * This function is used to update the book present in database
	 * @param bookObject book to be updated
	 * @return updated list of books
	 */
	public ArrayList<BookDetail> updateBook(BookDetail bookObject) {
		try {
			Connection con = mysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement( "Update book set title=?, published_year=? where id=?");
			ps.setString(1, bookObject.getTitle());
			ps.setInt(2, bookObject.getPublishedYear());
			ps.setInt(3, bookObject.getId());
			if ( ps.executeUpdate() > 0) 
				System.out.println("Record Updated Successfully");
			else 
				System.out.println("There is a problem in updating Record.");
		} 
		catch (SQLException sql) {
			sql.printStackTrace();
		}
		return getAllBooks(); 
	}

	/**
	 * This function is used to delete book by id
	 * @param bookId represents book to be deleted
	 * @return updated list of book
	 */
	public ArrayList<BookDetail> deleteById(int bookId) {
		try {
			Connection con = mysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from book where id=?");
			ps.setInt(1, bookId);
			ps.executeUpdate();
			if ( ps.executeUpdate() > 0) {
				System.out.println("Record Successfully deleted");
			}
			else 
				System.out.println("No Record Found with this ID.");
		} 
		catch (SQLException sql) {
			sql.printStackTrace();
		}
		return getAllBooks();
	}

	/**
	 * This function deletes all the books present in table
	 * @return the updated list of book
	 */
	public  ArrayList<BookDetail> deleteAllBooks() {
		try {
			Connection con = mysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("truncate table book");
			if ( ps.executeUpdate() > 0) {
				System.out.println("Record Successfully deleted");
			}
			else 
				System.out.println("There is a problem in updating Record.");
		} 
		catch (SQLException sql) {
			sql.printStackTrace();
		}
		return getAllBooks();
	}

}
