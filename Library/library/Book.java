package library;

import java.util.Date;

/**
 * A Book object represent a reading book, such that for each book, the system
 * stores the title, author, publisher, ISBN, date of publication, number of
 * copies, current available copies and category.
 * 
 * @author Amr Nabil
 * 
 */
public class Book {
	/**
	 * Book title
	 */
	private String title;
	/**
	 * author's name
	 */
	private String author;
	/**
	 * Book publisher
	 */
	private String publisher;
	/**
	 * Book's ISBN
	 */
	private String isbn;
	/**
	 * publication date
	 */
	private Date publicationDate;
	/**
	 * number of book copies
	 */
	private int numberOfCopies;
	/**
	 * current available copies
	 */
	private int availableNumberOfCopies;
	/**
	 * book category
	 */
	private String category;
	/**
	 * ranking of the book
	 */
	private int ranking;

	/**
	 * Default constructor
	 */
	public Book() {
		this("", "", "", "", null, 0, 0, "");

	}

	/**
	 * @param title
	 *            book's title
	 * @param author
	 *            book's author
	 * @param publisher
	 *            book's publisher
	 * @param isbn
	 *            book's ISBN
	 * @param publicationDate
	 *            Publication date
	 * @param numberOfCopies
	 *            total number of copies
	 * @param availableNumberOfCopies
	 *            available number of copies
	 * @param category
	 *            book's category
	 */
	public Book(String title, String author, String publisher, String isbn,
			Date publicationDate, int numberOfCopies,
			int availableNumberOfCopies, String category) {

		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
		this.publicationDate = publicationDate;
		this.numberOfCopies = numberOfCopies;
		this.availableNumberOfCopies = availableNumberOfCopies;
		this.category = category;
		this.ranking = 0;
	}

	// setters and getters for class fields
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher
	 *            the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the ISBN
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn
	 *            the ISBN to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the publicationDate
	 */
	public Date getPublicationDate() {
		return publicationDate;
	}

	/**
	 * @param publicationDate
	 *            the publicationDate to set
	 */
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	/**
	 * @return the numberOfCopies
	 */
	public int getNumberOfCopies() {
		return numberOfCopies;
	}

	/**
	 * @param numberOfCopies
	 *            the numberOfCopies to set
	 */
	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}

	/**
	 * @return the availableNumberOfCopies
	 */
	public int getAvailableNumberOfCopies() {
		return availableNumberOfCopies;
	}

	/**
	 * @param availableNumberOfCopies
	 *            the availableNumberOfCopies to set
	 */
	public void setAvailableNumberOfCopies(int availableNumberOfCopies) {
		this.availableNumberOfCopies = availableNumberOfCopies;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @param ranking
	 *            the ranking to set
	 */
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	/**
	 * @return the ranking
	 */
	public int getRanking() {
		return ranking;
	}

	/**
	 * Book data is represented in a comma delimited line
	 * 
	 * @return formatted string
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return title + "," + author + "," + publisher + "," + isbn + ","
				+ IOManager.formatDate(publicationDate) + "," + numberOfCopies
				+ "," + availableNumberOfCopies + "," + category;
	}

	/**
	 */
	public void incrementRanking() {
		int newRanking = getRanking() + 1;
		setRanking(newRanking);
	}
}