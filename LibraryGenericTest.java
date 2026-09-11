package assign02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * For testing the LibraryGeneric class.
 * 
 * /**
 * A Library class with a generic patron type
 * @author CS 2420 course staff and Camden Lyon and Ibrahim Alasady
 * @version 2026-09-10
 */
public class LibraryGenericTest {
	// library that uses names to identify patrons
	private LibraryGeneric<String> patronByNameLibrary; 
	// library that uses phone numbers to identify patrons	
	private LibraryGeneric<PhoneNumber> patronByPhoneLibrary;
	
	@BeforeEach
	void setUp() throws Exception {
		patronByNameLibrary = new LibraryGeneric<String>();
		patronByNameLibrary.add(9780374292799L, "Friedman", "Thomas L.", "The World is Flat");
		patronByNameLibrary.add(9780330351690L, "Krakauer", "Jon", "Into the Wild");
		patronByNameLibrary.add(9780446580342L, "Baldacci", "David", "Simple Genius");

		patronByPhoneLibrary = new LibraryGeneric<PhoneNumber>();
		patronByPhoneLibrary.add(9780374292799L, "Friedman", "Thomas L.", "The World is Flat");
		patronByPhoneLibrary.add(9780330351690L, "Krakauer", "Jon", "Into the Wild");
		patronByPhoneLibrary.add(9780446580342L, "Baldacci", "David", "Simple Genius");
	}
	
	// -------------------------------------------------------------------------
	// Provided tests
	// -------------------------------------------------------------------------
	
	@Test
	public void testNameCheckOut() {
		String patron = "Unique Patron Name";
		assertTrue(patronByNameLibrary.checkOut(9780330351690L, patron, 10, 1, 2024));
		assertTrue(patronByNameLibrary.checkOut(9780374292799L, patron, 10, 1, 2024));
	}

	@Test
	public void testNameLookup() {
		String patron = "Unique Patron Name";
		patronByNameLibrary.checkOut(9780330351690L, patron, 10, 1, 2024);
		patronByNameLibrary.checkOut(9780374292799L, patron, 10, 1, 2024);
		ArrayList<LibraryBookGeneric<String>> booksCheckedOut = patronByNameLibrary.lookup(new String("Unique Patron Name"));
		
		assertNotNull(booksCheckedOut);
		assertEquals(2, booksCheckedOut.size());
		assertTrue(booksCheckedOut.contains(new Book(9780330351690L, "Krakauer", "Jon", "Into the Wild")));
		assertTrue(booksCheckedOut.contains(new Book(9780374292799L, "Friedman", "Thomas L.", "The World is Flat")));
		assertEquals(patron, booksCheckedOut.get(0).getPatron());
		assertEquals(patron, booksCheckedOut.get(1).getPatron());
	}
	
	@Test
	public void testNameCheckIn() {
		String patron = "Unique Patron Name";
		patronByNameLibrary.checkOut(9780330351690L, patron, 10, 1, 2024);
		patronByNameLibrary.checkOut(9780374292799L, patron, 10, 1, 2024);
		assertTrue(patronByNameLibrary.checkIn(new String("Unique Patron Name")));
	}

	@Test
	public void testPhoneCheckOut() {
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		assertTrue(patronByPhoneLibrary.checkOut(9780330351690L, patron, 10, 1, 2024));
		assertTrue(patronByPhoneLibrary.checkOut(9780374292799L, patron, 10, 1, 2024));
	}

	@Test
	public void testPhoneLookup() {
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		patronByPhoneLibrary.checkOut(9780330351690L, patron, 10, 1, 2024);
		patronByPhoneLibrary.checkOut(9780374292799L, patron, 10, 1, 2024);
		ArrayList<LibraryBookGeneric<PhoneNumber>> booksCheckedOut = patronByPhoneLibrary.lookup(new PhoneNumber("801.555.1234"));
		
		assertNotNull(booksCheckedOut);
		assertEquals(2, booksCheckedOut.size());
		assertTrue(booksCheckedOut.contains(new Book(9780330351690L, "Krakauer", "Jon", "Into the Wild")));
		assertTrue(booksCheckedOut.contains(new Book(9780374292799L, "Friedman", "Thomas L.", "The World is Flat")));
		assertEquals(patron, booksCheckedOut.get(0).getPatron());
		assertEquals(patron, booksCheckedOut.get(1).getPatron());
	}

	@Test
	public void testPhoneCheckIn() {
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		patronByPhoneLibrary.checkOut(9780330351690L, patron, 10, 1, 2024);
		patronByPhoneLibrary.checkOut(9780374292799L, patron, 10, 1, 2024);
		assertTrue(patronByPhoneLibrary.checkIn(new PhoneNumber("801.555.1234")));
	}
	
	
	// -------------------------------------------------------------------------
	// Student-supplied tests
	// -------------------------------------------------------------------------

	@Test
	public void testGetListSortedByAuthor(){
		java.util.List<LibraryBookGeneric<String>> sortedList = patronByNameLibrary.getListSortedByAuthor();
		assertEquals("Baldacci", sortedList.get(0).getAuthorSurname());
		assertEquals("Friedman", sortedList.get(1).getAuthorSurname());
		assertEquals("Krakauer", sortedList.get(2).getAuthorSurname());
	}

	@Test
	public void testGetOverdueList() {
		patronByNameLibrary.checkOut(9780330351690L, "Jane Doe", 9, 1, 2026);
		java.util.List<LibraryBookGeneric<String>> overdueList =patronByNameLibrary.getOverdueList(9, 10, 2026);
		assertEquals(1, overdueList.size());
		assertEquals(9780330351690L, overdueList.get(0).getIsbn());
	}

	@Test
	public void testPhoneCheckOutAlreadyCheckedOut() {
		PhoneNumber patron1 = new PhoneNumber("801.555.1234");
		PhoneNumber patron2 = new PhoneNumber("801.555.9876");
		patronByPhoneLibrary.checkOut(9780330351690L, patron1, 10, 1, 2026);
		assertFalse(patronByPhoneLibrary.checkOut(9780330351690L, patron2, 10, 5, 2026));
	}
}
		

	
