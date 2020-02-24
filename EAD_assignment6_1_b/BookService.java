package com.book.Assignment_5_b;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This class works as resource for client.
 * @author Martand
 *
 */
@Path("book")
public class BookService {
	private mysqlDao dao = new mysqlDao();

	/**
	 * This function is used to add a book in database
	 * @param bookObject to be added
	 * @return updated list of book
	 */
	@POST
	@Path("itemname")
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<BookDetail> addBook(BookDetail bookObject){
		System.out.println(bookObject);
		return dao.addBook(bookObject);
	}

	/**
	 * This function is used to get all books from database
	 * @return updated list of book
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<BookDetail> getAllBooks() {
		System.out.println("-----I'm in book service-------");
		return dao.getAllBooks();
	}

	/**
	 * This function is used to get book by title from database
	 * @param title of book
	 * @return book of required title name
	 */
	@GET
	@Path("/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public BookDetail getBooksByTitle(@PathParam("title") String title) {
		return dao.getByTitle(title);
	}

	/**
	 * This function is used to update book by title in database
	 * @param bookObject to be updated
	 * @return updated list of book
	 */
	@PUT
	@Path("/title")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<BookDetail> updateBook(BookDetail bookObject) {
		System.out.println(bookObject.getTitle());
		return dao.updateBook(bookObject);
	}

	/**
	 * This function is used to delete book by id from database
	 * @param id of book to be deleted
	 * @return updated list of book
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<BookDetail> deleteBookById(@PathParam("id") int id) {
		return dao.deleteById(id);
	}

	/**
	 * This function is used to delete all books from database
	 * @return updated list of book
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public  ArrayList<BookDetail> deleteAllBooks() {
		return dao.deleteAllBooks();
	}
}
