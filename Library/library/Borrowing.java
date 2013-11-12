package library;

import java.text.ParseException;
import java.util.Date;

/**
 * This class manages different transactions on borrowing data.
 * 
 * @author Amr Nabil
 * 
 */

public class Borrowing {

	private BorrowingProduct borrowingProduct = new BorrowingProduct();

	/**
	 * array data size
	 */
	private int dataSize;

	Borrowing(UserInterface userInterface) {
      borrowingProduct.setUserInterface(userInterface);
    }
    public UserInterface getUserInterface(){
        return borrowingProduct.getUserInterface();
    }
	/**
	 * @return the borrowingArray
	 */
	public Borrower[] getBorrowingArray() {
		return borrowingProduct.getBorrowingArray();
	}

	/**
	 * @param borrowingArray
	 *            the borrowingArray to set
	 */
	public void setBorrowingArray(Borrower[] borrowingArray) {
		borrowingProduct.setBorrowingArray(borrowingArray);
	}


	/**
	 * @param dataSize
	 *            the dataSize to set
	 */

	/**
	 * allows a member to borrow a book given its ISBN and the member's ID
	 * 
	 * @param isbn
	 *            the book's ISBN
	 * @param id
	 *            the member's ID
	 * @param due
	 *            date due to return
	 * @return message displaying method progress
	 * @throws ParseException
	 */
	public String borrow(String isbn, int id, Date due) throws ParseException {
		return borrowingProduct.borrow(isbn, id, due, this);

	}

	/**
	 * @param memberID
	 * @return number of books the member has borrowed and has not been returned
	 */
	public int getUnreturnedBooks(int memberID) {
		return borrowingProduct.getUnreturnedBooks(memberID);
	}

	/**
	 * returns a borrowed book to the library system
	 * 
	 * @param isbn
	 *            Book's ISBN
	 * @param id
	 *            Member's ID
	 * @param dateReturned
	 *            the date when the book was returned
	 * @return message displaying method progress
	 */
	public String returnBook(String isbn, int id, Date dateReturned) {

		return borrowingProduct.returnBook(isbn, id, dateReturned);

	}

	/**
	 * displays over due books
	 * 
	 * @return over due books
	 */
	public String getOverDueBooks() {
		return borrowingProduct.getOverDueBooks();

	}

	/**
	 * returns a list of most popular books
	 * 
	 * @return list of most popular books
	 */
	public String getPopularBooks() {

		return borrowingProduct.getPopularBooks();

	}
	public int setDataSize(int dataSize) {
		this.dataSize = dataSize;
		return dataSize;
	}
	public int getDataSize() {
		return dataSize;
	}

}
