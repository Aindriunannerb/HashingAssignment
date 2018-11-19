
public class Book {
	String title;
	String genre; //int?
	String author;
	String url;
	String description;
	
	int yearOfRelease;
	int bookLength;
	int bookId;
	int hashValue;
	
	
	public Book()
	{
		
	}
	
	public Book(String title, String genre, int bookLength, int bookId)
	{
		this.title = title;
		this.genre = genre;
		this.bookLength = bookLength;
		this.bookId = bookId;
		
		this.hashValue=hashCode();
	}
}
