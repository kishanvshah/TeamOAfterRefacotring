package library;

import java.text.ParseException;

/**
 * This class manages data validation methods
 * 
 * 
 * 
 */
public class Validator  {

	/**
	 * maximum number of digits in phone number
	 */
	public static final int MAXIMUM_LENGTH = 15;


    private UserInterface userInterface;
    private Condition condition;
    
  Validator(Condition condition) {
      this.condition = condition;
  }

    Validator(UserInterface userInterface) {
        this.userInterface = userInterface;
    }
        public UserInterface getUserInterface(){
        return userInterface;
    }


	/**
	 * validate e-mail
	 * 
	 * @param mail
	 *            the e-mail to check
	 * @return boolean, true if valid
	 */
	public boolean isValidEmail(String mail) {

		String[] tokens = mail.split("@");

    if (mail.isEmpty()){
		  //System.out.println("Enter a valid Email id");
			return false;}

		if (mail.lastIndexOf(".") > mail.lastIndexOf("@") && tokens.length == 2
				&& !tokens[0].isEmpty())
			return true;
		else
		  //System.out.println("Enter a valid Email id");
			return false;
	}

	/**
	 * validates the phone number
	 * 
	 * @param phoneNumber
	 *            the phone number to check
	 * @return boolean, true if valid
	 */
	public boolean isValidPhoneNumber(String phoneNumber) {

		if (phoneNumber.isEmpty() || phoneNumber.length() > MAXIMUM_LENGTH)
			return false;
		int i = 0;
		while (i < phoneNumber.length()) {
			if (!Character.isDigit(phoneNumber.charAt(i))
					&& !(phoneNumber.charAt(i) == '-'))
				return false;
			else
				i++;
		}
		return true;
	}

	/**
	 * validates an Integer
	 * 
	 * @param integer
	 *            the string to check
	 * @return boolean, true when valid
	 */
	public boolean isValidInteger(String integer) {

		if (integer == null || integer.isEmpty()
				|| integer.length() > MAXIMUM_LENGTH)
			return false;
		int i = 0;
		while (i < integer.length()) {
			if (!Character.isDigit(integer.charAt(i)))
				return false;
			else
				i++;
		}
		return true;
	}

	/**
	 * returns false when the string contains ","
	 * 
	 * @param inData
	 *            the string to check
	 * @return boolean,true when valid
	 */
	public boolean isValidString(String inData) {
      if (inData.isEmpty() || inData.contains(",")){
		  //System.out.println("Enter a valid String");
			return false;}
		else
			return true;
	}

	/**
	 * validates the inserted name
	 * 
	 * @param name
	 *            the name to check
	 * @return boolean, true when valid
	 */
	public boolean isValidName(String name) {
		if (name.isEmpty())
			return false;
		int i = 0;
		while (i < name.length()) {
			if (!Character.isLetter(name.charAt(i)) && !(name.charAt(i) == ' ')
          && !(name.charAt(i) == '.')){
			 // System.out.println("Enter a valid Name");
				return false;}
			else
				i++;
		}

		return true;

	}

	/**
	 * validates ISBN
	 * 
	 * @param isbn
	 *            the ISBN to check
	 * @return boolean, true when valid
	 */
	public boolean isValidISBN(String isbn) {
		if (isbn == null || !isbn.contains("-"))
			return false;
		int i = 0;
		while (i < isbn.length()) {
        if (!Character.isDigit(isbn.charAt(i)) && !(isbn.charAt(i) == '-')){
          System.out.println("Enter a valid ISBN");
				return false;}
			else
				i++;
		}
		return true;
	}

	/**
	 * validates the date
	 * 
	 * @param date
	 *            the string to check
	 * @return boolean, true when valid
	 */
	public boolean isValidDate(String date) {
		try {
        if(date == "")
         return false;   
			IOManager.parseDate(date);
		} catch (ParseException e) {
		  //System.out.println("Enter a valid Date");
			return false;
		}
		return true;

	}

	/**
	 * validates book data when reading from a file
	 * 
	 * @param bookData
	 *            array of strings containing book data
	 * @return boolean, true when valid
	 */
	public boolean isValidBookLine(String[] bookData) {
		boolean valid = isValidName(bookData[1]) && isValidISBN(bookData[3])
				&& isValidDate(bookData[4]) && isValidInteger(bookData[5])
				&& isValidInteger(bookData[6]);
		return valid;
	}

	/**
	 * validates member data when reading from a file
	 * 
	 * @param memberData
	 *            array of strings containing member data
	 * @return boolean, true when valid
	 */
	public boolean isValidMemberLine(String[] memberData) {

		boolean valid = isValidInteger(memberData[0])
				&& isValidName(memberData[1])
				&& isValidPhoneNumber(memberData[5])
				&& isValidInteger(memberData[6])
				&& ((memberData.length == 8) ? isValidEmail(memberData[7])
						: true); // the system allows empty field for e-mail

		return valid;
	}

	/**
	 * validates borrowing data when reading from a file
	 * 
	 * @param borrowingData
	 *            array of strings containing borrowing data
	 * @return boolean, true when valid
	 */
	public boolean isValidBorrowingLine(String[] borrowingData) {

		boolean valid = isValidISBN(borrowingData[0])
				&& (getUserInterface().getBooks().searchISBN(borrowingData[0]) != -1)
				&& isValidInteger(borrowingData[1])
				&& isValidDate(borrowingData[2])
				&& isValidDate(borrowingData[3])
				&& ((borrowingData.length == 4 || borrowingData[4]
						.equalsIgnoreCase(" ")) ? true
						: isValidDate(borrowingData[4]));
		return valid;
	}
  


}