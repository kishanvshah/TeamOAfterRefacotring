/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author Team O
 */

//Modification-------------------------------------------------------------------
public class Condition {
    
    private Validator validator;
    private Books books;
    private Members members;
    
   public Members getMembers() {
      return members;
  }
    public Books getBooks()
    {
        return books;
    }
    
  public Validator getValidator() {
      return validator;
  }
     /*public Validator getValidator() {
        return validator;
    }*/
     
     public Condition(){
       this.validator = new Validator(this);
       this.books = new Books(this);
       this.members = new Members(this);
       }
       
     String text = "";
    public boolean jButton3Conditions(String title,String author,String publisher,String category,String isbn,String dateOfPublication)
    {
        
        boolean valid,valid1,valid2,valid3,valid4,valid6 = true;
        
        
        valid = getValidator().isValidString(title);
        if(valid ==false)
            text = text + "Enter a valid Title \n";
          
      valid6 = getValidator().isValidString(category);
      if(valid6 ==false)
          text = text + "Enter a valid Category \n";
            
      valid1 = getValidator().isValidName(author);
      if(valid1 ==false)
        text = text + "Enter a valid Author \n";
     
      
      valid2 = getValidator().isValidISBN(isbn);
      if(valid2 ==false)
            text = text + "Enter a valid ISBN \n";
       
      
      valid3 = getValidator().isValidString(publisher);
      if(valid3 ==false)
        text = text + "Enter a valid Publisher \n";
       
            
      valid4 = getValidator().isValidDate(dateOfPublication); 
      if(valid4 ==false)
        text = text + "Enter a valid Date of Publication \n";
     
     boolean valid5 = true;
      int temp = getBooks().searchISBN(isbn);
      if(temp != -1){
          valid5 = false;
           text = "ISBN alredy exists \n";
      } 
      if(valid && valid1 && valid2 && valid3 && valid4 && valid5 && valid6)
      {
       return true;
      }
      else
      {
          returnError();
          return false; 
      }
    }
    
    
  public boolean jButton1Conditions(String firstName,String lastName,String address,String city,String street,String phone,String mail,String age,String id)
  {
      
      boolean valid,valid1,valid2,valid3,valid4,valid6,valid7,valid8,valid9 = true;
      
      
      valid = getValidator().isValidString(address);
      if(valid ==false)
          text = text + "Enter a valid Address \n";
        
    valid6 = getValidator().isValidString(city);
    if(valid6 ==false)
        text = text + "Enter a valid City \n";
          
    valid1 = getValidator().isValidName(firstName);
    if(valid1 ==false)
      text = text + "Enter a valid First Name \n";
   
    
    valid2 = getValidator().isValidName(lastName);
    if(valid2 ==false)
          text = text + "Enter a valid Last Name \n";
     
    
    valid3 = getValidator().isValidString(street);
    if(valid3 ==false)
      text = text + "Enter a valid Street \n";
     
          
    valid4 = getValidator().isValidEmail(mail); 
    if(valid4 ==false)
      text = text + "Enter a valid Email \n";
      
    valid7 =  getValidator().isValidPhoneNumber(phone);
    if(valid7 ==false)
    text = text + "Enter a valid Phone Number \n";
    
    valid8 = getValidator().isValidInteger(id);
    if(valid8 ==false)
    text = text + "Enter a valid ID \n";
    
    valid9 = getValidator().isValidInteger(age);
    if(valid9 ==false)
    text = text + "Enter a valid Age \n";
   
    int temp = 0;
    boolean valid5 = true;
    if  (getValidator().isValidInteger(id))
    {
    temp = getMembers().searchID(Integer.parseInt(id));
    if(temp != -1){
        valid5 = false;
         text = "Member alredy exists \n";
    }}
    if(valid && valid1 && valid2 && valid3 && valid4 && valid5 && valid9 &&valid7 && valid8 && valid9)
    {
     return true;
    }
    else
    {
        returnError();
        return false; 
    }
  }
    
    public String returnError()
    {
        return text;
    }
    
}
