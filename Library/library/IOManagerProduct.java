package library;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class IOManagerProduct {
	private UserInterface userInterface;
	private String booksFileLocation;

	public UserInterface getUserInterface() {
		return userInterface;
	}

	public void setUserInterface(UserInterface userInterface) {
		this.userInterface = userInterface;
	}

	public String getBooksFileLocation() {
		return booksFileLocation;
	}

	public void setBooksFileLocation(String booksFileLocation) {
		this.booksFileLocation = booksFileLocation;
	}

	public void jButton9ActionPerformed(java.awt.event.ActionEvent evt,
			IOManager iOManager) {
		iOManager.jButton9ActionPerformed(evt, this);
	}

	/**
	 * prints book data to a file
	 * @throws IOException
	 */
	public void printBooksFile() throws IOException {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(booksFileLocation));
			for (int i = 0; userInterface.getBooks().getBooksArray()[i] != null; i++) {
				pw.println(userInterface.getBooks().getBooksArray()[i]
						.toString());
			}
			pw.close();
		} catch (NullPointerException e) {
			System.out.println("The system cannot find the path specified! "
					+ e);
		} catch (FileNotFoundException e) {
			System.out.println("The system cannot find the path specified! "
					+ e);
		}
	}
}