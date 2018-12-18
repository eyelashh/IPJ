import java.util.ArrayList;
import java.util.Scanner;

/**
* Breve descrição do código
*
* @sid 2013
* @aid 1.1
*/

public class BookStore {
	
	private ArrayList <Book> Books=new ArrayList();
	private ArrayList <User> Users;
	private String name;
	private int id;
	
	public BookStore() {
		super();
		Books = new ArrayList();
	}
	
	public BookStore(ArrayList<Book> books, ArrayList<User> users, String name, int id) {
		super();
		Books = books;
		Users = users;
		this.name = name;
		this.id = id;
	}
	
	public ArrayList<Book> getBooks() {
		return Books;
	}
	
	public void setBooks(ArrayList<Book> books) {
		Books = books;
	}
	public ArrayList<User> getUsers() {
		return Users;
	}
	public void setUsers(ArrayList<User> users) {
		Users = users;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void logIn() {//ALL
		Scanner sc=new Scanner(System.in);
		System.out.println("Username");
		String user=sc.next();
		System.out.println("Password");
		String pass=sc.next();
		
		for (User u:this.Users) {
			if (user.equals(u.getUserName())){
				if (pass.equals(u.getPassword())) {
					//user e pass correctos -----> chamar nova janela
				}
				else {
					System.out.println("Password incorrecta");
				}
			}
			else {
				System.out.println("Username incorrecto");
			}
		}
		sc.close();
	}
	
	public void addUser(User u) {
		this.Users.add(u);
	}
	public void removeUser(User u) {
		this.Users.remove(u);
		
	}
	
	
	public void searchBook() {//ALL
		
		System.out.println("Por que atributo pretende pesquisar?");
		//Procurar por um livro especifico, pode ser combinado com o metodo view specs
		
		
	}
	
	public void addnewBook() {//ADMIN
		//adicionar um livro que ainda nao existe na bases de dadso
		
	}
	
	public void removeBook() {//ADMIN
		//remover um livro totalmente
		
	}
	public void viewAll() {//ALL
		//exibir toda a lista dos livros disponiveis
	}
	public void changeSpecs() {//ADMIN
		//procurar por um livro e alterar os seus atributos 
	}

}
