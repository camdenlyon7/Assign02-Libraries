package assign02;

import java.util.GregorianCalendar;

/**
 * 
 * 
 * @author CS 2420 course staff and Camden Lyon and Ibrahim 
 * @version 2026-09-09
 */
public class LibraryBook extends Book{
	int patron;
	GregorianCalendar dueDate;
	
	/**
	 * Creates a LibraryBook from the given ISBN, author, and title.
	 * 
	 * @param isbn - unique id for this book
	 * @param authorSurname - last name for this book's author
	 * @param authorOtherName - rest of name for this book's author
	 * @param title - title for this book
	 */
	public LibraryBook (long isbn, String authorSurname, String authorOtherName, String title) {
		super(isbn, authorSurname, authorOtherName, title);
		this.patron = -1;
		this.dueDate = null;
	}
	
	/**
	 * A getter method to retrieve the patron of the LibraryBook
	 * @return an int, the patron who has checked out the LibraryBook
	 */
	public int getPatron() {
		return this.patron;
	}
	
	/**
	 * A getter method to retrieve the due date of the LibraryBook
	 * @return a GregorianCalendar, the due date of the LibraryBook
	 */
	public GregorianCalendar getDueDate() {
		return this.dueDate;
	}
	
	/**
	 * Checks out a library book with the given patron and and due date
	 * 
	 * @param Patron, the patron to be added
	 * @param DueDate, the due date to be added
	 */
	public void checkOut (int Patron, int month, int day, int year) {
		this.patron = Patron;
		this.dueDate = new GregorianCalendar(year, month, day);
	}
	
	/**
	 * Checks a book back in, removing the due date and patron
	 */
	public void returnBook () {
		this.patron = -1;
		this.dueDate = null;
	}
	
}
