package assign02;

import java.util.GregorianCalendar;

/**
 * A subclass of Book with two additional instance variables patron, a generic
 * variable, and dueDate, a GregorianCalendar. LibraryBooks can be checked in or
 * out
 * 
 */
public class LibraryBookGeneric<T> extends Book {

	T patron;
	GregorianCalendar dueDate;

	/**
	 * Creates a LibraryBook from the given ISBN, author, and title.
	 * 
	 * @param isbn            - unique id for this book
	 * @param authorSurname   - last name for this book's author
	 * @param authorOtherName - rest of name for this book's author
	 * @param title           - title for this book
	 */
	public LibraryBookGeneric(long isbn, String authorSurname, String authorOtherName, String title) {
		super(isbn, authorSurname, authorOtherName, title);
		this.patron = null;
		this.dueDate = null;
	}

	/**
	 * A getter method to retrieve the patron of the LibraryBook
	 * 
	 * @return of the generic type used for patrons, the patron who has checked out
	 *         the LibraryBook
	 */
	public T getPatron() {
		return this.patron;
	}

	/**
	 * A getter method to retrieve the due date of the LibraryBook
	 * 
	 * @return a GregorianCalendar, the due date of the LibraryBook
	 */
	public GregorianCalendar getDueDate() {
		return this.dueDate;
	}

	/**
	 * Checks out a library book with the given patron and and due date
	 * 
	 * @param Patron,  the patron to be added
	 * @param DueDate, the due date to be added
	 */
	public void checkOut(T patron, int month, int day, int year) {
		this.patron = patron;
		this.dueDate = new GregorianCalendar(year, month, day);
	}

	/**
	 * Checks a book back in, removing the due date and patron
	 */
	public void returnBook() {
		this.patron = null;
		this.dueDate = null;
	}

}
