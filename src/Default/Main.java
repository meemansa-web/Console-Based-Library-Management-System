package Default;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
    	System.out.println("Working Directory: " + System.getProperty("user.dir"));
    	Library  library=new Library();
    	library.setBooks(FileHandler.loadBooks());
    	Scanner sc=new Scanner(System.in);
    	while(true) {
    		System.out.println("\n===Library Managment System===");
    		System.out.println("1. Add Book");
    		System.out.println("2. Register Member");
    		System.out.println("3. Borrow Book");
    		System.out.println("4. Return Book");
    		System.out.println("5. Display Book");
    		System.out.println("6. Remove Book");
    		System.out.println("7. Show Statistics");
    		System.out.println("9. Export Books to CSV");
    		System.out.println("0. Exit");
    		
    		System.out.println("Enter your choice :");
    		int choice =sc.nextInt();
    		sc.nextLine();
    		switch(choice) {
    		case 1:
    			System.out.println("ISBN");
    			String ISBN=sc.nextLine();
    			
    			System.out.println("tittle");
    			String tittle=sc.nextLine();
    			
    			System.out.println("Author");
    			String author=sc.nextLine();
    			
    			library.addBook(new Book(ISBN,tittle,author,true));
    			FileHandler.saveBooks(library.getBooks());
    			break;
    		
    		case 2:
    			 System.out.print("Member ID: ");
                 String id = sc.nextLine();
                 System.out.print("Name: ");
                 String name = sc.nextLine();

                 library.addMember(new Member(id, name));
                 
                 break;
                 
    		case 3:
    			 System.out.print("ISBN: ");
                 String ISBN1 = sc.nextLine();

                 System.out.print("Member ID: ");
                 String id1 = sc.nextLine();

                 library.borrowBook(ISBN1, id1);
                 break;
                 
    		case 4:
    			System.out.print("ISBN: ");
                ISBN1 = sc.nextLine();

                 System.out.print("Member ID: ");
                 id1 = sc.nextLine();

                 library.returnBook(ISBN1, id1);
                 break;
    		 case 5:
                 library.displayBook();
                 break;
    		 case 6:
    			    System.out.print("Enter ISBN to remove: ");
    			    String removeIsbn = sc.nextLine();

    			    library.removeBook(removeIsbn);
    			    FileHandler.saveBooks(library.getBooks());
    			    break;
    		 case 7:
    			    library.showStatistics();
    			    break;
    		 case 8:
    			    FileHandler.exportBooksToCSV(library.getBooks());
    			    break;
             case 0:
            	 FileHandler.saveBooks(library.getBooks());
                 System.out.println("Exiting...");
                 return;

             default:
                 System.out.println("Invalid choice!");
    		}
    	}
    }
}
