
/**
* Breve descrição do código
*
* @sid 2013
* @aid 1.1
*/

public class Book {
	
	private String name;
	private String author;
	private int bookID;
	private int stock;
	private int price;
	
	public Book() {
		super();
	}
	
	public Book(String name, String author, int bookID, int stock) {
		super();
		this.name = name;
		this.author = author;
		this.bookID = bookID;
		this.stock=stock;
	}
	
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	public void changeStock() {
		
		//tanto dá para adicionar ou subtrair
		
	}
	


	
	
	
	
	

}
