package Default;

public class Book {
	private String ISBN;
	private String tittle;
	private String author;
	private boolean isAvailaable;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String iSBN, String tittle, String author, boolean isAvailaable) {
		super();
		ISBN = iSBN;
		this.tittle = tittle;
		this.author = author;
		this.isAvailaable = isAvailaable;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isAvailaable() {
		return isAvailaable;
	}
	public void setAvailaable(boolean isAvailaable) {
		this.isAvailaable = isAvailaable;
	}
	@Override
	public String toString() {
		return  ISBN + ", " + tittle + ", " + author + ", " + isAvailaable;
	}
	
	

}
