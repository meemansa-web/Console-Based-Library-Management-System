package Default;

import java.util.ArrayList;

public class Library {
     private ArrayList<Book>books = new ArrayList<>();
     private ArrayList<Member>members = new ArrayList<>();
     
     public void setBooks(ArrayList<Book> books) {
         this.books = books;
     }

     public ArrayList<Book> getBooks() {
         return books;
     }
     //Add Book
     public void addBook(Book book) {
    	 books.add(book);
    	 System.out.println("Book added sucessfully");
     }
     
     //remove book
     public void removeBook(String ISBN) {
    	    for (Book book : books) {
    	        if (book.getISBN().equals(ISBN)) {

    	            books.remove(book);
    	            System.out.println("Book removed successfully!");
    	            return;
    	        }
    	    }
    	    System.out.println("Book not found!");
    	}
     
     //register member
     public void addMember(Member member) {
    	 members.add(member);
    	 System.out.println("Member Added Sucessfully");
     }
     
     //Search Book and Member
     public Book findBook(String ISBN) {
    	 for (Book b : books) {
			if(b.getISBN().equals(ISBN)) {
				return b;
			}
		}
    	 return null;
     }
     public Member findMember(String mid) {
    	 for (Member m : members) {
			if(m.getId().equals(mid)) {
				return m;
			}
		}
    	 return null;
     }
     
     // Borrow Book
     public void borrowBook(String ISBN,String id) {
    	 Book book=findBook(ISBN);
    	 Member member =findMember(id);
    	 if(book == null || member == null) {
    		 System.out.println("Invalid Book and Member");
    		 return;
    	 }
    	 if(!book.isAvailaable()) {
    		 System.out.println("Book already borrowed");
    		 return;
    	 }
    	 book.setAvailaable(false);
    	 member.borrowBook(ISBN);
    	 System.out.println("Book borrowed Sucessfully");
     }
     
     //Return Book
     public void returnBook(String isbn, String memberId) {
         Book book = findBook(isbn);
         Member member = findMember(memberId);

         if (book != null && member != null) {
             book.setAvailaable(true);
             member.returnBook(isbn);
             System.out.println("Book returned!");
         }
     }
     
     //Display Books
     public void displayBook() {
    	    if (books.isEmpty()) {
    	        System.out.println("No books available!");
    	        return;
    	    }

    	    for (Book b : books) {
    	        System.out.println("ISBN: " + b.getISBN() +
    	                " | Title: " + b.getTittle() +
    	                " | Author: " + b.getAuthor() +
    	                " | Available: " + b.isAvailaable());
    	    }
    	}
     }