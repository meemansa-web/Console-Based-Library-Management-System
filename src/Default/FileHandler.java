package Default;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
	public static void saveBooks(ArrayList<Book>books) {
		try(BufferedWriter writer=new BufferedWriter(new FileWriter("books.txt"))){
			System.out.println("Saving " + books.size() + " books...");
			for (Book book : books) {
				writer.write(book.toString());
				writer.newLine();
			}
			System.out.println("✅ Books saved successfully!");
		}
		catch(IOException e) {
			System.out.println("Error saving Book..!");
		}	
	}
	public static void exportBooksToCSV(ArrayList<Book> books) {

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.csv"))) {

	        // ✅ Header row
	        writer.write("ISBN,Title,Author,Available");
	        writer.newLine();

	        // ✅ Data rows
	        for (Book b : books) {
	            writer.write(b.getISBN() + "," +
	                         b.getTittle() + "," +
	                         b.getAuthor() + "," +
	                         b.isAvailaable());
	            writer.newLine();
	        }

	        System.out.println("📊 Data exported to books.csv successfully!");

	    } catch (IOException e) {
	        System.out.println("❌ Error exporting CSV!");
	        e.printStackTrace();
	    }
	}
	public static ArrayList<Book>loadBooks(){
		ArrayList<Book>books =new ArrayList<>();
		try(BufferedReader reader=new BufferedReader(new FileReader("books.txt"))){
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data=line.split(",");
				books.add(new Book(
						data[0],
						data[1],
						data[2],
						Boolean.parseBoolean(data[3])
						));
			}
		}
		catch(IOException e) {
			System.out.println("No previous data Found");
		}
		return books;
	}
}
