package library;


import java.util.Date;
import java.text.ParseException;

public class BorrowingProduct {
	private Borrower[] borrowingArray;
	private UserInterface userInterface;

	public Borrower[] getBorrowingArray() {
		return borrowingArray;
	}

	public void setBorrowingArray(Borrower[] borrowingArray) {
		this.borrowingArray = borrowingArray;
	}

	public UserInterface getUserInterface() {
		return userInterface;
	}

	public void setUserInterface(UserInterface userInterface) {
		this.userInterface = userInterface;
	}

	/**
	 * allows a member to borrow a book given its ISBN and the member's ID
	 * @param isbn the book's ISBN
	 * @param id the member's ID
	 * @param due date due to return
	 * @return  message displaying method progress
	 * @throws ParseException
	 */
	public String borrow(String isbn, int id, Date due, Borrowing borrowing)
			throws ParseException {
		String message = "";
		int bookIndex = userInterface.getBooks().searchISBN(isbn);
		int memberID = userInterface.getMembers().searchID(id);
		if (bookIndex == -1)
			message = "Invalid ISBN\n";
		else if (memberID == -1)
			message = "Invalid ID\n";
		else if (userInterface.getBooks().getBooksArray()[bookIndex]
				.getAvailableNumberOfCopies() <= 0)
			message = "Sorry, there are no available copies!\n";
		else if (getUnreturnedBooks(id) >= 3)
			message = "You cannot borrow more than 3 books at a time!\n";
		else {
			Book borrowedBook = userInterface.getBooks().getBooksArray()[bookIndex];
			int index = borrowing.getDataSize();
			borrowingArray[index] = new Borrower(isbn, id, new Date(), due,
					null);
			borrowing.setDataSize(borrowing.getDataSize() + 1);
			borrowedBook.setAvailableNumberOfCopies(borrowedBook
					.getAvailableNumberOfCopies() - 1);
			userInterface.getBooks().incrementRanking(borrowedBook);
			message = "Data updated successfully.\n";
		}
		return message;
	}

	/**
	 * returns a borrowed book to the library system
	 * @param isbn Book's ISBN
	 * @param id Member's ID
	 * @param dateReturned the date when the book was returned
	 * @return  message displaying method progress
	 */
	public String returnBook(String isbn, int id, Date dateReturned) {
		int index = searchBook(isbn, id);
		String message = "";
		if (index == -1)
			message = "Invalid data!\n";
		else {
			borrowingArray[index].setDateReturned(dateReturned);
			int bookIndex = userInterface.getBooks().searchISBN(isbn);
			if (bookIndex != -1) {
				Book returnedBook = userInterface.getBooks().getBooksArray()[bookIndex];
				returnedBook.setAvailableNumberOfCopies(returnedBook
						.getAvailableNumberOfCopies() + 1);
				message = "Data updated successfully.\n";
			} else
				message = "This book was deleted";
		}
		return message;
	}

	/**
	 * displays over due books
	 * @return  over due books
	 */
	public String getOverDueBooks() {
		int counter = 0;
		String message = "Over due books:\n---------------\n";
		int i = 0;
		while (borrowingArray[i] != null) {
			if (borrowingArray[i].getDueDate().before(new Date())
					&& borrowingArray[i].getDateReturned() == null) {
				counter++;
				int bookIndex = userInterface.getBooks().searchISBN(
						borrowingArray[i].getIsbn());
				if (bookIndex == -1)
					message = "The book of ISBN: "
							+ borrowingArray[i].getIsbn() + " was deleted\n";
				else
					message = message
							+ counter
							+ ")"
							+ userInterface.getBooks().getBooksArray()[bookIndex]
									.getTitle() + "\r\n";
			}
			i++;
		}
		if (counter == 0)
			message = "No over due books.\n";
		return message;
	}

	/**
	 * returns a list of most popular books
	 * @return  list of most popular books
	 */
	public String getPopularBooks() {
		String message = "Most popular books:\n-------------------\n";
		int length = userInterface.getBooks().getDataSize();
		int counter = 0;
		int i, j;
		for (i = length - 1; i > 0 && counter != 10; i--) {
			for (j = length - 1; j >= length - i; j--)
				if (userInterface.getBooks().getBooksArray()[j].getRanking() > userInterface
						.getBooks().getBooksArray()[j - 1].getRanking()) {
					Book temp = new Book();
					temp = userInterface.getBooks().getBooksArray()[j];
					userInterface.getBooks().getBooksArray()[j] = userInterface
							.getBooks().getBooksArray()[j - 1];
					userInterface.getBooks().getBooksArray()[j - 1] = temp;
				}
			counter++;
			message = message + counter + ")"
					+ userInterface.getBooks().getBooksArray()[j].getTitle()
					+ "\r\n";
		}
		if (counter == 0)
			message = "List is not available.\n";
		return message;
	}

	/**
	 * @param memberID
	 * @return  number of books the member has borrowed and has not been returned
	 */
	public int getUnreturnedBooks(int memberID) {
		int numberOfBooks = 0;
		int i = 0;
		while (borrowingArray[i] != null) {
			if ((borrowingArray[i].getId() == memberID)
					&& (borrowingArray[i].getDateReturned() == null))
				numberOfBooks++;
			i++;
		}
		return numberOfBooks;
	}

	/**
	 * searches for a book in the borrowing array given its ISBN and the member's ID who has borrowed this book
	 * @param isbn book's ISBN
	 * @param id member's ID
	 * @return  the index of the book in the borrowing array
	 */
	public int searchBook(String isbn, int id) {
		int index = -1;
		int i = 0;
		boolean found = false;
		while ((!found) && (borrowingArray[i] != null)) {
			if (borrowingArray[i].getIsbn().equalsIgnoreCase(isbn)
					&& (borrowingArray[i].getId() == id)
					&& (borrowingArray[i].getDateReturned() == null)) {
				index = i;
				found = true;
			}
			i++;
		}
		return index;
	}
}