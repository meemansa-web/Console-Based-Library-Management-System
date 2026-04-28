package Default;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Library {
     private ArrayList<Book>books = new ArrayList<>();
     private ArrayList<Member>members = new ArrayList<>();
     
     public void setBooks(ArrayList<Book> books) {
         this.books = books;
     }

     public ArrayList<Book> getBooks() {
         return books;
     }
     public ArrayList<Member> getMembers() {
    	    return members;
    	}

    	public void setMembers(ArrayList<Member> members) {
    	    this.members = members;
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

         if (book == null || member == null) {
             System.out.println("Invalid Book or Member!");
             return;
         }

         LocalDate borrowDate = member.returnBook(isbn);

         if (borrowDate == null) {
             System.out.println("This book was not borrowed by the member!");
             return;
         }

         book.setAvailaable(true);

         // ✅ Calculate days
         long days = ChronoUnit.DAYS.between(borrowDate, LocalDate.now());

         int allowedDays = 7;
         int finePerDay = 5;

         if (days > allowedDays) {
             long extraDays = days - allowedDays;
             long fine = extraDays * finePerDay;
             System.out.println("Book returned by " + member.getName() + " (ID: " + member.getId() + ")");
             System.out.println("Book returned!");
             System.out.println("⚠ Overdue by " + extraDays + " days");
             System.out.println("💰 Fine: ₹" + fine);
         } else {
             System.out.println("Book returned on time. No fine.");
         }
     }
     
     //Display Books
       public void displayBook() {

    	    if (books.isEmpty()) {
    	        System.out.println("No books available!");
    	        return;
    	    }

    	    for (Book b : books) {

    	        String borrowerInfo = "Available";

    	        if (!b.isAvailaable()) {

    	            for (Member m : members) {
    	                if (m.getBorrowedBooks().containsKey(b.getISBN())) {

    	                    borrowerInfo = "Borrowed by: " + m.getName() +
    	                                   " (ID: " + m.getId() + ")";
    	                    break;
    	                }
    	            }
    	        }

    	        System.out.println("ISBN: " + b.getISBN() +
    	                " | Title: " + b.getTittle() +
    	                " | Author: " + b.getAuthor() +
    	                " | Status: " + borrowerInfo);
    	    }
    	}
     
     //Library Statistics
     public void showStatistics() {

    	    int totalBooks = books.size();
    	    int availableBooks = 0;
    	    int borrowedBooks = 0;

    	    for (Book b : books) {
    	        if (b.isAvailaable()) {
    	            availableBooks++;
    	        } else {
    	            borrowedBooks++;
    	        }
    	    }

    	    System.out.println("\n===== 📊 Library Statistics =====");
    	    System.out.println("Total Books     : " + totalBooks);
    	    System.out.println("Available Books : " + availableBooks);
    	    System.out.println("Borrowed Books  : " + borrowedBooks);
    	    System.out.println("Total Members   : " + members.size());
    	}
     
     }