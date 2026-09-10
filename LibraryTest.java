package assign02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * For testing the Library class.
 * 
 * @author CS 2420 course staff and ***PROGRAMMING PAIR: FILL IN YOUR NAMES*** 
 * @version ***FILL IN THE DATE***
 */
public class LibraryTest {
	private Library emptyLibrary, tinyLibrary, smallLibrary;
	
	@BeforeEach
	void setUp() throws Exception {
		emptyLibrary = new Library();
		
		tinyLibrary = new Library();
		tinyLibrary.add(9780374292799L, "Friedman", "Thomas L.", "The World is Flat");
		tinyLibrary.add(9780330351690L, "Krakauer", "Jon", "Into the Wild");
		tinyLibrary.add(9780446580342L, "Baldacci", "David", "Simple Genius");

		smallLibrary = new Library();
		smallLibrary.addAll("src/assign02/Mushroom_Publishing.txt");
	}
	
	// -------------------------------------------------------------------------
	// Provided tests
	// -------------------------------------------------------------------------

	@Test
	public void testEmptyLookupISBN() {
		assertEquals(-1, emptyLibrary.lookup(978037429279L));
	}
	
	@Test
	public void testEmptyLookupPatron() {
		ArrayList<LibraryBook> booksCheckedOut = emptyLibrary.lookup(123);
		assertNotNull(booksCheckedOut);
		assertEquals(0, booksCheckedOut.size());
	}
	
	@Test
	public void testEmptyCheckOut() {
		assertFalse(emptyLibrary.checkOut(978037429279L, 123, 10, 1, 2024));
	}

	@Test
	public void testEmptyCheckInISBN() {
		assertFalse(emptyLibrary.checkIn(978037429279L));
	}
	
	@Test
	public void testEmptyCheckInPatron() {
		assertFalse(emptyLibrary.checkIn(123));
	}

	@Test
	public void testTinyLibraryLookupISBN() {
		assertEquals(-1, tinyLibrary.lookup(9780330351690L));
	}
	
	@Test
	public void testTinyLibraryLookupPatron() {
		tinyLibrary.checkOut(9780330351690L, 123, 10, 1, 2024);
		ArrayList<LibraryBook> booksCheckedOut = tinyLibrary.lookup(123);
		
		assertNotNull(booksCheckedOut);
		assertEquals(1, booksCheckedOut.size());
		assertEquals(new Book(9780330351690L, "Krakauer", "Jon", "Into the Wild"), booksCheckedOut.get(0));
		assertEquals(123, booksCheckedOut.get(0).getPatron());
	}

	@Test
	public void testTinyLibraryCheckOut() {
		assertTrue(tinyLibrary.checkOut(9780330351690L, 123, 10, 1, 2024));
	}

	@Test
	public void testTinyLibraryCheckInISBN() {
		tinyLibrary.checkOut(9780330351690L, 123, 10, 1, 2024);
		assertTrue(tinyLibrary.checkIn(9780330351690L));
	}

	@Test
	public void testTinyLibraryCheckInPatron() {
		assertFalse(tinyLibrary.checkIn(123));
	}
	
	
	// -------------------------------------------------------------------------
	// Student-supplied tests
	// -------------------------------------------------------------------------

	// TO DO: Add more unit tests HERE to completely and robustly check the Library class.
}