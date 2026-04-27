package Default;

import java.util.ArrayList;

public class Member {
      private String id;
      private String name;
      private ArrayList<String>borrowedBook;
	  public Member() {
		super();
		// TODO Auto-generated constructor stub
	  }
	  public Member(String id, String name, ArrayList<String> borrowedBook) {
		super();
		this.id = id;
		this.name = name;
		this.borrowedBook = borrowedBook;
	  }
	  public String getId() {
		  return id;
	  }
	  public void setId(String id) {
		  this.id = id;
	  }
	  public String getName() {
		  return name;
	  }
	  public void setName(String name) {
		  this.name = name;
	  }
	  public ArrayList<String> getBorrowedBook() {
		  return borrowedBook;
	  }
	  public void setBorrowedBook(ArrayList<String> borrowedBook) {
		  this.borrowedBook = borrowedBook;
	  }
	  public void borrowBook(String ISBN) {
		  borrowedBook.add(ISBN);
	  }
	  public void returnBook(String ISBN) {
		  borrowedBook.remove(ISBN);
	  }
	  @Override
	  public String toString() {
		return "Member [id=" + id + ", name=" + name + ", borrowedBook=" + borrowedBook + "]";
	  }
      
      
      
}
